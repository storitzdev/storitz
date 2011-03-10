
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="csUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csSiteName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iUnitTypeId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="tMoveInDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "csUser",
    "csPassword",
    "csSiteName",
    "iUnitTypeId",
    "tMoveInDate"
})
@XmlRootElement(name = "MoveInCost")
public class MoveInCost {

    protected String csUser;
    protected String csPassword;
    protected String csSiteName;
    @XmlSchemaType(name = "unsignedInt")
    protected long iUnitTypeId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tMoveInDate;

    /**
     * Gets the value of the csUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsUser() {
        return csUser;
    }

    /**
     * Sets the value of the csUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsUser(String value) {
        this.csUser = value;
    }

    /**
     * Gets the value of the csPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsPassword() {
        return csPassword;
    }

    /**
     * Sets the value of the csPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsPassword(String value) {
        this.csPassword = value;
    }

    /**
     * Gets the value of the csSiteName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsSiteName() {
        return csSiteName;
    }

    /**
     * Sets the value of the csSiteName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsSiteName(String value) {
        this.csSiteName = value;
    }

    /**
     * Gets the value of the iUnitTypeId property.
     * 
     */
    public long getIUnitTypeId() {
        return iUnitTypeId;
    }

    /**
     * Sets the value of the iUnitTypeId property.
     * 
     */
    public void setIUnitTypeId(long value) {
        this.iUnitTypeId = value;
    }

    /**
     * Gets the value of the tMoveInDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTMoveInDate() {
        return tMoveInDate;
    }

    /**
     * Sets the value of the tMoveInDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTMoveInDate(XMLGregorianCalendar value) {
        this.tMoveInDate = value;
    }

}
