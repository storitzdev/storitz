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
 *         &lt;element name="itypeId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
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
        "itypeId"
})
@XmlRootElement(name = "UnitTypeInfo")
public class UnitTypeInfo {

    protected String csUser;
    protected String csPassword;
    protected String csSiteName;
    @XmlSchemaType(name = "unsignedInt")
    protected long itypeId;

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
     * Gets the value of the itypeId property.
     */
    public long getItypeId() {
        return itypeId;
    }

    /**
     * Sets the value of the itypeId property.
     */
    public void setItypeId(long value) {
        this.itypeId = value;
    }

}
