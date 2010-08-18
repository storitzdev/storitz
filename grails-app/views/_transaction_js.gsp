var storageSize = [];
var searchSize = ${searchSize};
var sizeDescription;
var unitId = ${unitId};
var additionalFees = ${site.adminFee ? site.adminFee : 0} + ${site.lockFee ? site.lockFee : 0};
var adminFee = ${site.adminFee ? site.adminFee : 0};

// vars set by callback
var durationMonths = 1;
var monthlyRent = ${monthlyRate};
var pushRate = ${pushRate};
var chosenPromo = '';
var chosenPromoId = -999;
var totalMoveInCost = additionalFees + monthlyRent;
var unitTypes = [];
<g:each var="unitType" status="i" in="${unitTypes}">
  unitTypes[${i}] = ${unitType};
</g:each>
var discountTotal = 0;
var chosenUnitType = '${chosenUnitType}';
var insuranceId = -999;
var premium = 0;

var ajaxFormUpdateTimer;
var ajaxFormDirty = false;
var ajaxFormNewValues;
var ajaxFormOldValues = new Hash().toJSON();
var activeTab;
var allTabs;


<g:each var="size" in="${sizeList}">storageSize[${size.id}] = "${size.description}";</g:each>
<g:if test="${params.searchSize}">
  searchSize = ${params.searchSize};
  sizeDescription = storageSize[ ${params.searchSize} ];
</g:if>

function setupSize() {
  if (searchSize && searchSize > 1) {
  } else if ($F('unitsize')) {
    searchSize = $F('unitsize');
    searchDescription = storageSize[$F('unitsize')];
  }
}

function updateTransaction() {
  // update form
  $('unitId').value = unitId;
  
  // update dropdowns
  $('unitType').childElements().each(function(elem) { elem.remove(); });
  unitTypes.each(function (unitType) {
     var opt = new Element("option", {
       selected: unitType.type == chosenUnitType,
       value: unitType.type
     });
     opt.update(unitType.value);
     $('unitType').insert(opt);
  });

  // update dates
  $('transMoveInDate').update(startDate);
  var paidThru = Date.parseDate(startDate, "%m/%d/%y");
  paidThru.setMonth( paidThru.getMonth() + durationMonths);
  $('paidThruDate').update(paidThru.print("%o/%d/%y"))

  // update prices
  if (pushRate < monthlyRent) {
    $('regPrice').update('$' + monthlyRent.toFixed(2));
    $('pushPrice').update('$' + pushRate.toFixed(2));
  } else {
    $('regPrice').update('');
    $('pushPrice').update('$' + monthlyRent.toFixed(2));
  }

  // update promo
  $('selectedOffer').update(chosenPromo);

  // update costs
  $('totalMoveInCost').update('$' + totalMoveInCost.toFixed(2));
  $('monthlyDuration').update(durationMonths);
  $('monthlyPerMonth').update('$' + pushRate.toFixed(2));
  $('monthlyTotal').update('$' + (pushRate * durationMonths).toFixed(2));
  // insurance cost
  $('insuranceDuration').update(durationMonths);
  $('insurancePerMonth').update('$' + premium.toFixed(2));
  $('insuranceTotal').update('$' + (premium * durationMonths).toFixed(2));
  if (premium > 0) {
    $('insuranceBlock').show();
  } else {
    $('insuranceBlock').hide();
  }
  // promo discount
  $('discountTotal').update(discountTotal > 0 ? ('-$' + discountTotal.toFixed(2)) : '$0.00');
  $('adminTotal').update('$' + additionalFees.toFixed(2));
}

function transactionFormSetup() {

  $('specialOffers').observe('click', function() {
    var offerId =  $('specialOffers').select('input:checked[type=radio]').pluck('value')[0];
    $('promoId').value = offerId;
    chosenPromoId = offerId;
    showTotals();
  });

  $('unitsize').observe('change', function() {
    searchSize = $F('unitsize');
    $('SC_searchSize').value = searchSize;
    showTotals();
  })

  $('unitType').observe('change', function() {
    chosenUnitType = $F('unitType');
    showTotals();
  })
}

function setupCalendar() {
  $('moveInDate').value = startDate;

  Calendar.setup({
      dateField     : 'date',
      triggerElement: 'calendarPic',
      dateFormat    : '%m/%d/%y',
      selectHandler :  function(cal, dateString) {
        this.hide();
        startDate = dateString;
        $('SC_date').value = startDate;
        $('moveInDate').value = startDate;
        $('transMoveInDate').update(startDate);
        var paidThru = Date.parseDate(startDate, "%m/%d/%y");
        paidThru.setMonth( paidThru.getMonth() + durationMonths);
        $('paidThruDate').update(paidThru.print("%o/%d/%y"))
      }
  });
}

function showTotals() {
  new Ajax.Request("${createLink(controller:'storageSite', action:'detailTotals')}",
  {
    method:'get',
    parameters: {searchSize: searchSize, id: siteId, chosenPromoId: chosenPromoId, insuranceId: insuranceId, unitType: chosenUnitType },
    onSuccess:function(transport) {
      var totals = transport.responseJSON.totals;
      durationMonths = totals.durationMonths;
      unitTypes = totals.unitTypes;
      chosenPromo = totals.chosenPromo;
      chosenUnitType = totals.chosenUnitType;
      premium = totals.premium;
      discountTotal = totals.discountTotal;
      monthlyRent = totals.monthlyRate;
      pushRate = totals.pushRate;
      additionalFees = totals.additionalFees;
      totalMoveInCost = totals.totalMoveInCost;
      unitId = totals.unitId;
      updateTransaction();
    }
  });
}
