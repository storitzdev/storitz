package org.tempuri;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="csUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csSiteName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iCustomerID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="iMonth" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="csUnitID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "csUser",
        "csPassword",
        "csSiteName",
        "iCustomerID",
        "iMonth",
        "csUnitID"
})
@XmlRootElement(name = "GetCustomerAccountBalance")
public class GetCustomerAccountBalance {

    protected String csUser;
    protected String csPassword;
    protected String csSiteName;
    @XmlSchemaType(name = "unsignedInt")
    protected long iCustomerID;
    @XmlSchemaType(name = "unsignedInt")
    protected long iMonth;
    protected String csUnitID;

    /**
     * Gets the value of the csUser property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsUser() {
        return csUser;
    }

    /**
     * Sets the value of the csUser property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsUser(String value) {
        this.csUser = value;
    }

    /**
     * Gets the value of the csPassword property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsPassword() {
        return csPassword;
    }

    /**
     * Sets the value of the csPassword property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsPassword(String value) {
        this.csPassword = value;
    }

    /**
     * Gets the value of the csSiteName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsSiteName() {
        return csSiteName;
    }

    /**
     * Sets the value of the csSiteName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsSiteName(String value) {
        this.csSiteName = value;
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
     * Gets the value of the iMonth property.
     */
    public long getIMonth() {
        return iMonth;
    }

    /**
     * Sets the value of the iMonth property.
     */
    public void setIMonth(long value) {
        this.iMonth = value;
    }

    /**
     * Gets the value of the csUnitID property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsUnitID() {
        return csUnitID;
    }

    /**
     * Sets the value of the csUnitID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsUnitID(String value) {
        this.csUnitID = value;
    }

}
