
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddUpdateMerchandiseItems_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddUpdateMerchandiseItems_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgRetailItems" type="{http://www.centershift.com/STORE40/}ArrayOfORG_RETAIL_ITEMS" minOccurs="0"/>
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddUpdateMerchandiseItems_Response", propOrder = {
    "orgRetailItems",
    "errorMessage"
})
public class AddUpdateMerchandiseItemsResponse2 {

    @XmlElement(name = "OrgRetailItems")
    protected ArrayOfORGRETAILITEMS orgRetailItems;
    @XmlElement(name = "ErrorMessage")
    protected String errorMessage;

    /**
     * Gets the value of the orgRetailItems property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfORGRETAILITEMS }
     *     
     */
    public ArrayOfORGRETAILITEMS getOrgRetailItems() {
        return orgRetailItems;
    }

    /**
     * Sets the value of the orgRetailItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfORGRETAILITEMS }
     *     
     */
    public void setOrgRetailItems(ArrayOfORGRETAILITEMS value) {
        this.orgRetailItems = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

}
