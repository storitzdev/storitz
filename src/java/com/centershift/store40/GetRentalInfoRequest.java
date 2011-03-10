
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetRentalInfo_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetRentalInfo_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ContactID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AcctID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UnitID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetRentalInfo_Request", propOrder = {
    "contactID",
    "acctID",
    "unitID",
    "rentalID"
})
public class GetRentalInfoRequest {

    @XmlElement(name = "ContactID", required = true, type = Long.class, nillable = true)
    protected Long contactID;
    @XmlElement(name = "AcctID", required = true, type = Long.class, nillable = true)
    protected Long acctID;
    @XmlElement(name = "UnitID", required = true, type = Long.class, nillable = true)
    protected Long unitID;
    @XmlElement(name = "RentalID", required = true, type = Long.class, nillable = true)
    protected Long rentalID;

    /**
     * Gets the value of the contactID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getContactID() {
        return contactID;
    }

    /**
     * Sets the value of the contactID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setContactID(Long value) {
        this.contactID = value;
    }

    /**
     * Gets the value of the acctID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAcctID() {
        return acctID;
    }

    /**
     * Sets the value of the acctID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAcctID(Long value) {
        this.acctID = value;
    }

    /**
     * Gets the value of the unitID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUnitID() {
        return unitID;
    }

    /**
     * Sets the value of the unitID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUnitID(Long value) {
        this.unitID = value;
    }

    /**
     * Gets the value of the rentalID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRentalID() {
        return rentalID;
    }

    /**
     * Sets the value of the rentalID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRentalID(Long value) {
        this.rentalID = value;
    }

}
