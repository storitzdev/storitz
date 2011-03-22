package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfAPPL_INS_EXPORT complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfAPPL_INS_EXPORT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="APPL_INS_EXPORT" type="{http://www.centershift.com/STORE40/}APPL_INS_EXPORT" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAPPL_INS_EXPORT", propOrder = {
        "applinsexport"
})
public class ArrayOfAPPLINSEXPORT {

    @XmlElement(name = "APPL_INS_EXPORT", nillable = true)
    protected List<APPLINSEXPORT> applinsexport;

    /**
     * Gets the value of the applinsexport property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applinsexport property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAPPLINSEXPORT().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link APPLINSEXPORT }
     */
    public List<APPLINSEXPORT> getAPPLINSEXPORT() {
        if (applinsexport == null) {
            applinsexport = new ArrayList<APPLINSEXPORT>();
        }
        return this.applinsexport;
    }

}
