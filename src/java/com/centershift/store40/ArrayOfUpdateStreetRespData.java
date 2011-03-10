
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfUpdateStreetRespData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfUpdateStreetRespData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UpdateStreetRespItem" type="{http://www.centershift.com/STORE40/}UpdateStreetRespData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfUpdateStreetRespData", propOrder = {
    "updateStreetRespItem"
})
public class ArrayOfUpdateStreetRespData {

    @XmlElement(name = "UpdateStreetRespItem")
    protected List<UpdateStreetRespData> updateStreetRespItem;

    /**
     * Gets the value of the updateStreetRespItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the updateStreetRespItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUpdateStreetRespItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UpdateStreetRespData }
     * 
     * 
     */
    public List<UpdateStreetRespData> getUpdateStreetRespItem() {
        if (updateStreetRespItem == null) {
            updateStreetRespItem = new ArrayList<UpdateStreetRespData>();
        }
        return this.updateStreetRespItem;
    }

}
