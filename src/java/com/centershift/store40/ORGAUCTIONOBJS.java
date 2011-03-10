
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ORG_AUCTION_OBJS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ORG_AUCTION_OBJS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionORG_AUCTION_OBJSColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="AUCTION_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UNIT_CONTENTS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SOLD_TO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AMT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TAX_COLLECTED" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ADDRESS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NOTES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PHONE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TAX_EXEMPT" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="TAX_EXEMPT_NUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORG_AUCTION_OBJS", propOrder = {
    "auctionid",
    "rentalid",
    "unitcontents",
    "soldto",
    "amt",
    "taxcollected",
    "address",
    "notes",
    "status",
    "phone",
    "createdby",
    "updatedby",
    "taxexempt",
    "taxexemptnum"
})
public class ORGAUCTIONOBJS
    extends BaseEntityOfCollectionORGAUCTIONOBJSColumnIndexes
{

    @XmlElement(name = "AUCTION_ID", required = true, type = Long.class, nillable = true)
    protected Long auctionid;
    @XmlElement(name = "RENTAL_ID", required = true, type = Long.class, nillable = true)
    protected Long rentalid;
    @XmlElement(name = "UNIT_CONTENTS")
    protected String unitcontents;
    @XmlElement(name = "SOLD_TO")
    protected String soldto;
    @XmlElement(name = "AMT", required = true, nillable = true)
    protected BigDecimal amt;
    @XmlElement(name = "TAX_COLLECTED", required = true, nillable = true)
    protected BigDecimal taxcollected;
    @XmlElement(name = "ADDRESS")
    protected String address;
    @XmlElement(name = "NOTES")
    protected String notes;
    @XmlElement(name = "STATUS")
    protected int status;
    @XmlElement(name = "PHONE")
    protected String phone;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;
    @XmlElement(name = "TAX_EXEMPT")
    protected boolean taxexempt;
    @XmlElement(name = "TAX_EXEMPT_NUM")
    protected String taxexemptnum;

    /**
     * Gets the value of the auctionid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAUCTIONID() {
        return auctionid;
    }

    /**
     * Sets the value of the auctionid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAUCTIONID(Long value) {
        this.auctionid = value;
    }

    /**
     * Gets the value of the rentalid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRENTALID() {
        return rentalid;
    }

    /**
     * Sets the value of the rentalid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRENTALID(Long value) {
        this.rentalid = value;
    }

    /**
     * Gets the value of the unitcontents property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNITCONTENTS() {
        return unitcontents;
    }

    /**
     * Sets the value of the unitcontents property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUNITCONTENTS(String value) {
        this.unitcontents = value;
    }

    /**
     * Gets the value of the soldto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSOLDTO() {
        return soldto;
    }

    /**
     * Sets the value of the soldto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSOLDTO(String value) {
        this.soldto = value;
    }

    /**
     * Gets the value of the amt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAMT() {
        return amt;
    }

    /**
     * Sets the value of the amt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAMT(BigDecimal value) {
        this.amt = value;
    }

    /**
     * Gets the value of the taxcollected property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTAXCOLLECTED() {
        return taxcollected;
    }

    /**
     * Sets the value of the taxcollected property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTAXCOLLECTED(BigDecimal value) {
        this.taxcollected = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADDRESS() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADDRESS(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the notes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOTES() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOTES(String value) {
        this.notes = value;
    }

    /**
     * Gets the value of the status property.
     * 
     */
    public int getSTATUS() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     */
    public void setSTATUS(int value) {
        this.status = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPHONE() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPHONE(String value) {
        this.phone = value;
    }

    /**
     * Gets the value of the createdby property.
     * 
     */
    public long getCREATEDBY() {
        return createdby;
    }

    /**
     * Sets the value of the createdby property.
     * 
     */
    public void setCREATEDBY(long value) {
        this.createdby = value;
    }

    /**
     * Gets the value of the updatedby property.
     * 
     */
    public long getUPDATEDBY() {
        return updatedby;
    }

    /**
     * Sets the value of the updatedby property.
     * 
     */
    public void setUPDATEDBY(long value) {
        this.updatedby = value;
    }

    /**
     * Gets the value of the taxexempt property.
     * 
     */
    public boolean isTAXEXEMPT() {
        return taxexempt;
    }

    /**
     * Sets the value of the taxexempt property.
     * 
     */
    public void setTAXEXEMPT(boolean value) {
        this.taxexempt = value;
    }

    /**
     * Gets the value of the taxexemptnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTAXEXEMPTNUM() {
        return taxexemptnum;
    }

    /**
     * Sets the value of the taxexemptnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTAXEXEMPTNUM(String value) {
        this.taxexemptnum = value;
    }

}
