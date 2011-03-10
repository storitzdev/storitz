
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="CheckAccessCodeValidationResult" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
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
    "checkAccessCodeValidationResult"
})
@XmlRootElement(name = "CheckAccessCodeValidationResponse")
public class CheckAccessCodeValidationResponse {

    @XmlElement(name = "CheckAccessCodeValidationResult")
    @XmlSchemaType(name = "unsignedInt")
    protected long checkAccessCodeValidationResult;

    /**
     * Gets the value of the checkAccessCodeValidationResult property.
     * 
     */
    public long getCheckAccessCodeValidationResult() {
        return checkAccessCodeValidationResult;
    }

    /**
     * Sets the value of the checkAccessCodeValidationResult property.
     * 
     */
    public void setCheckAccessCodeValidationResult(long value) {
        this.checkAccessCodeValidationResult = value;
    }

}
