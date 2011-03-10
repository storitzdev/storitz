
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetAuctionTax_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetAuctionTax_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuctionTaxes" type="{http://www.centershift.com/STORE40/}ArrayOfAuctionTaxInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAuctionTax_Response", propOrder = {
    "auctionTaxes"
})
public class GetAuctionTaxResponse2 {

    @XmlElement(name = "AuctionTaxes")
    protected ArrayOfAuctionTaxInfo auctionTaxes;

    /**
     * Gets the value of the auctionTaxes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAuctionTaxInfo }
     *     
     */
    public ArrayOfAuctionTaxInfo getAuctionTaxes() {
        return auctionTaxes;
    }

    /**
     * Sets the value of the auctionTaxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAuctionTaxInfo }
     *     
     */
    public void setAuctionTaxes(ArrayOfAuctionTaxInfo value) {
        this.auctionTaxes = value;
    }

}
