/**
 */
package org.occiware.clouddesigner.OCCI.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.examples.library.collection.CollectionIncludesAllOperation;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.occiware.clouddesigner.OCCI.Configuration;
import org.occiware.clouddesigner.OCCI.Extension;
import org.occiware.clouddesigner.OCCI.Link;
import org.occiware.clouddesigner.OCCI.Mixin;
import org.occiware.clouddesigner.OCCI.OCCIPackage;
import org.occiware.clouddesigner.OCCI.OCCITables;
import org.occiware.clouddesigner.OCCI.Resource;
import org.occiware.clouddesigner.OCCI.util.OCCIValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Configuration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.occiware.clouddesigner.OCCI.impl.ConfigurationImpl#getUse <em>Use</em>}</li>
 *   <li>{@link org.occiware.clouddesigner.OCCI.impl.ConfigurationImpl#getResources <em>Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationImpl extends MinimalEObjectImpl.Container implements
		Configuration {
	/**
	 * The cached value of the '{@link #getUse() <em>Use</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUse()
	 * @generated
	 * @ordered
	 */
	protected EList<Extension> use;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> resources;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCCIPackage.Literals.CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Extension> getUse() {
		if (use == null) {
			use = new EObjectResolvingEList<Extension>(Extension.class, this, OCCIPackage.CONFIGURATION__USE);
		}
		return use;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Resource> getResources() {
		if (resources == null) {
			resources = new EObjectContainmentEList<Resource>(Resource.class, this, OCCIPackage.CONFIGURATION__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean AllResourcesLinksKindsInUse(
			final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		// /**
		// *
		// * inv AllResourcesLinksKindsInUse:
		// use->includesAll(resources.links.kind.oclContainer())
		// */
		// final /*@NonNull*/ /*@NonInvalid*/ DomainEvaluator evaluator =
		// PivotUtil.getEvaluator(this);
		// final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver =
		// evaluator.getIdResolver();
		// /*@NonNull*/ /*@Caught*/ Object CAUGHT_includesAll;
		// try {
		// final /*@NonNull*/ /*@Thrown*/ List<Extension> use = this.getUse();
		// final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_use =
		// idResolver.createOrderedSetOfAll(OCCITables.ORD_CLSSid_Extension,
		// use);
		// final /*@NonNull*/ /*@Thrown*/ List<Resource> resources =
		// this.getResources();
		// final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_resources =
		// idResolver.createOrderedSetOfAll(OCCITables.ORD_CLSSid_Resource,
		// resources);
		// /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator =
		// ValuesUtil.createSequenceAccumulatorValue(OCCITables.SEQ_CLSSid_Link);
		// /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_resources.iterator();
		// /*@NonNull*/ /*@Thrown*/ SequenceValue collect_1;
		// while (true) {
		// if (!ITERATOR__1.hasNext()) {
		// collect_1 = accumulator;
		// break;
		// }
		// /*@Nullable*/ /*@NonInvalid*/ Resource _1 =
		// (Resource)ITERATOR__1.next();
		// /**
		// * links
		// */
		// if (_1 == null) {
		// throw new
		// InvalidValueException("Null source for \'OCCI::Resource::links\'");
		// }
		// final /*@NonNull*/ /*@Thrown*/ List<Link> links = _1.getLinks();
		// final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_links =
		// idResolver.createOrderedSetOfAll(OCCITables.ORD_CLSSid_Link, links);
		// //
		// for (Object value : BOXED_links.flatten().getElements()) {
		// accumulator.add(value);
		// }
		// }
		// /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 =
		// ValuesUtil.createSequenceAccumulatorValue(OCCITables.SEQ_CLSSid_Kind);
		// /*@Nullable*/ Iterator<?> ITERATOR__1_0 = collect_1.iterator();
		// /*@NonNull*/ /*@Thrown*/ SequenceValue collect_0;
		// while (true) {
		// if (!ITERATOR__1_0.hasNext()) {
		// collect_0 = accumulator_0;
		// break;
		// }
		// /*@Nullable*/ /*@NonInvalid*/ Link _1_0 = (Link)ITERATOR__1_0.next();
		// /**
		// * kind
		// */
		// if (_1_0 == null) {
		// throw new
		// InvalidValueException("Null source for \'OCCI::Entity::kind\'");
		// }
		// final /*@Nullable*/ /*@Thrown*/ Kind kind = _1_0.getKind();
		// //
		// accumulator_0.add(kind);
		// }
		// /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_1 =
		// ValuesUtil.createSequenceAccumulatorValue(OCCITables.SEQ_CLSSid_OclElement);
		// /*@Nullable*/ Iterator<?> ITERATOR__1_1 = collect_0.iterator();
		// /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
		// while (true) {
		// if (!ITERATOR__1_1.hasNext()) {
		// collect = accumulator_1;
		// break;
		// }
		// /*@Nullable*/ /*@NonInvalid*/ Kind _1_1 = (Kind)ITERATOR__1_1.next();
		// /**
		// * oclContainer()
		// */
		// final /*@Nullable*/ /*@Thrown*/ Object oclContainer =
		// ClassifierOclContainerOperation.INSTANCE.evaluate(_1_1);
		// //
		// if (oclContainer instanceof CollectionValue) {
		// for (Object value :
		// ((CollectionValue)oclContainer).flatten().getElements()) {
		// accumulator_1.add(value);
		// }
		// }
		// else {
		// accumulator_1.add(oclContainer);
		// }
		// }
		// final /*@Thrown*/ boolean includesAll =
		// DomainUtil.nonNullState(CollectionIncludesAllOperation.INSTANCE.evaluate(BOXED_use,
		// collect).booleanValue());
		// CAUGHT_includesAll = includesAll;
		// }
		// catch (Exception e) {
		// CAUGHT_includesAll = ValuesUtil.createInvalidValue(e);
		// }
		// if (CAUGHT_includesAll == ValuesUtil.TRUE_VALUE) {
		// return true;
		// }
		// if (diagnostics != null) {
		// int severity = Diagnostic.WARNING;
		// String message =
		// DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_,
		// new Object[]{"Configuration", "AllResourcesLinksKindsInUse",
		// EObjectValidator.getObjectLabel(this, context)});
		// diagnostics.add(new BasicDiagnostic(severity,
		// OCCIValidator.DIAGNOSTIC_SOURCE,
		// OCCIValidator.CONFIGURATION__ALL_RESOURCES_LINKS_KINDS_IN_USE,
		// message, new Object [] { this }));
		// }
		// return false;
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean AllResourcesLinksTargetsInConfiguration(
			final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv AllResourcesLinksTargetsInConfiguration: resources.links.target->forAll(r | r.oclContainer() = self)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@NonNull*/ /*@Caught*/ Object CAUGHT_forAll;
		try {
		    final /*@NonNull*/ /*@Thrown*/ List<Resource> resources = this.getResources();
		    final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_resources = idResolver.createOrderedSetOfAll(OCCITables.ORD_CLSSid_Resource, resources);
		    /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValuesUtil.createSequenceAccumulatorValue(OCCITables.SEQ_CLSSid_Link);
		    /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_resources.iterator();
		    /*@NonNull*/ /*@Thrown*/ SequenceValue collect_0;
		    while (true) {
		        if (!ITERATOR__1.hasNext()) {
		            collect_0 = accumulator;
		            break;
		        }
		        /*@Nullable*/ /*@NonInvalid*/ Resource _1 = (Resource)ITERATOR__1.next();
		        /**
		         * links
		         */
		        if (_1 == null) {
		            throw new InvalidValueException("Null source for \'OCCI::Resource::links\'");
		        }
		        final /*@NonNull*/ /*@Thrown*/ List<Link> links = _1.getLinks();
		        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_links = idResolver.createOrderedSetOfAll(OCCITables.ORD_CLSSid_Link, links);
		        //
		        for (Object value : BOXED_links.flatten().getElements()) {
		            accumulator.add(value);
		        }
		    }
		    /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValuesUtil.createSequenceAccumulatorValue(OCCITables.SEQ_CLSSid_Resource);
		    /*@Nullable*/ Iterator<?> ITERATOR__1_0 = collect_0.iterator();
		    /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
		    while (true) {
		        if (!ITERATOR__1_0.hasNext()) {
		            collect = accumulator_0;
		            break;
		        }
		        /*@Nullable*/ /*@NonInvalid*/ Link _1_0 = (Link)ITERATOR__1_0.next();
		        /**
		         * target
		         */
		        if (_1_0 == null) {
		            throw new InvalidValueException("Null source for \'OCCI::Link::target\'");
		        }
		        final /*@NonNull*/ /*@Thrown*/ Resource target = _1_0.getTarget();
		        //
		        accumulator_0.add(target);
		    }
		    /*@NonNull*/ /*@Thrown*/ Object accumulator_1 = ValuesUtil.TRUE_VALUE;
		    /*@Nullable*/ Iterator<?> ITERATOR_r = collect.iterator();
		    /*@Thrown*/ boolean forAll;
		    while (true) {
		        if (!ITERATOR_r.hasNext()) {
		            if (accumulator_1 == ValuesUtil.TRUE_VALUE) {
		                forAll = (Boolean)accumulator_1;
		            }
		            else {
		                throw (InvalidValueException)accumulator_1;
		            }
		            break;
		        }
		        /*@Nullable*/ /*@NonInvalid*/ Resource r = (Resource)ITERATOR_r.next();
		        /**
		         * r.oclContainer() = self
		         */
		        /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final /*@Nullable*/ /*@Thrown*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(r);
		            final /*@Thrown*/ boolean eq = this.equals(oclContainer);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		        }
		        //
		        if (CAUGHT_eq == ValuesUtil.FALSE_VALUE) {					// Normal unsuccessful body evaluation result
		            forAll = ValuesUtil.FALSE_VALUE;
		            break;														// Stop immediately 
		        }
		        else if (CAUGHT_eq == ValuesUtil.TRUE_VALUE) {				// Normal successful body evaluation result
		            ;															// Carry on
		        }
		        else if (CAUGHT_eq instanceof InvalidValueException) {		// Abnormal exception evaluation result
		            accumulator_1 = CAUGHT_eq;									// Cache an exception failure
		        }
		        else {															// Impossible badly typed result
		            accumulator_1 = new InvalidValueException(EvaluatorMessages.NonBooleanBody, "forAll");
		        }
		    }
		    CAUGHT_forAll = forAll;
		}
		catch (Exception e) {
		    CAUGHT_forAll = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_forAll == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"Configuration", "AllResourcesLinksTargetsInConfiguration", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, OCCIValidator.DIAGNOSTIC_SOURCE, OCCIValidator.CONFIGURATION__ALL_RESOURCES_LINKS_TARGETS_IN_CONFIGURATION, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean AllResourcesKindsInUse(final DiagnosticChain diagnostics,
			final Map<Object, Object> context) {
		// /**
		// * inv AllResourcesKindsInUse:
		// use->includesAll(resources.kind.oclContainer())
		// */
		// final /*@NonNull*/ /*@NonInvalid*/ DomainEvaluator evaluator =
		// PivotUtil.getEvaluator(this);
		// final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver =
		// evaluator.getIdResolver();
		// /*@NonNull*/ /*@Caught*/ Object CAUGHT_includesAll;
		// try {
		// final /*@NonNull*/ /*@Thrown*/ List<Extension> use = this.getUse();
		// final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_use =
		// idResolver.createOrderedSetOfAll(OCCITables.ORD_CLSSid_Extension,
		// use);
		// final /*@NonNull*/ /*@Thrown*/ List<Resource> resources =
		// this.getResources();
		// final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_resources =
		// idResolver.createOrderedSetOfAll(OCCITables.ORD_CLSSid_Resource,
		// resources);
		// /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator =
		// ValuesUtil.createSequenceAccumulatorValue(OCCITables.SEQ_CLSSid_Kind);
		// /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_resources.iterator();
		// /*@NonNull*/ /*@Thrown*/ SequenceValue collect_0;
		// while (true) {
		// if (!ITERATOR__1.hasNext()) {
		// collect_0 = accumulator;
		// break;
		// }
		// /*@Nullable*/ /*@NonInvalid*/ Resource _1 =
		// (Resource)ITERATOR__1.next();
		// /**
		// * kind
		// */
		// if (_1 == null) {
		// throw new
		// InvalidValueException("Null source for \'OCCI::Entity::kind\'");
		// }
		// final /*@Nullable*/ /*@Thrown*/ Kind kind = _1.getKind();
		// //
		// accumulator.add(kind);
		// }
		// /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 =
		// ValuesUtil.createSequenceAccumulatorValue(OCCITables.SEQ_CLSSid_OclElement);
		// /*@Nullable*/ Iterator<?> ITERATOR__1_0 = collect_0.iterator();
		// /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
		// while (true) {
		// if (!ITERATOR__1_0.hasNext()) {
		// collect = accumulator_0;
		// break;
		// }
		// /*@Nullable*/ /*@NonInvalid*/ Kind _1_0 = (Kind)ITERATOR__1_0.next();
		// /**
		// * oclContainer()
		// */
		// final /*@Nullable*/ /*@Thrown*/ Object oclContainer =
		// ClassifierOclContainerOperation.INSTANCE.evaluate(_1_0);
		// //
		// if (oclContainer instanceof CollectionValue) {
		// for (Object value :
		// ((CollectionValue)oclContainer).flatten().getElements()) {
		// accumulator_0.add(value);
		// }
		// }
		// else {
		// accumulator_0.add(oclContainer);
		// }
		// }
		// final /*@Thrown*/ boolean includesAll =
		// DomainUtil.nonNullState(CollectionIncludesAllOperation.INSTANCE.evaluate(BOXED_use,
		// collect).booleanValue());
		// CAUGHT_includesAll = includesAll;
		// }
		// catch (Exception e) {
		// CAUGHT_includesAll = ValuesUtil.createInvalidValue(e);
		// }
		// if (CAUGHT_includesAll == ValuesUtil.TRUE_VALUE) {
		// return true;
		// }
		// if (diagnostics != null) {
		// int severity = Diagnostic.WARNING;
		// String message =
		// DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_,
		// new Object[]{"Configuration", "AllResourcesKindsInUse",
		// EObjectValidator.getObjectLabel(this, context)});
		// diagnostics.add(new BasicDiagnostic(severity,
		// OCCIValidator.DIAGNOSTIC_SOURCE,
		// OCCIValidator.CONFIGURATION__ALL_RESOURCES_KINDS_IN_USE, message, new
		// Object [] { this }));
		// }
		// return false;
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean AllResourcesMixinsInUse(final DiagnosticChain diagnostics,
			final Map<Object, Object> context) {
		/**
		 * inv AllResourcesMixinsInUse: use->includesAll(resources.mixins.oclContainer())
		 */
		final /*@NonNull*/ /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@NonNull*/ /*@Caught*/ Object CAUGHT_includesAll;
		try {
		    final /*@NonNull*/ /*@Thrown*/ List<Extension> use = this.getUse();
		    final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_use = idResolver.createOrderedSetOfAll(OCCITables.ORD_CLSSid_Extension, use);
		    final /*@NonNull*/ /*@Thrown*/ List<Resource> resources = this.getResources();
		    final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_resources = idResolver.createOrderedSetOfAll(OCCITables.ORD_CLSSid_Resource, resources);
		    /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValuesUtil.createSequenceAccumulatorValue(OCCITables.SEQ_CLSSid_Mixin);
		    /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_resources.iterator();
		    /*@NonNull*/ /*@Thrown*/ SequenceValue collect_0;
		    while (true) {
		        if (!ITERATOR__1.hasNext()) {
		            collect_0 = accumulator;
		            break;
		        }
		        /*@Nullable*/ /*@NonInvalid*/ Resource _1 = (Resource)ITERATOR__1.next();
		        /**
		         * mixins
		         */
		        if (_1 == null) {
		            throw new InvalidValueException("Null source for \'OCCI::Entity::mixins\'");
		        }
		        final /*@NonNull*/ /*@Thrown*/ List<Mixin> mixins = _1.getMixins();
		        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_mixins = idResolver.createOrderedSetOfAll(OCCITables.ORD_CLSSid_Mixin, mixins);
		        //
		        for (Object value : BOXED_mixins.flatten().getElements()) {
		            accumulator.add(value);
		        }
		    }
		    /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValuesUtil.createSequenceAccumulatorValue(OCCITables.SEQ_CLSSid_OclElement);
		    /*@Nullable*/ Iterator<?> ITERATOR__1_0 = collect_0.iterator();
		    /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
		    while (true) {
		        if (!ITERATOR__1_0.hasNext()) {
		            collect = accumulator_0;
		            break;
		        }
		        /*@Nullable*/ /*@NonInvalid*/ Mixin _1_0 = (Mixin)ITERATOR__1_0.next();
		        /**
		         * oclContainer()
		         */
		        final /*@Nullable*/ /*@Thrown*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(_1_0);
		        //
		        if (oclContainer instanceof CollectionValue) {
		            for (Object value : ((CollectionValue)oclContainer).flatten().getElements()) {
		                accumulator_0.add(value);
		            }
		        }
		        else {
		            accumulator_0.add(oclContainer);
		        }
		    }
		    final /*@Thrown*/ boolean includesAll = DomainUtil.nonNullState(CollectionIncludesAllOperation.INSTANCE.evaluate(BOXED_use, collect).booleanValue());
		    CAUGHT_includesAll = includesAll;
		}
		catch (Exception e) {
		    CAUGHT_includesAll = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_includesAll == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"Configuration", "AllResourcesMixinsInUse", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, OCCIValidator.DIAGNOSTIC_SOURCE, OCCIValidator.CONFIGURATION__ALL_RESOURCES_MIXINS_IN_USE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean AllResourcesLinksMixinsInUse(
			final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv AllResourcesLinksMixinsInUse: use->includesAll(resources.links.mixins.oclContainer())
		 */
		final /*@NonNull*/ /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@NonNull*/ /*@Caught*/ Object CAUGHT_includesAll;
		try {
		    final /*@NonNull*/ /*@Thrown*/ List<Extension> use = this.getUse();
		    final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_use = idResolver.createOrderedSetOfAll(OCCITables.ORD_CLSSid_Extension, use);
		    final /*@NonNull*/ /*@Thrown*/ List<Resource> resources = this.getResources();
		    final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_resources = idResolver.createOrderedSetOfAll(OCCITables.ORD_CLSSid_Resource, resources);
		    /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValuesUtil.createSequenceAccumulatorValue(OCCITables.SEQ_CLSSid_Link);
		    /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_resources.iterator();
		    /*@NonNull*/ /*@Thrown*/ SequenceValue collect_1;
		    while (true) {
		        if (!ITERATOR__1.hasNext()) {
		            collect_1 = accumulator;
		            break;
		        }
		        /*@Nullable*/ /*@NonInvalid*/ Resource _1 = (Resource)ITERATOR__1.next();
		        /**
		         * links
		         */
		        if (_1 == null) {
		            throw new InvalidValueException("Null source for \'OCCI::Resource::links\'");
		        }
		        final /*@NonNull*/ /*@Thrown*/ List<Link> links = _1.getLinks();
		        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_links = idResolver.createOrderedSetOfAll(OCCITables.ORD_CLSSid_Link, links);
		        //
		        for (Object value : BOXED_links.flatten().getElements()) {
		            accumulator.add(value);
		        }
		    }
		    /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValuesUtil.createSequenceAccumulatorValue(OCCITables.SEQ_CLSSid_Mixin);
		    /*@Nullable*/ Iterator<?> ITERATOR__1_0 = collect_1.iterator();
		    /*@NonNull*/ /*@Thrown*/ SequenceValue collect_0;
		    while (true) {
		        if (!ITERATOR__1_0.hasNext()) {
		            collect_0 = accumulator_0;
		            break;
		        }
		        /*@Nullable*/ /*@NonInvalid*/ Link _1_0 = (Link)ITERATOR__1_0.next();
		        /**
		         * mixins
		         */
		        if (_1_0 == null) {
		            throw new InvalidValueException("Null source for \'OCCI::Entity::mixins\'");
		        }
		        final /*@NonNull*/ /*@Thrown*/ List<Mixin> mixins = _1_0.getMixins();
		        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_mixins = idResolver.createOrderedSetOfAll(OCCITables.ORD_CLSSid_Mixin, mixins);
		        //
		        for (Object value : BOXED_mixins.flatten().getElements()) {
		            accumulator_0.add(value);
		        }
		    }
		    /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_1 = ValuesUtil.createSequenceAccumulatorValue(OCCITables.SEQ_CLSSid_OclElement);
		    /*@Nullable*/ Iterator<?> ITERATOR__1_1 = collect_0.iterator();
		    /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
		    while (true) {
		        if (!ITERATOR__1_1.hasNext()) {
		            collect = accumulator_1;
		            break;
		        }
		        /*@Nullable*/ /*@NonInvalid*/ Mixin _1_1 = (Mixin)ITERATOR__1_1.next();
		        /**
		         * oclContainer()
		         */
		        final /*@Nullable*/ /*@Thrown*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(_1_1);
		        //
		        if (oclContainer instanceof CollectionValue) {
		            for (Object value : ((CollectionValue)oclContainer).flatten().getElements()) {
		                accumulator_1.add(value);
		            }
		        }
		        else {
		            accumulator_1.add(oclContainer);
		        }
		    }
		    final /*@Thrown*/ boolean includesAll = DomainUtil.nonNullState(CollectionIncludesAllOperation.INSTANCE.evaluate(BOXED_use, collect).booleanValue());
		    CAUGHT_includesAll = includesAll;
		}
		catch (Exception e) {
		    CAUGHT_includesAll = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_includesAll == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"Configuration", "AllResourcesLinksMixinsInUse", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, OCCIValidator.DIAGNOSTIC_SOURCE, OCCIValidator.CONFIGURATION__ALL_RESOURCES_LINKS_MIXINS_IN_USE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OCCIPackage.CONFIGURATION__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OCCIPackage.CONFIGURATION__USE:
				return getUse();
			case OCCIPackage.CONFIGURATION__RESOURCES:
				return getResources();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OCCIPackage.CONFIGURATION__USE:
				getUse().clear();
				getUse().addAll((Collection<? extends Extension>)newValue);
				return;
			case OCCIPackage.CONFIGURATION__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends Resource>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OCCIPackage.CONFIGURATION__USE:
				getUse().clear();
				return;
			case OCCIPackage.CONFIGURATION__RESOURCES:
				getResources().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OCCIPackage.CONFIGURATION__USE:
				return use != null && !use.isEmpty();
			case OCCIPackage.CONFIGURATION__RESOURCES:
				return resources != null && !resources.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID) {
			case OCCIPackage.CONFIGURATION___ALL_RESOURCES_LINKS_KINDS_IN_USE__DIAGNOSTICCHAIN_MAP:
				return AllResourcesLinksKindsInUse((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case OCCIPackage.CONFIGURATION___ALL_RESOURCES_LINKS_TARGETS_IN_CONFIGURATION__DIAGNOSTICCHAIN_MAP:
				return AllResourcesLinksTargetsInConfiguration((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case OCCIPackage.CONFIGURATION___ALL_RESOURCES_KINDS_IN_USE__DIAGNOSTICCHAIN_MAP:
				return AllResourcesKindsInUse((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case OCCIPackage.CONFIGURATION___ALL_RESOURCES_MIXINS_IN_USE__DIAGNOSTICCHAIN_MAP:
				return AllResourcesMixinsInUse((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case OCCIPackage.CONFIGURATION___ALL_RESOURCES_LINKS_MIXINS_IN_USE__DIAGNOSTICCHAIN_MAP:
				return AllResourcesLinksMixinsInUse((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // ConfigurationImpl
