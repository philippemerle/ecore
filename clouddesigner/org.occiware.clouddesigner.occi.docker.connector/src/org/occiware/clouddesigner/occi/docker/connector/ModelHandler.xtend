package org.occiware.clouddesigner.occi.docker.connector

import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.Reader
import java.io.StringReader
import java.io.StringWriter
import java.util.ArrayList
import java.util.Collections
import java.util.HashMap
import java.util.IdentityHashMap
import java.util.Iterator
import java.util.List
import java.util.Map
import org.codehaus.jackson.JsonNode
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.URIConverter
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.XMIResource
import org.eclipse.emf.ecore.xmi.XMLResource
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.occiware.clouddesigner.occi.docker.Container
import org.occiware.clouddesigner.occi.docker.DockerFactory
import org.occiware.clouddesigner.occi.docker.DockerPackage
import org.occiware.clouddesigner.occi.docker.Machine
import org.occiware.clouddesigner.occi.docker.Machine_Amazon_EC2
import org.occiware.clouddesigner.occi.docker.Machine_VirtualBox
import org.occiware.clouddesigner.occi.docker.connector.dockermachine.util.DockerUtil
import org.occiware.clouddesigner.occi.infrastructure.ComputeStatus
import org.occiware.clouddesigner.occi.docker.connector.dockermachine.manager.Provider
import org.occiware.clouddesigner.occi.docker.connector.dockermachine.manager.DockerMachineManager

class ModelHandler {

	def static void main(String[] args) {
		val m = new ModelHandler

		//
		m.loadModelWithoutGenerateCode

	}

	/*
	 * Dynamic EMF 
	 */
	def loadModelWithoutGenerateCode() {
		val resource = loadModel

		val EPackage ePackage = resource.contents.get(0) as EPackage

		val EList<EClassifier> eClassifiers = ePackage.EClassifiers
		for (EClassifier eClassifier : eClassifiers) {
			println(eClassifier.name)
			println(" ")

			// Run through classes
			if (eClassifier instanceof EClass) {
				val EClass eClass = eClassifier as EClass
				val EList<EAttribute> eAttributes = eClass.EAttributes

				// run through class's attributes
				for (EAttribute eAttribute : eAttributes) {
					println(eAttribute.name + "(" + eAttribute.EAttributeType.name + ") ")
				}
				if (!eClass.EAttributes.isEmpty && !eClass.EReferences.isEmpty) {
					println()
					println(" References: ")
				}
				val EList<EReference> eReferences = eClass.EReferences
				for (EReference eReference : eReferences) {
					println(
						eReference.getName() + "(" + eReference.EReferenceType.name + "[" + eReference.lowerBound + ".." +
							eReference.upperBound + "])")
				}
				if (!eClass.getEOperations().isEmpty()) {
					println()
					println(" Operations: ")
					for (EOperation eOperation : eClass.getEOperations()) {
						println(eOperation.EType + " " + eOperation.name)
					}
				}
			}
			println()
		}

	}

	def createAndSaveDockerMachineWithMetaModel() {
		var resource = loadModel
		resource.load(null)
		val EPackage ePackage = resource.getContents().get(0) as EPackage
		val EClass dockerMachine = ePackage.getEClassifier("Machine") as EClass
		val EReference eContains = dockerMachine.getEStructuralFeature("contains") as EReference
		val EAttribute eName = dockerMachine.getEStructuralFeature("name") as EAttribute
		val EObject dockerMachineInstance = ePackage.EFactoryInstance.create(dockerMachine)
		dockerMachineInstance.eSet(eName, "test-xx")

		val EClass evbox = ePackage.getEClassifier("Machine_VirtualBox") as EClass
		val EAttribute eboot2docker_url = evbox.getEStructuralFeature("boot2docker_url") as EAttribute
		val EAttribute edisk_size = evbox.getEStructuralFeature("disk_size") as EAttribute
		val EObject vboxInstance = ePackage.getEFactoryInstance().create(evbox)
		vboxInstance.eSet(eboot2docker_url, "link")

		//vboxInstance.eSet(edisk_size, 100)
		//		val List<EObject> containsList = new ArrayList<EObject>()
		//		containsList.add(vboxInstance)
		//		dockerMachineInstance.eSet(eContains, containsList)
		val ResourceSet resourceSet = new ResourceSetImpl
		resourceSet.resourceFactoryRegistry.extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl)
		var File temp = File.createTempFile("tempfile", "dockerinstancesonlymodel.xmi")
		val URI uri = URI.createURI(temp.absolutePath)
		println(uri)
		val Resource r = resourceSet.createResource(uri)
		if (r == null) {
			throw new NullPointerException("The resource is null.")
		}
		println("Resource: " + r)
		r.contents.add(vboxInstance)
		r.save(null)

