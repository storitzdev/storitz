
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MiniKeyStatsReport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MiniKeyStatsReport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Occupancy" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Vacancy" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Other" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="GrossPotential" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="GrossPotentialDifference" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ProjectedRent" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ProjectedRentDifference" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="GrossScheduled" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="GrossScheduledDifference" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="EconomicOccupancy" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="EconomicOccupancyDifference" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="OccupiedSquareFeet" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="VacantSquareFeet" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="OtherSquareFeet" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TotalSquareFeet" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="OccupiedSquareFeetPercentage" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="VacantSquareFeetPercentage" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="OtherSquareFeetPercentage" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="OccupiedPercentage" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="VacantPercentage" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ActiveAutoPay" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ARTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ArDifference" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PrepaidRent" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PrepaidRentDifference" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Prospects" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NetYTD" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MiniKeyStatsCollection" type="{http://www.centershift.com/STORE40/}ArrayOfMiniKeyStatsReport" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MiniKeyStatsReport", propOrder = {
    "siteID",
    "occupancy",
    "vacancy",
    "other",
    "grossPotential",
    "grossPotentialDifference",
    "projectedRent",
    "projectedRentDifference",
    "grossScheduled",
    "grossScheduledDifference",
    "economicOccupancy",
    "economicOccupancyDifference",
    "occupiedSquareFeet",
    "vacantSquareFeet",
    "otherSquareFeet",
    "totalSquareFeet",
    "occupiedSquareFeetPercentage",
    "vacantSquareFeetPercentage",
    "otherSquareFeetPercentage",
    "occupiedPercentage",
    "vacantPercentage",
    "activeAutoPay",
    "arTotal",
    "arDifference",
    "prepaidRent",
    "prepaidRentDifference",
    "prospects",
    "netYTD",
    "miniKeyStatsCollection"
})
public class MiniKeyStatsReport {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "Occupancy")
    protected int occupancy;
    @XmlElement(name = "Vacancy")
    protected int vacancy;
    @XmlElement(name = "Other")
    protected int other;
    @XmlElement(name = "GrossPotential", required = true)
    protected BigDecimal grossPotential;
    @XmlElement(name = "GrossPotentialDifference", required = true)
    protected BigDecimal grossPotentialDifference;
    @XmlElement(name = "ProjectedRent", required = true)
    protected BigDecimal projectedRent;
    @XmlElement(name = "ProjectedRentDifference", required = true)
    protected BigDecimal projectedRentDifference;
    @XmlElement(name = "GrossScheduled", required = true)
    protected BigDecimal grossScheduled;
    @XmlElement(name = "GrossScheduledDifference", required = true)
    protected BigDecimal grossScheduledDifference;
    @XmlElement(name = "EconomicOccupancy", required = true)
    protected BigDecimal economicOccupancy;
    @XmlElement(name = "EconomicOccupancyDifference", required = true)
    protected BigDecimal economicOccupancyDifference;
    @XmlElement(name = "OccupiedSquareFeet", required = true)
    protected BigDecimal occupiedSquareFeet;
    @XmlElement(name = "VacantSquareFeet", required = true)
    protected BigDecimal vacantSquareFeet;
    @XmlElement(name = "OtherSquareFeet", required = true)
    protected BigDecimal otherSquareFeet;
    @XmlElement(name = "TotalSquareFeet", required = true)
    protected BigDecimal totalSquareFeet;
    @XmlElement(name = "OccupiedSquareFeetPercentage", required = true)
    protected BigDecimal occupiedSquareFeetPercentage;
    @XmlElement(name = "VacantSquareFeetPercentage", required = true)
    protected BigDecimal vacantSquareFeetPercentage;
    @XmlElement(name = "OtherSquareFeetPercentage", required = true)
    protected BigDecimal otherSquareFeetPercentage;
    @XmlElement(name = "OccupiedPercentage", required = true)
    protected BigDecimal occupiedPercentage;
    @XmlElement(name = "VacantPercentage", required = true)
    protected BigDecimal vacantPercentage;
    @XmlElement(name = "ActiveAutoPay", required = true)
    protected BigDecimal activeAutoPay;
    @XmlElement(name = "ARTotal", required = true)
    protected BigDecimal arTotal;
    @XmlElement(name = "ArDifference", required = true)
    protected BigDecimal arDifference;
    @XmlElement(name = "PrepaidRent", required = true)
    protected BigDecimal prepaidRent;
    @XmlElement(name = "PrepaidRentDifference", required = true)
    protected BigDecimal prepaidRentDifference;
    @XmlElement(name = "Prospects")
    protected int prospects;
    @XmlElement(name = "NetYTD")
    protected int netYTD;
    @XmlElement(name = "MiniKeyStatsCollection")
    protected ArrayOfMiniKeyStatsReport miniKeyStatsCollection;

    /**
     * Gets the value of the siteID property.
     * 
     */
    public long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     * 
     */
    public void setSiteID(long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the occupancy property.
     * 
     */
    public int getOccupancy() {
        return occupancy;
    }

    /**
     * Sets the value of the occupancy property.
     * 
     */
    public void setOccupancy(int value) {
        this.occupancy = value;
    }

    /**
     * Gets the value of the vacancy property.
     * 
     */
    public int getVacancy() {
        return vacancy;
    }

    /**
     * Sets the value of the vacancy property.
     * 
     */
    public void setVacancy(int value) {
        this.vacancy = value;
    }

    /**
     * Gets the value of the other property.
     * 
     */
    public int getOther() {
        return other;
    }

    /**
     * Sets the value of the other property.
     * 
     */
    public void setOther(int value) {
        this.other = value;
    }

    /**
     * Gets the value of the grossPotential property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGrossPotential() {
        return grossPotential;
    }

    /**
     * Sets the value of the grossPotential property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGrossPotential(BigDecimal value) {
        this.grossPotential = value;
    }

    /**
     * Gets the value of the grossPotentialDifference property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGrossPotentialDifference() {
        return grossPotentialDifference;
    }

    /**
     * Sets the value of the grossPotentialDifference property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGrossPotentialDifference(BigDecimal value) {
        this.grossPotentialDifference = value;
    }

    /**
     * Gets the value of the projectedRent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProjectedRent() {
        return projectedRent;
    }

    /**
     * Sets the value of the projectedRent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProjectedRent(BigDecimal value) {
        this.projectedRent = value;
    }

    /**
     * Gets the value of the projectedRentDifference property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProjectedRentDifference() {
        return projectedRentDifference;
    }

    /**
     * Sets the value of the projectedRentDifference property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProjectedRentDifference(BigDecimal value) {
        this.projectedRentDifference = value;
    }

    /**
     * Gets the value of the grossScheduled property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGrossScheduled() {
        return grossScheduled;
    }

    /**
     * Sets the value of the grossScheduled property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGrossScheduled(BigDecimal value) {
        this.grossScheduled = value;
    }

    /**
     * Gets the value of the grossScheduledDifference property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGrossScheduledDifference() {
        return grossScheduledDifference;
    }

    /**
     * Sets the value of the grossScheduledDifference property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGrossScheduledDifference(BigDecimal value) {
        this.grossScheduledDifference = value;
    }

    /**
     * Gets the value of the economicOccupancy property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEconomicOccupancy() {
        return economicOccupancy;
    }

    /**
     * Sets the value of the economicOccupancy property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEconomicOccupancy(BigDecimal value) {
        this.economicOccupancy = value;
    }

    /**
     * Gets the value of the economicOccupancyDifference property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEconomicOccupancyDifference() {
        return economicOccupancyDifference;
    }

    /**
     * Sets the value of the economicOccupancyDifference property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEconomicOccupancyDifference(BigDecimal value) {
        this.economicOccupancyDifference = value;
    }

    /**
     * Gets the value of the occupiedSquareFeet property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOccupiedSquareFeet() {
        return occupiedSquareFeet;
    }

    /**
     * Sets the value of the occupiedSquareFeet property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOccupiedSquareFeet(BigDecimal value) {
        this.occupiedSquareFeet = value;
    }

    /**
     * Gets the value of the vacantSquareFeet property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVacantSquareFeet() {
        return vacantSquareFeet;
    }

    /**
     * Sets the value of the vacantSquareFeet property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVacantSquareFeet(BigDecimal value) {
        this.vacantSquareFeet = value;
    }

    /**
     * Gets the value of the otherSquareFeet property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOtherSquareFeet() {
        return otherSquareFeet;
    }

    /**
     * Sets the value of the otherSquareFeet property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOtherSquareFeet(BigDecimal value) {
        this.otherSquareFeet = value;
    }

    /**
     * Gets the value of the totalSquareFeet property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalSquareFeet() {
        return totalSquareFeet;
    }

    /**
     * Sets the value of the totalSquareFeet property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalSquareFeet(BigDecimal value) {
        this.totalSquareFeet = value;
    }

    /**
     * Gets the value of the occupiedSquareFeetPercentage property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOccupiedSquareFeetPercentage() {
        return occupiedSquareFeetPercentage;
    }

    /**
     * Sets the value of the occupiedSquareFeetPercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOccupiedSquareFeetPercentage(BigDecimal value) {
        this.occupiedSquareFeetPercentage = value;
    }

    /**
     * Gets the value of the vacantSquareFeetPercentage property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVacantSquareFeetPercentage() {
        return vacantSquareFeetPercentage;
    }

    /**
     * Sets the value of the vacantSquareFeetPercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVacantSquareFeetPercentage(BigDecimal value) {
        this.vacantSquareFeetPercentage = value;
    }

    /**
     * Gets the value of the otherSquareFeetPercentage property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOtherSquareFeetPercentage() {
        return otherSquareFeetPercentage;
    }

    /**
     * Sets the value of the otherSquareFeetPercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOtherSquareFeetPercentage(BigDecimal value) {
        this.otherSquareFeetPercentage = value;
    }

    /**
     * Gets the value of the occupiedPercentage property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOccupiedPercentage() {
        return occupiedPercentage;
    }

    /**
     * Sets the value of the occupiedPercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOccupiedPercentage(BigDecimal value) {
        this.occupiedPercentage = value;
    }

    /**
     * Gets the value of the vacantPercentage property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVacantPercentage() {
        return vacantPercentage;
    }

    /**
     * Sets the value of the vacantPercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVacantPercentage(BigDecimal value) {
        this.vacantPercentage = value;
    }

    /**
     * Gets the value of the activeAutoPay property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getActiveAutoPay() {
        return activeAutoPay;
    }

    /**
     * Sets the value of the activeAutoPay property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setActiveAutoPay(BigDecimal value) {
        this.activeAutoPay = value;
    }

    /**
     * Gets the value of the arTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getARTotal() {
        return arTotal;
    }

    /**
     * Sets the value of the arTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setARTotal(BigDecimal value) {
        this.arTotal = value;
    }

    /**
     * Gets the value of the arDifference property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getArDifference() {
        return arDifference;
    }

    /**
     * Sets the value of the arDifference property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setArDifference(BigDecimal value) {
        this.arDifference = value;
    }

    /**
     * Gets the value of the prepaidRent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrepaidRent() {
        return prepaidRent;
    }

    /**
     * Sets the value of the prepaidRent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrepaidRent(BigDecimal value) {
        this.prepaidRent = value;
    }

    /**
     * Gets the value of the prepaidRentDifference property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrepaidRentDifference() {
        return prepaidRentDifference;
    }

    /**
     * Sets the value of the prepaidRentDifference property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrepaidRentDifference(BigDecimal value) {
        this.prepaidRentDifference = value;
    }

    /**
     * Gets the value of the prospects property.
     * 
     */
    public int getProspects() {
        return prospects;
    }

    /**
     * Sets the value of the prospects property.
     * 
     */
    public void setProspects(int value) {
        this.prospects = value;
    }

    /**
     * Gets the value of the netYTD property.
     * 
     */
    public int getNetYTD() {
        return netYTD;
    }

    /**
     * Sets the value of the netYTD property.
     * 
     */
    public void setNetYTD(int value) {
        this.netYTD = value;
    }

    /**
     * Gets the value of the miniKeyStatsCollection property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMiniKeyStatsReport }
     *     
     */
    public ArrayOfMiniKeyStatsReport getMiniKeyStatsCollection() {
        return miniKeyStatsCollection;
    }

    /**
     * Sets the value of the miniKeyStatsCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMiniKeyStatsReport }
     *     
     */
    public void setMiniKeyStatsCollection(ArrayOfMiniKeyStatsReport value) {
        this.miniKeyStatsCollection = value;
    }

}
