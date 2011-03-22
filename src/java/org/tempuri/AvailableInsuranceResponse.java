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
 *         &lt;element name="AvailableInsuranceResult" type="{http://tempuri.org/}ArrayOfAvailableInsurance_ST" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "availableInsuranceResult"
})
@XmlRootElement(name = "AvailableInsuranceResponse")
public class AvailableInsuranceResponse {

    @XmlElement(name = "AvailableInsuranceResult")
    protected ArrayOfAvailableInsuranceST availableInsuranceResult;

    /**
     * Gets the value of the availableInsuranceResult property.
     *
     * @return possible object is
     *         {@link ArrayOfAvailableInsuranceST }
     */
    public ArrayOfAvailableInsuranceST getAvailableInsuranceResult() {
        return availableInsuranceResult;
    }

    /**
     * Sets the value of the availableInsuranceResult property.
     *
     * @param value allowed object is
     *              {@link ArrayOfAvailableInsuranceST }
     */
    public void setAvailableInsuranceResult(ArrayOfAvailableInsuranceST value) {
        this.availableInsuranceResult = value;
    }

}
