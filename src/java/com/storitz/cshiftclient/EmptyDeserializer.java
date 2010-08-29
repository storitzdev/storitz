package com.storitz.cshiftclient;

import org.apache.axis.encoding.DeserializerImpl;
import org.apache.axis.Constants;
import org.apache.axis.encoding.DeserializationContext;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.FieldTarget;
import org.apache.axis.message.SOAPHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import javax.xml.namespace.QName;
import java.util.Hashtable;

/**
 *
 *
 */
public class EmptyDeserializer extends DeserializerImpl {

		 public static final QName myTypeQName = new QName("http://schemas.microsoft.com/soap-toolkit/data-types", "empty");

		 public EmptyDeserializer()
		 {
		 }

		 /** DESERIALIZER - event handlers
    	  */
         @Override
         public void onStartElement(java.lang.String namespace, java.lang.String localName, java.lang.String prefix, org.xml.sax.Attributes attributes, org.apache.axis.encoding.DeserializationContext context)
                 throws org.xml.sax.SAXException {

             setValue("");
         }
}