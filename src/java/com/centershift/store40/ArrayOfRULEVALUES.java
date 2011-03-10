
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfRULE_VALUES complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRULE_VALUES">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RULE_VALUES" type="{http://www.centershift.com/STORE40/}RULE_VALUES" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRULE_VALUES", propOrder = {
    "rulevalues"
})
public class ArrayOfRULEVALUES {

    @XmlElement(name = "RULE_VALUES", nillable = true)
    protected List<RULEVALUES> rulevalues;

    /**
     * Gets the value of the rulevalues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rulevalues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRULEVALUES().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RULEVALUES }
     * 
     * 
     */
    public List<RULEVALUES> getRULEVALUES() {
        if (rulevalues == null) {
            rulevalues = new ArrayList<RULEVALUES>();
        }
        return this.rulevalues;
    }

}
