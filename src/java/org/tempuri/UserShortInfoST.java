
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserShortInfo_ST complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserShortInfo_ST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="csEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csKeycode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserShortInfo_ST", propOrder = {
    "csEmail",
    "csKeycode"
})
public class UserShortInfoST {

    protected String csEmail;
    protected String csKeycode;

    /**
     * Gets the value of the csEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsEmail() {
        return csEmail;
    }

    /**
     * Sets the value of the csEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsEmail(String value) {
        this.csEmail = value;
    }

    /**
     * Gets the value of the csKeycode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsKeycode() {
        return csKeycode;
    }

    /**
     * Sets the value of the csKeycode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsKeycode(String value) {
        this.csKeycode = value;
    }

}
