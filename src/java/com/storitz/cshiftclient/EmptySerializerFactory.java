package com.storitz.cshiftclient;

import org.apache.axis.encoding.SerializerFactory;

import javax.xml.rpc.encoding.Serializer;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Aug 23, 2010
 * Time: 12:04:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmptySerializerFactory implements javax.xml.rpc.encoding.SerializerFactory, SerializerFactory {

//    @Override
    public Serializer getSerializerAs(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

//    @Override
    public Iterator getSupportedMechanismTypes() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
