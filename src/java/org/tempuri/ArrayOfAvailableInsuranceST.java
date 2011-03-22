package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfAvailableInsurance_ST complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfAvailableInsurance_ST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AvailableInsurance_ST" type="{http://tempuri.org/}AvailableInsurance_ST" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAvailableInsurance_ST", propOrder = {
        "availableInsuranceST"
})
public class ArrayOfAvailableInsuranceST {

    @XmlElement(name = "AvailableInsurance_ST")
    protected List<AvailableInsuranceST> availableInsuranceST;

    /**
     * Gets the value of the availableInsuranceST property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the availableInsuranceST property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvailableInsuranceST().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link AvailableInsuranceST }
     */
    public List<AvailableInsuranceST> getAvailableInsuranceST() {
        if (availableInsuranceST == null) {
            availableInsuranceST = new ArrayList<AvailableInsuranceST>();
        }
        return this.availableInsuranceST;
    }

}
