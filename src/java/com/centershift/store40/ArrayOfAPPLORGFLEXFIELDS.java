package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfAPPL_ORG_FLEX_FIELDS complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfAPPL_ORG_FLEX_FIELDS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="APPL_ORG_FLEX_FIELDS" type="{http://www.centershift.com/STORE40/}APPL_ORG_FLEX_FIELDS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAPPL_ORG_FLEX_FIELDS", propOrder = {
        "applorgflexfields"
})
public class ArrayOfAPPLORGFLEXFIELDS {

    @XmlElement(name = "APPL_ORG_FLEX_FIELDS", nillable = true)
    protected List<APPLORGFLEXFIELDS> applorgflexfields;

    /**
     * Gets the value of the applorgflexfields property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applorgflexfields property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAPPLORGFLEXFIELDS().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link APPLORGFLEXFIELDS }
     */
    public List<APPLORGFLEXFIELDS> getAPPLORGFLEXFIELDS() {
        if (applorgflexfields == null) {
            applorgflexfields = new ArrayList<APPLORGFLEXFIELDS>();
        }
        return this.applorgflexfields;
    }

}
