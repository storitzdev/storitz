
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAuctionRentalItemData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAuctionRentalItemData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Rental" type="{http://www.centershift.com/STORE40/}AuctionRentalItemData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAuctionRentalItemData", propOrder = {
    "rental"
})
public class ArrayOfAuctionRentalItemData {

    @XmlElement(name = "Rental", nillable = true)
    protected List<AuctionRentalItemData> rental;

    /**
     * Gets the value of the rental property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rental property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRental().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AuctionRentalItemData }
     * 
     * 
     */
    public List<AuctionRentalItemData> getRental() {
        if (rental == null) {
            rental = new ArrayList<AuctionRentalItemData>();
        }
        return this.rental;
    }

}
