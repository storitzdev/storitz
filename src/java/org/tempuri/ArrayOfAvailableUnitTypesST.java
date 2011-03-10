
package org.tempuri;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAvailableUnitTypes_ST complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAvailableUnitTypes_ST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AvailableUnitTypes_ST" type="{http://tempuri.org/}AvailableUnitTypes_ST" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAvailableUnitTypes_ST", propOrder = {
    "availableUnitTypesST"
})
public class ArrayOfAvailableUnitTypesST {

    @XmlElement(name = "AvailableUnitTypes_ST")
    protected List<AvailableUnitTypesST> availableUnitTypesST;

    /**
     * Gets the value of the availableUnitTypesST property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the availableUnitTypesST property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvailableUnitTypesST().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AvailableUnitTypesST }
     * 
     * 
     */
    public List<AvailableUnitTypesST> getAvailableUnitTypesST() {
        if (availableUnitTypesST == null) {
            availableUnitTypesST = new ArrayList<AvailableUnitTypesST>();
        }
        return this.availableUnitTypesST;
    }

}
