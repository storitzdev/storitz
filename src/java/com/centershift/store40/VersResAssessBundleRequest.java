
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VersResAssessBundle_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VersResAssessBundle_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetUnitDataRequest" type="{http://www.centershift.com/STORE40/}GetUnitData_Request"/>
 *         &lt;element name="MakeReservationRequest" type="{http://www.centershift.com/STORE40/}MakeReservation_Request"/>
 *         &lt;element name="AssessFeeRequest" type="{http://www.centershift.com/STORE40/}AssessFee_Request"/>
 *         &lt;element name="AddService" type="{http://www.centershift.com/STORE40/}AddMultipleService_Request"/>
 *         &lt;element name="AddInsuranceRequest" type="{http://www.centershift.com/STORE40/}AddInsurance_Request"/>
 *         &lt;element name="SellRetailWithAccountMultipleRequest" type="{http://www.centershift.com/STORE40/}SellRetailWithAccountMultiple_Request"/>
 *         &lt;element name="GetAssessmentsRequest" type="{http://www.centershift.com/STORE40/}GetAssessments_Request"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VersResAssessBundle_Request", propOrder = {
    "getUnitDataRequest",
    "makeReservationRequest",
    "assessFeeRequest",
    "addService",
    "addInsuranceRequest",
    "sellRetailWithAccountMultipleRequest",
    "getAssessmentsRequest"
})
public class VersResAssessBundleRequest {

    @XmlElement(name = "GetUnitDataRequest", required = true)
    protected GetUnitDataRequest getUnitDataRequest;
    @XmlElement(name = "MakeReservationRequest", required = true)
    protected MakeReservationRequest makeReservationRequest;
    @XmlElement(name = "AssessFeeRequest", required = true)
    protected AssessFeeRequest assessFeeRequest;
    @XmlElement(name = "AddService", required = true)
    protected AddMultipleServiceRequest addService;
    @XmlElement(name = "AddInsuranceRequest", required = true)
    protected AddInsuranceRequest addInsuranceRequest;
    @XmlElement(name = "SellRetailWithAccountMultipleRequest", required = true)
    protected SellRetailWithAccountMultipleRequest sellRetailWithAccountMultipleRequest;
    @XmlElement(name = "GetAssessmentsRequest", required = true)
    protected GetAssessmentsRequest getAssessmentsRequest;

    /**
     * Gets the value of the getUnitDataRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetUnitDataRequest }
     *     
     */
    public GetUnitDataRequest getGetUnitDataRequest() {
        return getUnitDataRequest;
    }

    /**
     * Sets the value of the getUnitDataRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetUnitDataRequest }
     *     
     */
    public void setGetUnitDataRequest(GetUnitDataRequest value) {
        this.getUnitDataRequest = value;
    }

    /**
     * Gets the value of the makeReservationRequest property.
     * 
     * @return
     *     possible object is
     *     {@link MakeReservationRequest }
     *     
     */
    public MakeReservationRequest getMakeReservationRequest() {
        return makeReservationRequest;
    }

    /**
     * Sets the value of the makeReservationRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link MakeReservationRequest }
     *     
     */
    public void setMakeReservationRequest(MakeReservationRequest value) {
        this.makeReservationRequest = value;
    }

    /**
     * Gets the value of the assessFeeRequest property.
     * 
     * @return
     *     possible object is
     *     {@link AssessFeeRequest }
     *     
     */
    public AssessFeeRequest getAssessFeeRequest() {
        return assessFeeRequest;
    }

    /**
     * Sets the value of the assessFeeRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssessFeeRequest }
     *     
     */
    public void setAssessFeeRequest(AssessFeeRequest value) {
        this.assessFeeRequest = value;
    }

    /**
     * Gets the value of the addService property.
     * 
     * @return
     *     possible object is
     *     {@link AddMultipleServiceRequest }
     *     
     */
    public AddMultipleServiceRequest getAddService() {
        return addService;
    }

    /**
     * Sets the value of the addService property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddMultipleServiceRequest }
     *     
     */
    public void setAddService(AddMultipleServiceRequest value) {
        this.addService = value;
    }

    /**
     * Gets the value of the addInsuranceRequest property.
     * 
     * @return
     *     possible object is
     *     {@link AddInsuranceRequest }
     *     
     */
    public AddInsuranceRequest getAddInsuranceRequest() {
        return addInsuranceRequest;
    }

    /**
     * Sets the value of the addInsuranceRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddInsuranceRequest }
     *     
     */
    public void setAddInsuranceRequest(AddInsuranceRequest value) {
        this.addInsuranceRequest = value;
    }

    /**
     * Gets the value of the sellRetailWithAccountMultipleRequest property.
     * 
     * @return
     *     possible object is
     *     {@link SellRetailWithAccountMultipleRequest }
     *     
     */
    public SellRetailWithAccountMultipleRequest getSellRetailWithAccountMultipleRequest() {
        return sellRetailWithAccountMultipleRequest;
    }

    /**
     * Sets the value of the sellRetailWithAccountMultipleRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SellRetailWithAccountMultipleRequest }
     *     
     */
    public void setSellRetailWithAccountMultipleRequest(SellRetailWithAccountMultipleRequest value) {
        this.sellRetailWithAccountMultipleRequest = value;
    }

    /**
     * Gets the value of the getAssessmentsRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetAssessmentsRequest }
     *     
     */
    public GetAssessmentsRequest getGetAssessmentsRequest() {
        return getAssessmentsRequest;
    }

    /**
     * Sets the value of the getAssessmentsRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetAssessmentsRequest }
     *     
     */
    public void setGetAssessmentsRequest(GetAssessmentsRequest value) {
        this.getAssessmentsRequest = value;
    }

}
