package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateNewEcommAccount_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="CreateNewEcommAccount_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EcommID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AcctDetails" type="{http://www.centershift.com/STORE40/}structCreateAccount"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateNewEcommAccount_Response", propOrder = {
        "ecommID",
        "acctDetails"
})
public class CreateNewEcommAccountResponse2 {

    @XmlElement(name = "EcommID")
    protected long ecommID;
    @XmlElement(name = "AcctDetails", required = true)
    protected StructCreateAccount acctDetails;

    /**
     * Gets the value of the ecommID property.
     */
    public long getEcommID() {
        return ecommID;
    }

    /**
     * Sets the value of the ecommID property.
     */
    public void setEcommID(long value) {
        this.ecommID = value;
    }

    /**
     * Gets the value of the acctDetails property.
     *
     * @return possible object is
     *         {@link StructCreateAccount }
     */
    public StructCreateAccount getAcctDetails() {
        return acctDetails;
    }

    /**
     * Sets the value of the acctDetails property.
     *
     * @param value allowed object is
     *              {@link StructCreateAccount }
     */
    public void setAcctDetails(StructCreateAccount value) {
        this.acctDetails = value;
    }

}
