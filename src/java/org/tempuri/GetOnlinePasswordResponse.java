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
 *         &lt;element name="GetOnlinePasswordResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getOnlinePasswordResult"
})
@XmlRootElement(name = "GetOnlinePasswordResponse")
public class GetOnlinePasswordResponse {

    @XmlElement(name = "GetOnlinePasswordResult")
    protected String getOnlinePasswordResult;

    /**
     * Gets the value of the getOnlinePasswordResult property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getGetOnlinePasswordResult() {
        return getOnlinePasswordResult;
    }

    /**
     * Sets the value of the getOnlinePasswordResult property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGetOnlinePasswordResult(String value) {
        this.getOnlinePasswordResult = value;
    }

}
