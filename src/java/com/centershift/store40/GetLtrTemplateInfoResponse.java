
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getLtrTemplateInfo_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getLtrTemplateInfo_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TemplateCol" type="{http://www.centershift.com/STORE40/}ArrayOfPOST_LTR_TEMPLATE_INFO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLtrTemplateInfo_Response", propOrder = {
    "templateCol"
})
public class GetLtrTemplateInfoResponse {

    @XmlElement(name = "TemplateCol")
    protected ArrayOfPOSTLTRTEMPLATEINFO templateCol;

    /**
     * Gets the value of the templateCol property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPOSTLTRTEMPLATEINFO }
     *     
     */
    public ArrayOfPOSTLTRTEMPLATEINFO getTemplateCol() {
        return templateCol;
    }

    /**
     * Sets the value of the templateCol property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPOSTLTRTEMPLATEINFO }
     *     
     */
    public void setTemplateCol(ArrayOfPOSTLTRTEMPLATEINFO value) {
        this.templateCol = value;
    }

}
