package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getLtrTemplateInfo_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="getLtrTemplateInfo_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TemplateLevel" type="{http://www.centershift.com/STORE40/}templateLevelVals"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLtrTemplateInfo_Request", propOrder = {
        "orgID",
        "siteID",
        "templateLevel"
})
public class GetLtrTemplateInfoRequest {

    @XmlElement(name = "OrgID")
    protected long orgID;
    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "TemplateLevel", required = true)
    protected TemplateLevelVals templateLevel;

    /**
     * Gets the value of the orgID property.
     */
    public long getOrgID() {
        return orgID;
    }

    /**
     * Sets the value of the orgID property.
     */
    public void setOrgID(long value) {
        this.orgID = value;
    }

    /**
     * Gets the value of the siteID property.
     */
    public long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     */
    public void setSiteID(long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the templateLevel property.
     *
     * @return possible object is
     *         {@link TemplateLevelVals }
     */
    public TemplateLevelVals getTemplateLevel() {
        return templateLevel;
    }

    /**
     * Sets the value of the templateLevel property.
     *
     * @param value allowed object is
     *              {@link TemplateLevelVals }
     */
    public void setTemplateLevel(TemplateLevelVals value) {
        this.templateLevel = value;
    }

}
