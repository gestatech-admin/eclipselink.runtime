/*******************************************************************************
 * Copyright (c) 2011, 2015 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     12/18/2009-2.1 Guy Pelletier
 *       - 211323: Add class extractor support to the EclipseLink-ORM.XML Schema
 ******************************************************************************/
package org.eclipse.persistence.testing.models.jpa.inheritance;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(
    name="findAllMacBookPros",
    query="SELECT mbp FROM MacBookPro mbp"
)
@Table(name="JPA_MACBOOK_PRO")
public class MacBookPro extends MacBook {
    public String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRam(Integer ram) {
        if (ram <= 4) {
            this.ram = 6;
        } else {
            this.ram = ram;
        }
    }
}
