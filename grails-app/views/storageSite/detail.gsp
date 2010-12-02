<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <meta name="DESCRIPTION" content="Storitz self storage partner - ${site.title} located in ${site.city}, ${site.state.fullName} postal code ${site.zipcode} : ${site.description ? site.getTextDescription() : '' }"/>
    <g:meta name="keywords" content="Storage unit, self storage units, storage units, moving, storage units for rent, cheap storage units, storage unit rental, self storage, self storage facility, self storage facilities, air conditioned storage units, self storage rental, public self storage, security self storage, find self storage, self storage companies, Mini storage, mini self storage"/> 
    <g:render template="/header_home" />

  <p:dependantJavascript>
    <script type="text/javascript">
//<![CDATA[

    var gallerySetup = false;
    var startDate = "${params.date && params.date != 'null' ? params.date : (new Date()).format('MM/dd/yy')}";
    var siteId = ${params.id};
    var ajaxFormDirty = false;
    var ajaxServerPollTimer;
    var ajaxFormUpdateTimer;
    var ajaxFormNewValues;
    var ajaxFormOldValues;
    var urlAjaxUpdate = "${createLink(controller:'rentalTransaction', action: 'ajaxUpdate', id:shortSessionId)}";
    var urlAjaxPoll = "${createLink(controller:'rentalTransaction', action: 'ajaxPoll', id:shortSessionId)}";
    var urlThemePath = "${resource(dir:'/images/themes/')}";
    var srcSpinner = ${p.imageLink(src:'ajax-loader.gif')};

    <g:render template="/transaction_js"/>
    <g:render template="/directions_js"/>

    function createMap() {}

  $(document).ready(function() {

    setupImageGallery();
    setupJQueryTabs();
    setupSize();
    rentmeClick();
    transactionFormSetup();
    setupCalendar();
    getDirections();
    createDirectionMap();
    setupHelp();
    primaryCountryClick();
  <g:if test="${params.returnForm}">
    details_return();
  </g:if>
    showTotals();
    setupValidation();
    ajaxFormUpdate();
    ajaxServerPoll();
    setupAnalytics();
  });


