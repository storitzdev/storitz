function contactChange() {
  $('#billingAddress').click(function(event) {
    var contactType =  $('input[name="billingAddress"]:checked').val();
    if (contactType == 'new') {
      $('#newContact').show();
    } else {
      $('#newContact').hide();
    }
  });
}

function primaryCountryClick() {
  $('.country').change(function() {
    var country = $('#country').val();
    if (country == "US") {
      $('#secondaryProvinceField').hide();
      $('#secondaryStateField').show();
      $('#secondaryProvinceLabel').hide();
      $('#secondaryStateLabel').show();
      $("input.zipcode").mask('99999');
    } else {
      $('#secondaryProvinceField').show();
      $('#secondaryStateField').hide();
      $('#secondaryProvinceLabel').show();
      $('#secondaryStateLabel').hide();
      $("input.zipcode").unmask();
    }
  });
}

function isValidCardNumber (strNum) {
   var nCheck = 0;
   var nDigit = 0;
   var bEven = false;

   for (n = strNum.length - 1; n >= 0; n--) {
      var cDigit = strNum.charAt (n);
      if (isDigit (cDigit)) {
         var nDigit = parseInt(cDigit, 10);
         if (bEven) {
            if ((nDigit *= 2) > 9)
               nDigit -= 9;
         }
         nCheck += nDigit;
         bEven = ! bEven;
      } else if (cDigit != ' ' && cDigit != '.' && cDigit != '-') {
         return false;
      }
   }
   return (nCheck % 10) == 0;
}

function isDigit (c) {
   var strAllowed = "1234567890";
   return (strAllowed.indexOf (c) != -1);
}

function createMap() {}

function setupForm() {
  $("input.zipcode").mask('99999');
  $('#errorMessage').hide();

  $.validator.addMethod("state", function(value, element) {
    var contactType =  $('input[name="billingAddress"]:checked').val();
    if (contactType == 'new' && $('#country').val() == 'US') {
      return value != 'NONE';
    }
    return true;
  }, "Missing state");

  $.validator.addMethod("province", function(value, element) {
    var contactType =  $('input[name="billingAddress"]:checked').val();
    if (contactType == 'new' && $('#country').val() != 'US') {
      return value != '';
    }
    return true;
  }, "Missing state or province");

  $.validator.addMethod("ccnumber", function(value, element) {
    return isValidCardNumber(value)
  }, "Invalid credit card number");

  $.validator.addMethod("contactRequired", function(value, element) {
    var contactType =  $('input[name="billingAddress"]:checked').val();
    if (contactType == 'new') {
      return value && value.length > 0
    }
    return true;
  }, "This field is required");

  var validator = $('#paymentTransaction')
    .validate({
      submitHandler: function(form) {
          $('<div>').css({'text-align':'center', 'display':'block', 'line-height':'150px'}).append($('<img>', { 'src': srcSpinner, 'width':32, 'height':32, 'border':0})).dialog({
                    modal: true,
                    height: 180,
                    title: 'Processing. Please wait...',
                    autoOpen: true,
                    draggable: false,
                    resizable: false
                  });
          form.submit();
      },
      messages: {
        "firstName": "Missing first name",
        "lastName": "Missing last name",
        "address1": "Missing address",
        "city": "Missing city",
        "country": "Please select your country",
        "zipcode":"Missing postal code",
        "cc_number": {
          required: "Missing credit card number",
          creditcard: "Incorrect credit card number"
        },
        cc_cvv2: {
          required: "Missing credit card security code",
          digits: "Credit card security code must be 3 or 4 digits"
        }
      },
      errorContainer: $("#errorMessage"),
      errorLabelContainer: $("#errorList"),
      errorClass: "validation-failed",
      wrapper: "li",
      ignore: ".ignore",
      invalidHandler: function(form, validator) {
        $('#errorMessage').show();
      },
      showErrors: function(errorMap, errorList) {
        $("#errorInfo").html("Please correct the " + this.numberOfInvalids() + " issue" + (this.numberOfInvalids() > 1 ? 's' : '') + " below and continue:");
        this.defaultShowErrors();
      }
  });

}

function setupJQueryTabs() {
  $("#operatingHours").tabs();
}

function setupAnalytics() {
    window.setTimeout(doAnalytics, 1);
}

function doAnalytics() {

    // Called a few ms after the page has loaded.
    var ga = document.createElement('script');
    ga.type = 'text/javascript';
    ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(ga, s);
}

$(document).ready(function() {

  contactChange();
  setupForm();
  setupJQueryTabs();
  primaryCountryClick();
  ajaxFormUpdate();
  ajaxServerPoll();
  setupAnalytics();
});

var _gaq = _gaq || [];
_gaq.push(  ['pageTracker._setAccount', 'UA-16012579-1'],
            ['pageTracker._trackPageview'],
            ['funnelTracker._setAccount', 'UA-16012579-1'],
            ['funnelTracker._trackPageview', '/payment']);
