
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPrimaryContactRentals complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPrimaryContactRentals">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PrimaryContactRentals" type="{http://www.centershift.com/STORE40/}PrimaryContactRentals" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPrimaryContactRentals", propOrder = {
    "primaryContactRentals"
})
public class ArrayOfPrimaryContactRentals {

    @XmlElement(name = "PrimaryContactRentals", nillable = true)
    protected List<PrimaryContactRentals> primaryContactRentals;

    /**
     * Gets the value of the primaryContactRentals property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the primaryContactRentals property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrimaryContactRentals().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrimaryContactRentals }
     * 
     * 
     */
    public List<PrimaryContactRentals> getPrimaryContactRentals() {
        if (primaryContactRentals == null) {
            primaryContactRentals = new ArrayList<PrimaryContactRentals>();
        }
        return this.primaryContactRentals;
    }

}
