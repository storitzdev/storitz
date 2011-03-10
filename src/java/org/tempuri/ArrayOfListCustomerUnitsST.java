
package org.tempuri;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfListCustomerUnits_ST complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfListCustomerUnits_ST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ListCustomerUnits_ST" type="{http://tempuri.org/}ListCustomerUnits_ST" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfListCustomerUnits_ST", propOrder = {
    "listCustomerUnitsST"
})
public class ArrayOfListCustomerUnitsST {

    @XmlElement(name = "ListCustomerUnits_ST")
    protected List<ListCustomerUnitsST> listCustomerUnitsST;

    /**
     * Gets the value of the listCustomerUnitsST property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listCustomerUnitsST property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListCustomerUnitsST().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListCustomerUnitsST }
     * 
     * 
     */
    public List<ListCustomerUnitsST> getListCustomerUnitsST() {
        if (listCustomerUnitsST == null) {
            listCustomerUnitsST = new ArrayList<ListCustomerUnitsST>();
        }
        return this.listCustomerUnitsST;
    }

}
