package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NewAccountResult complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="NewAccountResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="csReturnMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iCustomerID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="csAccessCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csOrderID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NewAccountResult", propOrder = {
        "bResult",
        "csReturnMessage",
        "iCustomerID",
        "csAccessCode",
        "csOrderID"
})
public class NewAccountResult {

    protected boolean bResult;
    protected String csReturnMessage;
    @XmlSchemaType(name = "unsignedInt")
    protected long iCustomerID;
    protected String csAccessCode;
    protected String csOrderID;

    /**
     * Gets the value of the bResult property.
     */
    public boolean isBResult() {
        return bResult;
    }

    /**
     * Sets the value of the bResult property.
     */
    public void setBResult(boolean value) {
        this.bResult = value;
    }

    /**
     * Gets the value of the csReturnMessage property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsReturnMessage() {
        return csReturnMessage;
    }

    /**
     * Sets the value of the csReturnMessage property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsReturnMessage(String value) {
        this.csReturnMessage = value;
    }

    /**
     * Gets the value of the iCustomerID property.
     */
    public long getICustomerID() {
        return iCustomerID;
    }

    /**
     * Sets the value of the iCustomerID property.
     */
    public void setICustomerID(long value) {
        this.iCustomerID = value;
    }

    /**
     * Gets the value of the csAccessCode property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsAccessCode() {
        return csAccessCode;
    }

    /**
     * Sets the value of the csAccessCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsAccessCode(String value) {
        this.csAccessCode = value;
    }

    /**
     * Gets the value of the csOrderID property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsOrderID() {
        return csOrderID;
    }

    /**
     * Sets the value of the csOrderID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsOrderID(String value) {
        this.csOrderID = value;
    }

}
