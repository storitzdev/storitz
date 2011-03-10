
package com.centershift.store40;

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
 *         &lt;element name="MiniKeyStatsResult" type="{http://www.centershift.com/STORE40/}MiniKeyStats_Response"/>
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
    "miniKeyStatsResult"
})
@XmlRootElement(name = "MiniKeyStatsResponse")
public class MiniKeyStatsResponse {

    @XmlElement(name = "MiniKeyStatsResult", required = true)
    protected MiniKeyStatsResponse2 miniKeyStatsResult;

    /**
     * Gets the value of the miniKeyStatsResult property.
     * 
     * @return
     *     possible object is
     *     {@link MiniKeyStatsResponse2 }
     *     
     */
    public MiniKeyStatsResponse2 getMiniKeyStatsResult() {
        return miniKeyStatsResult;
    }

    /**
     * Sets the value of the miniKeyStatsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link MiniKeyStatsResponse2 }
     *     
     */
    public void setMiniKeyStatsResult(MiniKeyStatsResponse2 value) {
        this.miniKeyStatsResult = value;
    }

}
