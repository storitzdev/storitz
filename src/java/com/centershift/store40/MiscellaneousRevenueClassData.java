
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MiscellaneousRevenueClassData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MiscellaneousRevenueClassData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClassID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="MiscClassID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClassRef" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TaxGroupID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MiscellaneousRevenueClassData", propOrder = {
    "classID",
    "miscClassID",
    "description",
    "classRef",
    "taxGroupID"
})
public class MiscellaneousRevenueClassData {

    @XmlElement(name = "ClassID")
    protected long classID;
    @XmlElement(name = "MiscClassID")
    protected long miscClassID;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "ClassRef")
    protected long classRef;
    @XmlElement(name = "TaxGroupID")
    protected long taxGroupID;

    /**
     * Gets the value of the classID property.
     * 
     */
    public long getClassID() {
        return classID;
    }

    /**
     * Sets the value of the classID property.
     * 
     */
    public void setClassID(long value) {
        this.classID = value;
    }

    /**
     * Gets the value of the miscClassID property.
     * 
     */
    public long getMiscClassID() {
        return miscClassID;
    }

    /**
     * Sets the value of the miscClassID property.
     * 
     */
    public void setMiscClassID(long value) {
        this.miscClassID = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the classRef property.
     * 
     */
    public long getClassRef() {
        return classRef;
    }

    /**
     * Sets the value of the classRef property.
     * 
     */
    public void setClassRef(long value) {
        this.classRef = value;
    }

    /**
     * Gets the value of the taxGroupID property.
     * 
     */
    public long getTaxGroupID() {
        return taxGroupID;
    }

    /**
     * Sets the value of the taxGroupID property.
     * 
     */
    public void setTaxGroupID(long value) {
        this.taxGroupID = value;
    }

}
