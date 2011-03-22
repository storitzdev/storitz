package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessManualAutoPay_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ProcessManualAutoPay_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TranID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessManualAutoPay_Response", propOrder = {
        "tranID"
})
public class ProcessManualAutoPayResponse2 {

    @XmlElement(name = "TranID")
    protected long tranID;

    /**
     * Gets the value of the tranID property.
     */
    public long getTranID() {
        return tranID;
    }

    /**
     * Sets the value of the tranID property.
     */
    public void setTranID(long value) {
        this.tranID = value;
    }

}
