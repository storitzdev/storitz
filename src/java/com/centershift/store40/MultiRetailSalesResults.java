package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MultiRetailSalesResults complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="MultiRetailSalesResults">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RetailItemID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Successful" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="AssessmentID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ErrorString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultiRetailSalesResults", propOrder = {
        "retailItemID",
        "successful",
        "assessmentID",
        "errorString"
})
public class MultiRetailSalesResults {

    @XmlElement(name = "RetailItemID")
    protected long retailItemID;
    @XmlElement(name = "Successful")
    protected boolean successful;
    @XmlElement(name = "AssessmentID")
    protected long assessmentID;
    @XmlElement(name = "ErrorString")
    protected String errorString;

    /**
     * Gets the value of the retailItemID property.
     */
    public long getRetailItemID() {
        return retailItemID;
    }

    /**
     * Sets the value of the retailItemID property.
     */
    public void setRetailItemID(long value) {
        this.retailItemID = value;
    }

    /**
     * Gets the value of the successful property.
     */
    public boolean isSuccessful() {
        return successful;
    }

    /**
     * Sets the value of the successful property.
     */
    public void setSuccessful(boolean value) {
        this.successful = value;
    }

    /**
     * Gets the value of the assessmentID property.
     */
    public long getAssessmentID() {
        return assessmentID;
    }

    /**
     * Sets the value of the assessmentID property.
     */
    public void setAssessmentID(long value) {
        this.assessmentID = value;
    }

    /**
     * Gets the value of the errorString property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getErrorString() {
        return errorString;
    }

    /**
     * Sets the value of the errorString property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setErrorString(String value) {
        this.errorString = value;
    }

}
