package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for UpdateUnitStatusExpanded_ResponseData complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="UpdateUnitStatusExpanded_ResponseData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UnitID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="NewUnitVersion" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Succeeded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateUnitStatusExpanded_ResponseData", propOrder = {
        "unitID",
        "newUnitVersion",
        "succeeded",
        "errorMessage"
})
public class UpdateUnitStatusExpandedResponseData {

    @XmlElement(name = "UnitID")
    protected long unitID;
    @XmlElement(name = "NewUnitVersion", required = true)
    protected BigDecimal newUnitVersion;
    @XmlElement(name = "Succeeded")
    protected boolean succeeded;
    @XmlElement(name = "ErrorMessage")
    protected String errorMessage;

    /**
     * Gets the value of the unitID property.
     */
    public long getUnitID() {
        return unitID;
    }

    /**
     * Sets the value of the unitID property.
     */
    public void setUnitID(long value) {
        this.unitID = value;
    }

    /**
     * Gets the value of the newUnitVersion property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getNewUnitVersion() {
        return newUnitVersion;
    }

    /**
     * Sets the value of the newUnitVersion property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setNewUnitVersion(BigDecimal value) {
        this.newUnitVersion = value;
    }

    /**
     * Gets the value of the succeeded property.
     */
    public boolean isSucceeded() {
        return succeeded;
    }

    /**
     * Sets the value of the succeeded property.
     */
    public void setSucceeded(boolean value) {
        this.succeeded = value;
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
