
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddUpdatePCD_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddUpdatePCD_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PcdID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddUpdatePCD_Response", propOrder = {
    "pcdID"
})
public class AddUpdatePCDResponse2 {

    @XmlElement(name = "PcdID")
    protected long pcdID;

    /**
     * Gets the value of the pcdID property.
     * 
     */
    public long getPcdID() {
        return pcdID;
    }

    /**
     * Sets the value of the pcdID property.
     * 
     */
    public void setPcdID(long value) {
        this.pcdID = value;
    }

}
