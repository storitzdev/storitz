package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfORG_RETAIL_BOM complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfORG_RETAIL_BOM">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ORG_RETAIL_BOM" type="{http://www.centershift.com/STORE40/}ORG_RETAIL_BOM" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfORG_RETAIL_BOM", propOrder = {
        "orgretailbom"
})
public class ArrayOfORGRETAILBOM {

    @XmlElement(name = "ORG_RETAIL_BOM", nillable = true)
    protected List<ORGRETAILBOM> orgretailbom;

    /**
     * Gets the value of the orgretailbom property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orgretailbom property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getORGRETAILBOM().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link ORGRETAILBOM }
     */
    public List<ORGRETAILBOM> getORGRETAILBOM() {
        if (orgretailbom == null) {
            orgretailbom = new ArrayList<ORGRETAILBOM>();
        }
        return this.orgretailbom;
    }

}