package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfDAILY_INS_DETAILS complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfDAILY_INS_DETAILS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DAILY_INS_DETAILS" type="{http://www.centershift.com/STORE40/}DAILY_INS_DETAILS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDAILY_INS_DETAILS", propOrder = {
        "dailyinsdetails"
})
public class ArrayOfDAILYINSDETAILS {

    @XmlElement(name = "DAILY_INS_DETAILS", nillable = true)
    protected List<DAILYINSDETAILS> dailyinsdetails;

    /**
     * Gets the value of the dailyinsdetails property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dailyinsdetails property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDAILYINSDETAILS().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link DAILYINSDETAILS }
     */
    public List<DAILYINSDETAILS> getDAILYINSDETAILS() {
        if (dailyinsdetails == null) {
            dailyinsdetails = new ArrayList<DAILYINSDETAILS>();
        }
        return this.dailyinsdetails;
    }

}
