
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfGetRefundTypes_ResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfGetRefundTypes_ResponseData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DetailItem" type="{http://www.centershift.com/STORE40/}GetRefundTypes_ResponseData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfGetRefundTypes_ResponseData", propOrder = {
    "detailItem"
})
public class ArrayOfGetRefundTypesResponseData {

    @XmlElement(name = "DetailItem")
    protected List<GetRefundTypesResponseData> detailItem;

    /**
     * Gets the value of the detailItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detailItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetailItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetRefundTypesResponseData }
     * 
     * 
     */
    public List<GetRefundTypesResponseData> getDetailItem() {
        if (detailItem == null) {
            detailItem = new ArrayList<GetRefundTypesResponseData>();
        }
        return this.detailItem;
    }

}
