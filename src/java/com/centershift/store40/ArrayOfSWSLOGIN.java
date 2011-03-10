
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSWS_LOGIN complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSWS_LOGIN">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SWS_LOGIN" type="{http://www.centershift.com/STORE40/}SWS_LOGIN" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSWS_LOGIN", propOrder = {
    "swslogin"
})
public class ArrayOfSWSLOGIN {

    @XmlElement(name = "SWS_LOGIN", nillable = true)
    protected List<SWSLOGIN> swslogin;

    /**
     * Gets the value of the swslogin property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the swslogin property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSWSLOGIN().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SWSLOGIN }
     * 
     * 
     */
    public List<SWSLOGIN> getSWSLOGIN() {
        if (swslogin == null) {
            swslogin = new ArrayList<SWSLOGIN>();
        }
        return this.swslogin;
    }

}
