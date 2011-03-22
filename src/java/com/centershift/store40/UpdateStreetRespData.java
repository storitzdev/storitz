package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateStreetRespData complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="UpdateStreetRespData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CountPassed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CountFailed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CountRentUpdated" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateStreetRespData", propOrder = {
        "countPassed",
        "countFailed",
        "countRentUpdated",
        "errorMessage"
})
public class UpdateStreetRespData {

    @XmlElement(name = "CountPassed")
    protected int countPassed;
    @XmlElement(name = "CountFailed")
    protected int countFailed;
    @XmlElement(name = "CountRentUpdated")
    protected int countRentUpdated;
    @XmlElement(name = "ErrorMessage")
    protected String errorMessage;

    /**
     * Gets the value of the countPassed property.
     */
    public int getCountPassed() {
        return countPassed;
    }

    /**
     * Sets the value of the countPassed property.
     */
    public void setCountPassed(int value) {
        this.countPassed = value;
    }

    /**
     * Gets the value of the countFailed property.
     */
    public int getCountFailed() {
        return countFailed;
    }

    /**
     * Sets the value of the countFailed property.
     */
    public void setCountFailed(int value) {
        this.countFailed = value;
    }

    /**
     * Gets the value of the countRentUpdated property.
     */
    public int getCountRentUpdated() {
        return countRentUpdated;
    }

    /**
     * Sets the value of the countRentUpdated property.
     */
    public void setCountRentUpdated(int value) {
        this.countRentUpdated = value;
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
