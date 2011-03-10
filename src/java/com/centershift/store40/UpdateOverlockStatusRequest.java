
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateOverlockStatus_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateOverlockStatus_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="OverlockData" type="{http://www.centershift.com/STORE40/}ArrayOfRentalOverlockData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateOverlockStatus_Request", propOrder = {
    "orgID",
    "overlockData"
})
public class UpdateOverlockStatusRequest {

    @XmlElement(name = "OrgID")
    protected long orgID;
    @XmlElement(name = "OverlockData")
    protected ArrayOfRentalOverlockData overlockData;

    /**
     * Gets the value of the orgID property.
     * 
     */
    public long getOrgID() {
        return orgID;
    }

    /**
     * Sets the value of the orgID property.
     * 
     */
    public void setOrgID(long value) {
        this.orgID = value;
    }

    /**
     * Gets the value of the overlockData property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRentalOverlockData }
     *     
     */
    public ArrayOfRentalOverlockData getOverlockData() {
        return overlockData;
    }

    /**
     * Sets the value of the overlockData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRentalOverlockData }
     *     
     */
    public void setOverlockData(ArrayOfRentalOverlockData value) {
        this.overlockData = value;
    }

}
