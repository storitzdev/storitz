package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfSDS_WALK_THRU_LIST complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfSDS_WALK_THRU_LIST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SDS_WALK_THRU_LIST" type="{http://www.centershift.com/STORE40/}SDS_WALK_THRU_LIST" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSDS_WALK_THRU_LIST", propOrder = {
        "sdswalkthrulist"
})
public class ArrayOfSDSWALKTHRULIST {

    @XmlElement(name = "SDS_WALK_THRU_LIST", nillable = true)
    protected List<SDSWALKTHRULIST> sdswalkthrulist;

    /**
     * Gets the value of the sdswalkthrulist property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sdswalkthrulist property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSDSWALKTHRULIST().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link SDSWALKTHRULIST }
     */
    public List<SDSWALKTHRULIST> getSDSWALKTHRULIST() {
        if (sdswalkthrulist == null) {
            sdswalkthrulist = new ArrayList<SDSWALKTHRULIST>();
        }
        return this.sdswalkthrulist;
    }

}
