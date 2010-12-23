function rentmeClick() {
    $('#rentme').click(function() {
        // check date and turn red if bad
        var today = new Date();
        today.setHours(0, 0, 0, 0);
        var cutoff = new Date(today.getTime());
        cutoff.setMonth(cutoff.getMonth() + 2);
        var chosenDate = $.datepicker.parseDate('mm/dd/y', startDate);
        if (chosenDate < today || chosenDate > cutoff) {
            $('#transMoveInDate').addClass('validation-failed');
            return;
        }
        var params = new Object();
        params.fs = true;
        $.bbq.pushState(params, 0);
        _gaq.push(['funnelTracker._trackEvent', 'detail', 'rentme']);
        $('#transMoveInDate').removeClass('validation-failed');
        // TODO - check if all things are cleared
        $('#sizeHelp').hide();
        $('#rentalForm').show();
        $('#detailInfo').hide();
        $('#moveInDate').val(startDate);
        $('#contactPrimary.firstName').focus();
    });
}

function details_return() {
    $('#rentalForm').show();
    $('#detailInfo').hide();
}

function leave_form() {
    $('#rentalForm').hide();
    $('#detailInfo').show();
}

function primaryCountryClick() {
    $('.country').change(function() {
        var country = $('#contactPrimary-country').val();
        if (country == "US") {
            $('#primaryProvinceField').hide();
            $('#primaryStateField').show();
            $('#primaryProvinceLabel').hide();
            $('#primaryStateLabel').show();
            $("input.zipcode").mask('99999');
        } else {
            $('#primaryProvinceField').show();
            $('#primaryStateField').hide();
            $('#primaryProvinceLabel').show();
            $('#primaryStateLabel').hide();
            $("input.zipcode").unmask();
        }
    });
}

function setupImageGallery() {

    $('#galleryView').galleryView({
        panel_width: 570,
        panel_height: 360,
        frame_width: 60,
        frame_height: 40,
        pause_on_hover: true,
        filmstrip_position: 'right',
        theme_path: urlThemePath
    });
}

function setupValidation() {

    $("input.phone").mask('999-999-9999');
    $("input.zipcode").mask('99999');
    $('#errorMessage').hide();

    $.validator.addMethod("state", function(value, element) {
        if ($('#contactPrimary-country').val() == 'US') {
            return value != 'NONE';
        }
        return true;
    }, "Missing state");

    $.validator.addMethod("province", function(value, element) {
        if ($('#contactPrimary-country').val() != 'US') {
            return value != '';
        }
        return true;
    }, "Missing state or province");

    var validator = $('#rentalTransaction')
            .validate({
        submitHandler: function(form) {
            $('#step1_bullet').hide();
            $('#step2_bullet').show();
            $('#step1').removeClass('step_header_hi').addClass('step_header');
            $('#step2').removeClass('step_header').addClass('step_header_hi');
            $('#errorMessage').hide();
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
        rules: {
            rentalUse: "required",
            "contactPrimary.emailRepeat": {
                equalTo: "#contactPrimary-email"
            }
        },
        messages: {
            "contactPrimary.firstName": "Missing first name",
            "contactPrimary.lastName": "Missing last name",
            "contactPrimary.address1": "Missing address",
            "contactPrimary.city": "Missing city",
            "contactPrimary.phone": "Missing phone",
            "contactPrimary.country": "Please select your country",
            "contactPrimary.email": {
                required: "Missing email",
                email: "Incorrect email"
            },
            "contactPrimary.emailRepeat":"Repeated email does not match",
            "contactPrimary.zipcode":"Missing postal code",
            rentalUse: "Missing rental use: personal or business",
            terms:"Please accept the terms of agreement"
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

function setupAnalytics() {
    window.setTimeout(doAnalytics, 1);
}

function setupHelp() {
    $('#sizeHelp').dialog({
        autoOpen: false,
        resizable: false,
        width: 440
    }).addTouch();
    $('.sizeGuide').click(function(event) {
        _gaq.push(['funnelTracker._trackEvent', 'detail', 'size guide']);
        $('#sizeHelp').dialog('open');
    });
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

function setupEmbed() {
    $("a.embed").click(function(event) {
      $("div#embed").toggle("fade");
      return false;
    });
}

function setupJQueryTabs() {
    $("#operatingHours").tabs();
    $('#detail_tabs').tabs();

    $('#detail_tabs').bind('tabsshow', function(event, ui) {
        _gaq.push(['funnelTracker._trackEvent', 'detail', 'tab', ui.panel.id]);
        if (ui.panel.id == "tab_directions") {
            refreshMap();
        }
    });
}

$(window).bind('hashchange', function(e) {
  var url = e.fragment;
  var params = $.deparam.fragment(url);
  if (params.fs) {
    $('#rentalForm').show();
    $('#detailInfo').hide();
  } else {
    $('#rentalForm').hide();
    $('#detailInfo').show();
  }

});

$(window).trigger( 'hashchange' );

var _gaq = _gaq || [];
_gaq.push(  ['pageTracker._setAccount', 'UA-16012579-1'],
            ['pageTracker._trackPageview'],
            ['funnelTracker._setAccount', 'UA-16012579-1'],
            ['funnelTracker._trackPageview', '/detail']);

