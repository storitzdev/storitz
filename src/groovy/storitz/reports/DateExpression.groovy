package storitz.reports

import ar.com.fdvs.dj.domain.CustomExpression

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Sep 24, 2010
 * Time: 3:04:23 PM
 * To change this template use File | Settings | File Templates.
 */
class DateExpression implements CustomExpression {

  public Object evaluate(Map fields, Map variables, Map parameters) {
          Date date = (Date) fields.get("bookingDate");
          return date.format("MM/dd/yy")
  }

  public String getClassName() {
          return String.class.getName();
  }

}
