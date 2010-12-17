package storitz.reports

import ar.com.fdvs.dj.domain.CustomExpression
import com.storitz.Invoice

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Sep 24, 2010
 * Time: 3:04:23 PM
 * To change this template use File | Settings | File Templates.
 */
class InvoiceNumberExpression implements CustomExpression {

  public Object evaluate(Map fields, Map variables, Map parameters) {
          String invoice = (String) fields.get("invoice.invoiceId")
          if (!invoice) return "---"
          return invoice
  }

  public String getClassName() {
          return String.class.getName();
  }

}
