<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:render template="/header" />

    <script type="text/javascript">
//<![CDATA[

    var directionsService;
    var directionsDisplay;
    var storageSize = [];
    var premiums = [];
    var searchSize = ${searchSize};
    var sizeDescription;
    var unitId;
    var siteId = ${params.id};
    var additionalFees = ${site.adminFee ? site.adminFee : 0} + ${site.lockFee ? site.lockFee : 0};
    var adminFee = ${site.adminFee ? site.adminFee : 0};
    var destLatLng;
    var startDate = "${params.date && params.date != 'null' ? params.date : new Date().format('MM/dd/yy')}";
    var galleryImageNum = 0;

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

    var priceDriveup = ${rentalTransaction?.priceDriveup ? "true" : "false"};
    var priceInterior = ${rentalTransaction?.priceInterior ? "true" : "false"};
    var priceUpper = ${rentalTransaction?.priceUpper ? "true" : "false"};

    var ajaxFormUpdateTimer;
    var ajaxFormDirty = false;
    var ajaxFormNewValues;
    var ajaxFormOldValues = new Hash().toJSON();


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
      $('moveInDate').update(startDate);
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

    function insuranceClick() {
      $('insuranceChoices').observe('click', function() {
        var insId =  $('insuranceChoices').select('input:checked[type=radio]').pluck('value');
        insuranceId = insId;
        showTotals();
      });
    }

    function transactionFormSetup() {
      $('specialOffers').observe('click', function() {
        var offerId =  $('specialOffers').select('input:checked[type=radio]').pluck('value');
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
          updateTransaction();
        }
      });
    }

    function createMap() {
      destLatLng = new google.maps.LatLng(${site.lat}, ${site.lng});
      directionsService = new google.maps.DirectionsService();
      directionsDisplay = new google.maps.DirectionsRenderer();
      directionsDisplay.setPanel($('dirPanel'));
    }

    function setupHelp() {
      $('sizeInfo').observe('click', function(event) {
        $('sizeHelp').setStyle({ top: Event.pointerY(event) - 10 + "px", left: Event.pointerX(event) + 10 + "px" });
        Effect.toggle('sizeHelp', 'appear', {duration: 0.8});
      });
      $('helpClose').observe('click', function() {
        Effect.toggle('sizeHelp', 'appear', {duration: 0.8});
      });
    }

    function getDirections() {
      $('get_directions').observe('click', function() {
        var request = {
                origin:$F('srcAddr'),
                destination:destLatLng,
                travelMode: google.maps.DirectionsTravelMode.DRIVING
            };
            directionsService.route(request, function(response, status) {
              if (status == google.maps.DirectionsStatus.OK) {
                directionsDisplay.setDirections(response);
              }
            });

      });
    }

    function directionTab() {
      $('direction_button').observe('click', function() {
        $('photo_button').removeClassName('tab_button_on');
        $('photo_button').removeClassName('button_text_hi');
        $('photo_button').addClassName('tab_button_off');
        $('photo_button').addClassName('button_text');
        $('direction_button').removeClassName('tab_button_off');
        $('direction_button').removeClassName('button_text');
        $('direction_button').addClassName('tab_button_on');
        $('direction_button').addClassName('button_text_hi');
        $('photos').hide();
        $('directions').show();
      })
    }

    function photoTab() {
      $('photo_button').observe('click', function() {
        $('direction_button').removeClassName('tab_button_on');
        $('direction_button').removeClassName('button_text_hi');
        $('direction_button').addClassName('tab_button_off');
        $('direction_button').addClassName('button_text');
        $('photo_button').removeClassName('tab_button_off');
        $('photo_button').removeClassName('button_text');
        $('photo_button').addClassName('tab_button_on');
        $('photo_button').addClassName('button_text_hi');
        $('directions').hide();
        $('photos').show();
      })
    }

    function rentmeClick() {
      $('rentme').observe('click', function() {
        $('sizeHelp').hide();
        $('rentalForm').show();
        $('detailInfo').hide();
      });
    }

    function details_return() {
      $('left_info').show();
      $('left_checkout_info').hide();
      $('rentalForm').hide();
      $('detailInfo').show();
    }

    function idTypeClick() {
      $('idType').observe('change', function() {
         var idType = $F('idType');
         switch($F('idType')) {
            case "PASSPORT":
              $('idStateLabel').hide();
              $('idStateField').hide();
              $('idCountryLabel').show();
              $('idCountryField').show();
              break;
            case "DRIVERSLICENSE":
              $('idCountryLabel').hide();
              $('idCountryField').hide();
              $('idStateLabel').show();
              $('idStateField').show();
              break;
         }
      });
    }

    function primaryCountryClick() {
      $('contactPrimary.country').observe('change', function() {
        var country = $F('contactPrimary.country');
        if (country == "US") {
          $('primaryProvinceField').hide();
          $('primaryStateField').show();
          $('primaryProvinceLabel').hide();
          $('primaryStateLabel').show();
        } else {
          $('primaryProvinceField').show();
          $('primaryStateField').hide();
          $('primaryProvinceLabel').show();
          $('primaryStateLabel').hide();
        }
      });
    }

    function secondaryCountryClick() {
      $('contactSecondary.country').observe('change', function() {
        var country = $F('contactSecondary.country');
        if (country == "US") {
          $('secondaryProvinceField').hide();
          $('secondaryStateField').show();
          $('secondaryProvinceLabel').hide();
          $('secondaryStateLabel').show();
        } else {
          $('secondaryProvinceField').show();
          $('secondaryStateField').hide();
          $('secondaryProvinceLabel').show();
          $('secondaryStateLabel').hide();
        }
      });
    }

    function validateStep1() {
      var valid = true;
      valid &= Validation.validate('contactPrimary.firstName');
      valid &= Validation.validate('contactPrimary.lastName');
      valid &= Validation.validate('contactPrimary.streetNumber');
      valid &= Validation.validate('contactPrimary.street');
      valid &= Validation.validate('contactPrimary.city');
      valid &= Validation.validate('contactPrimary.state');
      valid &= Validation.validate('contactPrimary.zipcode');
      valid &= Validation.validate('contactPrimary.phone');
      valid &= Validation.validate('contactPrimary.email');
      valid &= Validation.validate('idState');
      valid &= Validation.validate('idNumber');
      return valid;
    }

    function validateStep2() {
      // TODO validate dupe information
      var valid = true;
      valid &= Validation.validate('contactSecondary.firstName');
      valid &= Validation.validate('contactSecondary.lastName');
      valid &= Validation.validate('contactSecondary.streetNumber');
      valid &= Validation.validate('contactSecondary.street');
      valid &= Validation.validate('contactSecondary.city');
      valid &= Validation.validate('contactSecondary.state');
      valid &= Validation.validate('contactSecondary.zipcode');
      valid &= Validation.validate('contactSecondary.phone');
      valid &= Validation.validate('contactSecondary.email');
      return valid;
    }

    function validateStep3() {
      var valid = true;
      valid &= Validation.validate('rentalUse');
      valid &= Validation.validate('insuranceChoices');
      valid &= Validation.validate('insuranceTermsHolder');
      valid &= Validation.validate('hazardousMaterialsHolder');
      valid &= Validation.validate('termsHolder');
      return valid;
    }

    function nextStep1() {
      if (validateStep1()) {
        $('step1_bullet').hide();
        $('step2_bullet').show();
        $('step1').removeClassName('step_header_hi');
        $('step1').addClassName('step_header');
        $('step2').removeClassName('step_header');
        $('step2').addClassName('step_header_hi');
        $('primary_contact').hide();
        $('secondary_contact').show();
      }
    }

    function prevStep2() {
      $('step2_bullet').hide();
      $('step1_bullet').show();
      $('step1').addClassName('step_header_hi');
      $('step1').removeClassName('step_header');
      $('step2').addClassName('step_header');
      $('step2').removeClassName('step_header_hi');
      $('secondary_contact').hide();
      $('primary_contact').show();
    }

    function nextStep2() {
      if (validateStep2()) {
        $('step2_bullet').hide();
        $('step3_bullet').show();
        $('step2').removeClassName('step_header_hi');
        $('step2').addClassName('step_header');
        $('step3').removeClassName('step_header');
        $('step3').addClassName('step_header_hi');
        $('secondary_contact').hide();
        $('rental_info').show();
      }
    }

    function prevStep3() {
      $('step3_bullet').hide();
      $('step2_bullet').show();
      $('step3').removeClassName('step_header_hi');
      $('step3').addClassName('step_header');
      $('step2').removeClassName('step_header');
      $('step2').addClassName('step_header_hi');
      $('rental_info').hide();
      $('secondary_contact').show();
    }

    function nextStep3() {
      if (validateStep3()) {
        $('step3_bullet').hide();
        $('step4_bullet').show();
        $('step3').removeClassName('step_header_hi');
        $('step3').addClassName('step_header');
        $('step4').removeClassName('step_header');
        $('step4').addClassName('step_header_hi');
        $('rental_info').hide();
        $('rentalTransaction').submit();
      }
    }

    function setupCalendar() {
      Calendar.setup({
          dateField     : 'date',
          triggerElement: 'calendarPic',
          dateFormat    : '%m/%d/%y',
          selectHandler :  function(cal, dateString) {
            this.hide();
            startDate = dateString;
            $('SC_date').value = startDate;
            $('moveInDate').update(startDate);
            var paidThru = Date.parseDate(startDate, "%m/%d/%y");
            paidThru.setMonth( paidThru.getMonth() + durationMonths);
            $('paidThruDate').update(paidThru.print("%o/%d/%y"))
          }
      });
    }


  function showImage(img, newElem) {
    $$('img.gallerySelected').each(function(elem) {
      elem.removeClassName('gallerySelected');
      elem.addClassName('galleryNormal');
    });
    $(newElem).removeClassName('galleryNormal');
    $(newElem).addClassName('gallerySelected');
    var imgElem = new Element("img", {src:img, alt:"", visibility:"hidden", style:"display:block;margin:auto;"});
    $('imgFrame').update(imgElem);
    new Effect.Opacity(
     'imgFrame', {
        from: 0.0,
        to: 1.0,
        duration: 0.5,
        queue: 'end'
     }
    );
  }

  function rightArrowClick() {
    $('rightArrow').observe('click', function() {
      if (galleryImageNum < (${site.siteImages().size()} - 4)) {
        galleryImageNum++;
        new Effect.Move('items', { x: -62, y:0, mode:'relative'});
        if (galleryImageNum >= (${site.siteImages().size()} - 4)) {
          if($('rightArrow').hasClassName('rightArrowActive')) {
            $('rightArrow').removeClassName('rightArrowActive');
            $('rightArrow').addClassName('rightArrowNull');
          }
        }
        if ($('leftArrow').hasClassName('leftArrowNull')) {
          $('leftArrow').addClassName('leftArrowActive');
          $('leftArrow').removeClassName('leftArrowNull');
        }
      } else {
        if($('rightArrow').hasClassName('rightArrowActive')) {
          $('rightArrow').removeClassName('rightArrowActive');
          $('rightArrow').addClassName('rightArrowNull');
        }
      }
    });
  }

  function leftArrowClick() {
    $('leftArrow').observe('click', function() {
      if ((${site.siteImages().size()}) > 4 && galleryImageNum > 0) {
        galleryImageNum--;
        new Effect.Move('items', { x: 62, y:0, mode:'relative'});
        if (galleryImageNum < (${site.siteImages().size()} - 4)) {
          if($('rightArrow').hasClassName('rightArrowNull')) {
            $('rightArrow').removeClassName('rightArrowNull');
            $('rightArrow').addClassName('rightArrowActive');
          }
        }
        if (galleryImageNum == 0) {
          if($('leftArrow').hasClassName('leftArrowActive')) {
            $('leftArrow').removeClassName('leftArrowActive');
            $('leftArrow').addClassName('leftArrowNull');
          }
        }
      } else {
        if($('leftArrow').hasClassName('leftArrowActive')) {
          $('leftArrow').removeClassName('leftArrowActive');
          $('leftArrow').addClassName('leftArrowNull');
        }
      }
    });
  }

  function setupValidation() {
  }


  function ajaxFormUpdate() {
    ajaxFormUpdateTimer = setTimeout("doAjaxFormUpdate()", 5000)
  }

  function doAjaxFormUpdate() {
    ajaxFormNewValues = $('rentalTransaction');

    if (ajaxFormNewValues != undefined) {
      ajaxFormNewValues = ajaxFormNewValues.serialize(true);
      var jsonValues = Object.toJSON(ajaxFormNewValues);
      var valuesUnchanged = ajaxFormOldValues == jsonValues;
      ajaxFormOldValues = jsonValues;

      if (ajaxFormDirty) {
        if (valuesUnchanged) {
          new Ajax.Request("${createLink(controller:'rentalTransaction', action: 'ajaxUpdate', id:shortSessionId)}",
          {
            method:'post',
            parameters: ajaxFormNewValues,
            onComplete:function() {
              ajaxFormDirty = false;
              ajaxFormUpdate();
            }
          });
          return;
        }
      } else {
        if (!valuesUnchanged) {
          ajaxFormDirty = true;
        }
      }
    }
    ajaxFormUpdate();
  }

  function ajaxServerPoll() {
    ajaxServerPollTimer = setTimeout("doAjaxServerPoll()", 5000)
  }

  function doAjaxServerPoll() {
    new Ajax.Request("${createLink(controller:'rentalTransaction', action: 'ajaxPoll', id:shortSessionId)}",
    {
      method:'get',
      onSuccess:function(transport) {
        $('helpDeskStatus').update(transport.responseText);
      },
      onComplete:function() {
        ajaxServerPoll();
      }
    });
  }

  Event.observe(window, 'load', function() {
    transactionFormSetup();
    updateTransaction();
    setupSize();
    setupHelp();
    directionTab();
    photoTab();
    getDirections();
    idTypeClick();
    rentmeClick();
    setupCalendar();
    setupValidation();
    primaryCountryClick();
    secondaryCountryClick();
    <g:if test="${site.requiresInsurance}">
    insuranceClick();
    </g:if>
    rightArrowClick();
    leftArrowClick();
    ajaxFormUpdate();
    ajaxServerPoll();
    createMap();
  });

