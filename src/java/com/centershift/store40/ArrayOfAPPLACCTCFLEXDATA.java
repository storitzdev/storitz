
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAPPL_ACCT_CFLEX_DATA complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAPPL_ACCT_CFLEX_DATA">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="APPL_ACCT_CFLEX_DATA" type="{http://www.centershift.com/STORE40/}APPL_ACCT_CFLEX_DATA" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAPPL_ACCT_CFLEX_DATA", propOrder = {
    "applacctcflexdata"
})
public class ArrayOfAPPLACCTCFLEXDATA {

    @XmlElement(name = "APPL_ACCT_CFLEX_DATA", nillable = true)
    protected List<APPLACCTCFLEXDATA> applacctcflexdata;

    /**
     * Gets the value of the applacctcflexdata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applacctcflexdata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAPPLACCTCFLEXDATA().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link APPLACCTCFLEXDATA }
     * 
     * 
     */
    public List<APPLACCTCFLEXDATA> getAPPLACCTCFLEXDATA() {
        if (applacctcflexdata == null) {
            applacctcflexdata = new ArrayList<APPLACCTCFLEXDATA>();
        }
        return this.applacctcflexdata;
    }

}
