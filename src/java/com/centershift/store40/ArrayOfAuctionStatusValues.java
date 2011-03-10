
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAuctionStatusValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAuctionStatusValues">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StatusItem" type="{http://www.centershift.com/STORE40/}AuctionStatusValues" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAuctionStatusValues", propOrder = {
    "statusItem"
})
public class ArrayOfAuctionStatusValues {

    @XmlElement(name = "StatusItem")
    protected List<AuctionStatusValues> statusItem;

    /**
     * Gets the value of the statusItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the statusItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatusItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AuctionStatusValues }
     * 
     * 
     */
    public List<AuctionStatusValues> getStatusItem() {
        if (statusItem == null) {
            statusItem = new ArrayList<AuctionStatusValues>();
        }
        return this.statusItem;
    }

}
