
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAuctionEndRentalComplete1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAuctionEndRentalComplete1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CompletedItem" type="{http://www.centershift.com/STORE40/}AuctionEndRentalComplete" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAuctionEndRentalComplete1", propOrder = {
    "completedItem"
})
public class ArrayOfAuctionEndRentalComplete1 {

    @XmlElement(name = "CompletedItem")
    protected List<AuctionEndRentalComplete> completedItem;

    /**
     * Gets the value of the completedItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the completedItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompletedItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AuctionEndRentalComplete }
     * 
     * 
     */
    public List<AuctionEndRentalComplete> getCompletedItem() {
        if (completedItem == null) {
            completedItem = new ArrayList<AuctionEndRentalComplete>();
        }
        return this.completedItem;
    }

}
