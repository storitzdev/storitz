
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfORG_RETAIL_ITEMS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfORG_RETAIL_ITEMS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RetailItem" type="{http://www.centershift.com/STORE40/}ORG_RETAIL_ITEMS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfORG_RETAIL_ITEMS", propOrder = {
    "retailItem"
})
public class ArrayOfORGRETAILITEMS {

    @XmlElement(name = "RetailItem", nillable = true)
    protected List<ORGRETAILITEMS> retailItem;

    /**
     * Gets the value of the retailItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the retailItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRetailItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ORGRETAILITEMS }
     * 
     * 
     */
    public List<ORGRETAILITEMS> getRetailItem() {
        if (retailItem == null) {
            retailItem = new ArrayList<ORGRETAILITEMS>();
        }
        return this.retailItem;
    }

}
