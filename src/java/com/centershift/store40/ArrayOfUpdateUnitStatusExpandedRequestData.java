
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfUpdateUnitStatusExpanded_RequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfUpdateUnitStatusExpanded_RequestData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UpdateUnitStatusExpanded_RequestData" type="{http://www.centershift.com/STORE40/}UpdateUnitStatusExpanded_RequestData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfUpdateUnitStatusExpanded_RequestData", propOrder = {
    "updateUnitStatusExpandedRequestData"
})
public class ArrayOfUpdateUnitStatusExpandedRequestData {

    @XmlElement(name = "UpdateUnitStatusExpanded_RequestData")
    protected List<UpdateUnitStatusExpandedRequestData> updateUnitStatusExpandedRequestData;

    /**
     * Gets the value of the updateUnitStatusExpandedRequestData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the updateUnitStatusExpandedRequestData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUpdateUnitStatusExpandedRequestData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UpdateUnitStatusExpandedRequestData }
     * 
     * 
     */
    public List<UpdateUnitStatusExpandedRequestData> getUpdateUnitStatusExpandedRequestData() {
        if (updateUnitStatusExpandedRequestData == null) {
            updateUnitStatusExpandedRequestData = new ArrayList<UpdateUnitStatusExpandedRequestData>();
        }
        return this.updateUnitStatusExpandedRequestData;
    }

}
