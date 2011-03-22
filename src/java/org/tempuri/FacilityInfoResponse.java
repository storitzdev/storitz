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
 *         &lt;element name="FacilityInfoResult" type="{http://tempuri.org/}FacilityInfo_ST"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "facilityInfoResult"
})
@XmlRootElement(name = "FacilityInfoResponse")
public class FacilityInfoResponse {

    @XmlElement(name = "FacilityInfoResult", required = true)
    protected FacilityInfoST facilityInfoResult;

    /**
     * Gets the value of the facilityInfoResult property.
     *
     * @return possible object is
     *         {@link FacilityInfoST }
     */
    public FacilityInfoST getFacilityInfoResult() {
        return facilityInfoResult;
    }

    /**
     * Sets the value of the facilityInfoResult property.
     *
     * @param value allowed object is
     *              {@link FacilityInfoST }
     */
    public void setFacilityInfoResult(FacilityInfoST value) {
        this.facilityInfoResult = value;
    }

}
