package storitz.reports

import ar.com.fdvs.dj.domain.CustomExpression

/**
 * This class is used to generate accounts that look like XXXXX1234 in reports
 */
class AccountExpression implements CustomExpression {

  String fieldName = null

  public AccountExpression(String fieldName) {
    this.fieldName = fieldName
  }

  public Object evaluate(Map fields, Map variables, Map parameters) {
    String account =  fields.get(fieldName);
    def ret = ""
    if (account?.size() > 4) {
      for(i in 0..account.size() - 4) {
        ret += "X"
      }
      ret += account.substring(account.size() - 4)
    }
    return ret
  }

  public String getClassName() {
          return String.class.getName();
  }

}
