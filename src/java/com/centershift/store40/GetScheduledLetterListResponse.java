
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
 *         &lt;element name="getScheduledLetterListResult" type="{http://www.centershift.com/STORE40/}getScheduledLetterList_Response"/>
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
    "getScheduledLetterListResult"
})
@XmlRootElement(name = "getScheduledLetterListResponse")
public class GetScheduledLetterListResponse {

    @XmlElement(required = true)
    protected GetScheduledLetterListResponse2 getScheduledLetterListResult;

    /**
     * Gets the value of the getScheduledLetterListResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetScheduledLetterListResponse2 }
     *     
     */
    public GetScheduledLetterListResponse2 getGetScheduledLetterListResult() {
        return getScheduledLetterListResult;
    }

    /**
     * Sets the value of the getScheduledLetterListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetScheduledLetterListResponse2 }
     *     
     */
    public void setGetScheduledLetterListResult(GetScheduledLetterListResponse2 value) {
        this.getScheduledLetterListResult = value;
    }

}
