
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetTotalDuePastDue_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetTotalDuePastDue_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestedTotalDue" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PastDueTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PastDueCycles" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTotalDuePastDue_Response", propOrder = {
    "requestedTotalDue",
    "pastDueTotal",
    "pastDueCycles"
})
public class GetTotalDuePastDueResponse2 {

    @XmlElement(name = "RequestedTotalDue", required = true)
    protected BigDecimal requestedTotalDue;
    @XmlElement(name = "PastDueTotal", required = true)
    protected BigDecimal pastDueTotal;
    @XmlElement(name = "PastDueCycles")
    protected int pastDueCycles;

    /**
     * Gets the value of the requestedTotalDue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRequestedTotalDue() {
        return requestedTotalDue;
    }

    /**
     * Sets the value of the requestedTotalDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRequestedTotalDue(BigDecimal value) {
        this.requestedTotalDue = value;
    }

    /**
     * Gets the value of the pastDueTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPastDueTotal() {
        return pastDueTotal;
    }

    /**
     * Sets the value of the pastDueTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPastDueTotal(BigDecimal value) {
        this.pastDueTotal = value;
    }

    /**
     * Gets the value of the pastDueCycles property.
     * 
     */
    public int getPastDueCycles() {
        return pastDueCycles;
    }

    /**
     * Sets the value of the pastDueCycles property.
     * 
     */
    public void setPastDueCycles(int value) {
        this.pastDueCycles = value;
    }

}