//]]>
  </script>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?v=3.1&amp;sensor=false&amp;key=ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA"></script>
    <p:javascript src="detail_bundle"/>
  </p:dependantJavascript>
  </head>
  <body>
    <div id="body">
    <g:render template="/topnav" />
    <div class="stcontent">
      <g:render template="/logo_bar" />
        <div id="site_info" class="left" style="margin-top: 26px;">
          <g:render template="/siteInfo" />
        </div>

        <div style="width: 650px;" class="left">

          <div id="detailInfo">
            <div style="margin-top:10px;">
              <div class="returnLink right" style="padding: 0 0 0 0.5em;">
                <g:link controller="home" action="index">
                  New Search
                </g:link>
              </div>
              <div class="returnLink right">|</div>
              <div class="returnLink right" style="padding: 0 0.5em;">
                <g:link controller="home" action="index" params="[size: params.size, date: params.date, address: params.address]">
                 Back to Seach Results
                </g:link>
              </div>
            </div>
            <div style="height: 25px; clear: both;"></div>

            <div id="transaction">
              <g:render template="/transaction" />
            </div>

            <div style="height:15px;"></div>
            
            <div id="detail_tabs" style="width:650px;">
              <ul>
                <li><a href="#tab_summary">Description</a></li>
                <li><a href="#tab_photos">Photos</a></li>
                <li><a href="#tab_directions">Map &amp; Directions</a></li>
              </ul>
              <div id="tab_summary">
                <div class="left">
                  <g:if test="${site.coverImage()}">
                    <div class="left">
                      <img src="${resource(file: site.coverImage().mid())}" width="320" height="240" alt="Image of ${site.title} located in ${site.city}, ${site.state.fullName}" style="width:240px; height:160px; margin: 0 20px 20px 0px;">
                    </div>
                  </g:if>
                  <p class="descriptionTitle" style="margin: 0;">
                    ${site.title}
                  </p>
                  <p style="margin: 0;">
                    ${site.address}${site.address2 && site.address2.size() > 0 ? '&nbsp;' + site.address2 : ''}, ${site.city}, ${site.state.display} ${site.zipcode}
                  </p>
                  <div class="descriptionText" style="margin: 18px">
                    ${site.description}
                  </div>
                  <div style="clear:both;"></div>
                  <div id="featuresList">
                    <ul>
                      <li class="safety">Safety/Security</li>
                      <g:each in="${site.securityItems}" status="i" var="item">
                        <li ${i == site.securityItems.size() -1 ? 'class="last"' : ''}><a href="#">${item.bullet}</a></li>
                      </g:each>
                    </ul>
                    <ul>
                      <li class="convenience">Convenience</li>
                      <g:each in="${site.convenienceItems}" status="i" var="item">
                        <li ${i == site.convenienceItems.size() -1 ? 'class="last"' : ''}><a href="#">${item.bullet}</a></li>
                      </g:each>
                    </ul>
                    <ul>
                      <li class="amenities">Amenities</li>
                      <g:each in="${site.amenityItems}" status="i" var="item">
                        <li ${i == site.amenityItems.size() -1 ? 'class="last"' : ''}><a href="#">${item.bullet}</a></li> 
                      </g:each>
                    </ul>
                  </div>
                </div>
              </div>
              <div id="tab_photos" style="width:650px;">
                <div style="margin:auto;">
                  <g:if test="${site.siteImages().size() > 0}">
                    <ul id="galleryView">
                    <g:each var="siteImg" in="${site.siteImages()}" status="i">
                        <li>
                          <img width="60" height="40" src="${resource(file:siteImg.thumbnail())}" alt="Image of ${site.title} located in ${site.city}, ${site.state.fullName}"/>
                          <div class="panel-content">
                            <img src="${resource(file:siteImg.src())}" alt="Image of ${site.title} located in ${site.city}, ${site.state.fullName}" />
                          </div>
                        </li>
                    </g:each>
                    </ul>
                  </g:if>
                  <g:else>
                    <storitz:image src="placeholder.jpg" width="320" height="240" style="margin-left:155px;" alt="place holder"/>
                  </g:else>
                </div>
              </div>
              <div id="tab_directions">
                <g:render template="/directions" />
              </div>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div id="rentalForm" style="display: none;">
            <g:form action="save" controller="rentalTransaction" method="post" useToken="true" name="rentalTransaction" id="${rentalTransactionInstance?.id}">

              <div>
              <input type="hidden" name="unitId" id="unitId" value="${rentalTransactionInstance ? rentalTransactionInstance.unitId : unitId}" />
              <input type="hidden" name="promoId" id="promoId" value="${rentalTransactionInstance?.promoId}" />
              <input type="hidden" name="insuranceId" id="insuranceId" value="${rentalTransactionInstance?.insuranceId}" />
              <input type="hidden" name="site" value="${rentalTransactionInstance ? rentalTransactionInstance.site.id : params.id}" />
              <input type="hidden" name="moveInDate" id="moveInDate" value="${rentalTransactionInstance?.moveInDate}" />
              <input type="hidden" name="chosenType" id="chosenType" value="${unitType ? unitType : rentalTransactionInstance?.unitType}" />
              <input type="hidden" name="searchSize" id="searchSize" value="${searchSize ? searchSize : rentalTransactionInstance?.searchSize}" />

              <input style="display:none" type="text" name="SC_searchSize" id="SC_searchSize" value="${params.size}"/>
              <input style="display:none" type="text" name="SC_address" id="SC_address" value="${params.address}"/>
              <input style="display:none" type="text" name="SC_date" id="SC_date" value="${params.date}"/>
              <input style="display:none" type="text" name="SC_page" id="SC_page" value="detail"/>
              </div>

              <div class="vert_text" style="margin-top:10px;">
                <span id="step1_bullet" class="bullet">&#8226;</span><span id="step1" class="step_header_hi">Renter Information</span>
                <span id="step2_bullet" class="bullet" style="display: none;">&#8226;</span><span id="step2" class="step_header">Payment</span>
                <span id="step3_bullet" class="bullet" style="display: none;">&#8226;</span><span id="step3" class="step_header">Order Complete</span>
              </div>

              <!-- Renter Information -->
              <div id="primary_contact">
                <div class="price_options checkout_header white">
                  Renter Information
                </div>
                <div id="errorMessage" class="formErrors">
                  <div id="errorInfo" class="errorInfo"></div>
                  <div id="errorList" class="errorList"></div>
                </div>
                <div class="formInstructions">
                  Information collected is for purposes of completing the Storage Rental Agreement, and will not be used for any other purpose except as described in our <a href="${createLink(controller:'static', action:'privacy')}" onclick="window.open(this.href,'_blank');return false;">Privacy Policy</a>
                </div>
                <div class="checkout_section_header">
                  Name
                </div>
                <div class="checkout_fields">
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.firstName', 'errors')}">
                      <g:textField id="contactPrimary.firstName" name="contactPrimary.firstName" style="width: 180px;" class="required" value="${rentalTransactionInstance?.contactPrimary?.firstName}" />
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.lastName', 'errors')}">
                    <g:textField id="contactPrimary.lastName" name="contactPrimary.lastName" style="width: 180px;" class="required" value="${rentalTransactionInstance?.contactPrimary?.lastName}" />
                  </div>
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.suffixName', 'errors')}">
                    <g:textField id="contactPrimary.suffixName" name="contactPrimary.suffixName" style="width: 80px;" class="ignore" value="${rentalTransactionInstance?.contactPrimary?.suffixName}" />
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
                  <div style="width:315px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.address1', 'errors')}">
                      <g:textField name="contactPrimary.address1" id="contactPrimary.address1" class="required" style="width:295px;" value="${rentalTransactionInstance?.contactPrimary?.address1}" />
                  </div>
                  <div style="width:315px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.address2', 'errors')}">
                      <g:textField name="contactPrimary.address2" id="contactPrimary.address2" style="width:295px;" class="ignore" value="${rentalTransactionInstance?.contactPrimary?.address2}" />
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div style="width:315px;" class="checkout_name">
                    <label for="contactPrimary.address1">Address line 1</label>
                  </div>
                  <div style="width:315px;" class="checkout_name">
                    <label for="contactPrimary.address2">Address line 2</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_fields">
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.city', 'errors')}">
                      <g:textField name="contactPrimary.city" id="contactPrimary.city" class="required" style="width:180px;" value="${rentalTransactionInstance?.contactPrimary?.city}" />
                  </div>
                  <div id="primaryStateField" style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.state', 'errors')}">
                    <g:select name="contactPrimary.state" id="contactPrimary.state" class="state" style="width:80px;" from="${storitz.constants.State.list()}" value="${rentalTransactionInstance?.contactPrimary?.state}" optionValue="value"/>
                  </div>
                  <div style="width: 120px;display: none;" id="primaryProvinceField" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.province', 'errors')}" >
                    <g:textField name="contactPrimary.province" id="contactPrimary.province" class="province" style="width:100px;" value="${rentalTransactionInstance?.contactPrimary?.province}" />
                  </div>
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.zipcode', 'errors')}">
                      <g:textField name="contactPrimary.zipcode" id="contactPrimary.zipcode" class="required zipcode" style="width:80px;" value="${rentalTransactionInstance?.contactPrimary?.zipcode}" />
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.country', 'errors')}">
                    <g:select name="contactPrimary.country" id="contactPrimary-country" style="width:180px;" class="country" from="${storitz.constants.Country.list()}" value="${rentalTransactionInstance?.contactPrimary?.country?.key}" optionKey="key" optionValue="display"/>
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
                  <div style="width: 120px;display: none;" id="primaryProvinceLabel" class="checkout_name">
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
                <div style="height: 10px;"></div>
                <div class="checkout_section_header">
                  Phone / Email
                </div>
                <div class="checkout_fields">
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.phoneType', 'errors')}">
                      <g:select name="contactPrimary.phoneType" id="contactPrimary.phoneType" style="width:80px;" from="${storitz.constants.PhoneType.list()}" value="${rentalTransactionInstance?.contactPrimary?.phoneType}" optionValue="value"/>
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.phone', 'errors')}">
                      <g:textField name="contactPrimary.phone" id="contactPrimary.phone" class="required phone" style="width:180px;" value="${rentalTransactionInstance?.contactPrimary?.phone}" />
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactPrimary.phoneType">Phone Type</label>
                  </div>
                  <div style="width:200px;" class="checkout_name">
                    <label for="contactPrimary.phone">Phone Number (XXX-XXX-XXXX)</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_fields">
                  <div style="width:300px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.email', 'errors')}">
                      <g:textField name="contactPrimary.email" id="contactPrimary-email" class="required email" style="width:280px;" value="${rentalTransactionInstance?.contactPrimary?.email}" />
                  </div>
                  <div style="width:300px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.email', 'errors')}">
                      <g:textField name="contactPrimary.emailRepeat" id="contactPrimary.emailRepeat" style="width:280px;" value="${rentalTransactionInstance?.contactPrimary?.email}" />
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div style="width:300px;" class="checkout_name">
                    <label for="contactPrimary-email">Email</label>
                  </div>
                  <div style="width:300px;" class="checkout_name">
                    <label for="contactPrimary.emailRepeat">Confirm Email</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div style="height: 10px;"></div>
                <div class="checkout_section_header">
                  Rental Use
                </div>
                <div class="checkout_fields">
                  <div id="rentalUse" class="validate-one-radio value ${hasErrors(bean: rentalTransactionInstance, field: 'rentalUse', 'errors')}">
                      <g:radioGroup name="rentalUse" labels="${storitz.constants.RentalUse.labels()}" values="${storitz.constants.RentalUse.list()}" value="${rentalTransactionInstance?.rentalUse}">
                        <div class="left" style="width:200px;">${it.radio} ${it.label}</div>
                      </g:radioGroup>
                      <div style="clear:both;"></div>
                  </div>
                </div>
                <div style="height: 10px;"></div>
                <div class="checkout_section_header">
                  Active Military
                </div>
                <div class="formInstructions">
                  Section 307 of the <a href="${resource(file:'/SCRA Section 307.pdf')}" onclick="window.open(this.href,'_blank');return false;">Servicemembers Civil Relief Act</a> protects servicemembers currently serving or 90 days removed from a period of active duty against lien auctions on their property. Checking this box will protect your rights as a servicemember.
                </div>
                <div class="checkout_fields">
                  <div class="value ${hasErrors(bean: rentalTransactionInstance, field: 'activeMilitary', 'errors')}">
                      <div class="left"><g:checkBox name="activeMilitary" value="${rentalTransactionInstance?.activeMilitary}" /></div><div class="checkBoxText">  I am servicemember in the US Armed Forces and on a period of active duty</div>
                      <div style="clear:both;"></div>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div style="height: 10px;"></div>
                <g:if test="${site.freeTruck == storitz.constants.TruckType.FREE}">
                  <div class="checkout_section_header">
                    Free Truck
                  </div>
                  <div class="checkout_fields">
                    <div class="value ${hasErrors(bean: rentalTransactionInstance, field: 'reserveTruck', 'errors')}">
                        <div class="left"><g:checkBox name="reserveTruck" id="reserveTruck" value="${rentalTransactionInstance?.reserveTruck}" /></div><div class="checkBoxText"> Reserve Free Truck for this move in</div>
                        <div style="clear:both;"></div>
                    </div>
                    <div style="clear:both;"></div>
                  </div>
                  <div style="height: 10px;"></div>
                </g:if>
                <g:elseif test="${site.freeTruck == storitz.constants.TruckType.RENTAL}">
                  <div class="checkout_section_header">
                    Rental Truck
                  </div>
                  <div class="checkout_fields">
                    <div class="value ${hasErrors(bean: rentalTransactionInstance, field: 'reserveTruck', 'errors')}">
                        <div class="left"><g:checkBox name="reserveTruck" id="reserveTruck" value="${rentalTransactionInstance?.reserveTruck}" /></div><div class="checkBoxText"> Reserve Rental Truck for this move in</div>
                        <div style="clear:both;"></div>
                    </div>
                    <div style="clear:both;"></div>
                  </div>
                  <div style="height: 20px;"></div>
                </g:elseif>
                <div class="checkout_section_header">
                  Terms
                </div>
                <div class="checkout_fields">
                  <textarea style="width:610px; height: 50px;" name="termText">
  Storage property owner does not carry insurance to cover the loss or damage of your items. Your existing Homeowner’s Insurance or Renter’s Insurance may cover items you keep in storage. Alternatively, you may select (are required to select) the level of monthly insurance coverage that you may pay for as part of your monthly rent.
  By Checking Here, I acknowledge that I am responsible for damage or loss to my goods while stored at Storage Property
  By checking here, I agree to not store hazardous items according to Federal Code, which includes but is not limited to Tires, Oil, Gasoline or Flammables, Paints, Environmental or Toxic Waste and Perishable Food.
                  </textarea>
                  <div id="termsHolder" style="margin-top:7px;" class="${hasErrors(bean: rentalTransactionInstance, field: 'terms', 'errors')}">
                      <div class="left">
                        <g:checkBox name="terms" id="terms" class="required" value="${rentalTransactionInstance?.terms}" /></div><div class="checkBoxText"> I agree to the <a href="${createLink(controller:'static', action:'terms')}" onclick="window.open(this.href,'_blank');return false;">Terms of Use</a>
                          <g:if test="${site.rentalAgreement}">
                            and the <a href="${resource(file:site.rentalAgreement.src())}" onclick="window.open(this.href,'_blank');return false;">Storage Rental Agreement</a>
                          </g:if>
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
                    <div style="width:100px;" class="checkout_value">
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
                  <div class="left"><p:inputImage style="width:108px;height:36px;border:none;" src="btn-previous2.png" onclick="leave_form(); return false" alt="Back" /></div>
                  <div class="right"><p:inputImage style="width:108px;height:36px;border:none;" src="btn-next2.png" alt="Next" /></div>
                  <div style="clear:both;"></div>
                </div>
              </div>

            </g:form>
          </div>
        </div>
    </div>
    <div style="clear:both; height:30px;"></div>
    <div id="helpDeskStatus">STATUS</div>
    <g:render template="/footer_no_analytics" />
    <g:render template="/size_popup_jquery" />
    </div>
  </body>
  <p:renderDependantJavascript />
</html>