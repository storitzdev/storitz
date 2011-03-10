
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfUpdateOverlockStatusResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfUpdateOverlockStatusResponseData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UpdateOverlockStatusResponseData" type="{http://www.centershift.com/STORE40/}UpdateOverlockStatusResponseData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfUpdateOverlockStatusResponseData", propOrder = {
    "updateOverlockStatusResponseData"
})
public class ArrayOfUpdateOverlockStatusResponseData {

    @XmlElement(name = "UpdateOverlockStatusResponseData")
    protected List<UpdateOverlockStatusResponseData> updateOverlockStatusResponseData;

    /**
     * Gets the value of the updateOverlockStatusResponseData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the updateOverlockStatusResponseData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUpdateOverlockStatusResponseData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UpdateOverlockStatusResponseData }
     * 
     * 
     */
    public List<UpdateOverlockStatusResponseData> getUpdateOverlockStatusResponseData() {
        if (updateOverlockStatusResponseData == null) {
            updateOverlockStatusResponseData = new ArrayList<UpdateOverlockStatusResponseData>();
        }
        return this.updateOverlockStatusResponseData;
    }

}
