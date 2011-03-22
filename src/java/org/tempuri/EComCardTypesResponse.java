package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="eComCardTypesResult" type="{http://tempuri.org/}ArrayOfAnyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "eComCardTypesResult"
})
@XmlRootElement(name = "eComCardTypesResponse")
public class EComCardTypesResponse {

    protected ArrayOfAnyType eComCardTypesResult;

    /**
     * Gets the value of the eComCardTypesResult property.
     *
     * @return possible object is
     *         {@link ArrayOfAnyType }
     */
    public ArrayOfAnyType getEComCardTypesResult() {
        return eComCardTypesResult;
    }

    /**
     * Sets the value of the eComCardTypesResult property.
     *
     * @param value allowed object is
     *              {@link ArrayOfAnyType }
     */
    public void setEComCardTypesResult(ArrayOfAnyType value) {
        this.eComCardTypesResult = value;
    }

}
