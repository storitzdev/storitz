
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfBulkPricing complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfBulkPricing">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BulkPricing" type="{http://www.centershift.com/STORE40/}BulkPricing" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfBulkPricing", propOrder = {
    "bulkPricing"
})
public class ArrayOfBulkPricing {

    @XmlElement(name = "BulkPricing", nillable = true)
    protected List<BulkPricing> bulkPricing;

    /**
     * Gets the value of the bulkPricing property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bulkPricing property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBulkPricing().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BulkPricing }
     * 
     * 
     */
    public List<BulkPricing> getBulkPricing() {
        if (bulkPricing == null) {
            bulkPricing = new ArrayList<BulkPricing>();
        }
        return this.bulkPricing;
    }

}
