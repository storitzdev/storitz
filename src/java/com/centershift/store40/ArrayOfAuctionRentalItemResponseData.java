
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAuctionRentalItemResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAuctionRentalItemResponseData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentalItem" type="{http://www.centershift.com/STORE40/}AuctionRentalItemResponseData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAuctionRentalItemResponseData", propOrder = {
    "rentalItem"
})
public class ArrayOfAuctionRentalItemResponseData {

    @XmlElement(name = "RentalItem", nillable = true)
    protected List<AuctionRentalItemResponseData> rentalItem;

    /**
     * Gets the value of the rentalItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rentalItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRentalItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AuctionRentalItemResponseData }
     * 
     * 
     */
    public List<AuctionRentalItemResponseData> getRentalItem() {
        if (rentalItem == null) {
            rentalItem = new ArrayList<AuctionRentalItemResponseData>();
        }
        return this.rentalItem;
    }

}
