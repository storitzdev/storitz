var storageSize = [];
var searchSize = ${searchSize ? searchSize : 0};
var sizeDescription;
var unitId = ${unitId ? unitId : -1};
var additionalFees = ${site.adminFee ? site.adminFee : 0} + ${site.lockFee ? site.lockFee : 0};
var adminFee = ${site.adminFee ? site.adminFee : 0};

// vars set by callback
var durationMonths = 1;
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
  $('paidThruDate').update(paidThruDate);

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
  if (chosenPromo != '') {
    $('clearOffer').update('remove');
  }
  $('selectedInsurance').update(chosenInsurance);

  // update costs
  $('totalMoveInCost').update('$' + totalMoveInCost.toFixed(2));
  $('monthlyDuration').update(durationMonths.toFixed(2));
  $('monthlyPerMonth').update('$' + pushRate.toFixed(2));
  $('monthlyTotal').update('$' + (pushRate * durationMonths).toFixed(2));
  // insurance cost
  $('insuranceDuration').update(durationMonths.toFixed(2));
  $('insurancePerMonth').update('$' + premium.toFixed(2));
  $('insuranceTotal').update('$' + (premium * durationMonths).toFixed(2));
  if (premium > 0) {
    $('insuranceBlock').show();
  } else {
    $('insuranceBlock').hide();
  }
  $('taxTotal').update('$' + tax.toFixed(2));
  if (tax > 0) {
    $('taxBlock').show();
  } else {
    $('taxBlock').hide();
  }
  $('deposit').update('$' + deposit.toFixed(2));
  if (deposit > 0) {
    $('depositBlock').show();
  } else {
    $('depositBlock').hide();
  }
  // promo discount
  $('discountTotal').update(discountTotal > 0 ? ('-$' + discountTotal.toFixed(2)) : '$0.00');
  if (discountTotal > 0) {
    $('specialOfferBlock').show();
  } else {
    $('specialOfferBlock').hide();
  }
  $('adminTotal').update('$' + additionalFees.toFixed(2));
  if (totalMoveInCost == 0) {
    $('rentme').hide();
  } else {
    $('rentme').show();
  }
}

function transactionFormSetup() {

  $('specialOffers').observe('click', function() {
    var offerId =  $('specialOffers').select('input:checked[type=radio]').pluck('value')[0];
    $('promoId').value = offerId;
    chosenPromoId = offerId;
    showTotals('promo');
  });
  
  $('insurances').observe('click', function() {
    insuranceId =  $('insurances').select('input:checked[type=radio]').pluck('value')[0];
    $('insuranceId').value = insuranceId;
    showTotals('insurance');
  });

  $('moreOffers').observe('click', function() {
      Effect.toggle('moreOffers', 'appear', {queue: 'end', duration: 0.1});
      Effect.BlindDown('nonFeaturedOffers');
      Effect.toggle('fewerOffers', 'appear', {queue:'end', duration: 0.1});
  });

  $('fewerOffers').observe('click', function() {
      Effect.toggle('fewerOffers', 'appear', {queue: 'end', duration: 0.1});
      Effect.BlindUp('nonFeaturedOffers');
      Effect.toggle('moreOffers', 'appear', {queue:'end', duration: 0.1});
  });

  $('moreInsurance').observe('click', function() {
      Effect.toggle('moreInsurance', 'appear', {queue: 'end', duration: 0.1});
      Effect.toggle('fewerInsurance', 'appear', {queue:'end', duration: 0.1});
      Effect.BlindDown('insurances');
  });

  $('fewerInsurance').observe('click', function() {
      Effect.BlindUp('insurances');
      Effect.toggle('fewerInsurance', 'appear', {queue: 'end', duration: 0.1});
      Effect.toggle('moreInsurance', 'appear', {queue:'end', duration: 0.1});
  });
  $('clearOffer').observe('click', function() {
    chosenPromo = '';
    chosenPromoId = -999;
    $('clearOffer').update('');
    $('selectedOffer').update('');
    $('specialOffers').select('input:checked[type=radio]')[0].checked = false;
    showTotals('promo');
  });

  $('totalMoveInCost').observe('click', function() {
      Effect.toggle('costDetails', 'appear', { duration: 0.25 });
  });

  $('unitsize').observe('change', function() {
    searchSize = $F('unitsize');
    $('SC_searchSize').value = searchSize;
    $('searchSize').value = searchSize;
    showTotals('size');
  })

  $('unitType').observe('change', function() {
    chosenUnitType = $F('unitType');
    $('chosenType').value = chosenUnitType;
    showTotals('unitType');
  })
}

function setupCalendar() {
  $('moveInDate').value = startDate;

  Calendar.setup({
      dateField     : 'date',
      triggerElement: 'calendarPic',
      dateFormat    : '%m/%d/%y',
      shouldClose   :  false,
      selectHandler :  function(cal, dateString) {
        startDate = dateString;
        var today = new Date();
        today.setHours(0, 0, 0, 0);
        var cutoff = new Date(today.getTime());
        cutoff.setMonth(cutoff.getMonth() + 2);
        if (cal.date.getTime() < today.getTime() || cal.date.getTime() > cutoff.getTime()) {
          $('transMoveInDate').addClassName('validation-failed');
          return;
        } else {
          $('transMoveInDate').removeClassName('validation-failed');
        }
        $('SC_date').value = startDate;
        $('moveInDate').value = startDate;
        $('transMoveInDate').update(startDate);
        showTotals('date');
      }
  });
}

function showTotals(action) {
  new Ajax.Request("${createLink(controller:'storageSite', action:'detailTotals')}",
  {
    method:'get',
    parameters: {searchSize: searchSize, id: siteId, chosenPromoId: chosenPromoId, insuranceId: insuranceId, unitType: chosenUnitType, moveInDate:startDate, action:action },
    onSuccess:function(transport) {
      var totals = transport.responseJSON.totals;
      durationMonths = totals.durationMonths;
      unitTypes = totals.unitTypes;
      chosenPromo = totals.chosenPromo;
      chosenInsurance = totals.chosenInsurance;
      chosenUnitType = totals.chosenUnitType;
      chosenUnitTypeDisplay = totals.chosenUnitTypeDisplay;
      premium = totals.premium;
      discountTotal = totals.discountTotal;
      monthlyRent = totals.monthlyRate;
      pushRate = totals.pushRate;
      additionalFees = totals.additionalFees;
      tax = totals.tax;
      deposit = totals.deposit;
      totalMoveInCost = totals.totalMoveInCost;
      unitId = totals.unitId;
      paidThruDate = totals.paidThruDate;
      updateTransaction();
    }
  });
}
