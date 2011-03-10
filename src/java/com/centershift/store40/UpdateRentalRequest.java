
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for UpdateRental_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateRental_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentalId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="MoveOutDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CreateTask" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateRental_Request", propOrder = {
    "rentalId",
    "moveOutDate",
    "createTask"
})
public class UpdateRentalRequest {

    @XmlElement(name = "RentalId", required = true, type = Long.class, nillable = true)
    protected Long rentalId;
    @XmlElement(name = "MoveOutDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar moveOutDate;
    @XmlElement(name = "CreateTask")
    protected boolean createTask;

    /**
     * Gets the value of the rentalId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRentalId() {
        return rentalId;
    }

    /**
     * Sets the value of the rentalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRentalId(Long value) {
        this.rentalId = value;
    }

    /**
     * Gets the value of the moveOutDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMoveOutDate() {
        return moveOutDate;
    }

    /**
     * Sets the value of the moveOutDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMoveOutDate(XMLGregorianCalendar value) {
        this.moveOutDate = value;
    }

    /**
     * Gets the value of the createTask property.
     * 
     */
    public boolean isCreateTask() {
        return createTask;
    }

    /**
     * Sets the value of the createTask property.
     * 
     */
    public void setCreateTask(boolean value) {
        this.createTask = value;
    }

}
