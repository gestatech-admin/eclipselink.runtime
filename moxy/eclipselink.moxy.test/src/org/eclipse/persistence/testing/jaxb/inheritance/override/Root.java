/*******************************************************************************
 * Copyright (c) 2012, 2015 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Matt MacIvor - 2.5.1 - initial implementation
 ******************************************************************************/
package org.eclipse.persistence.testing.jaxb.inheritance.override;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Root {

    protected Subclass subclass;

    public Subclass getSubclass() {
        return subclass;
    }

    public void setSubclass(Subclass subclass) {
        this.subclass = subclass;
    }

    @Override
    public boolean equals(Object obj) {
        return this.subclass.equals(((Root)obj).getSubclass());
    }

    @Override
    public int hashCode() {
        return subclass != null ? subclass.hashCode() : 0;
    }
}
