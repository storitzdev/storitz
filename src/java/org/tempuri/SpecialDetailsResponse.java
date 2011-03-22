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
 *         &lt;element name="SpecialDetailsResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "specialDetailsResult"
})
@XmlRootElement(name = "SpecialDetailsResponse")
public class SpecialDetailsResponse {

    @XmlElement(name = "SpecialDetailsResult")
    protected String specialDetailsResult;

    /**
     * Gets the value of the specialDetailsResult property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSpecialDetailsResult() {
        return specialDetailsResult;
    }

    /**
     * Sets the value of the specialDetailsResult property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSpecialDetailsResult(String value) {
        this.specialDetailsResult = value;
    }

}
