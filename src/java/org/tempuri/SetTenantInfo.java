package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="csUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csWorkPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csHomePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csCellPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "csUnit",
        "csAddress",
        "csZip",
        "csCity",
        "csEmail",
        "csWorkPhone",
        "csHomePhone",
        "csCellPhone"
})
@XmlRootElement(name = "SetTenantInfo")
public class SetTenantInfo {

    protected String csUser;
    protected String csPassword;
    protected String csSiteName;
    protected String csUnit;
    protected String csAddress;
    protected String csZip;
    protected String csCity;
    protected String csEmail;
    protected String csWorkPhone;
    protected String csHomePhone;
    protected String csCellPhone;

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
     * Gets the value of the csUnit property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsUnit() {
        return csUnit;
    }

    /**
     * Sets the value of the csUnit property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsUnit(String value) {
        this.csUnit = value;
    }

    /**
     * Gets the value of the csAddress property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsAddress() {
        return csAddress;
    }

    /**
     * Sets the value of the csAddress property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsAddress(String value) {
        this.csAddress = value;
    }

    /**
     * Gets the value of the csZip property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsZip() {
        return csZip;
    }

    /**
     * Sets the value of the csZip property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsZip(String value) {
        this.csZip = value;
    }

    /**
     * Gets the value of the csCity property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsCity() {
        return csCity;
    }

    /**
     * Sets the value of the csCity property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsCity(String value) {
        this.csCity = value;
    }

    /**
     * Gets the value of the csEmail property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsEmail() {
        return csEmail;
    }

    /**
     * Sets the value of the csEmail property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsEmail(String value) {
        this.csEmail = value;
    }

    /**
     * Gets the value of the csWorkPhone property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsWorkPhone() {
        return csWorkPhone;
    }

    /**
     * Sets the value of the csWorkPhone property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsWorkPhone(String value) {
        this.csWorkPhone = value;
    }

    /**
     * Gets the value of the csHomePhone property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsHomePhone() {
        return csHomePhone;
    }

    /**
     * Sets the value of the csHomePhone property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsHomePhone(String value) {
        this.csHomePhone = value;
    }

    /**
     * Gets the value of the csCellPhone property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsCellPhone() {
        return csCellPhone;
    }

    /**
     * Sets the value of the csCellPhone property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsCellPhone(String value) {
        this.csCellPhone = value;
    }

}
