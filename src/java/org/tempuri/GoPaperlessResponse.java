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
 *         &lt;element name="GoPaperlessResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "goPaperlessResult"
})
@XmlRootElement(name = "GoPaperlessResponse")
public class GoPaperlessResponse {

    @XmlElement(name = "GoPaperlessResult")
    protected boolean goPaperlessResult;

    /**
     * Gets the value of the goPaperlessResult property.
     */
    public boolean isGoPaperlessResult() {
        return goPaperlessResult;
    }

    /**
     * Sets the value of the goPaperlessResult property.
     */
    public void setGoPaperlessResult(boolean value) {
        this.goPaperlessResult = value;
    }

}
