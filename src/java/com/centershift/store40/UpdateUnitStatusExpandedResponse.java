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
 *         &lt;element name="UpdateUnitStatusExpandedResult" type="{http://www.centershift.com/STORE40/}UpdateUnitStatusExpanded_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "updateUnitStatusExpandedResult"
})
@XmlRootElement(name = "UpdateUnitStatusExpandedResponse")
public class UpdateUnitStatusExpandedResponse {

    @XmlElement(name = "UpdateUnitStatusExpandedResult", required = true)
    protected UpdateUnitStatusExpandedResponse2 updateUnitStatusExpandedResult;

    /**
     * Gets the value of the updateUnitStatusExpandedResult property.
     *
     * @return possible object is
     *         {@link UpdateUnitStatusExpandedResponse2 }
     */
    public UpdateUnitStatusExpandedResponse2 getUpdateUnitStatusExpandedResult() {
        return updateUnitStatusExpandedResult;
    }

    /**
     * Sets the value of the updateUnitStatusExpandedResult property.
     *
     * @param value allowed object is
     *              {@link UpdateUnitStatusExpandedResponse2 }
     */
    public void setUpdateUnitStatusExpandedResult(UpdateUnitStatusExpandedResponse2 value) {
        this.updateUnitStatusExpandedResult = value;
    }

}
