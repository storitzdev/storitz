package com.storitz.cshiftclient;

import org.apache.axis.encoding.DeserializerImpl;

import javax.xml.namespace.QName;

/**
 *
 *
 */
public class EmptyDeserializer extends DeserializerImpl {

    public static final QName myTypeQName = new QName("http://schemas.microsoft.com/soap-toolkit/data-types", "empty");

    public EmptyDeserializer() {
    }

    /**
     * DESERIALIZER - event handlers
     */
    @Override
    public void onStartElement(java.lang.String namespace, java.lang.String localName, java.lang.String prefix, org.xml.sax.Attributes attributes, org.apache.axis.encoding.DeserializationContext context)
            throws org.xml.sax.SAXException {

        setValue("");
    }
}