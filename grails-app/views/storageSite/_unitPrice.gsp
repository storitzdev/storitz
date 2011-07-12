<div class="price">
  <g:formatNumber number="${unit.bestUnitPrice}" type="currency" currencyCode="USD" />
  <g:if test="${unit.price && unit.price > unit.bestUnitPrice}"><span class="original_price"><g:formatNumber number="${unit.price}" type="currency" currencyCode="USD" /></span></g:if>
  <div class="per_month">per month</div>
</div>