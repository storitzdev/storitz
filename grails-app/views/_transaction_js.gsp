var storageSize = [];
var searchSize = ${searchSize ? searchSize : 0};
var sizeDescription;
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

<g:each var="size" in="${sizeList}">storageSize[${size.id}] = "${size.description}";</g:each>
<g:if test="${params.size}">
  searchSize = ${params.size};
  sizeDescription = storageSize[ ${params.size} ];
</g:if>

function setupSize() {
  if (searchSize && searchSize > 1) {
  } else if ($('#unitsize').val()) {
    searchSize = $('#unitsize').val();
    searchDescription = storageSize[$('#unitsize').val()];
  }
}

function updateTransaction() {
  // update form
  $('#unitId').val(unitId);
  
  // update dropdowns
  $('#unitType').children().each(function(index) { $(this).remove(); });

  $.each(unitTypes, function (index, unitType) {
     var opt = $("<option>", {
       selected: unitType.type == chosenUnitType,
       value: unitType.type
     }).text(unitType.value);
     $('#unitType').append(opt);
  });
  $('#chosenType').val(chosenUnitType);
  $('#SC_searchSize').val(searchSize);
  $('#searchSize').val(searchSize);
  
  // update dates
  $('#transMoveInDate').html(startDate);
  $('#paidThruDate').html(paidThruDate);

  // update prices
  if (pushRate < monthlyRent) {
    $('#regPrice').html('$' + monthlyRent.toFixed(2));
    $('#pushPrice').html('$' + pushRate.toFixed(2));
  } else {
    $('#regPrice').html('');
    $('#pushPrice').html('$' + monthlyRent.toFixed(2));
  }

  // update promo
  $('#selectedOffer').html(chosenPromo);
  if (chosenPromo != '') {
    $('#clearOffer').html('remove');
  }
  $('#selectedInsurance').html(chosenInsurance);

  // update costs
  var durationText = '';
  if (durationMonths > 0) {
    durationText += (durationMonths + ' mo ');
  }
  if (durationDays > 0) {
    durationText += (durationDays + ' days');
  }
  $('#totalMoveInCost').html('$' + totalMoveInCost.toFixed(2));
  $('#monthlyDuration').html(durationText);
  $('#monthlyPerMonth').html('$' + pushRate.toFixed(2));
  $('#monthlyTotal').html('$' + (pushRate * duration).toFixed(2));
  // insurance cost
  $('#insuranceDuration').html(durationText);
  $('#insurancePerMonth').html('$' + premium.toFixed(2));
  $('#insuranceTotal').html('$' + (premium * duration).toFixed(2));
  if (premium > 0) {
    $('#insuranceBlock').show();
  } else {
    $('#insuranceBlock').hide();
  }
  $('#taxTotal').html('$' + tax.toFixed(2));
  if (tax > 0) {
    $('#taxBlock').show();
  } else {
    $('#taxBlock').hide();
  }
  $('#deposit').html('$' + deposit.toFixed(2));
  if (deposit > 0) {
    $('#depositBlock').show();
  } else {
    $('#depositBlock').hide();
  }
  // promo discount
  $('#discountTotal').html(discountTotal > 0 ? ('-$' + discountTotal.toFixed(2)) : '$0.00');
  if (discountTotal > 0) {
    $('#specialOfferBlock').show();
  } else {
    $('#specialOfferBlock').hide();
  }
  $('#adminTotal').html('$' + additionalFees.toFixed(2));
  if (totalMoveInCost == 0) {
    $('#rentme').hide();
  } else {
    $('#rentme').show();
  }
}

function transactionFormSetup() {

  $("input[name='specialOffer']").change(function(event) {
    var offerId =  $("input:[name='specialOffer']:checked").val();
    $('#promoId').val(offerId);
    chosenPromoId = offerId;
    showTotals('promo');
  });
  
  $("input[name='insuranceId']").change(function(event) {
    insuranceId =  $("input[name='insuranceId']:checked").val();
    $('#insuranceId').val(insuranceId);
    showTotals('insurance');
  });

  $('#moreOffers').click(function(event) {
      $('#moreOffers').toggle('fade');
      $('#nonFeaturedOffers').show("blind");
      $('#fewerOffers').toggle('fade');
  });

  $('#fewerOffers').click(function(event) {
      $('#fewerOffers').toggle('fade');
      $('#nonFeaturedOffers').hide("blind");
      $('#moreOffers').toggle('fade');
  });

  $('#moreInsurance').click(function() {
      $('#moreInsurance').toggle('fade');
      $('#fewerInsurance').toggle('fade');
      $('#insurances').show("blind");
  });

  $('#fewerInsurance').click(function(event) {
      $('#insurances').hide("blind");
      $('#fewerInsurance').toggle('fade');
      $('#moreInsurance').toggle('fade');
  });

  $('#clearOffer').click(function(event) {
    chosenPromo = '';
    chosenPromoId = -999;
    $('#clearOffer').html('');
    $('#selectedOffer').html('');
    $("input[name='specialOffer']:checked").attr('checked', false);
    showTotals('promo');
  });

  $('#totalMoveInCost').click(function(event) {
      $('#costDetails').toggle('fade');
  });

  $('#unitsize').change(function(event) {
    searchSize = $('#unitsize').val();
    $('#SC_searchSize').val(searchSize);
    $('#searchSize').val(searchSize);
    showTotals('size');
  })

  $('#unitType').change(function(event) {
    chosenUnitType = $('#unitType').val();
    $('#chosenType').val(chosenUnitType);
    showTotals('unitType');
  })
}

function setupCalendar() {
  $('#moveInDate').val(startDate);

  var datePicker = $('#date').datepicker(
            { dateFormat: 'mm/dd/y',
              minDate: 0,
              maxDate: "+2M",
              onSelect: function(dateText, inst) {
                startDate = dateText;
                $('#SC_date').val(startDate);
                $('#moveInDate').val(startDate);
                $('#transMoveInDate').html(startDate);
                showTotals('date');
              }
            }).addTouch();

  $('#calendarPic').click(function(event) {
    $('#date').datepicker('show');
  });

}

function showTotals(action) {
  $.ajax({
    url: "${createLink(controller:'storageSite', action:'detailTotals')}",
    method:'get',
    dataType: 'json',
    data: {
      searchSize: searchSize,
      id: siteId,
      chosenPromoId: chosenPromoId,
      insuranceId: insuranceId,
      unitType: chosenUnitType,
      moveInDate:startDate, action:action
    },
    success:function(ret) {
      duration = ret.totals.duration;
      durationDays = ret.totals.durationDays;
      durationMonths = ret.totals.durationMonths;
      unitTypes = ret.totals.unitTypes;
      chosenPromo = ret.totals.chosenPromo;
      chosenInsurance = ret.totals.chosenInsurance;
      chosenUnitType = ret.totals.chosenUnitType;
      chosenUnitTypeDisplay = ret.totals.chosenUnitTypeDisplay;
      premium = ret.totals.premium;
      discountTotal = ret.totals.discountTotal;
      monthlyRent = ret.totals.monthlyRate;
      pushRate = ret.totals.pushRate;
      additionalFees = ret.totals.additionalFees;
      tax = ret.totals.tax;
      deposit = ret.totals.deposit;
      totalMoveInCost = ret.totals.totalMoveInCost;
      unitId = ret.totals.unitId;
      paidThruDate = ret.totals.paidThruDate;
      updateTransaction();
    }
  });
}
