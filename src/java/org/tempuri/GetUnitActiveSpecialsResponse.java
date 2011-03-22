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
 *         &lt;element name="GetUnitActiveSpecialsResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getUnitActiveSpecialsResult"
})
@XmlRootElement(name = "GetUnitActiveSpecialsResponse")
public class GetUnitActiveSpecialsResponse {

    @XmlElement(name = "GetUnitActiveSpecialsResult")
    protected String getUnitActiveSpecialsResult;

    /**
     * Gets the value of the getUnitActiveSpecialsResult property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getGetUnitActiveSpecialsResult() {
        return getUnitActiveSpecialsResult;
    }

    /**
     * Sets the value of the getUnitActiveSpecialsResult property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGetUnitActiveSpecialsResult(String value) {
        this.getUnitActiveSpecialsResult = value;
    }

}
