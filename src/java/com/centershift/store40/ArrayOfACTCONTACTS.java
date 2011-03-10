
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfACT_CONTACTS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfACT_CONTACTS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ACT_CONTACTS" type="{http://www.centershift.com/STORE40/}ACT_CONTACTS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfACT_CONTACTS", propOrder = {
    "actcontacts"
})
public class ArrayOfACTCONTACTS {

    @XmlElement(name = "ACT_CONTACTS", nillable = true)
    protected List<ACTCONTACTS> actcontacts;

    /**
     * Gets the value of the actcontacts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actcontacts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getACTCONTACTS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ACTCONTACTS }
     * 
     * 
     */
    public List<ACTCONTACTS> getACTCONTACTS() {
        if (actcontacts == null) {
            actcontacts = new ArrayList<ACTCONTACTS>();
        }
        return this.actcontacts;
    }

}
