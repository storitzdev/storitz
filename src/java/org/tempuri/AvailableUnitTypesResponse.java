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
 *         &lt;element name="AvailableUnitTypesResult" type="{http://tempuri.org/}ArrayOfAvailableUnitTypes_ST" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "availableUnitTypesResult"
})
@XmlRootElement(name = "AvailableUnitTypesResponse")
public class AvailableUnitTypesResponse {

    @XmlElement(name = "AvailableUnitTypesResult")
    protected ArrayOfAvailableUnitTypesST availableUnitTypesResult;

    /**
     * Gets the value of the availableUnitTypesResult property.
     *
     * @return possible object is
     *         {@link ArrayOfAvailableUnitTypesST }
     */
    public ArrayOfAvailableUnitTypesST getAvailableUnitTypesResult() {
        return availableUnitTypesResult;
    }

    /**
     * Sets the value of the availableUnitTypesResult property.
     *
     * @param value allowed object is
     *              {@link ArrayOfAvailableUnitTypesST }
     */
    public void setAvailableUnitTypesResult(ArrayOfAvailableUnitTypesST value) {
        this.availableUnitTypesResult = value;
    }

}