//]]>
  </script>

  </head>
  <body>
    <div id="body">
    <g:render template="/topnav" />
    <div id="stcontent">
      <g:render template="/logo_bar" />
        <div id="site_info" class="left" style="margin-top: 26px;">
          <g:render template="/siteInfo" />
        </div>

        <div style="width: 650px;" class="left">

          <div id="detailInfo">
            <div style="margin-top: -20px;">
              <div class="returnLink right" style="padding: 0 0 0 0.5em;">
                <g:link controller="home" action="index">
                  New Search
                </g:link>
              </div>
              <div class="returnLink right">|</div>
              <div class="returnLink right" style="padding: 0 0.5em;">
                <g:link controller="home" action="index" params="[size: params.searchSize, date: params.date, address: params.address]">
                 Back to Seach Results
                </g:link>
              </div>
            </div>
            <div style="height: 25px; clear: both;"></div>

            <div id="transaction">
              <g:render template="/transaction" />
            </div>
            
            <div id="map">
              <img src="http://maps.google.com/maps/api/staticmap?zoom=15&size=314x265&maptype=roadmap&markers=icon:${resource(absolute: true, dir:'images', file:'icn_static.png')}|${site.getFullAddress().encodeAsURL()}&sensor=false&key=ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA" alt="Map of ${site.title}"/>
            </div>
            <div id="detail_tabs">
              <div id="photo_button" class="left tab_button_on button_text_hi">Photos</div><div id="direction_button" class="right tab_button_off button_text">Directions</div>
              <div style="clear: both;"></div>
              <div id="photos">
                <div id="imgFrame">
                  <g:if test="${site.siteImages().size() > 0}">
                      <img src="${resource(file:site.coverImage().mid())}" style="display:block;margin:auto;" alt=""/>
                  </g:if>
                  <g:else>
                    <img src="${resource(dir: 'images', file:'placeholder.jpg')}" alt="place holder"/>
                  </g:else>
                </div>
                <div id="leftArrow" class="left ${site.siteImages().size() > 4 ? 'leftArrowNull' : 'arrowEmpty'}" style="margin-top: 8px;">
                </div>
                <div class="left" id="thumbWrapper">
                  <ul id="items">
                     <g:each var="siteImg" in="${site.siteImages()}" status="i">
                         <li class="thumb">
                           <img id="img${siteImg.imgOrder}" class="${i == 0 ? 'gallerySelected' : 'galleryNormal'}" src="${resource(file:siteImg.thumbnail())}" alt="" onclick="showImage('${resource(file:siteImg.mid())}', 'img${siteImg.imgOrder}')"/>
                         </li>
                     </g:each>
                  </ul>
                </div>
                <div id="rightArrow" class="left ${site.siteImages().size() > 4 ? 'rightArrowActive' : 'arrowEmpty'}" style="margin-top: 8px;">
                </div>
                <div style="clear: both;height: 5px;"></div>
              </div>
              <div id="directions" style="display:none;">
                <div>
                  <label for="srcAddr">Start Address:</label> <input type="text" name="srcAddr" id="srcAddr"/>
                </div>
                <div>
                  <label for="get_directions"></label><input id="get_directions" type="button" name="getDirections" value="Get Directions"/>
                </div>
                <div id="dirPanel"></div>
              </div>
            </div>
            <div style="clear:both;"></div>
            <table id="price_table">
              <thead>
                <tr class="price_options">
                  <th style="width:200px; text-align: left; padding-left:20px;">Details</th>
                  <th style="width:100px;">Months</th>
                  <th style="width:200px; text-align: right;">Monthly Rent</th>
                  <th style="width:166px; text-align: right;">Total Rent</th>
                </tr>
              </thead>
              <tbody id="price_body">
              </tbody>
            </table>
            <div style="height: 10px;"></div>
            <table id="price_totals">
              <tbody id="price_totals_body">
              </tbody>
              <tr class="price_options">
                <th style="width: 500px; text-align: left; padding-left:20px;">Total Move-In Cost:</th>
                <th id="price_total" class="price_text" style="width:166px; padding-right: 20px;"></th>
              </tr>
            </table>
            <div style="height:15px;"></div>
            <div class="left">
              <g:link controller="home" action="index" params="[size: params.searchSize, date: params.date, address: params.address]">
                <img src="${resource(dir:'images', file:'btn-previous2.png')}" style="border: 0; cursor: pointer;" alt="back home"/>
              </g:link>
            </div>
            <div id="rentmeBtn" style="float: right; margin-right: 20px; display: none;">
              <img id="rentme" src="${createLinkTo(dir:'images', file:'btn-rent-me.png')}" alt="Rent Me"/>
            </div>
          </div>

          <div id="rentalForm" style="display: none;">
            <g:form action="save" controller="rentalTransaction" name="rentalTransaction" method="post" useToken="true">
              
              <input type="hidden" name="priceDriveup" id="priceDriveup" value="${rentalTransaction?.priceDriveup}" />
              <input type="hidden" name="priceInterior" id="priceInterior" value="${rentalTransaction?.priceInterior}" />
              <input type="hidden" name="priceUpper" id="priceUpper" value="${rentalTransaction?.priceUpper}" />
              <input type="hidden" name="unitId" id="unitId" value="${rentalTransaction?.unitId}" />
              <input type="hidden" name="promoId" id="promoId" value="${rentalTransaction?.promoId}" />
              <input type="hidden" name="site" value="${params.id}" />
              <input type="hidden" name="moveInDate" id="moveInDate" value="${rentalTransaction?.moveInDate}" />

              <input style="display:none" type="text" name="SC_searchSize" id="SC_searchSize" value="${params.searchSize}"/>
              <input style="display:none" type="text" name="SC_address" id="SC_address" value="${params.address}"/>
              <input style="display:none" type="text" name="SC_date" id="SC_date" value="${params.date}"/>

              <div class="vert_text">
                <span id="step1_bullet" class="bullet">&#8226</span><span id="step1" class="step_header_hi">Primary Contact</span>
                <span id="step2_bullet" class="bullet" style="display: none;">&#8226</span><span id="step2" class="step_header">Secondary Contact</span>
                <span id="step3_bullet" class="bullet" style="display: none;">&#8226</span><span id="step3" class="step_header">Rental Options</span>
                <span id="step4_bullet" class="bullet" style="display: none;">&#8226</span><span id="step4" class="step_header">Payment</span>
                <span id="step5_bullet" class="bullet" style="display: none;">&#8226</span><span id="step5" class="step_header">Order Complete</span>
              </div>

              <!-- Primary Contact -->
              <div id="primary_contact">
                <div class="price_options checkout_header white">
                  Contact Information
                </div>
                <div class="formInstructions">
                  Information collected is for purposes of completing the Storage Rental Agreement, and will not be used for any other purpose except as described in our <a href="${createLink(controller:'static', action:'privacy')}" target="_new">Privacy Policy</a>
                </div>
                <div class="checkout_section_header">
                  Name
                </div>
                <div class="checkout_fields">
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.firstName', 'errors')}">
                      <g:textField id="contactPrimary.firstName" name="contactPrimary.firstName" style="width: 180px;" class="required" value="${rentalTransaction?.contactPrimary?.firstName}" />
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.lastName', 'errors')}">
                    <g:textField id="contactPrimary.lastName" name="contactPrimary.lastName" style="width: 180px;" class="required" value="${rentalTransaction?.contactPrimary?.lastName}" />
                  </div>
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.suffixName', 'errors')}">
                    <g:textField id="contactPrimary.suffixName" name="contactPrimary.suffixName" style="width: 80px;" value="${rentalTransaction?.contactPrimary?.suffixName}" />
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div class="checkout_name" style="width:200px;">
                    <label for="contactPrimary.firstName">First Name</label>
                  </div>
                  <div class="checkout_name" style="width:200px;">
                    <label for="contactPrimary.lastName">Last Name</label>
                  </div>
                  <div class="checkout_name" style="width:100px;">
                    <label for="contactPrimary.suffixName">Suffix</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_section_header">
                  Address
                </div>
                <div class="checkout_fields">
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.streetNumber', 'errors')}">
                      <g:textField name="contactPrimary.streetNumber" id="contactPrimary.streetNumber" class="required" style="width:80px;" value="${rentalTransaction?.contactPrimary?.streetNumber}" />
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.street', 'errors')}">
                      <g:textField name="contactPrimary.street" id="contactPrimary.street" class="required" style="width:180px;" value="${rentalTransaction?.contactPrimary?.street}" />
                  </div>
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.streetType', 'errors')}">
                      <g:select name="contactPrimary.streetType" id="contactPrimary.streetType" style="width:80px;" from="${storitz.constants.StreetType.list()}" value="${rentalTransaction?.contactPrimary?.streetType}" optionValue="value"/>
                  </div>
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.unit', 'errors')}">
                      <g:textField name="contactPrimary.unit" id="contactPrimary.unit" style="width:80px;" value="${rentalTransaction?.contactPrimary?.unit}" />
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactPrimary.streetNumber">Street Number</label>
                  </div>
                  <div style="width:200px;" class="checkout_name">
                    <label for="contactPrimary.street">Street Name</label>
                  </div>
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactPrimary.streetType">Street Suffix</label>
                  </div>
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactPrimary.unit">Unit/Apt.</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_fields">
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.city', 'errors')}">
                      <g:textField name="contactPrimary.city" id="contactPrimary.city" class="required" style="width:180px;" value="${rentalTransaction?.contactPrimary?.city}" />
                  </div>
                  <div id="primaryStateField" style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.state', 'errors')}">
                    <g:select name="contactPrimary.state" id="contactPrimary.state" class="validate-selection" style="width:80px;" from="${storitz.constants.State.list()}" value="${rentalTransaction?.contactPrimary?.state}" optionValue="value"/>
                  </div>
                  <div id="primaryProvinceField" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.province', 'errors')}" style="width: 150px;display: none;">
                    <g:textField name="contactPrimary.province" id="contactPrimary.province" class="required" style="width:130px;" value="${rentalTransaction?.contactPrimary?.province}" />
                  </div>
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.zipcode', 'errors')}">
                      <g:textField name="contactPrimary.zipcode" id="contactPrimary.zipcode" class="required" style="width:80px;" value="${rentalTransaction?.contactPrimary?.zipcode}" />
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.country', 'errors')}">
                    <g:select name="contactPrimary.country" id="contactPrimary.country" style="width:180px;" from="${storitz.constants.Country.list()}" value="${rentalTransaction?.contactPrimary?.country?.key}" optionKey="key" optionValue="display"/>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div style="width:200px;" class="checkout_name">
                    <label for="contactPrimary.city">City</label>
                  </div>
                  <div style="width:100px;" id="primaryStateLabel" class="checkout_name">
                    <label for="contactPrimary.state">State</label>
                  </div>
                  <div style="width: 150px;display: none;" id="primaryProvinceLabel" class="checkout_name">
                    <label for="contactPrimary.province">Province</label>
                  </div>
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactPrimary.zipcode">Postal Code</label>
                  </div>
                  <div style="width:200px;" class="checkout_name">
                    <label for="contactPrimary.country">Country</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_section_header">
                  Phone / Email
                </div>
                <div class="checkout_fields">
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.phoneType', 'errors')}">
                      <g:select name="contactPrimary.phoneType" id="contactPrimary.phoneType" style="width:80px;" from="${storitz.constants.PhoneType.list()}" value="${rentalTransaction?.contactPrimary?.phoneType}" optionValue="value"/>
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.phone', 'errors')}">
                      <g:textField name="contactPrimary.phone" id="contactPrimary.phone" class="required" style="width:180px;" value="${rentalTransaction?.contactPrimary?.phone}" />
                  </div>
                  <div style="width:300px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.email', 'errors')}">
                      <g:textField name="contactPrimary.email" id="contactPrimary.email" class="required validate-email" style="width:280px;" value="${rentalTransaction?.contactPrimary?.email}" />
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactPrimary.phoneType">Phone Type</label>
                  </div>
                  <div style="width:200px;" class="checkout_name">
                    <label for="contactPrimary.phone">Phone Number</label>
                  </div>
                  <div style="width:300px;" class="checkout_name">
                    <label for="contactPrimary.email">Email</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_section_header">
                  ID Information
                </div>
                <div class="checkout_fields">
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'idType', 'errors')}">
                      <g:select id="idType" name="idType" style="width:180px;" from="${storitz.constants.IdType.list()}" value="${rentalTransaction?.idType}" optionValue="value"/>
                  </div>
                  <div id="idStateField" style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'idState', 'errors')}">
                      <g:select name="idState" id="idState" class="validate-selection" style="width:80px;" from="${storitz.constants.State.list()}" value="${rentalTransaction?.idState}" optionValue="value"/>
                  </div>
                  <div id="idCountryField" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'idCountry', 'errors')}" style="width:200px;display: none;">
                      <g:select name="idCountry" id="idCountry" style="width:180px;" from="${storitz.constants.Country.list()}" value="${rentalTransaction?.idCountry?.key}" optionKey="key" optionValue="display"/>
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'idNumber', 'errors')}">
                      <g:textField name="idNumber" id="idNumber" class="required" style="width:180px;" value="${rentalTransaction?.idNumber}" />
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div style="width:200px;" class="checkout_name">
                    <label for="idType">ID Type</label>
                  </div>
                  <div id="idStateLabel" style="width:100px;" class="checkout_name">
                    <label for="idState">ID State</label>
                  </div>
                  <div id="idCountryLabel" class="checkout_name" style="width:200px;display: none;">
                    <label for="idCountry">ID Country</label>
                  </div>
                  <div style="width:200px;" class="checkout_name">
                    <label for="idNumber">ID Number</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_fields">
                  <div style="width:300px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'dateOfBirth', 'errors')}">
                      <g:datePicker id="dateOfBirth" name="dateOfBirth" style="width:280px;" precision="day" years="${2010..1900}" value="${rentalTransaction?.dateOfBirth}" />
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div style="width:300px;" class="checkout_name">
                    <label for="dateOfBirth">Date of birth</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div style="margin-top: 20px;">
                  <div class="left"><img src="${resource(dir:'images', file:'btn-previous2.png')}" onclick="details_return(); return false" alt="Back"></div>
                  <div class="right"><img src="${resource(dir:'images', file:'btn-next2.png')}" onclick="nextStep1(); return false" alt="Next"></div>
                  <div style="clear:both;"></div>
                </div>
              </div>

              <!-- Secondary Contact -->
              <div id="secondary_contact" style="display:none;">
                <div class="price_options checkout_header white">
                  Contact Information
                </div>
                <div class="formInstructions">
                  Storage property owners (and most states) require a second contact with distinct address and phone number in the event your property is at risk and you are unreachable. Consider using a close friend or relative.
                </div>
                <div class="checkout_section_header">
                  Name
                </div>
                <div class="checkout_fields">
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.firstName', 'errors')}">
                      <g:textField name="contactSecondary.firstName" id="contactSecondary.firstName" class="required" style="width: 180px;" value="${rentalTransaction?.contactSecondary?.firstName}" />
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.lastName', 'errors')}">
                    <g:textField name="contactSecondary.lastName" id="contactSecondary.lastName" class="required" style="width: 180px;" value="${rentalTransaction?.contactSecondary?.lastName}" />
                  </div>
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.suffixName', 'errors')}">
                    <g:textField name="contactSecondary.suffixName" id="contactSecondary.suffixName" style="width: 80px;" value="${rentalTransaction?.contactSecondary?.suffixName}" />
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div class="checkout_name" style="width:200px;">
                    <label for="contactSecondary.firstName">First Name</label>
                  </div>
                  <div class="checkout_name" style="width:200px;">
                    <label for="contactSecondary.lastName">Last Name</label>
                  </div>
                  <div class="checkout_name" style="width:100px;">
                    <label for="contactSecondary.suffixName">Suffix</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_section_header">
                  Address
                </div>
                <div class="checkout_fields">
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.streetNumber', 'errors')}">
                      <g:textField name="contactSecondary.streetNumber" id="contactSecondary.streetNumber" class="required" style="width:80px;" value="${rentalTransaction?.contactSecondary?.streetNumber}" />
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.street', 'errors')}">
                      <g:textField name="contactSecondary.street" id="contactSecondary.street" class="required" style="width:180px;" value="${rentalTransaction?.contactSecondary?.street}" />
                  </div>
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.streetType', 'errors')}">
                      <g:select name="contactSecondary.streetType" id="contactSecondary.streetType" style="width:80px;" from="${storitz.constants.StreetType.list()}" value="${rentalTransaction?.contactSecondary?.streetType}" optionValue="value"/>
                  </div>
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.unit', 'errors')}">
                      <g:textField name="contactSecondary.unit" id="contactSecondary.unit" style="width:80px;" value="${rentalTransaction?.contactSecondary?.unit}" />
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactSecondary.streetNumber">Street Number</label>
                  </div>
                  <div style="width:200px;" class="checkout_name">
                    <label for="contactSecondary.street">Street Name</label>
                  </div>
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactSecondary.streetType">Street Suffix</label>
                  </div>
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactSecondary.unit">Unit/Apt.</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_fields">
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.city', 'errors')}">
                      <g:textField name="contactSecondary.city" id="contactSecondary.city" class="required" style="width:180px;" value="${rentalTransaction?.contactSecondary?.city}" />
                  </div>
                  <div id="secondaryStateField" style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.state', 'errors')}">
                    <g:select name="contactSecondary.state" id="contactSecondary.state" class="validate-selection" style="width:80px;" from="${storitz.constants.State.list()}" value="${rentalTransaction?.contactSecondary?.state}" optionValue="value"/>
                  </div>
                  <div id="secondaryProvinceField" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.province', 'errors')}" style="width: 200px;display: none;">
                    <g:textField name="contactSecondary.province" id="contactSecondary.province" class="required" style="width:180px;" value="${rentalTransaction?.contactSecondary?.province}" />
                  </div>
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.zipcode', 'errors')}">
                      <g:textField name="contactSecondary.zipcode" id="contactSecondary.zipcode" class="required" style="width:80px;" value="${rentalTransaction?.contactSecondary?.zipcode}" />
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.country', 'errors')}">
                    <g:select name="contactSecondary.country" id="contactSecondary.country" style="width:180px;" from="${storitz.constants.Country.list()}" value="${rentalTransaction?.contactSecondary?.country?.key}" optionKey="key" optionValue="display"/>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div style="width:200px;" class="checkout_name">
                    <label for="contactSecondary.city">City</label>
                  </div>
                  <div style="width:100px;" id="secondaryStateLabel" class="checkout_name">
                    <label for="contactSecondary.state">State</label>
                  </div>
                  <div style="width: 200px;display: none;" id="secondaryProvinceLabel" class="checkout_name">
                    <label for="contactSecondary.province">Province</label>
                  </div>
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactSecondary.zipcode">Postal Code</label>
                  </div>
                  <div style="width:200px;" class="checkout_name">
                    <label for="contactSecondary.country">Country</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_section_header">
                  Phone / Email
                </div>
                <div class="checkout_fields">
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.phoneType', 'errors')}">
                      <g:select name="contactSecondary.phoneType" id="contactSecondary.phoneType" style="width:80px;" from="${storitz.constants.PhoneType.list()}" value="${rentalTransaction?.contactSecondary?.phoneType}" optionValue="value"/>
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.phone', 'errors')}">
                      <g:textField name="contactSecondary.phone" id="contactSecondary.phone" class="required" style="width:180px;" value="${rentalTransaction?.contactSecondary?.phone}" />
                  </div>
                  <div style="width:300px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.email', 'errors')}">
                      <g:textField name="contactSecondary.email" id="contactSecondary.email" class="required validate-email" style="width:280px;" value="${rentalTransaction?.contactSecondary?.email}" />
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactSecondary.phoneType">Phone Type</label>
                  </div>
                  <div style="width:200px;" class="checkout_name">
                    <label for="contactSecondary.phone">Phone Number</label>
                  </div>
                  <div style="width:300px;" class="checkout_name">
                    <label for="contactSecondary.email">Email</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div style="margin-top: 20px;">
                  <div class="right" style="margin-left:20px;"><img src="${resource(dir:'images', file:'btn-next2.png')}" onclick="nextStep2(); return false" alt="Next"></div>
                  <div class="left"><img src="${resource(dir:'images', file:'btn-previous2.png')}" onclick="prevStep2(); return false" alt="Prev"></div>
                  <div style="clear:both;"></div>
                </div>
              </div>

              <!-- Rental Info -->
              <div id="rental_info" style="display:none;">
                <div class="price_options checkout_header white">
                  Rental Options
                </div>
                <div class="checkout_section_header">
                  Rental Use
                </div>
                <div class="checkout_fields">
                  <div id="rentalUse" class="validate-one-radio value ${hasErrors(bean: rentalTransaction, field: 'rentalUse', 'errors')}">
                      <g:radioGroup name="rentalUse" labels="${storitz.constants.RentalUse.labels()}" values="${storitz.constants.RentalUse.list()}" value="${rentalTransaction?.rentalUse}">
                        <div class="left" style="width:200px;">${it.radio} ${it.label}</div>
                      </g:radioGroup>
                      <div style="clear:both;"></div>
                  </div>
                </div>
                <div style="height: 20px;"></div>
                <g:if test="${site.freeTruck == storitz.constants.TruckType.FREE}">
                  <div class="checkout_section_header">
                    Free Truck
                  </div>
                  <div class="checkout_fields">
                    <div class="value ${hasErrors(bean: rentalTransaction, field: 'reserveTruck', 'errors')}">
                        <div class="left"><g:checkBox name="reserveTruck" id="reserveTruck" value="${rentalTransaction?.reserveTruck}" /></div><div class="checkBoxText"> Reserve Free Truck for this move in</div>
                        <div style="clear:both;"></div>
                    </div>
                    <div style="clear:both;"></div>
                  </div>
                  <div style="height: 20px;"></div>
                </g:if>
                <g:elseif test="${site.freeTruck == storitz.constants.TruckType.RENTAL}">
                  <div class="checkout_section_header">
                    Rental Truck
                  </div>
                  <div class="checkout_fields">
                    <div class="value ${hasErrors(bean: rentalTransaction, field: 'reserveTruck', 'errors')}">
                        <div class="left"><g:checkBox name="reserveTruck" id="reserveTruck" value="${rentalTransaction?.reserveTruck}" /></div><div class="checkBoxText"> Reserve Rental Truck for this move in</div>
                        <div style="clear:both;"></div>
                    </div>
                    <div style="clear:both;"></div>
                  </div>
                  <div style="height: 20px;"></div>
                </g:elseif>
                <div class="checkout_section_header">
                  Insurance
                </div>
                <div class="formInstructions">
                  Storage property owner does not carry insurance to cover the loss or damage of your items. Your existing Homeowner’s Insurance or Renter’s Insurance may cover items you keep in storage. Alternatively, you may select (are required to select) the level of monthly insurance coverage that you may pay for as part of your monthly rent.
                </div>
                <div class="checkout_fields" style="width:646px;">
                  <div id="insuranceChoices" class="validate-one-radio" >
                    <div class="left" style="width: 320px;"><input type="radio" name="insuranceId" value="-999" checked="checked" /> Waive insurance - use my renters/home policy coverage</div>
                    <g:each in="${site.insurances.sort{it.premium}}" var="ins">
                      <div class="left" style="width: 320px;"><input type="radio" name="insuranceId" value="${ins.id}"/> <g:formatNumber number="${ins.premium}" type="currency" currencyCode="USD" />/mo. Coverage: <g:formatNumber number="${ins.totalCoverage}" type="currency" currencyCode="USD" /> Theft: <g:formatNumber number="${ins.percentTheft}" type="percent" /></div>
                    </g:each>
                    <div style="clear:both;"></div>
                  </div>
                </div>
                <div class="checkout_fields">
                  <div id="insuranceTermsHolder" class="validate-one-checkbox value ${hasErrors(bean: rentalTransaction, field: 'insuranceTerms', 'errors')}">
                      <div class="left"><g:checkBox name="insuranceTerms" id="insuranceTerms" class="required" value="${rentalTransaction?.insuranceTerms}" /></div><div class="checkBoxText"> By Checking Here, I acknowledge that I am responsible for damage or loss to my goods while stored at Storage Property</div>
                      <div style="clear:both;"></div>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div style="height: 20px;"></div>
                <div class="checkout_section_header">
                  Active Military
                </div>
                <div class="formInstructions">
                  Active US Military renters are not eligible for lien auctions. This protects your items while you are on duty.
                </div>
                <div class="checkout_fields">
                  <div class="value ${hasErrors(bean: rentalTransaction, field: 'activeMilitary', 'errors')}">
                      <div class="left"><g:checkBox name="activeMilitary" value="${rentalTransaction?.activeMilitary}" /></div><div class="checkBoxText"> Are you a member of the US Armed Forces and on active duty?</div>
                      <div style="clear:both;"></div>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div style="height: 20px;"></div>
                <div class="checkout_section_header">
                  Hazardous Materials
                </div>
                <div class="checkout_fields">
                  <div id="hazardousMaterialsHolder" class="validate-one-checkbox value ${hasErrors(bean: rentalTransaction, field: 'hazardousMaterials', 'errors')}">
                      <div class="left"><g:checkBox name="hazardousMaterials" id="hazardousMaterials" class="required" value="${rentalTransaction?.hazardousMaterials}" /></div><div class="checkBoxText"> By checking here, I agree to not store hazardous items according to Federal Code, which includes but is not limited to Tires, Oil, Gasoline or Flammables, Paints, Environmental or Toxic Waste and Perishable Food.</div>
                      <div style="clear:both;"></div>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div style="height: 20px;"></div>
                <div class="checkout_section_header">
                  Terms
                </div>
                <div class="checkout_fields">
                  <div id="termsHolder" class="validate-one-checkbox value ${hasErrors(bean: rentalTransaction, field: 'terms', 'errors')}">
                      <div class="left">
                        <g:checkBox name="terms" id="terms" class="required" value="${rentalTransaction?.terms}" /></div><div class="checkBoxText"> I agree to the terms and conditions of the
                          <g:if test="${site.rentalAgreement}">
                            <a href="${resource(file:site.rentalAgreement.src())}" target="_blank">Storage Rental Agreement</a>
                          </g:if>
                          <g:else>Storage Rental Agreement</g:else>
                      </div>
                      <div style="clear:both;"></div>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <sec:ifAnyGranted roles="ROLE_CALLCENTER">
                  <div class="checkout_section_header">
                    Call Center Notes
                  </div>
                  <div class="checkout_fields">
                    <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.phone', 'errors')}">
                        <g:textField name="operatorInitials" id="operatorInitials" style="width:80px;" value="${operatorInitials}" />
                    </div>
                    <div style="clear:both;"></div>
                  </div>
                  <div class="checkout_labels">
                    <div style="width:100px;" class="checkout_name">
                      <label for="operatorInitials">Operator Initials</label>
                    </div>
                    <div style="clear:both;"></div>
                  </div>
                  <div class="checkout_fields">
                    <div style="width:500px;" class="checkout_value">
                        <g:textArea name="operatorNote" id="operatorNote" style="width:480px;">${operatorNote}</g:textArea>
                    </div>
                    <div style="clear:both;"></div>
                  </div>
                  <div class="checkout_labels">
                    <div style="width:500px;" class="checkout_name">
                      <label for="operatorNote">Operator Note</label>
                    </div>
                    <div style="clear:both;"></div>
                  </div>
                </sec:ifAnyGranted>
                <div style="margin-top: 20px;">
                  <div class="right" style="margin-left:20px;"><img src="${resource(dir:'images', file:'btn-next2.png')}" onclick="nextStep3(); return false" alt="Next"></div>
                  <div class="left"><img src="${resource(dir:'images', file:'btn-previous2.png')}" onclick="prevStep3(); return false" alt="Prev"></div>
                  <div style="clear:both;"></div>
                </div>
              </div>
            </g:form>
          </div>
        </div>
    </div>
    <div style="clear:both; height:30px;"></div>
    <div id="helpDeskStatus">STATUS</div>
    <g:render template="/footer" />
    <g:render template="/size_popup" />
    <script type="text/javascript" src="http://www.google.com/jsapi?autoload=%7B%22modules%22%3A%5B%7B%22name%22%3A%22maps%22%2C%22version%22%3A%223.x%22%2Cother_params%3A%22sensor%3Dfalse%22%2C%22callback%22%3A%22createMap%22%7D%2C%7B%22name%22%3A%22gdata%22%2C%22version%22%3A%222.x%22%2C%22packages%22%3A%5B%22maps%22%5D%7D%5D%7D&amp;key=ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA"></script>
    </div>
  </body>
</html>