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
 *         &lt;element name="sSpecialOrMoveInXML" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sPaymentST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sTenantInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sMoveInParams" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "sSpecialOrMoveInXML",
        "sPaymentST",
        "sTenantInfo",
        "sMoveInParams"
})
@XmlRootElement(name = "AddAccountMoveInSpecial")
public class AddAccountMoveInSpecial {

    protected String csUser;
    protected String csPassword;
    protected String csSiteName;
    protected String sSpecialOrMoveInXML;
    protected String sPaymentST;
    protected String sTenantInfo;
    protected String sMoveInParams;

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
     * Gets the value of the sSpecialOrMoveInXML property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSSpecialOrMoveInXML() {
        return sSpecialOrMoveInXML;
    }

    /**
     * Sets the value of the sSpecialOrMoveInXML property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSSpecialOrMoveInXML(String value) {
        this.sSpecialOrMoveInXML = value;
    }

    /**
     * Gets the value of the sPaymentST property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSPaymentST() {
        return sPaymentST;
    }

    /**
     * Sets the value of the sPaymentST property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSPaymentST(String value) {
        this.sPaymentST = value;
    }

    /**
     * Gets the value of the sTenantInfo property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSTenantInfo() {
        return sTenantInfo;
    }

    /**
     * Sets the value of the sTenantInfo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSTenantInfo(String value) {
        this.sTenantInfo = value;
    }

    /**
     * Gets the value of the sMoveInParams property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSMoveInParams() {
        return sMoveInParams;
    }

    /**
     * Sets the value of the sMoveInParams property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSMoveInParams(String value) {
        this.sMoveInParams = value;
    }

}
