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
 *         &lt;element name="EXRFIUExportResult" type="{http://www.centershift.com/STORE40/}EXRFIU_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "exrfiuExportResult"
})
@XmlRootElement(name = "EXRFIUExportResponse")
public class EXRFIUExportResponse {

    @XmlElement(name = "EXRFIUExportResult", required = true)
    protected EXRFIUResponse exrfiuExportResult;

    /**
     * Gets the value of the exrfiuExportResult property.
     *
     * @return possible object is
     *         {@link EXRFIUResponse }
     */
    public EXRFIUResponse getEXRFIUExportResult() {
        return exrfiuExportResult;
    }

    /**
     * Sets the value of the exrfiuExportResult property.
     *
     * @param value allowed object is
     *              {@link EXRFIUResponse }
     */
    public void setEXRFIUExportResult(EXRFIUResponse value) {
        this.exrfiuExportResult = value;
    }

}
