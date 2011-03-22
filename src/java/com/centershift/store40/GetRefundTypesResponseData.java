package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for GetRefundTypes_ResponseData complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetRefundTypes_ResponseData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TnxID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RefundTypes" type="{http://www.centershift.com/STORE40/}RefundTypes" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ErrorMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetRefundTypes_ResponseData", propOrder = {
        "tnxID",
        "refundTypes",
        "errorMsg"
})
public class GetRefundTypesResponseData {

    @XmlElement(name = "TnxID")
    protected long tnxID;
    @XmlElement(name = "RefundTypes")
    protected List<RefundTypes> refundTypes;
    @XmlElement(name = "ErrorMsg")
    protected String errorMsg;

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
     * Gets the value of the refundTypes property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refundTypes property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefundTypes().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link RefundTypes }
     */
    public List<RefundTypes> getRefundTypes() {
        if (refundTypes == null) {
            refundTypes = new ArrayList<RefundTypes>();
        }
        return this.refundTypes;
    }

    /**
     * Gets the value of the errorMsg property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * Sets the value of the errorMsg property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setErrorMsg(String value) {
        this.errorMsg = value;
    }

}
