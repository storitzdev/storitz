package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for MakeEcommReservation_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="MakeEcommReservation_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="EcommID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UnitID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="QuoteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="QuoteType" type="{http://www.centershift.com/STORE40/}Quote_Types"/>
 *         &lt;element name="RentNow" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Price" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="InquirySource" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Pcds" type="{http://www.centershift.com/STORE40/}ArrayOfTRAN_QUOTE_PCD_DETAIL" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MakeEcommReservation_Request", propOrder = {
        "siteID",
        "ecommID",
        "unitID",
        "version",
        "quoteID",
        "quoteType",
        "rentNow",
        "price",
        "inquirySource",
        "pcds"
})
public class MakeEcommReservationRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "EcommID")
    protected long ecommID;
    @XmlElement(name = "UnitID")
    protected long unitID;
    @XmlElement(name = "Version", required = true)
    protected BigDecimal version;
    @XmlElement(name = "QuoteID", required = true, type = Long.class, nillable = true)
    protected Long quoteID;
    @XmlElement(name = "QuoteType", required = true)
    protected QuoteTypes quoteType;
    @XmlElement(name = "RentNow")
    protected boolean rentNow;
    @XmlElement(name = "Price", required = true, nillable = true)
    protected BigDecimal price;
    @XmlElement(name = "InquirySource", required = true, type = Integer.class, nillable = true)
    protected Integer inquirySource;
    @XmlElement(name = "Pcds")
    protected ArrayOfTRANQUOTEPCDDETAIL pcds;

    /**
     * Gets the value of the siteID property.
     */
    public long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     */
    public void setSiteID(long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the ecommID property.
     */
    public long getEcommID() {
        return ecommID;
    }

    /**
     * Sets the value of the ecommID property.
     */
    public void setEcommID(long value) {
        this.ecommID = value;
    }

    /**
     * Gets the value of the unitID property.
     */
    public long getUnitID() {
        return unitID;
    }

    /**
     * Sets the value of the unitID property.
     */
    public void setUnitID(long value) {
        this.unitID = value;
    }

    /**
     * Gets the value of the version property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setVersion(BigDecimal value) {
        this.version = value;
    }

    /**
     * Gets the value of the quoteID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getQuoteID() {
        return quoteID;
    }

    /**
     * Sets the value of the quoteID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setQuoteID(Long value) {
        this.quoteID = value;
    }

    /**
     * Gets the value of the quoteType property.
     *
     * @return possible object is
     *         {@link QuoteTypes }
     */
    public QuoteTypes getQuoteType() {
        return quoteType;
    }

    /**
     * Sets the value of the quoteType property.
     *
     * @param value allowed object is
     *              {@link QuoteTypes }
     */
    public void setQuoteType(QuoteTypes value) {
        this.quoteType = value;
    }

    /**
     * Gets the value of the rentNow property.
     */
    public boolean isRentNow() {
        return rentNow;
    }

    /**
     * Sets the value of the rentNow property.
     */
    public void setRentNow(boolean value) {
        this.rentNow = value;
    }

    /**
     * Gets the value of the price property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the inquirySource property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getInquirySource() {
        return inquirySource;
    }

    /**
     * Sets the value of the inquirySource property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setInquirySource(Integer value) {
        this.inquirySource = value;
    }

    /**
     * Gets the value of the pcds property.
     *
     * @return possible object is
     *         {@link ArrayOfTRANQUOTEPCDDETAIL }
     */
    public ArrayOfTRANQUOTEPCDDETAIL getPcds() {
        return pcds;
    }

    /**
     * Sets the value of the pcds property.
     *
     * @param value allowed object is
     *              {@link ArrayOfTRANQUOTEPCDDETAIL }
     */
    public void setPcds(ArrayOfTRANQUOTEPCDDETAIL value) {
        this.pcds = value;
    }

}
