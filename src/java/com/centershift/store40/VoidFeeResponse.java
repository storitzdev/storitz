
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VoidFeeResult" type="{http://www.centershift.com/STORE40/}VoidFee_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "voidFeeResult"
})
@XmlRootElement(name = "VoidFeeResponse")
public class VoidFeeResponse {

    @XmlElement(name = "VoidFeeResult", required = true)
    protected VoidFeeResponse2 voidFeeResult;

    /**
     * Gets the value of the voidFeeResult property.
     * 
     * @return
     *     possible object is
     *     {@link VoidFeeResponse2 }
     *     
     */
    public VoidFeeResponse2 getVoidFeeResult() {
        return voidFeeResult;
    }

    /**
     * Sets the value of the voidFeeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoidFeeResponse2 }
     *     
     */
    public void setVoidFeeResult(VoidFeeResponse2 value) {
        this.voidFeeResult = value;
    }

}
