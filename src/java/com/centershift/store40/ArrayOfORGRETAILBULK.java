
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfORG_RETAIL_BULK complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfORG_RETAIL_BULK">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ORG_RETAIL_BULK" type="{http://www.centershift.com/STORE40/}ORG_RETAIL_BULK" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfORG_RETAIL_BULK", propOrder = {
    "orgretailbulk"
})
public class ArrayOfORGRETAILBULK {

    @XmlElement(name = "ORG_RETAIL_BULK", nillable = true)
    protected List<ORGRETAILBULK> orgretailbulk;

    /**
     * Gets the value of the orgretailbulk property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orgretailbulk property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getORGRETAILBULK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ORGRETAILBULK }
     * 
     * 
     */
    public List<ORGRETAILBULK> getORGRETAILBULK() {
        if (orgretailbulk == null) {
            orgretailbulk = new ArrayList<ORGRETAILBULK>();
        }
        return this.orgretailbulk;
    }

}
