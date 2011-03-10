
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfORG_RETAIL_ADJ_LOG complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfORG_RETAIL_ADJ_LOG">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ORG_RETAIL_ADJ_LOG" type="{http://www.centershift.com/STORE40/}ORG_RETAIL_ADJ_LOG" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfORG_RETAIL_ADJ_LOG", propOrder = {
    "orgretailadjlog"
})
public class ArrayOfORGRETAILADJLOG {

    @XmlElement(name = "ORG_RETAIL_ADJ_LOG", nillable = true)
    protected List<ORGRETAILADJLOG> orgretailadjlog;

    /**
     * Gets the value of the orgretailadjlog property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orgretailadjlog property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getORGRETAILADJLOG().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ORGRETAILADJLOG }
     * 
     * 
     */
    public List<ORGRETAILADJLOG> getORGRETAILADJLOG() {
        if (orgretailadjlog == null) {
            orgretailadjlog = new ArrayList<ORGRETAILADJLOG>();
        }
        return this.orgretailadjlog;
    }

}
