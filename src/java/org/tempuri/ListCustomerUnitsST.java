package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListCustomerUnits_ST complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ListCustomerUnits_ST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="csUnitID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LockedOut" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListCustomerUnits_ST", propOrder = {
        "csUnitID",
        "lockedOut"
})
public class ListCustomerUnitsST {

    protected String csUnitID;
    @XmlElement(name = "LockedOut")
    protected boolean lockedOut;

    /**
     * Gets the value of the csUnitID property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsUnitID() {
        return csUnitID;
    }

    /**
     * Sets the value of the csUnitID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsUnitID(String value) {
        this.csUnitID = value;
    }

    /**
     * Gets the value of the lockedOut property.
     */
    public boolean isLockedOut() {
        return lockedOut;
    }

    /**
     * Sets the value of the lockedOut property.
     */
    public void setLockedOut(boolean value) {
        this.lockedOut = value;
    }

}
