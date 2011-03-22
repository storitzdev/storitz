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
 *         &lt;element name="UnitTypeInfoResult" type="{http://tempuri.org/}UnitTypeInfo_ST"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "unitTypeInfoResult"
})
@XmlRootElement(name = "UnitTypeInfoResponse")
public class UnitTypeInfoResponse {

    @XmlElement(name = "UnitTypeInfoResult", required = true)
    protected UnitTypeInfoST unitTypeInfoResult;

    /**
     * Gets the value of the unitTypeInfoResult property.
     *
     * @return possible object is
     *         {@link UnitTypeInfoST }
     */
    public UnitTypeInfoST getUnitTypeInfoResult() {
        return unitTypeInfoResult;
    }

    /**
     * Sets the value of the unitTypeInfoResult property.
     *
     * @param value allowed object is
     *              {@link UnitTypeInfoST }
     */
    public void setUnitTypeInfoResult(UnitTypeInfoST value) {
        this.unitTypeInfoResult = value;
    }

}
