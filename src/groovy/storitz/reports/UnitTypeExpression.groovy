package storitz.reports

import ar.com.fdvs.dj.domain.CustomExpression
import storitz.constants.UnitType

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Sep 24, 2010
 * Time: 3:04:23 PM
 * To change this template use File | Settings | File Templates.
 */
class UnitTypeExpression implements CustomExpression {

  public Object evaluate(Map fields, Map variables, Map parameters) {
          String unitTypeName = (String) fields.get("unitType")
          if (!unitTypeName || unitTypeName == "") return ""
          UnitType unitType = UnitType.valueOf(unitTypeName)
          return unitType.display
  }

  public String getClassName() {
          return String.class.getName();
  }

}
