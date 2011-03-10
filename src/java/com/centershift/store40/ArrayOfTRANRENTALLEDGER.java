
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfTRAN_RENTAL_LEDGER complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfTRAN_RENTAL_LEDGER">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TRAN_RENTAL_LEDGER" type="{http://www.centershift.com/STORE40/}TRAN_RENTAL_LEDGER" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfTRAN_RENTAL_LEDGER", propOrder = {
    "tranrentalledger"
})
public class ArrayOfTRANRENTALLEDGER {

    @XmlElement(name = "TRAN_RENTAL_LEDGER", nillable = true)
    protected List<TRANRENTALLEDGER> tranrentalledger;

    /**
     * Gets the value of the tranrentalledger property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tranrentalledger property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTRANRENTALLEDGER().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TRANRENTALLEDGER }
     * 
     * 
     */
    public List<TRANRENTALLEDGER> getTRANRENTALLEDGER() {
        if (tranrentalledger == null) {
            tranrentalledger = new ArrayList<TRANRENTALLEDGER>();
        }
        return this.tranrentalledger;
    }

}
