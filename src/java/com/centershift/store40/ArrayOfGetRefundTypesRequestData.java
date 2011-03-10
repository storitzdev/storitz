
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfGetRefundTypes_RequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfGetRefundTypes_RequestData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RefundDataItem" type="{http://www.centershift.com/STORE40/}GetRefundTypes_RequestData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfGetRefundTypes_RequestData", propOrder = {
    "refundDataItem"
})
public class ArrayOfGetRefundTypesRequestData {

    @XmlElement(name = "RefundDataItem")
    protected List<GetRefundTypesRequestData> refundDataItem;

    /**
     * Gets the value of the refundDataItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refundDataItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefundDataItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetRefundTypesRequestData }
     * 
     * 
     */
    public List<GetRefundTypesRequestData> getRefundDataItem() {
        if (refundDataItem == null) {
            refundDataItem = new ArrayList<GetRefundTypesRequestData>();
        }
        return this.refundDataItem;
    }

}
