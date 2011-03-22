package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for GetRefundTypes_RequestData complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetRefundTypes_RequestData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TnxID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RetailRequest" type="{http://www.centershift.com/STORE40/}retailReturn"/>
 *         &lt;element name="ReturnDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetRefundTypes_RequestData", propOrder = {
        "tnxID",
        "retailRequest",
        "returnDate"
})
public class GetRefundTypesRequestData {

    @XmlElement(name = "TnxID")
    protected long tnxID;
    @XmlElement(name = "RetailRequest", required = true)
    protected RetailReturn retailRequest;
    @XmlElement(name = "ReturnDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar returnDate;

    /**
     * Gets the value of the tnxID property.
     */
    public long getTnxID() {
        return tnxID;
    }

    /**
     * Sets the value of the tnxID property.
     */
    public void setTnxID(long value) {
        this.tnxID = value;
    }

    /**
     * Gets the value of the retailRequest property.
     *
     * @return possible object is
     *         {@link RetailReturn }
     */
    public RetailReturn getRetailRequest() {
        return retailRequest;
    }

    /**
     * Sets the value of the retailRequest property.
     *
     * @param value allowed object is
     *              {@link RetailReturn }
     */
    public void setRetailRequest(RetailReturn value) {
        this.retailRequest = value;
    }

    /**
     * Gets the value of the returnDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getReturnDate() {
        return returnDate;
    }

    /**
     * Sets the value of the returnDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setReturnDate(XMLGregorianCalendar value) {
        this.returnDate = value;
    }

}
