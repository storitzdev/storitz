package com.storitz.cshiftclient;

import org.apache.axis.Constants;
import org.apache.axis.encoding.DeserializerFactory;

import javax.xml.rpc.encoding.Deserializer;
import java.util.Iterator;
import java.util.Vector;

public class EmptyDeserializerFactory implements javax.xml.rpc.encoding.DeserializerFactory, DeserializerFactory {

    Vector mechanisms;
    
//    @Override
    public Deserializer getDeserializerAs(String s) {
        return new EmptyDeserializer();
    }

//    @Override
    public Iterator getSupportedMechanismTypes() {
        if (mechanisms == null) {
            mechanisms = new Vector(1);
            mechanisms.add(Constants.AXIS_SAX);
        }
        return mechanisms.iterator();
    }
}