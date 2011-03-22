package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CancelInsurance_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="CancelInsurance_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ParentRentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="InsuranceRentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelInsurance_Request", propOrder = {
        "parentRentalID",
        "insuranceRentalID"
})
public class CancelInsuranceRequest {

    @XmlElement(name = "ParentRentalID")
    protected long parentRentalID;
    @XmlElement(name = "InsuranceRentalID")
    protected long insuranceRentalID;

    /**
     * Gets the value of the parentRentalID property.
     */
    public long getParentRentalID() {
        return parentRentalID;
    }

    /**
     * Sets the value of the parentRentalID property.
     */
    public void setParentRentalID(long value) {
        this.parentRentalID = value;
    }

    /**
     * Gets the value of the insuranceRentalID property.
     */
    public long getInsuranceRentalID() {
        return insuranceRentalID;
    }

    /**
     * Sets the value of the insuranceRentalID property.
     */
    public void setInsuranceRentalID(long value) {
        this.insuranceRentalID = value;
    }

}
