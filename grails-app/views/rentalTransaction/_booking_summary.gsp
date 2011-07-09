<h1>Your Booking Summary</h1>
<div class="site_info">
  <div class="image_container">
  <% site = transaction.site; %>
  <g:if test="${site.coverImage()}">
    <img src="${resource(file: site.coverImage().mid())}" alt="Image of ${site.title} located in ${site.city}, ${site.state.fullName}">
  </g:if>
  <g:elseif test="${site?.logo && site.logo != null}">
    <img src="${resource(file: site.logo.src())}" alt="${site_title} Logo"/>
  </g:elseif>
  </div>
  <h2>${site.title}</h2>
  <p>${site.address}</p>
  <p>${site.city}, ${site.state.display} ${site.zipcode}</p>
  <p class="tel">(877) 456-2929</p>
</div>
<div class="basic_info">
  <dl>
    <dt>Unit Size</dt><dd>${unit.displaySize ? unit.displaySize.replaceAll(/(\d+) X (\d+)/, "\$1' x \$2'") : "??"}</dd>
    <dt>Location</dt><dd>${unit.unitType.display}</dd>
    <dt>Move-in Date</dt><dd><g:formatDate type="date" format="MEDIUM" date="${transaction.moveInDate}" /></d>
    <dt>Total Move-in Cost</dt><dd>$116.34</dd>
  </dl>
</div>
<table class="cost_breakdown">
  <tbody>
  <tr>
    <th class="item">Item</th>
    <th>Initial Period</th>
    <th>Monthly Rate</th>
    <th class="last">Amount</th>
  </tr>
  <tr>
    <td class="item">Rent</td>
    <td>2 mo</td>
    <td><g:formatNumber number="${unit.bestUnitPrice}" type="currency" currencyCode="USD" /></td>
    <td class="last"><g:formatNumber number="${unit.bestUnitPrice * 2}" type="currency" currencyCode="USD" /></td>
  </tr>
  <tr>
    <td class="item">50% off first two months</td>
    <td>2 mo</td>
    <td></td>
    <td class="last">-$45.00</td>
  </tr>
  <tr>
    <td class="item">Property protection <a href="#" class="property_protection_options">view options</a></td>
    <td>2 mo</td>
    <td>$8.00</td>
    <td class="last">16.00</td>
  </tr>
  <tr>
    <td class="item">Facility fee</td>
    <td>2 mo</td>
    <td>$8.00</td>
    <td class="last">16.00</td>
  </tr>
  <tr>
    <td class="item">Sales tax</td>
    <td>2 mo</td>
    <td>$8.00</td>
    <td class="last">16.00</td>
  </tr>
  <tr>
    <td class="summary last" colspan="4">$116.34</td>
  </tr>
  </tbody>
</table>
<div class="note">* Paid thru Aug,. 17, 2011</div>
