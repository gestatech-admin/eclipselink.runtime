/*******************************************************************************
 * Copyright (c) 2014, 2015  Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Dmitry Kornilov - Initial implementation
 ******************************************************************************/
package org.eclipse.persistence.jpa.rs.util.metadatasources;

import org.eclipse.persistence.internal.jpa.rs.metadata.model.CollectionWrapper;
import org.eclipse.persistence.jaxb.metadata.MetadataSource;
import org.eclipse.persistence.jaxb.xmlmodel.JavaType;
import org.eclipse.persistence.jaxb.xmlmodel.XmlBindings;
import org.eclipse.persistence.jaxb.xmlmodel.XmlBindings.JavaTypes;

import java.util.Map;

/**
 * Makes the CollectionWrapper class available in our Dynamic JAXB context.
 *
 * @author Dmitry Kornilov
 * @since EclipseLink 2.6.0
 */
public class CollectionWrapperMetadataSource implements MetadataSource {

    private final XmlBindings xmlBindings;

    /**
     * Creates a new CollectionWrapperMetadataSource.
     */
    public CollectionWrapperMetadataSource() {
        xmlBindings = new XmlBindings();
        xmlBindings.setPackageName(CollectionWrapper.class.getPackage().getName());

        final JavaType javaType = new JavaType();
        javaType.setName(CollectionWrapper.class.getSimpleName());
        javaType.setXmlRootElement(new org.eclipse.persistence.jaxb.xmlmodel.XmlRootElement());

        final JavaTypes javaTypes = new JavaTypes();
        javaTypes.getJavaType().add(javaType);

        xmlBindings.setJavaTypes(javaTypes);
    }

    @Override
    public XmlBindings getXmlBindings(Map<String, ?> properties, ClassLoader classLoader) {
        return this.xmlBindings;
    }
}
