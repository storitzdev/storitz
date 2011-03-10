
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfORG_INS_SITE_OFFERINGS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfORG_INS_SITE_OFFERINGS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ORG_INS_SITE_OFFERINGS" type="{http://www.centershift.com/STORE40/}ORG_INS_SITE_OFFERINGS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfORG_INS_SITE_OFFERINGS", propOrder = {
    "orginssiteofferings"
})
public class ArrayOfORGINSSITEOFFERINGS {

    @XmlElement(name = "ORG_INS_SITE_OFFERINGS", nillable = true)
    protected List<ORGINSSITEOFFERINGS> orginssiteofferings;

    /**
     * Gets the value of the orginssiteofferings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orginssiteofferings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getORGINSSITEOFFERINGS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ORGINSSITEOFFERINGS }
     * 
     * 
     */
    public List<ORGINSSITEOFFERINGS> getORGINSSITEOFFERINGS() {
        if (orginssiteofferings == null) {
            orginssiteofferings = new ArrayList<ORGINSSITEOFFERINGS>();
        }
        return this.orginssiteofferings;
    }

}
