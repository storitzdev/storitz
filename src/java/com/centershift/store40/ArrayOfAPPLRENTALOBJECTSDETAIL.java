package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfAPPL_RENTAL_OBJECTS_DETAIL complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfAPPL_RENTAL_OBJECTS_DETAIL">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="APPL_RENTAL_OBJECTS_DETAIL" type="{http://www.centershift.com/STORE40/}APPL_RENTAL_OBJECTS_DETAIL" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAPPL_RENTAL_OBJECTS_DETAIL", propOrder = {
        "applrentalobjectsdetail"
})
public class ArrayOfAPPLRENTALOBJECTSDETAIL {

    @XmlElement(name = "APPL_RENTAL_OBJECTS_DETAIL", nillable = true)
    protected List<APPLRENTALOBJECTSDETAIL> applrentalobjectsdetail;

    /**
     * Gets the value of the applrentalobjectsdetail property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applrentalobjectsdetail property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAPPLRENTALOBJECTSDETAIL().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link APPLRENTALOBJECTSDETAIL }
     */
    public List<APPLRENTALOBJECTSDETAIL> getAPPLRENTALOBJECTSDETAIL() {
        if (applrentalobjectsdetail == null) {
            applrentalobjectsdetail = new ArrayList<APPLRENTALOBJECTSDETAIL>();
        }
        return this.applrentalobjectsdetail;
    }

}
