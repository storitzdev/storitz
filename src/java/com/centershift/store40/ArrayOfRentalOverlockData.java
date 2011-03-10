
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfRentalOverlockData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRentalOverlockData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentalOverlockData" type="{http://www.centershift.com/STORE40/}RentalOverlockData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRentalOverlockData", propOrder = {
    "rentalOverlockData"
})
public class ArrayOfRentalOverlockData {

    @XmlElement(name = "RentalOverlockData")
    protected List<RentalOverlockData> rentalOverlockData;

    /**
     * Gets the value of the rentalOverlockData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rentalOverlockData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRentalOverlockData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RentalOverlockData }
     * 
     * 
     */
    public List<RentalOverlockData> getRentalOverlockData() {
        if (rentalOverlockData == null) {
            rentalOverlockData = new ArrayList<RentalOverlockData>();
        }
        return this.rentalOverlockData;
    }

}
