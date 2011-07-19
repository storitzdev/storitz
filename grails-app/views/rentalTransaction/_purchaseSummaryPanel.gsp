<%@ page import="storitz.constants.UnitType" %>
<h1>Purchase Summary</h1>
<div class="site_info">
  <div class="image_container">
  <g:if test="${rentalTransactionInstance.site.coverImage()}">
    <img src="${resource(file: rentalTransactionInstance.site.coverImage()?.mid())}" alt="Image of ${rentalTransactionInstance.site.title} located in ${rentalTransactionInstance.site.city}, ${rentalTransactionInstance.site.state.fullName}" />
  </g:if>
  <g:elseif test="${rentalTransactionInstance.site?.logo && rentalTransactionInstance.site.logo != null}">
    <img src="${resource(file: rentalTransactionInstance.site.logo.src())}" alt="${rentalTransactionInstance.site_title} Logo"/>
  </g:elseif>
  </div>
  <h2>${rentalTransactionInstance.site.title}</h2>
  <p>${rentalTransactionInstance.site.address}</p>
  <p>${rentalTransactionInstance.site.city}, ${rentalTransactionInstance.site.state.display} ${rentalTransactionInstance.site.zipcode}</p>
  <p class="tel">(877) 456-2929</p>
</div>
<div class="unit_info">
  <h1>${rentalTransactionInstance.displaySize}
  <g:if test="${rentalTransactionInstance.unitType}">${rentalTransactionInstance.unitType.display} Unit</g:if>
  <g:else>Unit</g:else>
  </h1>
</div>