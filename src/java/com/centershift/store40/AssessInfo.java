package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for AssessInfo complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AssessInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssessId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AssessVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ApplyAmt" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssessInfo", propOrder = {
        "assessId",
        "assessVersion",
        "applyAmt"
})
public class AssessInfo {

    @XmlElement(name = "AssessId")
    protected long assessId;
    @XmlElement(name = "AssessVersion")
    protected int assessVersion;
    @XmlElement(name = "ApplyAmt", required = true)
    protected BigDecimal applyAmt;

    /**
     * Gets the value of the assessId property.
     */
    public long getAssessId() {
        return assessId;
    }

    /**
     * Sets the value of the assessId property.
     */
    public void setAssessId(long value) {
        this.assessId = value;
    }

    /**
     * Gets the value of the assessVersion property.
     */
    public int getAssessVersion() {
        return assessVersion;
    }

    /**
     * Sets the value of the assessVersion property.
     */
    public void setAssessVersion(int value) {
        this.assessVersion = value;
    }

    /**
     * Gets the value of the applyAmt property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getApplyAmt() {
        return applyAmt;
    }

    /**
     * Sets the value of the applyAmt property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setApplyAmt(BigDecimal value) {
        this.applyAmt = value;
    }

}
