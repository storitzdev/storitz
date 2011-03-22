package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetAvailableRetailItems_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetAvailableRetailItems_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Details" type="{http://www.centershift.com/STORE40/}ArrayOfAVAIL_SITE_RETAIL_ITEMS" minOccurs="0"/>
 *         &lt;element name="BulkPricing" type="{http://www.centershift.com/STORE40/}ArrayOfBulkPricing" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAvailableRetailItems_Response", propOrder = {
        "details",
        "bulkPricing"
})
public class GetAvailableRetailItemsResponse2 {

    @XmlElement(name = "Details")
    protected ArrayOfAVAILSITERETAILITEMS details;
    @XmlElement(name = "BulkPricing")
    protected ArrayOfBulkPricing bulkPricing;

    /**
     * Gets the value of the details property.
     *
     * @return possible object is
     *         {@link ArrayOfAVAILSITERETAILITEMS }
     */
    public ArrayOfAVAILSITERETAILITEMS getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     *
     * @param value allowed object is
     *              {@link ArrayOfAVAILSITERETAILITEMS }
     */
    public void setDetails(ArrayOfAVAILSITERETAILITEMS value) {
        this.details = value;
    }

    /**
     * Gets the value of the bulkPricing property.
     *
     * @return possible object is
     *         {@link ArrayOfBulkPricing }
     */
    public ArrayOfBulkPricing getBulkPricing() {
        return bulkPricing;
    }

    /**
     * Sets the value of the bulkPricing property.
     *
     * @param value allowed object is
     *              {@link ArrayOfBulkPricing }
     */
    public void setBulkPricing(ArrayOfBulkPricing value) {
        this.bulkPricing = value;
    }

}
