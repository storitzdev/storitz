package storitz.reports

import ar.com.fdvs.dj.domain.CustomExpression

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Sep 24, 2010
 * Time: 3:04:23 PM
 * To change this template use File | Settings | File Templates.
 */
class NameExpression implements CustomExpression {

  public Object evaluate(Map fields, Map variables, Map parameters) {
    String firstName = (String) fields.get("contactPrimary.firstName");
    String lastName = (String) fields.get("contactPrimary.lastName");
    String suffixName = (String) fields.get("contactPrimary.suffixName");
    String ret = "${firstName} ${lastName}${suffixName ? ' ' + suffixName : ''}"
    ret
  }

  public String getClassName() {
    return String.class.getName();
  }

}
