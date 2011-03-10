
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for RecurringTask complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecurringTask">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatternType" type="{http://www.centershift.com/STORE40/}RecurPattern"/>
 *         &lt;element name="DailyOption" type="{http://www.centershift.com/STORE40/}DailyOptions"/>
 *         &lt;element name="NumberOfDays" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NumberOfWeeks" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DayOfWeek" type="{http://www.centershift.com/STORE40/}ArrayOfDaysOfWeek" minOccurs="0"/>
 *         &lt;element name="DayOfMonth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NumOfMonths" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MonthOfYear" type="{http://www.centershift.com/STORE40/}MonthsOfYear"/>
 *         &lt;element name="DayOfMonthOfYear" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RangeOfRecur" type="{http://www.centershift.com/STORE40/}RecurRange"/>
 *         &lt;element name="EndNumRecur" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecurringTask", propOrder = {
    "patternType",
    "dailyOption",
    "numberOfDays",
    "numberOfWeeks",
    "dayOfWeek",
    "dayOfMonth",
    "numOfMonths",
    "monthOfYear",
    "dayOfMonthOfYear",
    "rangeOfRecur",
    "endNumRecur",
    "endDate"
})
@XmlSeeAlso({
    RecurTaskData.class
})
public class RecurringTask {

    @XmlElement(name = "PatternType", required = true)
    protected RecurPattern patternType;
    @XmlElement(name = "DailyOption", required = true)
    protected DailyOptions dailyOption;
    @XmlElement(name = "NumberOfDays")
    protected int numberOfDays;
    @XmlElement(name = "NumberOfWeeks")
    protected int numberOfWeeks;
    @XmlElement(name = "DayOfWeek")
    protected ArrayOfDaysOfWeek dayOfWeek;
    @XmlElement(name = "DayOfMonth")
    protected int dayOfMonth;
    @XmlElement(name = "NumOfMonths")
    protected int numOfMonths;
    @XmlElement(name = "MonthOfYear", required = true)
    protected MonthsOfYear monthOfYear;
    @XmlElement(name = "DayOfMonthOfYear")
    protected int dayOfMonthOfYear;
    @XmlElement(name = "RangeOfRecur", required = true)
    protected RecurRange rangeOfRecur;
    @XmlElement(name = "EndNumRecur")
    protected int endNumRecur;
    @XmlElement(name = "EndDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;

    /**
     * Gets the value of the patternType property.
     * 
     * @return
     *     possible object is
     *     {@link RecurPattern }
     *     
     */
    public RecurPattern getPatternType() {
        return patternType;
    }

    /**
     * Sets the value of the patternType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecurPattern }
     *     
     */
    public void setPatternType(RecurPattern value) {
        this.patternType = value;
    }

    /**
     * Gets the value of the dailyOption property.
     * 
     * @return
     *     possible object is
     *     {@link DailyOptions }
     *     
     */
    public DailyOptions getDailyOption() {
        return dailyOption;
    }

    /**
     * Sets the value of the dailyOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link DailyOptions }
     *     
     */
    public void setDailyOption(DailyOptions value) {
        this.dailyOption = value;
    }

    /**
     * Gets the value of the numberOfDays property.
     * 
     */
    public int getNumberOfDays() {
        return numberOfDays;
    }

    /**
     * Sets the value of the numberOfDays property.
     * 
     */
    public void setNumberOfDays(int value) {
        this.numberOfDays = value;
    }

    /**
     * Gets the value of the numberOfWeeks property.
     * 
     */
    public int getNumberOfWeeks() {
        return numberOfWeeks;
    }

    /**
     * Sets the value of the numberOfWeeks property.
     * 
     */
    public void setNumberOfWeeks(int value) {
        this.numberOfWeeks = value;
    }

    /**
     * Gets the value of the dayOfWeek property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDaysOfWeek }
     *     
     */
    public ArrayOfDaysOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * Sets the value of the dayOfWeek property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDaysOfWeek }
     *     
     */
    public void setDayOfWeek(ArrayOfDaysOfWeek value) {
        this.dayOfWeek = value;
    }

    /**
     * Gets the value of the dayOfMonth property.
     * 
     */
    public int getDayOfMonth() {
        return dayOfMonth;
    }

    /**
     * Sets the value of the dayOfMonth property.
     * 
     */
    public void setDayOfMonth(int value) {
        this.dayOfMonth = value;
    }

    /**
     * Gets the value of the numOfMonths property.
     * 
     */
    public int getNumOfMonths() {
        return numOfMonths;
    }

    /**
     * Sets the value of the numOfMonths property.
     * 
     */
    public void setNumOfMonths(int value) {
        this.numOfMonths = value;
    }

    /**
     * Gets the value of the monthOfYear property.
     * 
     * @return
     *     possible object is
     *     {@link MonthsOfYear }
     *     
     */
    public MonthsOfYear getMonthOfYear() {
        return monthOfYear;
    }

    /**
     * Sets the value of the monthOfYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link MonthsOfYear }
     *     
     */
    public void setMonthOfYear(MonthsOfYear value) {
        this.monthOfYear = value;
    }

    /**
     * Gets the value of the dayOfMonthOfYear property.
     * 
     */
    public int getDayOfMonthOfYear() {
        return dayOfMonthOfYear;
    }

    /**
     * Sets the value of the dayOfMonthOfYear property.
     * 
     */
    public void setDayOfMonthOfYear(int value) {
        this.dayOfMonthOfYear = value;
    }

    /**
     * Gets the value of the rangeOfRecur property.
     * 
     * @return
     *     possible object is
     *     {@link RecurRange }
     *     
     */
    public RecurRange getRangeOfRecur() {
        return rangeOfRecur;
    }

    /**
     * Sets the value of the rangeOfRecur property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecurRange }
     *     
     */
    public void setRangeOfRecur(RecurRange value) {
        this.rangeOfRecur = value;
    }

    /**
     * Gets the value of the endNumRecur property.
     * 
     */
    public int getEndNumRecur() {
        return endNumRecur;
    }

    /**
     * Sets the value of the endNumRecur property.
     * 
     */
    public void setEndNumRecur(int value) {
        this.endNumRecur = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

}
