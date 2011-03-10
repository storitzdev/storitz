
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for swsLtrParams complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="swsLtrParams">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="siteId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="acctId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="rentalId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="unitNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ltrTypeId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="siteLtrRule" type="{http://www.centershift.com/STORE40/}siteRuleLtrTypeGrpVals"/>
 *         &lt;element name="isMailLocal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isCOM" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="certifiedType" type="{http://www.centershift.com/STORE40/}certifiedVals"/>
 *         &lt;element name="contactType" type="{http://www.centershift.com/STORE40/}contactTypeVals"/>
 *         &lt;element name="contactOrAddrId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "swsLtrParams", propOrder = {
    "siteId",
    "acctId",
    "rentalId",
    "unitNum",
    "ltrTypeId",
    "siteLtrRule",
    "isMailLocal",
    "isCOM",
    "certifiedType",
    "contactType",
    "contactOrAddrId"
})
public class SwsLtrParams {

    protected long siteId;
    protected long acctId;
    protected long rentalId;
    protected String unitNum;
    protected long ltrTypeId;
    @XmlElement(required = true)
    protected SiteRuleLtrTypeGrpVals siteLtrRule;
    protected boolean isMailLocal;
    protected boolean isCOM;
    @XmlElement(required = true)
    protected CertifiedVals certifiedType;
    @XmlElement(required = true)
    protected ContactTypeVals contactType;
    protected long contactOrAddrId;

    /**
     * Gets the value of the siteId property.
     * 
     */
    public long getSiteId() {
        return siteId;
    }

    /**
     * Sets the value of the siteId property.
     * 
     */
    public void setSiteId(long value) {
        this.siteId = value;
    }

    /**
     * Gets the value of the acctId property.
     * 
     */
    public long getAcctId() {
        return acctId;
    }

    /**
     * Sets the value of the acctId property.
     * 
     */
    public void setAcctId(long value) {
        this.acctId = value;
    }

    /**
     * Gets the value of the rentalId property.
     * 
     */
    public long getRentalId() {
        return rentalId;
    }

    /**
     * Sets the value of the rentalId property.
     * 
     */
    public void setRentalId(long value) {
        this.rentalId = value;
    }

    /**
     * Gets the value of the unitNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitNum() {
        return unitNum;
    }

    /**
     * Sets the value of the unitNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitNum(String value) {
        this.unitNum = value;
    }

    /**
     * Gets the value of the ltrTypeId property.
     * 
     */
    public long getLtrTypeId() {
        return ltrTypeId;
    }

    /**
     * Sets the value of the ltrTypeId property.
     * 
     */
    public void setLtrTypeId(long value) {
        this.ltrTypeId = value;
    }

    /**
     * Gets the value of the siteLtrRule property.
     * 
     * @return
     *     possible object is
     *     {@link SiteRuleLtrTypeGrpVals }
     *     
     */
    public SiteRuleLtrTypeGrpVals getSiteLtrRule() {
        return siteLtrRule;
    }

    /**
     * Sets the value of the siteLtrRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link SiteRuleLtrTypeGrpVals }
     *     
     */
    public void setSiteLtrRule(SiteRuleLtrTypeGrpVals value) {
        this.siteLtrRule = value;
    }

    /**
     * Gets the value of the isMailLocal property.
     * 
     */
    public boolean isIsMailLocal() {
        return isMailLocal;
    }

    /**
     * Sets the value of the isMailLocal property.
     * 
     */
    public void setIsMailLocal(boolean value) {
        this.isMailLocal = value;
    }

    /**
     * Gets the value of the isCOM property.
     * 
     */
    public boolean isIsCOM() {
        return isCOM;
    }

    /**
     * Sets the value of the isCOM property.
     * 
     */
    public void setIsCOM(boolean value) {
        this.isCOM = value;
    }

    /**
     * Gets the value of the certifiedType property.
     * 
     * @return
     *     possible object is
     *     {@link CertifiedVals }
     *     
     */
    public CertifiedVals getCertifiedType() {
        return certifiedType;
    }

    /**
     * Sets the value of the certifiedType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CertifiedVals }
     *     
     */
    public void setCertifiedType(CertifiedVals value) {
        this.certifiedType = value;
    }

    /**
     * Gets the value of the contactType property.
     * 
     * @return
     *     possible object is
     *     {@link ContactTypeVals }
     *     
     */
    public ContactTypeVals getContactType() {
        return contactType;
    }

    /**
     * Sets the value of the contactType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactTypeVals }
     *     
     */
    public void setContactType(ContactTypeVals value) {
        this.contactType = value;
    }

    /**
     * Gets the value of the contactOrAddrId property.
     * 
     */
    public long getContactOrAddrId() {
        return contactOrAddrId;
    }

    /**
     * Sets the value of the contactOrAddrId property.
     * 
     */
    public void setContactOrAddrId(long value) {
        this.contactOrAddrId = value;
    }

}
