
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetUnitEmailResult" type="{http://tempuri.org/}UserShortInfo_ST"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getUnitEmailResult"
})
@XmlRootElement(name = "GetUnitEmailResponse")
public class GetUnitEmailResponse {

    @XmlElement(name = "GetUnitEmailResult", required = true)
    protected UserShortInfoST getUnitEmailResult;

    /**
     * Gets the value of the getUnitEmailResult property.
     * 
     * @return
     *     possible object is
     *     {@link UserShortInfoST }
     *     
     */
    public UserShortInfoST getGetUnitEmailResult() {
        return getUnitEmailResult;
    }

    /**
     * Sets the value of the getUnitEmailResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserShortInfoST }
     *     
     */
    public void setGetUnitEmailResult(UserShortInfoST value) {
        this.getUnitEmailResult = value;
    }

}
