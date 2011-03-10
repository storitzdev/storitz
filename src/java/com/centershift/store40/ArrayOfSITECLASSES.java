
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSITE_CLASSES complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSITE_CLASSES">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SITE_CLASSES" type="{http://www.centershift.com/STORE40/}SITE_CLASSES" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSITE_CLASSES", propOrder = {
    "siteclasses"
})
public class ArrayOfSITECLASSES {

    @XmlElement(name = "SITE_CLASSES", nillable = true)
    protected List<SITECLASSES> siteclasses;

    /**
     * Gets the value of the siteclasses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the siteclasses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSITECLASSES().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SITECLASSES }
     * 
     * 
     */
    public List<SITECLASSES> getSITECLASSES() {
        if (siteclasses == null) {
            siteclasses = new ArrayList<SITECLASSES>();
        }
        return this.siteclasses;
    }

}
