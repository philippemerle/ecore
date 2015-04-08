/*
 * generated by Xtext
 */
package org.occiware.clouddesigner.occi.xtext.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.occiware.clouddesigner.OCCI.Action;
import org.occiware.clouddesigner.OCCI.Attribute;
import org.occiware.clouddesigner.OCCI.Extension;
import org.occiware.clouddesigner.OCCI.Kind;
import org.occiware.clouddesigner.OCCI.Mixin;
import org.occiware.clouddesigner.OCCI.OCCIPackage;
import org.occiware.clouddesigner.occi.xtext.services.OCCIGrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractOCCISemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private OCCIGrammarAccess grammarAccess;
	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == OCCIPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case OCCIPackage.ACTION:
				sequence_Action(context, (Action) semanticObject); 
				return; 
			case OCCIPackage.ATTRIBUTE:
				sequence_Attribute(context, (Attribute) semanticObject); 
				return; 
			case OCCIPackage.EXTENSION:
				sequence_Extension(context, (Extension) semanticObject); 
				return; 
			case OCCIPackage.KIND:
				sequence_Kind(context, (Kind) semanticObject); 
				return; 
			case OCCIPackage.MIXIN:
				sequence_Mixin(context, (Mixin) semanticObject); 
				return; 
			}
		else if(semanticObject.eClass().getEPackage() == EcorePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case EcorePackage.EDATA_TYPE:
				sequence_EDataType_Impl(context, (EDataType) semanticObject); 
				return; 
			case EcorePackage.EENUM:
				sequence_EEnum(context, (EEnum) semanticObject); 
				return; 
			case EcorePackage.EENUM_LITERAL:
				sequence_EEnumLiteral(context, (EEnumLiteral) semanticObject); 
				return; 
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (term=EString scheme=EString title=EString? (attributes+=Attribute attributes+=Attribute*)?)
	 */
	protected void sequence_Action(EObject context, Action semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString mutable=EBoolean? required=EBoolean? default=EString? description=EString?)
	 */
	protected void sequence_Attribute(EObject context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString instanceClassName=EString? instanceTypeName=EString? serializable=EBoolean?)
	 */
	protected void sequence_EDataType_Impl(EObject context, EDataType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString value=EInt? literal=EString?)
	 */
	protected void sequence_EEnumLiteral(EObject context, EEnumLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString instanceClassName=EString? instanceTypeName=EString? serializable=EBoolean? (eLiterals+=EEnumLiteral eLiterals+=EEnumLiteral*)?)
	 */
	protected void sequence_EEnum(EObject context, EEnum semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=EString 
	 *         scheme=EString 
	 *         (import+=[Extension|EString] import+=[Extension|EString]*)? 
	 *         (kinds+=Kind kinds+=Kind*)? 
	 *         (mixins+=Mixin mixins+=Mixin*)?
	 *     )
	 */
	protected void sequence_Extension(EObject context, Extension semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         term=EString 
	 *         scheme=EString 
	 *         title=EString? 
	 *         parent=[Kind|EString]? 
	 *         (attributes+=Attribute attributes+=Attribute*)? 
	 *         (actions+=Action actions+=Action*)?
	 *     )
	 */
	protected void sequence_Kind(EObject context, Kind semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (term=EString scheme=EString title=EString? (attributes+=Attribute attributes+=Attribute*)? (actions+=Action actions+=Action*)?)
	 */
	protected void sequence_Mixin(EObject context, Mixin semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
