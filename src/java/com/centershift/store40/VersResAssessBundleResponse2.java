
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VersResAssessBundle_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VersResAssessBundle_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MakeReservationResponse" type="{http://www.centershift.com/STORE40/}MakeReservation_Response"/>
 *         &lt;element name="AssessFeeResponse" type="{http://www.centershift.com/STORE40/}AssessFee_Response"/>
 *         &lt;element name="AddInsuranceResponse" type="{http://www.centershift.com/STORE40/}AddInsurance_Response"/>
 *         &lt;element name="AddServicesResponse" type="{http://www.centershift.com/STORE40/}ArrayOfAddMultipleServices_Response" minOccurs="0"/>
 *         &lt;element name="SellRetailMultipleResponse" type="{http://www.centershift.com/STORE40/}SellRetailMultiple_Response"/>
 *         &lt;element name="GetAssessmentsResponse" type="{http://www.centershift.com/STORE40/}GetAssessments_Response"/>
 *         &lt;element name="Succeeded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ProcessResults" type="{http://www.centershift.com/STORE40/}ArrayOfProcessResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VersResAssessBundle_Response", propOrder = {
    "makeReservationResponse",
    "assessFeeResponse",
    "addInsuranceResponse",
    "addServicesResponse",
    "sellRetailMultipleResponse",
    "getAssessmentsResponse",
    "succeeded",
    "processResults"
})
public class VersResAssessBundleResponse2 {

    @XmlElement(name = "MakeReservationResponse", required = true)
    protected MakeReservationResponse makeReservationResponse;
    @XmlElement(name = "AssessFeeResponse", required = true)
    protected AssessFeeResponse2 assessFeeResponse;
    @XmlElement(name = "AddInsuranceResponse", required = true)
    protected AddInsuranceResponse2 addInsuranceResponse;
    @XmlElement(name = "AddServicesResponse")
    protected ArrayOfAddMultipleServicesResponse addServicesResponse;
    @XmlElement(name = "SellRetailMultipleResponse", required = true)
    protected SellRetailMultipleResponse sellRetailMultipleResponse;
    @XmlElement(name = "GetAssessmentsResponse", required = true)
    protected GetAssessmentsResponse2 getAssessmentsResponse;
    @XmlElement(name = "Succeeded")
    protected boolean succeeded;
    @XmlElement(name = "ProcessResults")
    protected ArrayOfProcessResult processResults;

    /**
     * Gets the value of the makeReservationResponse property.
     * 
     * @return
     *     possible object is
     *     {@link MakeReservationResponse }
     *     
     */
    public MakeReservationResponse getMakeReservationResponse() {
        return makeReservationResponse;
    }

    /**
     * Sets the value of the makeReservationResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link MakeReservationResponse }
     *     
     */
    public void setMakeReservationResponse(MakeReservationResponse value) {
        this.makeReservationResponse = value;
    }

    /**
     * Gets the value of the assessFeeResponse property.
     * 
     * @return
     *     possible object is
     *     {@link AssessFeeResponse2 }
     *     
     */
    public AssessFeeResponse2 getAssessFeeResponse() {
        return assessFeeResponse;
    }

    /**
     * Sets the value of the assessFeeResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssessFeeResponse2 }
     *     
     */
    public void setAssessFeeResponse(AssessFeeResponse2 value) {
        this.assessFeeResponse = value;
    }

    /**
     * Gets the value of the addInsuranceResponse property.
     * 
     * @return
     *     possible object is
     *     {@link AddInsuranceResponse2 }
     *     
     */
    public AddInsuranceResponse2 getAddInsuranceResponse() {
        return addInsuranceResponse;
    }

    /**
     * Sets the value of the addInsuranceResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddInsuranceResponse2 }
     *     
     */
    public void setAddInsuranceResponse(AddInsuranceResponse2 value) {
        this.addInsuranceResponse = value;
    }

    /**
     * Gets the value of the addServicesResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAddMultipleServicesResponse }
     *     
     */
    public ArrayOfAddMultipleServicesResponse getAddServicesResponse() {
        return addServicesResponse;
    }

    /**
     * Sets the value of the addServicesResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAddMultipleServicesResponse }
     *     
     */
    public void setAddServicesResponse(ArrayOfAddMultipleServicesResponse value) {
        this.addServicesResponse = value;
    }

    /**
     * Gets the value of the sellRetailMultipleResponse property.
     * 
     * @return
     *     possible object is
     *     {@link SellRetailMultipleResponse }
     *     
     */
    public SellRetailMultipleResponse getSellRetailMultipleResponse() {
        return sellRetailMultipleResponse;
    }

    /**
     * Sets the value of the sellRetailMultipleResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link SellRetailMultipleResponse }
     *     
     */
    public void setSellRetailMultipleResponse(SellRetailMultipleResponse value) {
        this.sellRetailMultipleResponse = value;
    }

    /**
     * Gets the value of the getAssessmentsResponse property.
     * 
     * @return
     *     possible object is
     *     {@link GetAssessmentsResponse2 }
     *     
     */
    public GetAssessmentsResponse2 getGetAssessmentsResponse() {
        return getAssessmentsResponse;
    }

    /**
     * Sets the value of the getAssessmentsResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetAssessmentsResponse2 }
     *     
     */
    public void setGetAssessmentsResponse(GetAssessmentsResponse2 value) {
        this.getAssessmentsResponse = value;
    }

    /**
     * Gets the value of the succeeded property.
     * 
     */
    public boolean isSucceeded() {
        return succeeded;
    }

    /**
     * Sets the value of the succeeded property.
     * 
     */
    public void setSucceeded(boolean value) {
        this.succeeded = value;
    }

    /**
     * Gets the value of the processResults property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfProcessResult }
     *     
     */
    public ArrayOfProcessResult getProcessResults() {
        return processResults;
    }

    /**
     * Sets the value of the processResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfProcessResult }
     *     
     */
    public void setProcessResults(ArrayOfProcessResult value) {
        this.processResults = value;
    }

}
