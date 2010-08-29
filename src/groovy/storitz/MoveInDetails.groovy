package storitz

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Aug 28, 2010
 * Time: 4:06:32 PM
 * To change this template use File | Settings | File Templates.
 */
class MoveInDetails {
  def items = []

  def subTotal() {
    def subtotal = 0 as BigDecimal
    for(item in items) {
      subtotal += item.amount
    }
    return subtotal
  }

  def taxTotal() {
    def taxtotal = 0 as BigDecimal
    for(item in items) {
      taxtotal += item.tax
    }
    return taxtotal
  }

  def total() {
    return subTotal() + taxTotal()
  }
}
