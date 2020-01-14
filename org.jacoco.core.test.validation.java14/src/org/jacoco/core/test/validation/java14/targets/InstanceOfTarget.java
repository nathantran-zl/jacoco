/*******************************************************************************
 * Copyright (c) 2009, 2020 Mountainminds GmbH & Co. KG and Contributors
 * This program and the accompanying materials are made available under
 * the terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Marc R. Hoffmann - initial API and implementation
 *
 *******************************************************************************/
package org.jacoco.core.test.validation.java14.targets;

import static org.jacoco.core.test.validation.targets.Stubs.nop;

/**
 * This target exercises pattern matching for instanceof (JEP 305).
 */
public class InstanceOfTarget {

	public static void main(String[] args) {
		ifInstanceOf(new Object());
		ifInstanceOf("string");
	}

	private static void ifInstanceOf(Object obj) {
		/* FAILURE: expected:<Counter[0/2]> but was:<Counter[1/3]>) */
		if (obj instanceof String s) { // assertFullyCovered(0, 2)
			nop(s); // assertFullyCovered()
		}
	}

}
