package com.centershift.store40;

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
 *         &lt;element name="FIUReIntResult" type="{http://www.centershift.com/STORE40/}FIU_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "fiuReIntResult"
})
@XmlRootElement(name = "FIUReIntResponse")
public class FIUReIntResponse {

    @XmlElement(name = "FIUReIntResult", required = true)
    protected FIUResponse fiuReIntResult;

    /**
     * Gets the value of the fiuReIntResult property.
     *
     * @return possible object is
     *         {@link FIUResponse }
     */
    public FIUResponse getFIUReIntResult() {
        return fiuReIntResult;
    }

    /**
     * Sets the value of the fiuReIntResult property.
     *
     * @param value allowed object is
     *              {@link FIUResponse }
     */
    public void setFIUReIntResult(FIUResponse value) {
        this.fiuReIntResult = value;
    }

}
