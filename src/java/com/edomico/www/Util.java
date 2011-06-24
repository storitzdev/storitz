package com.edomico.www;

import org.apache.axis.message.MessageElement;
import org.apache.axis.encoding.AnyContentType;
import org.w3c.dom.NodeList;

public class Util {

    public static String removeBoundingNode(String name, String input) {
        if (input == null || name == null) {
            return "";
        }
        return input.replaceAll("</?"+name+"/?>","");
    }

    public static MessageElement getBody (AnyContentType  anyContentType) {
        MessageElement [] messageElements = anyContentType.get_any();
        MessageElement head = messageElements[0]; // ignore the head
        MessageElement body = messageElements[1];
        return body;
    }

    public static NodeList getTopLevelNodeList(AnyContentType  anyContentType, String topLevelNode) {
        MessageElement element = Util.getBody(anyContentType);
        return element.getElementsByTagName(topLevelNode);
    }


}
