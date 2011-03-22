package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfAuctionEndRentalComplete complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfAuctionEndRentalComplete">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuctionItem" type="{http://www.centershift.com/STORE40/}AuctionEndRentalComplete" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAuctionEndRentalComplete", propOrder = {
        "auctionItem"
})
public class ArrayOfAuctionEndRentalComplete {

    @XmlElement(name = "AuctionItem")
    protected List<AuctionEndRentalComplete> auctionItem;

    /**
     * Gets the value of the auctionItem property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the auctionItem property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuctionItem().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link AuctionEndRentalComplete }
     */
    public List<AuctionEndRentalComplete> getAuctionItem() {
        if (auctionItem == null) {
            auctionItem = new ArrayList<AuctionEndRentalComplete>();
        }
        return this.auctionItem;
    }

}
