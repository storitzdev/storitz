<%@ page import="com.storitz.Insurance; com.storitz.SpecialOffer" %>
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
<g:render template="/storageSite/moveInQuote" model="[site:transaction.site, unit:unit, promo:SpecialOffer.get(transaction.promoId), promos:promos, totals:totals, insurance:Insurance.get(transaction.insuranceId), moveInDate:transaction.moveInDate]" />