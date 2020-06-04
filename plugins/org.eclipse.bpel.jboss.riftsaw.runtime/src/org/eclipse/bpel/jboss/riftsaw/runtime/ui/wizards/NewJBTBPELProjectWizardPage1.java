/*******************************************************************************
 * Copyright (c) 2006, 2012 University College London Software Systems Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	Bruno Wassermann - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.jboss.riftsaw.runtime.ui.wizards;

import org.eclipse.bpel.jboss.riftsaw.runtime.IRiftsawModuleFacetConstants;
import org.eclipse.bpel.jboss.riftsaw.runtime.RiftsawPlugin;
import org.eclipse.bpel.runtimes.IBPELModuleFacetConstants;
import org.eclipse.bpel.runtimes.IRuntimesUIConstants;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.bpel.jboss.riftsaw.runtime.ui.wizards.Messages;
import org.eclipse.wst.web.ui.internal.wizards.DataModelFacetCreationWizardPage;

/**
 * <code>DataModelFacetCreationWizardPage</code> for setting up a new BPEL
 * project.
 *
 * @author Bruno Wassermann, written Jun 29, 2006
 */
public class NewJBTBPELProjectWizardPage1 extends DataModelFacetCreationWizardPage {

	public NewJBTBPELProjectWizardPage1(IDataModel dataModel, String pageName) {
		super(dataModel, pageName);
		//setTitle(org.eclipse.bpel.runtimes.ui.wizards.Messages.NewProjectWizard_1);
		//setDescription(org.eclipse.bpel.runtimes.ui.wizards.Messages.NewProjectWizardPage1_1);
		setTitle(org.eclipse.bpel.jboss.riftsaw.runtime.ui.wizards.Messages.NewProjectWizard_1);
		setDescription(org.eclipse.bpel.jboss.riftsaw.runtime.ui.wizards.Messages.NewProjectWizardPage1_1);		
		setImageDescriptor(RiftsawPlugin.getPlugin().getImageDescriptor(IRuntimesUIConstants.ICON_NEWPRJ_WIZARD_BANNER));
	}
	
	protected String getModuleFacetID() {
		return IRiftsawModuleFacetConstants.JBT_BPEL_MODULE_TYPE;
	}

	protected String getModuleTypeID() {
		return IRiftsawModuleFacetConstants.JBT_BPEL_PROJECT_FACET;
	}
	
}
