/*******************************************************************************
 * Copyright (c) 1998, 2015 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     03/26/2008-1.0M6 Guy Pelletier
 *       - 211302: Add variable 1-1 mapping support to the EclipseLink-ORM.XML Schema
 ******************************************************************************/
package org.eclipse.persistence.testing.models.jpa.relationships;

import static javax.persistence.GenerationType.TABLE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.CloneCopyPolicy;

@Entity
@Table(name="CMP3_NAMCO")
@CloneCopyPolicy(method="cloneNamco", workingCopyMethod="cloneWorkingCopyNamco")
public class Namco implements Distributor, Cloneable {
    private Integer distributorId;
    private String name;

    public Namco() {}

    public Namco clone(){
        try{
            return (Namco)super.clone();
        } catch (CloneNotSupportedException exc){
            return null;
        }
    }

    public Namco cloneNamco(){
        return this.clone();
    }

    public Namco cloneWorkingCopyNamco(){
        return this.clone();
    }

    @Id
    @GeneratedValue(strategy=TABLE, generator="DISTRIBUTOR_TABLE_GENERATOR")
    @Column(name="ID")
    public Integer getDistributorId() {
        return distributorId;
    }

    public String getName() {
        return name;
    }

    public void setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
    }

    public void setName(String name) {
        this.name = name;
    }


}
