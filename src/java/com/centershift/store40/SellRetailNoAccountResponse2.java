
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SellRetailNoAccount_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SellRetailNoAccount_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssessmentID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AccountID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SellRetailNoAccount_Response", propOrder = {
    "assessmentID",
    "accountID"
})
public class SellRetailNoAccountResponse2 {

    @XmlElement(name = "AssessmentID")
    protected long assessmentID;
    @XmlElement(name = "AccountID")
    protected long accountID;

    /**
     * Gets the value of the assessmentID property.
     * 
     */
    public long getAssessmentID() {
        return assessmentID;
    }

    /**
     * Sets the value of the assessmentID property.
     * 
     */
    public void setAssessmentID(long value) {
        this.assessmentID = value;
    }

    /**
     * Gets the value of the accountID property.
     * 
     */
    public long getAccountID() {
        return accountID;
    }

    /**
     * Sets the value of the accountID property.
     * 
     */
    public void setAccountID(long value) {
        this.accountID = value;
    }

}
