package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfORG_FEE_SITE_ALL complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfORG_FEE_SITE_ALL">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ORG_FEE_SITE_ALL" type="{http://www.centershift.com/STORE40/}ORG_FEE_SITE_ALL" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfORG_FEE_SITE_ALL", propOrder = {
        "orgfeesiteall"
})
public class ArrayOfORGFEESITEALL {

    @XmlElement(name = "ORG_FEE_SITE_ALL", nillable = true)
    protected List<ORGFEESITEALL> orgfeesiteall;

    /**
     * Gets the value of the orgfeesiteall property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orgfeesiteall property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getORGFEESITEALL().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link ORGFEESITEALL }
     */
    public List<ORGFEESITEALL> getORGFEESITEALL() {
        if (orgfeesiteall == null) {
            orgfeesiteall = new ArrayList<ORGFEESITEALL>();
        }
        return this.orgfeesiteall;
    }

}
