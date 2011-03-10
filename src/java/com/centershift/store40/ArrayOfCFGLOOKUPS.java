
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCFG_LOOKUPS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCFG_LOOKUPS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CFG_LOOKUPS" type="{http://www.centershift.com/STORE40/}CFG_LOOKUPS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCFG_LOOKUPS", propOrder = {
    "cfglookups"
})
public class ArrayOfCFGLOOKUPS {

    @XmlElement(name = "CFG_LOOKUPS", nillable = true)
    protected List<CFGLOOKUPS> cfglookups;

    /**
     * Gets the value of the cfglookups property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cfglookups property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCFGLOOKUPS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFGLOOKUPS }
     * 
     * 
     */
    public List<CFGLOOKUPS> getCFGLOOKUPS() {
        if (cfglookups == null) {
            cfglookups = new ArrayList<CFGLOOKUPS>();
        }
        return this.cfglookups;
    }

}
