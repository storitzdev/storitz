package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SWS_LOGIN complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SWS_LOGIN">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionSWS_LOGINColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="ECOMM_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="USER_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PASSWORD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SWS_LOGIN", propOrder = {
        "ecommid",
        "orgid",
        "username",
        "password",
        "active"
})
public class SWSLOGIN
        extends BaseEntityOfCollectionSWSLOGINColumnIndexes {

    @XmlElement(name = "ECOMM_ID")
    protected long ecommid;
    @XmlElement(name = "ORG_ID")
    protected long orgid;
    @XmlElement(name = "USER_NAME")
    protected String username;
    @XmlElement(name = "PASSWORD")
    protected String password;
    @XmlElement(name = "ACTIVE")
    protected String active;

    /**
     * Gets the value of the ecommid property.
     */
    public long getECOMMID() {
        return ecommid;
    }

    /**
     * Sets the value of the ecommid property.
     */
    public void setECOMMID(long value) {
        this.ecommid = value;
    }

    /**
     * Gets the value of the orgid property.
     */
    public long getORGID() {
        return orgid;
    }

    /**
     * Sets the value of the orgid property.
     */
    public void setORGID(long value) {
        this.orgid = value;
    }

    /**
     * Gets the value of the username property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getUSERNAME() {
        return username;
    }

    /**
     * Sets the value of the username property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUSERNAME(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the password property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPASSWORD() {
        return password;
    }

    /**
     * Sets the value of the password property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPASSWORD(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the active property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getACTIVE() {
        return active;
    }

    /**
     * Sets the value of the active property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setACTIVE(String value) {
        this.active = value;
    }

}
