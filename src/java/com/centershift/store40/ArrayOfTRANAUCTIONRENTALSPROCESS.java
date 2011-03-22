package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfTRAN_AUCTION_RENTALS_PROCESS complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfTRAN_AUCTION_RENTALS_PROCESS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DetailItem" type="{http://www.centershift.com/STORE40/}TRAN_AUCTION_RENTALS_PROCESS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfTRAN_AUCTION_RENTALS_PROCESS", propOrder = {
        "detailItem"
})
public class ArrayOfTRANAUCTIONRENTALSPROCESS {

    @XmlElement(name = "DetailItem", nillable = true)
    protected List<TRANAUCTIONRENTALSPROCESS> detailItem;

    /**
     * Gets the value of the detailItem property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detailItem property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetailItem().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link TRANAUCTIONRENTALSPROCESS }
     */
    public List<TRANAUCTIONRENTALSPROCESS> getDetailItem() {
        if (detailItem == null) {
            detailItem = new ArrayList<TRANAUCTIONRENTALSPROCESS>();
        }
        return this.detailItem;
    }

}
