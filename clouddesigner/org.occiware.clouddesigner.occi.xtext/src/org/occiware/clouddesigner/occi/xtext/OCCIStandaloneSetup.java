/*
 * generated by Xtext
 */
package org.occiware.clouddesigner.occi.xtext;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class OCCIStandaloneSetup extends OCCIStandaloneSetupGenerated{

	public static void doSetup() {
		new OCCIStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

