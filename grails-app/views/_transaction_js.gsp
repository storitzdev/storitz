var storageSize = [];
var searchSize = ${searchSize ? searchSize : 0};
var unitId = ${unitId ? unitId : -1};
var additionalFees = ${site.adminFee ? site.adminFee : 0} + ${site.lockFee ? site.lockFee : 0};
var adminFee = ${site.adminFee ? site.adminFee : 0};

// vars set by callback
var duration = 1;
var durationMonths = 1;
var durationDays = 0;
var paidThruDate;
var monthlyRent = ${monthlyRate ? monthlyRate : 0};
var pushRate = ${pushRate ? pushRate : 0};
var chosenPromo = '';
var chosenPromoId = ${promoId ? promoId : -999};
var totalMoveInCost = additionalFees + monthlyRent;
var unitTypes = [];
var discountTotal = 0;
var chosenUnitType = '${chosenUnitType}';
var chosenUnitTypeDisplay = '${chosenUnitType?.display}'
var chosenInsurance = '';
var insuranceId = ${insuranceId ? insuranceId : -999};
var premium = 0;
var tax = 0;
var deposit = 0;
var actualSize = '';
var searchType = "${searchType}";
var urlDetailTotals = "${createLink(controller:'storageSite', action:'detailTotals')}";
var featuredOffers;
var specialOffers;

<g:each var="size" in="${sizeList}">storageSize[${size.id}] = "${size.description}";</g:each>
<g:if test="${params.size}">
  searchSize = ${params.size};
</g:if>

function setupRentVsReserve() {
    $('#rentVsReserveText').dialog({
        autoOpen: false,
        resizable: false,
        width: 250
    }).addTouch();
    $('#rentVsReserve').click(function(event) {
        _gaq.push(['funnelTracker._trackEvent', 'detail', 'rentvsreserve']);
        $('#rentVsReserveText').dialog('open');
    });
    $('#rentmeDisbled').click(function(event) {
        _gaq.push(['funnelTracker._trackEvent', 'detail', 'rentme']);
        $('#rentVsReserveText').dialog('open');
    });
}

