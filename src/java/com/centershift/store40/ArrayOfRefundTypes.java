
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfRefundTypes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRefundTypes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RefundType" type="{http://www.centershift.com/STORE40/}RefundTypes" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRefundTypes", propOrder = {
    "refundType"
})
public class ArrayOfRefundTypes {

    @XmlElement(name = "RefundType")
    protected List<RefundTypes> refundType;

    /**
     * Gets the value of the refundType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refundType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefundType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefundTypes }
     * 
     * 
     */
    public List<RefundTypes> getRefundType() {
        if (refundType == null) {
            refundType = new ArrayList<RefundTypes>();
        }
        return this.refundType;
    }

}
