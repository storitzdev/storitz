package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfAvailableUnitTypesSpecial_ST complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfAvailableUnitTypesSpecial_ST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AvailableUnitTypesSpecial_ST" type="{http://tempuri.org/}AvailableUnitTypesSpecial_ST" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAvailableUnitTypesSpecial_ST", propOrder = {
        "availableUnitTypesSpecialST"
})
public class ArrayOfAvailableUnitTypesSpecialST {

    @XmlElement(name = "AvailableUnitTypesSpecial_ST")
    protected List<AvailableUnitTypesSpecialST> availableUnitTypesSpecialST;

    /**
     * Gets the value of the availableUnitTypesSpecialST property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the availableUnitTypesSpecialST property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvailableUnitTypesSpecialST().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link AvailableUnitTypesSpecialST }
     */
    public List<AvailableUnitTypesSpecialST> getAvailableUnitTypesSpecialST() {
        if (availableUnitTypesSpecialST == null) {
            availableUnitTypesSpecialST = new ArrayList<AvailableUnitTypesSpecialST>();
        }
        return this.availableUnitTypesSpecialST;
    }

}
