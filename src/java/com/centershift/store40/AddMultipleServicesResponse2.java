
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddMultipleServices_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddMultipleServices_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Service" type="{http://www.centershift.com/STORE40/}ORG_SERVICE_SITE_OFFERINGS" minOccurs="0"/>
 *         &lt;element name="ServiceObjectID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Succeeded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ProcessMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddMultipleServices_Response", propOrder = {
    "service",
    "serviceObjectID",
    "succeeded",
    "processMessage"
})
public class AddMultipleServicesResponse2 {

    @XmlElement(name = "Service")
    protected ORGSERVICESITEOFFERINGS service;
    @XmlElement(name = "ServiceObjectID")
    protected String serviceObjectID;
    @XmlElement(name = "Succeeded")
    protected boolean succeeded;
    @XmlElement(name = "ProcessMessage")
    protected String processMessage;

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link ORGSERVICESITEOFFERINGS }
     *     
     */
    public ORGSERVICESITEOFFERINGS getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link ORGSERVICESITEOFFERINGS }
     *     
     */
    public void setService(ORGSERVICESITEOFFERINGS value) {
        this.service = value;
    }

    /**
     * Gets the value of the serviceObjectID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceObjectID() {
        return serviceObjectID;
    }

    /**
     * Sets the value of the serviceObjectID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceObjectID(String value) {
        this.serviceObjectID = value;
    }

    /**
     * Gets the value of the succeeded property.
     * 
     */
    public boolean isSucceeded() {
        return succeeded;
    }

    /**
     * Sets the value of the succeeded property.
     * 
     */
    public void setSucceeded(boolean value) {
        this.succeeded = value;
    }

    /**
     * Gets the value of the processMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessMessage() {
        return processMessage;
    }

    /**
     * Sets the value of the processMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessMessage(String value) {
        this.processMessage = value;
    }

}
