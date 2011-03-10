
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfTRAN_RENTALS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfTRAN_RENTALS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TRAN_RENTALS" type="{http://www.centershift.com/STORE40/}TRAN_RENTALS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfTRAN_RENTALS", propOrder = {
    "tranrentals"
})
public class ArrayOfTRANRENTALS {

    @XmlElement(name = "TRAN_RENTALS", nillable = true)
    protected List<TRANRENTALS> tranrentals;

    /**
     * Gets the value of the tranrentals property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tranrentals property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTRANRENTALS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TRANRENTALS }
     * 
     * 
     */
    public List<TRANRENTALS> getTRANRENTALS() {
        if (tranrentals == null) {
            tranrentals = new ArrayList<TRANRENTALS>();
        }
        return this.tranrentals;
    }

}
