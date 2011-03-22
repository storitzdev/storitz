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
 *         &lt;element name="HelloWorldPasswordResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "helloWorldPasswordResult"
})
@XmlRootElement(name = "HelloWorldPasswordResponse")
public class HelloWorldPasswordResponse {

    @XmlElement(name = "HelloWorldPasswordResult")
    protected String helloWorldPasswordResult;

    /**
     * Gets the value of the helloWorldPasswordResult property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getHelloWorldPasswordResult() {
        return helloWorldPasswordResult;
    }

    /**
     * Sets the value of the helloWorldPasswordResult property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setHelloWorldPasswordResult(String value) {
        this.helloWorldPasswordResult = value;
    }

}
