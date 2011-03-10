
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
 *         &lt;element name="RetrievePasswordResult" type="{http://www.centershift.com/STORE40/}Password_Response"/>
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
    "retrievePasswordResult"
})
@XmlRootElement(name = "RetrievePasswordResponse")
public class RetrievePasswordResponse {

    @XmlElement(name = "RetrievePasswordResult", required = true)
    protected PasswordResponse retrievePasswordResult;

    /**
     * Gets the value of the retrievePasswordResult property.
     * 
     * @return
     *     possible object is
     *     {@link PasswordResponse }
     *     
     */
    public PasswordResponse getRetrievePasswordResult() {
        return retrievePasswordResult;
    }

    /**
     * Sets the value of the retrievePasswordResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PasswordResponse }
     *     
     */
    public void setRetrievePasswordResult(PasswordResponse value) {
        this.retrievePasswordResult = value;
    }

}
