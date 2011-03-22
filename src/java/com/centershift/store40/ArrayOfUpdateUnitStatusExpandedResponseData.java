package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfUpdateUnitStatusExpanded_ResponseData complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfUpdateUnitStatusExpanded_ResponseData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UpdateUnitStatusExpanded_ResponseData" type="{http://www.centershift.com/STORE40/}UpdateUnitStatusExpanded_ResponseData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfUpdateUnitStatusExpanded_ResponseData", propOrder = {
        "updateUnitStatusExpandedResponseData"
})
public class ArrayOfUpdateUnitStatusExpandedResponseData {

    @XmlElement(name = "UpdateUnitStatusExpanded_ResponseData")
    protected List<UpdateUnitStatusExpandedResponseData> updateUnitStatusExpandedResponseData;

    /**
     * Gets the value of the updateUnitStatusExpandedResponseData property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the updateUnitStatusExpandedResponseData property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUpdateUnitStatusExpandedResponseData().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link UpdateUnitStatusExpandedResponseData }
     */
    public List<UpdateUnitStatusExpandedResponseData> getUpdateUnitStatusExpandedResponseData() {
        if (updateUnitStatusExpandedResponseData == null) {
            updateUnitStatusExpandedResponseData = new ArrayList<UpdateUnitStatusExpandedResponseData>();
        }
        return this.updateUnitStatusExpandedResponseData;
    }

}
