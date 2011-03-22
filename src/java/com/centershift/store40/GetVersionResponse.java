package com.centershift.store40;

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
 *         &lt;element name="GetVersionResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getVersionResult"
})
@XmlRootElement(name = "GetVersionResponse")
public class GetVersionResponse {

    @XmlElement(name = "GetVersionResult")
    protected String getVersionResult;

    /**
     * Gets the value of the getVersionResult property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getGetVersionResult() {
        return getVersionResult;
    }

    /**
     * Sets the value of the getVersionResult property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGetVersionResult(String value) {
        this.getVersionResult = value;
    }

}
