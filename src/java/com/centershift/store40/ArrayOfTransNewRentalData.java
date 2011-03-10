
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfTransNewRentalData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfTransNewRentalData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransNewRentalData" type="{http://www.centershift.com/STORE40/}TransNewRentalData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfTransNewRentalData", propOrder = {
    "transNewRentalData"
})
public class ArrayOfTransNewRentalData {

    @XmlElement(name = "TransNewRentalData", nillable = true)
    protected List<TransNewRentalData> transNewRentalData;

    /**
     * Gets the value of the transNewRentalData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transNewRentalData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransNewRentalData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransNewRentalData }
     * 
     * 
     */
    public List<TransNewRentalData> getTransNewRentalData() {
        if (transNewRentalData == null) {
            transNewRentalData = new ArrayList<TransNewRentalData>();
        }
        return this.transNewRentalData;
    }

}
