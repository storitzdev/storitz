
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for emailMsgTemplateIds.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="emailMsgTemplateIds">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GEN_AUTO_MAILER_TAG"/>
 *     &lt;enumeration value="GEN_AUTO_INVOICE"/>
 *     &lt;enumeration value="GEN_DELINQ_NOTICE"/>
 *     &lt;enumeration value="GEN_ALERT_END_TAG"/>
 *     &lt;enumeration value="SWS_CNCL_AUTO_PAY_APPEND"/>
 *     &lt;enumeration value="SWS_CNCL_RESERVATION_APPEND"/>
 *     &lt;enumeration value="SWS_PASSWORD_RETRIEVAL"/>
 *     &lt;enumeration value="SWS_RESERVATION_CONFIRMATION"/>
 *     &lt;enumeration value="SWS_PAYMENT_CONFIRMATION"/>
 *     &lt;enumeration value="SWS_CREATE_ACCOUNT"/>
 *     &lt;enumeration value="SWS_PAYMENT_FAILED"/>
 *     &lt;enumeration value="SWS_PASSWORD_CHANGE"/>
 *     &lt;enumeration value="SWS_CONTACT_SITE"/>
 *     &lt;enumeration value="SWS_SETUP_AUTO_PAY_APPEND"/>
 *     &lt;enumeration value="SWS_MOVE_OUT_NOTICE"/>
 *     &lt;enumeration value="GEN_SIMPLE_ALERT_END_TAG"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "emailMsgTemplateIds")
@XmlEnum
public enum EmailMsgTemplateIds {

    GEN_AUTO_MAILER_TAG,
    GEN_AUTO_INVOICE,
    GEN_DELINQ_NOTICE,
    GEN_ALERT_END_TAG,
    SWS_CNCL_AUTO_PAY_APPEND,
    SWS_CNCL_RESERVATION_APPEND,
    SWS_PASSWORD_RETRIEVAL,
    SWS_RESERVATION_CONFIRMATION,
    SWS_PAYMENT_CONFIRMATION,
    SWS_CREATE_ACCOUNT,
    SWS_PAYMENT_FAILED,
    SWS_PASSWORD_CHANGE,
    SWS_CONTACT_SITE,
    SWS_SETUP_AUTO_PAY_APPEND,
    SWS_MOVE_OUT_NOTICE,
    GEN_SIMPLE_ALERT_END_TAG;

    public String value() {
        return name();
    }

    public static EmailMsgTemplateIds fromValue(String v) {
        return valueOf(v);
    }

}
