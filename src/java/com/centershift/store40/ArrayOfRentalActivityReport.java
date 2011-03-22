package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfRentalActivityReport complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfRentalActivityReport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentalActivityReport" type="{http://www.centershift.com/STORE40/}RentalActivityReport" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRentalActivityReport", propOrder = {
        "rentalActivityReport"
})
public class ArrayOfRentalActivityReport {

    @XmlElement(name = "RentalActivityReport", nillable = true)
    protected List<RentalActivityReport> rentalActivityReport;

    /**
     * Gets the value of the rentalActivityReport property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rentalActivityReport property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRentalActivityReport().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link RentalActivityReport }
     */
    public List<RentalActivityReport> getRentalActivityReport() {
        if (rentalActivityReport == null) {
            rentalActivityReport = new ArrayList<RentalActivityReport>();
        }
        return this.rentalActivityReport;
    }

}
