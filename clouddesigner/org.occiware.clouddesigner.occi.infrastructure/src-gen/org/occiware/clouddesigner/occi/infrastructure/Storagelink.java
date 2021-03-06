/**
 * Copyright (c) 2015-2016 Obeo, Inria
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 	
 * Contributors:
 * - William Piers <william.piers@obeo.fr>
 * - Philippe Merle <philippe.merle@inria.fr>
 */
package org.occiware.clouddesigner.occi.infrastructure;

import org.occiware.clouddesigner.occi.Link;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Storagelink</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.occiware.clouddesigner.occi.infrastructure.Storagelink#getDeviceid <em>Deviceid</em>}</li>
 *   <li>{@link org.occiware.clouddesigner.occi.infrastructure.Storagelink#getMountpoint <em>Mountpoint</em>}</li>
 *   <li>{@link org.occiware.clouddesigner.occi.infrastructure.Storagelink#getState <em>State</em>}</li>
 *   <li>{@link org.occiware.clouddesigner.occi.infrastructure.Storagelink#getMessage <em>Message</em>}</li>
 * </ul>
 *
 * @see org.occiware.clouddesigner.occi.infrastructure.InfrastructurePackage#getStoragelink()
 * @model annotation="OCCIE2Ecore title='StorageLink Link'"
 * @generated
 */
public interface Storagelink extends Link {
	/**
	 * Returns the value of the '<em><b>Deviceid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deviceid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deviceid</em>' attribute.
	 * @see #setDeviceid(String)
	 * @see org.occiware.clouddesigner.occi.infrastructure.InfrastructurePackage#getStoragelink_Deviceid()
	 * @model dataType="org.occiware.clouddesigner.occi.String" required="true"
	 *        annotation="OCCIE2Ecore description='Device identifier as defined by the OCCI service provider'"
	 * @generated
	 */
	String getDeviceid();

	/**
	 * Sets the value of the '{@link org.occiware.clouddesigner.occi.infrastructure.Storagelink#getDeviceid <em>Deviceid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deviceid</em>' attribute.
	 * @see #getDeviceid()
	 * @generated
	 */
	void setDeviceid(String value);

	/**
	 * Returns the value of the '<em><b>Mountpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mountpoint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mountpoint</em>' attribute.
	 * @see #setMountpoint(String)
	 * @see org.occiware.clouddesigner.occi.infrastructure.InfrastructurePackage#getStoragelink_Mountpoint()
	 * @model dataType="org.occiware.clouddesigner.occi.String"
	 *        annotation="OCCIE2Ecore description='Point to where the storage is mounted in the guest OS'"
	 * @generated
	 */
	String getMountpoint();

	/**
	 * Sets the value of the '{@link org.occiware.clouddesigner.occi.infrastructure.Storagelink#getMountpoint <em>Mountpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mountpoint</em>' attribute.
	 * @see #getMountpoint()
	 * @generated
	 */
	void setMountpoint(String value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.occiware.clouddesigner.occi.infrastructure.StorageLinkStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.occiware.clouddesigner.occi.infrastructure.StorageLinkStatus
	 * @see #setState(StorageLinkStatus)
	 * @see org.occiware.clouddesigner.occi.infrastructure.InfrastructurePackage#getStoragelink_State()
	 * @model required="true"
	 *        annotation="OCCIE2Ecore description='Current status of the instance'"
	 * @generated
	 */
	StorageLinkStatus getState();

	/**
	 * Sets the value of the '{@link org.occiware.clouddesigner.occi.infrastructure.Storagelink#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.occiware.clouddesigner.occi.infrastructure.StorageLinkStatus
	 * @see #getState()
	 * @generated
	 */
	void setState(StorageLinkStatus value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.occiware.clouddesigner.occi.infrastructure.InfrastructurePackage#getStoragelink_Message()
	 * @model dataType="org.occiware.clouddesigner.occi.String"
	 *        annotation="OCCIE2Ecore description='Human-readable explanation of the current instance state'"
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.occiware.clouddesigner.occi.infrastructure.Storagelink#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

} // Storagelink
