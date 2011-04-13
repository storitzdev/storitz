package com.edomico.www;


import java.util.HashMap;
import java.util.Set;

public class EDomicoNode {
    private HashMap<String,String> values = null;

    public EDomicoNode(org.w3c.dom.NodeList childNodes) {
        values = new HashMap<String,String>();
        for (int j = 0; j < childNodes.getLength(); j++) {
            org.w3c.dom.Node childNode = childNodes.item(j);
            String name = childNode.getNodeName();
            String value = Util.removeBoundingNode(name, childNode.toString());
            values.put(name,value);
        }
    }

    public Set<String> keys() {
        return values.keySet();
    }

    public void set(String key, String val) {
        values.put(key,val);
    }

    public String get(String key) {
        String value = values.get(key);
        if (value == null) {
            value = "";
        }
        return value;
    }
}
