
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
 *         &lt;element name="AddUpdateMerchandiseItemsResult" type="{http://www.centershift.com/STORE40/}AddUpdateMerchandiseItems_Response"/>
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
    "addUpdateMerchandiseItemsResult"
})
@XmlRootElement(name = "AddUpdateMerchandiseItemsResponse")
public class AddUpdateMerchandiseItemsResponse {

    @XmlElement(name = "AddUpdateMerchandiseItemsResult", required = true)
    protected AddUpdateMerchandiseItemsResponse2 addUpdateMerchandiseItemsResult;

    /**
     * Gets the value of the addUpdateMerchandiseItemsResult property.
     * 
     * @return
     *     possible object is
     *     {@link AddUpdateMerchandiseItemsResponse2 }
     *     
     */
    public AddUpdateMerchandiseItemsResponse2 getAddUpdateMerchandiseItemsResult() {
        return addUpdateMerchandiseItemsResult;
    }

    /**
     * Sets the value of the addUpdateMerchandiseItemsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddUpdateMerchandiseItemsResponse2 }
     *     
     */
    public void setAddUpdateMerchandiseItemsResult(AddUpdateMerchandiseItemsResponse2 value) {
        this.addUpdateMerchandiseItemsResult = value;
    }

}
