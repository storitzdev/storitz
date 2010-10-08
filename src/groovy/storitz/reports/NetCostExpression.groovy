package storitz.reports

import ar.com.fdvs.dj.domain.CustomExpression

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Sep 24, 2010
 * Time: 3:04:23 PM
 * To change this template use File | Settings | File Templates.
 */
class NetCostExpression implements CustomExpression {

  public Object evaluate(Map fields, Map variables, Map parameters) {
          BigDecimal cost = (BigDecimal) fields.get("cost");
          BigDecimal commission = (BigDecimal) fields.get("commission");
          BigDecimal ret = cost - commission
          ret
  }

  public String getClassName() {
          return BigDecimal.class.getName();
  }

}
