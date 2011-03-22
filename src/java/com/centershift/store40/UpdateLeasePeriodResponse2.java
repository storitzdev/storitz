package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for UpdateLeasePeriod_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="UpdateLeasePeriod_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NewLeaseThruDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateLeasePeriod_Response", propOrder = {
        "newLeaseThruDate"
})
public class UpdateLeasePeriodResponse2 {

    @XmlElement(name = "NewLeaseThruDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar newLeaseThruDate;

    /**
     * Gets the value of the newLeaseThruDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getNewLeaseThruDate() {
        return newLeaseThruDate;
    }

    /**
     * Sets the value of the newLeaseThruDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setNewLeaseThruDate(XMLGregorianCalendar value) {
        this.newLeaseThruDate = value;
    }

}
