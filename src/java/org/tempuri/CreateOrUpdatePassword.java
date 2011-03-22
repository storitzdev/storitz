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
 *         &lt;element name="sUnitID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sEmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sOldPass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sNewPass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "sUnitID",
        "sEmailAddress",
        "sOldPass",
        "sNewPass"
})
@XmlRootElement(name = "CreateOrUpdatePassword")
public class CreateOrUpdatePassword {

    protected String csUser;
    protected String csPassword;
    protected String csSiteName;
    protected String sUnitID;
    protected String sEmailAddress;
    protected String sOldPass;
    protected String sNewPass;

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
     * Gets the value of the sUnitID property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSUnitID() {
        return sUnitID;
    }

    /**
     * Sets the value of the sUnitID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSUnitID(String value) {
        this.sUnitID = value;
    }

    /**
     * Gets the value of the sEmailAddress property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSEmailAddress() {
        return sEmailAddress;
    }

    /**
     * Sets the value of the sEmailAddress property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSEmailAddress(String value) {
        this.sEmailAddress = value;
    }

    /**
     * Gets the value of the sOldPass property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSOldPass() {
        return sOldPass;
    }

    /**
     * Sets the value of the sOldPass property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSOldPass(String value) {
        this.sOldPass = value;
    }

    /**
     * Gets the value of the sNewPass property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSNewPass() {
        return sNewPass;
    }

    /**
     * Sets the value of the sNewPass property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSNewPass(String value) {
        this.sNewPass = value;
    }

}
