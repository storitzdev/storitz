
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfRentRateReqData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRentRateReqData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentRateReqData" type="{http://www.centershift.com/STORE40/}RentRateReqData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRentRateReqData", propOrder = {
    "rentRateReqData"
})
public class ArrayOfRentRateReqData {

    @XmlElement(name = "RentRateReqData")
    protected List<RentRateReqData> rentRateReqData;

    /**
     * Gets the value of the rentRateReqData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rentRateReqData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRentRateReqData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RentRateReqData }
     * 
     * 
     */
    public List<RentRateReqData> getRentRateReqData() {
        if (rentRateReqData == null) {
            rentRateReqData = new ArrayList<RentRateReqData>();
        }
        return this.rentRateReqData;
    }

}
