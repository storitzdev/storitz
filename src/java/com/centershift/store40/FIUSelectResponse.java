
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
 *         &lt;element name="FIUSelectResult" type="{http://www.centershift.com/STORE40/}FIU_Response"/>
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
    "fiuSelectResult"
})
@XmlRootElement(name = "FIUSelectResponse")
public class FIUSelectResponse {

    @XmlElement(name = "FIUSelectResult", required = true)
    protected FIUResponse fiuSelectResult;

    /**
     * Gets the value of the fiuSelectResult property.
     * 
     * @return
     *     possible object is
     *     {@link FIUResponse }
     *     
     */
    public FIUResponse getFIUSelectResult() {
        return fiuSelectResult;
    }

    /**
     * Sets the value of the fiuSelectResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link FIUResponse }
     *     
     */
    public void setFIUSelectResult(FIUResponse value) {
        this.fiuSelectResult = value;
    }

}
