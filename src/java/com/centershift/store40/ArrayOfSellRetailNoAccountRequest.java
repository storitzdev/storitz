
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSellRetailNoAccount_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSellRetailNoAccount_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SellRetailNoAccount_Request" type="{http://www.centershift.com/STORE40/}SellRetailNoAccount_Request" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSellRetailNoAccount_Request", propOrder = {
    "sellRetailNoAccountRequest"
})
public class ArrayOfSellRetailNoAccountRequest {

    @XmlElement(name = "SellRetailNoAccount_Request")
    protected List<SellRetailNoAccountRequest> sellRetailNoAccountRequest;

    /**
     * Gets the value of the sellRetailNoAccountRequest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sellRetailNoAccountRequest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSellRetailNoAccountRequest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SellRetailNoAccountRequest }
     * 
     * 
     */
    public List<SellRetailNoAccountRequest> getSellRetailNoAccountRequest() {
        if (sellRetailNoAccountRequest == null) {
            sellRetailNoAccountRequest = new ArrayList<SellRetailNoAccountRequest>();
        }
        return this.sellRetailNoAccountRequest;
    }

}
