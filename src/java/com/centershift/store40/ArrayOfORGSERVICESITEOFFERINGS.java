package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfORG_SERVICE_SITE_OFFERINGS complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfORG_SERVICE_SITE_OFFERINGS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ORG_SERVICE_SITE_OFFERINGS" type="{http://www.centershift.com/STORE40/}ORG_SERVICE_SITE_OFFERINGS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfORG_SERVICE_SITE_OFFERINGS", propOrder = {
        "orgservicesiteofferings"
})
public class ArrayOfORGSERVICESITEOFFERINGS {

    @XmlElement(name = "ORG_SERVICE_SITE_OFFERINGS", nillable = true)
    protected List<ORGSERVICESITEOFFERINGS> orgservicesiteofferings;

    /**
     * Gets the value of the orgservicesiteofferings property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orgservicesiteofferings property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getORGSERVICESITEOFFERINGS().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link ORGSERVICESITEOFFERINGS }
     */
    public List<ORGSERVICESITEOFFERINGS> getORGSERVICESITEOFFERINGS() {
        if (orgservicesiteofferings == null) {
            orgservicesiteofferings = new ArrayList<ORGSERVICESITEOFFERINGS>();
        }
        return this.orgservicesiteofferings;
    }

}
