
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSOA_LOGIN complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSOA_LOGIN">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SOA_LOGIN" type="{http://www.centershift.com/STORE40/}SOA_LOGIN" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSOA_LOGIN", propOrder = {
    "soalogin"
})
public class ArrayOfSOALOGIN {

    @XmlElement(name = "SOA_LOGIN", nillable = true)
    protected List<SOALOGIN> soalogin;

    /**
     * Gets the value of the soalogin property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soalogin property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSOALOGIN().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SOALOGIN }
     * 
     * 
     */
    public List<SOALOGIN> getSOALOGIN() {
        if (soalogin == null) {
            soalogin = new ArrayList<SOALOGIN>();
        }
        return this.soalogin;
    }

}