	//resourceSet.packageRegistry.put("http://occiware.org/docker", ePackage)
	}

	def loadModel() {
		val Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE
		val Map<String, Object> m = reg.extensionToFactoryMap
		m.put("ecore", new XMIResourceFactoryImpl)
		val ResourceSet resourceSet = new ResourceSetImpl
		val URI fileURI = URI.createFileURI("model/Docker.ecore")
		val Resource resource = resourceSet.getResource(fileURI, true)
		return resource
	}

	def getmodelEClass() {
		val Map<String, Machine> m = new HashMap

		//TODO verify the good driver name
		m.put(Provider.virtualbox.toString, DockerFactory.eINSTANCE.createMachine_VirtualBox)
		m.put(Provider.amazonec2.toString, DockerFactory.eINSTANCE.createMachine_Amazon_EC2)
		m.put(Provider.digitalocean.toString, DockerFactory.eINSTANCE.createMachine_Digital_Ocean)
		m.put(Provider.google.toString, DockerFactory.eINSTANCE.createMachine_Google_Compute_Engine)
		m.put(Provider.ibm.toString, DockerFactory.eINSTANCE.createMachine_IBM_SoftLayer)
		m.put(Provider.azure.toString, DockerFactory.eINSTANCE.createMachine_Microsoft_Azure)
		m.put("microsofthyperv", DockerFactory.eINSTANCE.createMachine_Microsoft_Hyper_V)
		m.put(Provider.rackspace.toString, DockerFactory.eINSTANCE.createMachine_Rackspace)
		m.put("vmwarefusion", DockerFactory.eINSTANCE.createMachine_VMware_Fusion)
		m.put("vmwarevcloud", DockerFactory.eINSTANCE.createMachine_VMware_vCloud_Air)
		m.put("vmwaresphere", DockerFactory.eINSTANCE.createMachine_VMware_vSphere)

		return m
	}

	def saveFromStream(OutputStream output, Machine machine) {
		val rs = new ResourceSetImpl
		rs.resourceFactoryRegistry.extensionToFactoryMap.put("*", new XMIResourceFactoryImpl)
		rs.packageRegistry.put(DockerPackage.eNS_URI, DockerPackage.eINSTANCE)
		val URI uri = URI.createURI(DockerPackage.eNS_URI + "RAM")
		val Resource resource = rs.createResource(uri)

		// set the file encoding
		val res = resource as XMIResource
		res.defaultLoadOptions.put(XMLResource.OPTION_ENCODING, "UTF-8")
		res.defaultSaveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8")
		res.getContents().add(machine)
		res.save(output, new HashMap)
	}

	def loadFromStream(InputStream input) {
		val rs = new ResourceSetImpl
		rs.resourceFactoryRegistry.extensionToFactoryMap.put("*", new XMIResourceFactoryImpl)
		rs.packageRegistry.put(DockerPackage.eNS_URI, DockerPackage.eINSTANCE)
		val Resource resource = rs.createResource(URI.createURI(DockerPackage.eNS_URI))

		// set the file encoding
		val res = resource as XMIResource
		res.defaultLoadOptions.put(XMLResource.OPTION_ENCODING, "UTF-8")
		res.defaultSaveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8")
		res.load(input, new HashMap)

		return resource.contents.get(0) as Machine

	}

	def loadFromFile(String xmiPath) {
		val InputStream in = this.getClass().getClassLoader().getResourceAsStream(xmiPath)
		if (in == null) {
			throw new IllegalArgumentException("Unable to locate resource " + xmiPath)
		}

		val rs = new ResourceSetImpl
		rs.resourceFactoryRegistry.extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl)
		rs.packageRegistry.put(DockerPackage.eNS_URI, DockerPackage.eINSTANCE)
		val File inputFile = new File(xmiPath)
		val uri = URI.createURI(inputFile.absolutePath)
		val resource = rs.getResource(uri, true)
		val res = resource as XMIResource

		// set the file encoding
		res.defaultLoadOptions.put(XMLResource.OPTION_ENCODING, "UTF-8")
		res.defaultSaveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8")

		if (resource == null) {
			throw new NullPointerException("The resource is null.")
		}
		val m = resource.contents.get(0) as Machine
		println(m)
		return m
	}

	def saveFromFile(Machine machine) {
		val resourceSet = new ResourceSetImpl
		resourceSet.resourceFactoryRegistry.extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl)
		val String basePath = this.class.classLoader.getResource(".").path

		//var File temp = File.createTempFile("tempfile", machine.name + ".xmi")
		var File temp = new File(basePath + machine.name + ".xmi")
		println(temp)
		val uri = URI.createURI(temp.absolutePath)

		// Load resource
		var Resource resource = resourceSet.createResource(uri)
		val res = resource as XMIResource

		// set the file encoding
		res.defaultLoadOptions.put(XMLResource.OPTION_ENCODING, "UTF-8")
		res.defaultSaveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8")
		if (resource == null) {
			throw new NullPointerException("The resource is null.")
		}
		resource.contents.add(machine)
		resource.save(null)
	}

	def deleteAllOldModels() {
		val File myFile = new File("Models")
		if (myFile.isDirectory()) {
			myFile.delete()
		}
	}

	def static Resource load(URI uri, ResourceSet resourceSet, String data) throws IOException {
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl())
		var InputStream in = ModelHandler.classLoader.getResourceAsStream(data)
		if (in == null) {
			in = new FileInputStream(data)
			if (in == null) {
				throw new IllegalArgumentException("Unable to locate resource " + data)
			}
		}

		val Reader reader = new InputStreamReader(in)
		val URIConverter.ReadableInputStream input = new URIConverter.ReadableInputStream(reader, "UTF-8")
		val Resource resource = resourceSet.createResource(uri)
		resource.load(input, null)

		return resource
	}

	def String loadResource(String xmi) {
		var InputStream in = this.getClass().getClassLoader().getResourceAsStream(xmi)
		if (in == null) {
			in = new FileInputStream(xmi)
			if (in == null) {
				throw new IllegalArgumentException("Unable to locate resource " + xmi)
			}
		}
		var String result = null
		try {
			result = readContentAsString(new BufferedReader(new InputStreamReader(in)))
		} catch (IOException ex) {
			throw new IllegalArgumentException("Unable to read resource " + xmi, ex)
		}

		return result
	}

	def load(String path) {
		val rs = new ResourceSetImpl
		rs.resourceFactoryRegistry.extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl)
		rs.packageRegistry.put(DockerPackage.eNS_URI, DockerPackage.eINSTANCE)
		val File inputFile = new File(path);
		val uri = URI.createURI(inputFile.absolutePath)
		val resource = rs.getResource(uri, true)
		val res = resource as XMIResource

		// set the file encoding
		res.defaultLoadOptions.put(XMLResource.OPTION_ENCODING, "UTF-8")
		res.defaultSaveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8")

		if (resource == null) {
			throw new NullPointerException("The resource is null.")
		}
		val m = resource.contents.get(0) as Machine
		println(m)
		return m
	}

	def String readContentAsString(Reader reader) throws IOException {
		var StringBuffer result = new StringBuffer(1000)
		var char[] buf = newCharArrayOfSize(1024)
		var int numRead = 0
		while ((numRead = reader.read(buf)) != -1) {
			result.append(buf, 0, numRead)
		}
		reader.close
		return result.toString
	}

	def static EList<EObject> toEObject(String xmi, boolean unsetID) {
		try {
			var Map<Object, Object> options = new HashMap<Object, Object>()
			options.put(XMLResource.OPTION_ENCODING, "UTF-8")
			options.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE)
			options.put(XMLResource.OPTION_DEFER_ATTACHMENT, Boolean.TRUE)

			var ResourceSet resourceSet = new ResourceSetImpl()
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl)

			// Register XML resource factory
			resourceSet.packageRegistry.put(DockerPackage.eNS_URI, DockerPackage.eINSTANCE)

			var URIConverter.ReadableInputStream input = new URIConverter.ReadableInputStream(new StringReader(xmi),
				"UTF-8")
			var Resource resource = resourceSet.createResource(URI.createURI(""))

			resource.load(input, options)

			if (!resource.getErrors().isEmpty() || !resource.getWarnings().isEmpty()) {
				throw new IllegalArgumentException(
					"Unable to load the EObject. Errors:" + resource.getErrors() + "Warnings:" + resource.getWarnings())
			}

			var EList<EObject> result = resource.getContents()

			if (result != null && unsetID) {
				var Map<EObject, Boolean> preventCycles = new IdentityHashMap<EObject, Boolean>()

				var ArrayList<EObject> rootList = new ArrayList<EObject>()

				// collect all referenced & proxied objects
				for (EObject eObj : result) {
					readReferences(eObj, preventCycles, rootList)
				}

				for (EObject eobj : rootList) {
					if (eobj.eClass().getEIDAttribute() != null) {
						eobj.eSet(eobj.eClass().getEIDAttribute(), null)
					}

					// composition objects
					var Iterator<EObject> iterator = eobj.eAllContents()
					while (iterator.hasNext()) {
						var EObject dependentEObject = iterator.next()
						if (dependentEObject.eClass().getEIDAttribute() != null) {
							dependentEObject.eSet(dependentEObject.eClass().getEIDAttribute(), null)
						}
					}
				}
			}

			return result
		} catch (IOException e) {
			throw new IllegalArgumentException(e)
		}
	}

	def static String toXMI(EObject object) {
		try {
			var Map<Object, Object> options = new HashMap<Object, Object>()
			options.put(XMLResource.OPTION_ENCODING, "UTF-8")
			options.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE)
			options.put(XMLResource.OPTION_DEFER_ATTACHMENT, Boolean.TRUE)

			val StringWriter sw = new StringWriter()
			val URIConverter.WriteableOutputStream uws = new URIConverter.WriteableOutputStream(sw, "UTF-8")

			val ResourceSet resourceSet = new ResourceSetImpl()
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl())

			// Register XML resource factory
			resourceSet.packageRegistry.put(DockerPackage.eNS_URI, DockerPackage.eINSTANCE)

			var Resource resource = resourceSet.createResource(URI.createURI(""))

			var Map<EObject, Boolean> preventCycles = new IdentityHashMap<EObject, Boolean>()
			var ArrayList<EObject> rootList = new ArrayList<EObject>()

			// collect all referenced & proxied objects
			readReferences(object, preventCycles, rootList)

			for (EObject obj : rootList) {
				resource.getContents().add(obj)
			}
			resource.save(uws, options)

			return sw.toString()
		} catch (IOException e) {
			throw new IllegalArgumentException(e)
		}
	}

	def static void readReferences(EObject eobject, Map<EObject, Boolean> preventCycles, List<EObject> rootList) {
		if (preventCycles.containsKey(eobject)) { // been here get away
			return
		}
		preventCycles.put(eobject, null)

		if (eobject.eContainer() != null) {
			readReferences(eobject.eContainer(), preventCycles, rootList)
		} else { // a root object
			rootList.add(eobject)
		}

		for (Object erefObj : eobject.eClass().getEAllReferences()) {
			var EReference eref = erefObj as EReference
			val Object value = eobject.eGet(eref)
			if (value == null) {
				// continue
			}
			if (value instanceof List) {
				for (Object obj : value as List<?>) {
					ModelHandler.readReferences(obj as EObject, preventCycles, rootList)
				}
			} else { // an eobject
				ModelHandler.readReferences(value as EObject, preventCycles, rootList)
			}
		}
	}

	def getModel(String machine, String state) {
		val node = DockerUtil.jsonify(DockerMachineManager.inspectHostCmd(Runtime.getRuntime, machine))
		val model = new ModelHandler
		if (node != null) {
			var vbox = model.getmodelEClass.get(node.get("DriverName").toString.replaceAll("\"", ""))

			if (vbox instanceof Machine_VirtualBox) {
				var newvbox = vbox as Machine_VirtualBox

				// Set values
				machineFactory(newvbox, node, state)
				newvbox.disk_size = Integer.parseInt(node.get("Driver").get("DiskSize").toString)
				newvbox.boot2docker_url = node.get("Driver").get("Boot2DockerURL").toString.replaceAll("\"", "")
				println("Model setting: " + newvbox)
			} else if (vbox instanceof Machine_Amazon_EC2) {
				var newvbox = vbox as Machine_Amazon_EC2

				// Set values
				machineFactory(newvbox, node, state)
				println("Model setting: " + newvbox)
			}
			return vbox
		}
	}

	def machineFactory(Machine vbox, JsonNode node, String state) {
		vbox.name = node.get("Driver").get("MachineName").toString.replaceAll("\"", "")
		vbox.memory = Float.parseFloat(node.get("Driver").get("Memory").toString)
		vbox.cores = Integer.parseInt(node.get("Driver").get("CPU").toString)
		if (state == "Running") {
			vbox.state = ComputeStatus.get(0)
		}
		if (state == "Stopped") {
			vbox.state = ComputeStatus.get(1)
		}
	}

	def getModel(com.github.dockerjava.api.model.Container container) {

		// Initialize the model
		DockerFactory.eINSTANCE.eClass
		// Retrieve the default factory singleton
		var modelContainer = DockerFactory.eINSTANCE.createContainer
		modelContainer.id = container.id
		modelContainer.name = container.names.get(0)
		modelContainer.image = container.image
		modelContainer.command = container.command
		modelContainer.containerid = container.id
		
		return modelContainer
	}

	def saveMachine(Machine machine) {
		val resourceSet = new ResourceSetImpl
		resourceSet.resourceFactoryRegistry.extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl)
		val String basePath = this.class.classLoader.getResource(".").path

		//var File temp = File.createTempFile("tempfile", machine.name + ".xmi")
		var File temp = new File(basePath + machine.name + ".xmi")
		println(temp)
		val uri = URI.createURI(temp.absolutePath)

		// Load resource
		var Resource resource = resourceSet.createResource(uri)
		val res = resource as XMIResource

		// set the file encoding
		res.defaultLoadOptions.put(XMLResource.OPTION_ENCODING, "UTF-8")
		res.defaultSaveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8")
		if (resource == null) {
			throw new NullPointerException("The resource is null.")
		}
		resource.contents.add(machine)
		resource.save(Collections.EMPTY_MAP) // resource.save(null)
	}

	def saveContainer(Container container) {
		val resourceSet = new ResourceSetImpl
		resourceSet.resourceFactoryRegistry.extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl)
		val String basePath = this.class.classLoader.getResource(".").path

		//var File temp = File.createTempFile("tempfile", machine.name + ".xmi")
		var File temp = new File(basePath + container.name + ".xmi")
		println(temp)
		val uri = URI.createURI(temp.absolutePath)

		// Load resource
		var Resource resource = resourceSet.createResource(uri)
		val res = resource as XMIResource

		// set the file encoding
		res.defaultLoadOptions.put(XMLResource.OPTION_ENCODING, "UTF-8")
		res.defaultSaveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8")
		if (resource == null) {
			throw new NullPointerException("The resource is null.")
		}
		resource.contents.add(container)
		resource.save(Collections.EMPTY_MAP) // resource.save(null)
	}
	
		
	def linkContainerToMachine(Container container, Machine machine) {
		var contains = DockerFactory.eINSTANCE.createContains
		// Add Container to the Contains
		contains.eContents.add(container)
		machine.links.add(contains)
		return machine
	}

}
