package storitz.reports

import ar.com.fdvs.dj.domain.CustomExpression

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Sep 24, 2010
 * Time: 3:04:23 PM
 * To change this template use File | Settings | File Templates.
 */
class ReservationIdExpression implements CustomExpression {

  public Object evaluate(Map fields, Map variables, Map parameters) {
          Boolean reserved = (Boolean) fields.get("reserved");
          String reservationId = (String) fields.get("reservationId");
          String idNumber = (String) fields.get("idNumber");
          String ret = (reserved ? 'R' + reservationId : idNumber)
          ret
  }

  public String getClassName() {
          return String.class.getName();
  }

}
