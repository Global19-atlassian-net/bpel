/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.jboss.riftsaw.runtime.module;

import org.eclipse.bpel.jboss.riftsaw.runtime.IRiftsawModuleFacetConstants;
import org.eclipse.bpel.runtimes.IBPELModuleFacetConstants;
import org.eclipse.bpel.runtimes.module.BPELModuleArtifact;
import org.eclipse.bpel.runtimes.module.BPELModuleDelegate;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IModuleArtifact;
import org.eclipse.wst.server.core.ServerUtil;

public class RiftsawDeployableArtifactUtil {
	
	public RiftsawDeployableArtifactUtil() {
		super();
	}
	
	/**
	 * Adapt an object to an <code>IModuleArtifact</code>
	 * 
	 * @param obj
	 * @return <code>IModuleArtifact</code>
	 */
	public static IModuleArtifact getModuleObject(Object obj) {
		if (obj instanceof IProject) {
			return getModuleObject((IProject) obj);
		}
			
		if (obj instanceof IFile) {
			return getModuleObject((IFile) obj);
		}
			
		return null;
	}
	
	protected static IModuleArtifact getModuleObject(IProject project) {
		return null;
	}
	
	protected static IModuleArtifact getModuleObject(IFile file) {
		// TODO this is not really how you should be using RiftsawModuleDelegate 
		BPELModuleDelegate moduleDelegate = new BPELModuleDelegate(file.getProject(), file);
		IStatus fileStatus = moduleDelegate.validate();
		
		if (IStatus.OK != fileStatus.getCode()) return null; // not a valid BPEL file
		
		IModule[] modules = ServerUtil.getModules(
				IRiftsawModuleFacetConstants.JBT_BPEL_MODULE_TYPE);
		
		for (int i=0; i<modules.length; i++) {
			
			if (modules[i].getProject().equals(file.getProject()) 
					&& modules[i].getName().equals(file.getName())) 
			{
				return new BPELModuleArtifact(modules[i], file);
			}
		}
		return null;
	}
}
