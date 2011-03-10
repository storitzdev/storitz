
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProcessName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProcessSuccessful" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ErrorData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessResult", propOrder = {
    "processName",
    "processSuccessful",
    "errorData"
})
public class ProcessResult {

    @XmlElement(name = "ProcessName")
    protected String processName;
    @XmlElement(name = "ProcessSuccessful")
    protected boolean processSuccessful;
    @XmlElement(name = "ErrorData")
    protected String errorData;

    /**
     * Gets the value of the processName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * Sets the value of the processName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessName(String value) {
        this.processName = value;
    }

    /**
     * Gets the value of the processSuccessful property.
     * 
     */
    public boolean isProcessSuccessful() {
        return processSuccessful;
    }

    /**
     * Sets the value of the processSuccessful property.
     * 
     */
    public void setProcessSuccessful(boolean value) {
        this.processSuccessful = value;
    }

    /**
     * Gets the value of the errorData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorData() {
        return errorData;
    }

    /**
     * Sets the value of the errorData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorData(String value) {
        this.errorData = value;
    }

}
