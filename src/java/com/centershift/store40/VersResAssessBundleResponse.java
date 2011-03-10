
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
 *         &lt;element name="VersResAssessBundleResult" type="{http://www.centershift.com/STORE40/}VersResAssessBundle_Response"/>
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
    "versResAssessBundleResult"
})
@XmlRootElement(name = "VersResAssessBundleResponse")
public class VersResAssessBundleResponse {

    @XmlElement(name = "VersResAssessBundleResult", required = true)
    protected VersResAssessBundleResponse2 versResAssessBundleResult;

    /**
     * Gets the value of the versResAssessBundleResult property.
     * 
     * @return
     *     possible object is
     *     {@link VersResAssessBundleResponse2 }
     *     
     */
    public VersResAssessBundleResponse2 getVersResAssessBundleResult() {
        return versResAssessBundleResult;
    }

    /**
     * Sets the value of the versResAssessBundleResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersResAssessBundleResponse2 }
     *     
     */
    public void setVersResAssessBundleResult(VersResAssessBundleResponse2 value) {
        this.versResAssessBundleResult = value;
    }

}
