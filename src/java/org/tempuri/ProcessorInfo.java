package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessorInfo complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ProcessorInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="csProcessor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csPropertyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csURL1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csURL2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessorInfo", propOrder = {
        "csProcessor",
        "csUserName",
        "csPassword",
        "csPropertyCode",
        "csURL1",
        "csURL2"
})
public class ProcessorInfo {

    protected String csProcessor;
    protected String csUserName;
    protected String csPassword;
    protected String csPropertyCode;
    protected String csURL1;
    protected String csURL2;

    /**
     * Gets the value of the csProcessor property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsProcessor() {
        return csProcessor;
    }

    /**
     * Sets the value of the csProcessor property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsProcessor(String value) {
        this.csProcessor = value;
    }

    /**
     * Gets the value of the csUserName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsUserName() {
        return csUserName;
    }

    /**
     * Sets the value of the csUserName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsUserName(String value) {
        this.csUserName = value;
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
     * Gets the value of the csPropertyCode property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsPropertyCode() {
        return csPropertyCode;
    }

    /**
     * Sets the value of the csPropertyCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsPropertyCode(String value) {
        this.csPropertyCode = value;
    }

    /**
     * Gets the value of the csURL1 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsURL1() {
        return csURL1;
    }

    /**
     * Sets the value of the csURL1 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsURL1(String value) {
        this.csURL1 = value;
    }

    /**
     * Gets the value of the csURL2 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsURL2() {
        return csURL2;
    }

    /**
     * Sets the value of the csURL2 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsURL2(String value) {
        this.csURL2 = value;
    }

}
