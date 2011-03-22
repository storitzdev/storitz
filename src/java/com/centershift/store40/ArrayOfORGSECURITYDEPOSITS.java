package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfORG_SECURITY_DEPOSITS complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfORG_SECURITY_DEPOSITS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ORG_SECURITY_DEPOSITS" type="{http://www.centershift.com/STORE40/}ORG_SECURITY_DEPOSITS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfORG_SECURITY_DEPOSITS", propOrder = {
        "orgsecuritydeposits"
})
public class ArrayOfORGSECURITYDEPOSITS {

    @XmlElement(name = "ORG_SECURITY_DEPOSITS", nillable = true)
    protected List<ORGSECURITYDEPOSITS> orgsecuritydeposits;

    /**
     * Gets the value of the orgsecuritydeposits property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orgsecuritydeposits property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getORGSECURITYDEPOSITS().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link ORGSECURITYDEPOSITS }
     */
    public List<ORGSECURITYDEPOSITS> getORGSECURITYDEPOSITS() {
        if (orgsecuritydeposits == null) {
            orgsecuritydeposits = new ArrayList<ORGSECURITYDEPOSITS>();
        }
        return this.orgsecuritydeposits;
    }

}
