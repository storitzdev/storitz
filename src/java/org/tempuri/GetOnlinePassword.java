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
 *         &lt;element name="csUnitID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "csUnitID",
        "csEmail"
})
@XmlRootElement(name = "GetOnlinePassword")
public class GetOnlinePassword {

    protected String csUser;
    protected String csPassword;
    protected String csSiteName;
    protected String csUnitID;
    protected String csEmail;

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

}
