
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
 *         &lt;element name="GetMoveOutInfoResult" type="{http://www.centershift.com/STORE40/}GetMoveOutInfo_Response"/>
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
    "getMoveOutInfoResult"
})
@XmlRootElement(name = "GetMoveOutInfoResponse")
public class GetMoveOutInfoResponse {

    @XmlElement(name = "GetMoveOutInfoResult", required = true)
    protected GetMoveOutInfoResponse2 getMoveOutInfoResult;

    /**
     * Gets the value of the getMoveOutInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetMoveOutInfoResponse2 }
     *     
     */
    public GetMoveOutInfoResponse2 getGetMoveOutInfoResult() {
        return getMoveOutInfoResult;
    }

    /**
     * Sets the value of the getMoveOutInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetMoveOutInfoResponse2 }
     *     
     */
    public void setGetMoveOutInfoResult(GetMoveOutInfoResponse2 value) {
        this.getMoveOutInfoResult = value;
    }

}
