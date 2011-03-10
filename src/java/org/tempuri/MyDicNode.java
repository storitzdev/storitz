
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MyDicNode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MyDicNode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="csKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="obValue" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MyDicNode", propOrder = {
    "csKey",
    "obValue"
})
public class MyDicNode {

    protected String csKey;
    protected Object obValue;

    /**
     * Gets the value of the csKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsKey() {
        return csKey;
    }

    /**
     * Sets the value of the csKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsKey(String value) {
        this.csKey = value;
    }

    /**
     * Gets the value of the obValue property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getObValue() {
        return obValue;
    }

    /**
     * Sets the value of the obValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setObValue(Object value) {
        this.obValue = value;
    }

}
