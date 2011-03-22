package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VoidRetailAssessmentData complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="VoidRetailAssessmentData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssessID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Success" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VoidRetailAssessmentData", propOrder = {
        "assessID",
        "success",
        "errorMessage"
})
public class VoidRetailAssessmentData {

    @XmlElement(name = "AssessID")
    protected long assessID;
    @XmlElement(name = "Success")
    protected boolean success;
    @XmlElement(name = "ErrorMessage")
    protected String errorMessage;

    /**
     * Gets the value of the assessID property.
     */
    public long getAssessID() {
        return assessID;
    }

    /**
     * Sets the value of the assessID property.
     */
    public void setAssessID(long value) {
        this.assessID = value;
    }

    /**
     * Gets the value of the success property.
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets the value of the success property.
     */
    public void setSuccess(boolean value) {
        this.success = value;
    }

    /**
     * Gets the value of the errorMessage property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

}
