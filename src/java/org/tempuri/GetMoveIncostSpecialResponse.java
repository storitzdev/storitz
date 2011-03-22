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
 *         &lt;element name="GetMoveIncostSpecialResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getMoveIncostSpecialResult"
})
@XmlRootElement(name = "GetMoveIncostSpecialResponse")
public class GetMoveIncostSpecialResponse {

    @XmlElement(name = "GetMoveIncostSpecialResult")
    protected String getMoveIncostSpecialResult;

    /**
     * Gets the value of the getMoveIncostSpecialResult property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getGetMoveIncostSpecialResult() {
        return getMoveIncostSpecialResult;
    }

    /**
     * Sets the value of the getMoveIncostSpecialResult property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGetMoveIncostSpecialResult(String value) {
        this.getMoveIncostSpecialResult = value;
    }

}
