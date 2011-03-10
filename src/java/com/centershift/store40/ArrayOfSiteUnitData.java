
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSiteUnitData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSiteUnitData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteUnitData" type="{http://www.centershift.com/STORE40/}SiteUnitData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSiteUnitData", propOrder = {
    "siteUnitData"
})
public class ArrayOfSiteUnitData {

    @XmlElement(name = "SiteUnitData", nillable = true)
    protected List<SiteUnitData> siteUnitData;

    /**
     * Gets the value of the siteUnitData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the siteUnitData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSiteUnitData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SiteUnitData }
     * 
     * 
     */
    public List<SiteUnitData> getSiteUnitData() {
        if (siteUnitData == null) {
            siteUnitData = new ArrayList<SiteUnitData>();
        }
        return this.siteUnitData;
    }

}
