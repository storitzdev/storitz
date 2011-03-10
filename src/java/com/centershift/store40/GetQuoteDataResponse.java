
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
 *         &lt;element name="GetQuoteDataResult" type="{http://www.centershift.com/STORE40/}GetQuoteData_Response"/>
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
    "getQuoteDataResult"
})
@XmlRootElement(name = "GetQuoteDataResponse")
public class GetQuoteDataResponse {

    @XmlElement(name = "GetQuoteDataResult", required = true)
    protected GetQuoteDataResponse2 getQuoteDataResult;

    /**
     * Gets the value of the getQuoteDataResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetQuoteDataResponse2 }
     *     
     */
    public GetQuoteDataResponse2 getGetQuoteDataResult() {
        return getQuoteDataResult;
    }

    /**
     * Sets the value of the getQuoteDataResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetQuoteDataResponse2 }
     *     
     */
    public void setGetQuoteDataResult(GetQuoteDataResponse2 value) {
        this.getQuoteDataResult = value;
    }

}
