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
  $('#actualSize').html(actualSize);

  // update dates
  $('#transMoveInDate').html(startDate);
  $('#paidThruDate').html(paidThruDate);

  // update prices
  if (pushRate < monthlyRent) {
    $('#regPrice').html('$' + monthlyRent.toFixed(2));
    $('#pushPrice').html('$' + pushRate.toFixed(2));
    $('#pushPrice').addClass('red');
  } else {
    $('#regPrice').html('');
    $('#pushPrice').html('$' + monthlyRent.toFixed(2));
    $('#pushPrice').removeClass('red');
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
    if (pushRate < monthlyRent) {
      $('#monthlyPerMonth').html('$' + pushRate.toFixed(2));
      $('#monthlyTotal').html('$' + (pushRate * duration).toFixed(2));
    } else {
      $('#monthlyPerMonth').html('$' + monthlyRent.toFixed(2));
      $('#monthlyTotal').html('$' + (monthlyRent * duration).toFixed(2));
    }
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
    _gaq.push(['funnelTracker._trackEvent', 'detail', 'transaction box', 'chose promo', chosenPromoId]);
  });

  $("input[name='insuranceId']").change(function(event) {
    insuranceId =  $("input[name='insuranceId']:checked").val();
    $('#insuranceId').val(insuranceId);
    showTotals('insurance');
    _gaq.push(['funnelTracker._trackEvent', 'detail', 'transaction box', 'chose insurance', insuranceId]);
  });

  $('#moreOffers').click(function(event) {
      $('#moreOffers').toggle('fade');
      $('#nonFeaturedOffers').show("blind");
      $('#fewerOffers').toggle('fade');
      _gaq.push(['funnelTracker._trackEvent', 'detail', 'transaction box', 'show offers']);
  });

  $('#fewerOffers').click(function(event) {
      $('#fewerOffers').toggle('fade');
      $('#nonFeaturedOffers').hide("blind");
      $('#moreOffers').toggle('fade');
      _gaq.push(['funnelTracker._trackEvent', 'detail', 'transaction box', 'hide offers']);
  });

  $('#moreInsurance').click(function() {
      $('#moreInsurance').toggle('fade');
      $('#fewerInsurance').toggle('fade');
      $('#insurances').show("blind");
      _gaq.push(['funnelTracker._trackEvent', 'detail', 'transaction box', 'show insurance']);
  });

  $('#fewerInsurance').click(function(event) {
      $('#insurances').hide("blind");
      $('#fewerInsurance').toggle('fade');
      $('#moreInsurance').toggle('fade');
      _gaq.push(['funnelTracker._trackEvent', 'detail', 'transaction box', 'hide insurance']);
  });

  $('#clearOffer').click(function(event) {
    chosenPromo = '';
    chosenPromoId = -999;
    $('#clearOffer').html('');
    $('#selectedOffer').html('');
    $("input[name='specialOffer']:checked").attr('checked', false);
    showTotals('promo');
    _gaq.push(['funnelTracker._trackEvent', 'detail', 'transaction box', 'clear offer']);
  });

  $('#totalMoveInCost').click(function(event) {
      $('#costDetails').toggle('fade');
  });

  $('#unitsize').change(function(event) {
    searchSize = $('#unitsize').val();
    $('#SC_searchSize').val(searchSize);
    $('#searchSize').val(searchSize);
    showTotals('size');
      _gaq.push(['funnelTracker._trackEvent', 'detail', 'transaction box', 'unit size', searchSize]);
  });

  $('#unitType').change(function(event) {
    chosenUnitType = $('#unitType').val();
    $('#chosenType').val(chosenUnitType);
    showTotals('unitType');
    _gaq.push(['funnelTracker._trackEvent', 'detail', 'transaction box', 'unit type ' + chosenUnitType]);
  });
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
                _gaq.push(['funnelTracker._trackEvent', 'detail', 'transaction box', 'date change']);
              }
            }).addTouch();

  $('#calendarPic').click(function(event) {
    $('#date').datepicker('show');
  });

}

function showTotals(action) {
  $.ajax({
    url: urlDetailTotals,
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
      actualSize = ret.totals.actualSize;
      updateTransaction();
    }
  });
}
