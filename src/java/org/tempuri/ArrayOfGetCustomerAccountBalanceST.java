
package org.tempuri;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfGetCustomerAccountBalance_ST complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfGetCustomerAccountBalance_ST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetCustomerAccountBalance_ST" type="{http://tempuri.org/}GetCustomerAccountBalance_ST" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfGetCustomerAccountBalance_ST", propOrder = {
    "getCustomerAccountBalanceST"
})
public class ArrayOfGetCustomerAccountBalanceST {

    @XmlElement(name = "GetCustomerAccountBalance_ST")
    protected List<GetCustomerAccountBalanceST> getCustomerAccountBalanceST;

    /**
     * Gets the value of the getCustomerAccountBalanceST property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getCustomerAccountBalanceST property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetCustomerAccountBalanceST().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetCustomerAccountBalanceST }
     * 
     * 
     */
    public List<GetCustomerAccountBalanceST> getGetCustomerAccountBalanceST() {
        if (getCustomerAccountBalanceST == null) {
            getCustomerAccountBalanceST = new ArrayList<GetCustomerAccountBalanceST>();
        }
        return this.getCustomerAccountBalanceST;
    }

}
