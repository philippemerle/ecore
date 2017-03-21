/*******************************************************************************
 * Copyright (c) 2015-2016 Obeo, Inria
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * - William Piers <william.piers@obeo.fr>
 * - Philippe Merle <philippe.merle@inria.fr>
 *******************************************************************************/

package org.occiware.clouddesigner.occi.monitoring.ext.design.wizard;

import org.occiware.clouddesigner.occi.design.utils.NewDiagramWizard;

/**
 * This is a simple wizard for creating a new monitoringext model file.
 */

public class NewConfigurationWizard extends NewDiagramWizard
{
	public NewConfigurationWizard()
	{
		super("http://occiware.org/occi/monitoring/ext#", "viewpoint:/org.occiware.clouddesigner.occi.monitoring.ext.design/MonitoringextConfiguration", "monitoringext", "MonitoringextConfiguration Diagram");
	}
}
