
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfRentRateRespData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRentRateRespData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentRateRespData" type="{http://www.centershift.com/STORE40/}RentRateRespData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRentRateRespData", propOrder = {
    "rentRateRespData"
})
public class ArrayOfRentRateRespData {

    @XmlElement(name = "RentRateRespData")
    protected List<RentRateRespData> rentRateRespData;

    /**
     * Gets the value of the rentRateRespData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rentRateRespData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRentRateRespData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RentRateRespData }
     * 
     * 
     */
    public List<RentRateRespData> getRentRateRespData() {
        if (rentRateRespData == null) {
            rentRateRespData = new ArrayList<RentRateRespData>();
        }
        return this.rentRateRespData;
    }

}
