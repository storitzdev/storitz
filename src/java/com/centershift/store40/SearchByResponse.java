
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
 *         &lt;element name="SearchByResult" type="{http://www.centershift.com/STORE40/}SearchBy_Response"/>
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
    "searchByResult"
})
@XmlRootElement(name = "SearchByResponse")
public class SearchByResponse {

    @XmlElement(name = "SearchByResult", required = true)
    protected SearchByResponse2 searchByResult;

    /**
     * Gets the value of the searchByResult property.
     * 
     * @return
     *     possible object is
     *     {@link SearchByResponse2 }
     *     
     */
    public SearchByResponse2 getSearchByResult() {
        return searchByResult;
    }

    /**
     * Sets the value of the searchByResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchByResponse2 }
     *     
     */
    public void setSearchByResult(SearchByResponse2 value) {
        this.searchByResult = value;
    }

}
