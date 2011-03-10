
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
 *         &lt;element name="createLetterResult" type="{http://www.centershift.com/STORE40/}tntLtrNum_Response"/>
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
    "createLetterResult"
})
@XmlRootElement(name = "createLetterResponse")
public class CreateLetterResponse {

    @XmlElement(required = true)
    protected TntLtrNumResponse createLetterResult;

    /**
     * Gets the value of the createLetterResult property.
     * 
     * @return
     *     possible object is
     *     {@link TntLtrNumResponse }
     *     
     */
    public TntLtrNumResponse getCreateLetterResult() {
        return createLetterResult;
    }

    /**
     * Sets the value of the createLetterResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link TntLtrNumResponse }
     *     
     */
    public void setCreateLetterResult(TntLtrNumResponse value) {
        this.createLetterResult = value;
    }

}
