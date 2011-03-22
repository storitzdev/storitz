package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfAPPL_BEST_PCD complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfAPPL_BEST_PCD">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="APPL_BEST_PCD" type="{http://www.centershift.com/STORE40/}APPL_BEST_PCD" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAPPL_BEST_PCD", propOrder = {
        "applbestpcd"
})
public class ArrayOfAPPLBESTPCD {

    @XmlElement(name = "APPL_BEST_PCD", nillable = true)
    protected List<APPLBESTPCD> applbestpcd;

    /**
     * Gets the value of the applbestpcd property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applbestpcd property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAPPLBESTPCD().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link APPLBESTPCD }
     */
    public List<APPLBESTPCD> getAPPLBESTPCD() {
        if (applbestpcd == null) {
            applbestpcd = new ArrayList<APPLBESTPCD>();
        }
        return this.applbestpcd;
    }

}
