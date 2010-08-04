<%@ page import="com.storitz.UserRole" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Create Storage Site"/>
  <g:render template="/header"/>

  <script type="text/javascript">
    //<![CDATA[

    google.load("jquery", "1.4.2");

    google.setOnLoadCallback(function() {
      jQuery.noConflict();

      setupTimePickers();
    });

    function setupTimePickers() {
      AnyTime.picker("startWeekday", {format:"%h:%i%p"});
      AnyTime.picker("endWeekday", {format:"%h:%i%p"});
      AnyTime.picker("startSaturday", {format:"%h:%i%p"});
      AnyTime.picker("endSaturday", {format:"%h:%i%p"});
      AnyTime.picker("startSunday", {format:"%h:%i%p"});
      AnyTime.picker("endSunday", {format:"%h:%i%p"});
      AnyTime.picker("startGate", {format:"%h:%i%p"});
      AnyTime.picker("endGate", {format:"%h:%i%p"});
    }

    function checkAddItem(type) {
      var listName = type + 'ItemList';
      var listAdd = type + 'ItemAdd';
      if ($(listName).childElements().length >= 10) {
        $(listAdd).hide();
      }
    }

    function itemAdd(type) {
      var listName = type + 'ItemList';
      var list = $(listName).childElements();
      var newItem = list.length + 1;
      if (list.length > 0) {
         var lastItem = list[list.length - 1];
         var lastInputName = lastItem.firstDescendant().name;
         newItem = parseInt(lastInputName.substr(lastInputName.indexOf('_') + 1)) + 1;
      }
      var itemName = type + 'Item_' + newItem;
      var liElem = new Element('li', {id:itemName});
      var newInput = new Element('input', {
        name: itemName,
        type: 'text',
        style: 'width:200px;'
      });
      var newLink = new Element('a', {
        href: '#',
        onclick: '$(\'' + itemName + '\').remove();checkAddItem(' + type + ');'
      });
      newLink.update('delete');
      liElem.insert({bottom: newInput});
      liElem.insert({bottom: newLink});
      $(listName).insert({bottom: liElem});
    }

    //]]>
  </script>
  <g:javascript src="jquery.MetaDeta.js"/>
  <g:javascript src="jquery.MultiFile.js"/>
  <g:javascript src="anytimec.js"/>
  <link href="${createLinkTo(dir:'css', file:'anytimec.css')}" media="screen" rel="stylesheet" type="text/css" />

</head>
<body>
<div id="body">
  <g:render template="/topnav"/>
  <div id="stcontent">
    <g:render template="/logo_bar" />

    <div style="clear: both;height: 10px"></div>
    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><g:link action="list">List Sites</g:link></span>
      <sec:ifAnyGranted roles="ROLE_ADMIN">
        <span class="button"><g:link action="create">Create new Site</g:link></span>
      </sec:ifAnyGranted>
  
    </div>
    <div style="clear: both;height: 10px"></div>

    <div class="body">

      <div class="price_options checkout_header white">
        Edit Site
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:hasErrors bean="${storageSiteInstance}">
        <div class="errors">
          <g:renderErrors bean="${storageSiteInstance}" as="list"/>
        </div>
      </g:hasErrors>

      <g:uploadForm method="post" id="${storageSiteInstance?.id}">
        <g:hiddenField name="version" value="${storageSiteInstance?.version}"/>
        <div class="dialog">

          <div class="formInstructions">
            Edit the information for your site below. Use this page to update information about this storage site, upload pictures
            and add descriptive features and text.
          </div>

          <div class="checkout_section_header">
            Property Name and Address
          </div>

          <div class="checkout_fields">
            <div style="width:300px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'title', 'errors')}">
              <g:textField id="title" name="title" style="width: 280px;" value="${storageSiteInstance?.title}" />
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:300px;">
              <label for="title">Property Name</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:300px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'address', 'errors')}">
              <g:textField id="address" name="address" style="width: 280px;" value="${storageSiteInstance?.address}" />
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:300px;">
              <label for="address">Address Line 1</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:300px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'address2', 'errors')}">
              <g:textField id="address2" name="address2" style="width: 280px;" value="${storageSiteInstance?.address2}" />
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:300px;">
              <label for="address2">Address Line 2</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:300px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'city', 'errors')}">
              <g:textField id="city" name="city" style="width: 280px;" value="${storageSiteInstance?.city}" />
            </div>
            <div style="width:100px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'state', 'errors')}">
              <g:select name="state" id="state" class="validate-selection" style="width:80px;" from="${storitz.constants.State.list()}" value="${storageSiteInstance?.state}" optionValue="value"/>
            </div>
            <div style="width:120px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'zipcode', 'errors')}">
              <g:textField id="zipcode" name="zipcode" style="width: 100px;" value="${storageSiteInstance?.zipcode}" />
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:300px;">
              <label for="city">City</label>
            </div>
            <div class="checkout_name" style="width:100px;">
              <label for="state">State</label>
            </div>
            <div class="checkout_name" style="width:120px;">
              <label for="zipcode">Zip Code</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'phone', 'errors')}">
              <g:textField id="phone" name="phone" style="width: 180px;" value="${storageSiteInstance?.phone}" />
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:200px;">
              <label for="phone">Phone</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_section_header">
            Hours of Operation
          </div>

          <div class="checkout_fields">
            <div style="width:150px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'openWeekday', 'errors')}">
              <g:checkBox name="openWeekday" value="${storageSiteInstance?.openWeekday}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'startWeekday', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="startWeekday" name="startWeekday" value="${storageSiteInstance?.startWeekday?.format("h:mma")}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'endWeekday', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="endWeekday" name="endWeekday" value="${storageSiteInstance?.endWeekday?.format("h:mma")}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:150px;">
              <label for="openWeekday">Open Weekdays</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="openWeekday">Start</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="openWeekday">End</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:150px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'openSaturday', 'errors')}">
              <g:checkBox name="openSaturday" value="${storageSiteInstance?.openSaturday}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'startSaturday', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="startSaturday" name="startSaturday" value="${storageSiteInstance?.startSaturday?.format("h:mma")}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'endSaturday', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="endSaturday" name="endSaturday" value="${storageSiteInstance?.endSaturday?.format("h:mma")}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:150px;">
              <label for="openSaturday">Open Saturdays</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="openSaturday">Start</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="openSaturday">End</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:150px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'openSunday', 'errors')}">
              <g:checkBox name="openSunday" value="${storageSiteInstance?.openSunday}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'startSunday', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="startSunday" name="startSunday" value="${storageSiteInstance?.startSunday?.format("h:mma")}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'endSaturday', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="endSunday" name="endSunday" value="${storageSiteInstance?.endSunday?.format("h:mma")}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:150px;">
              <label for="openSunday">Open Sundays</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="openSunday">Start</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="openSunday">End</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:150px;" class="checkout_value">
              &nbsp;
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'startGate', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="startGate" name="startGate" value="${storageSiteInstance?.startGate?.format("h:mma")}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'endGate', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="endGate" name="endGate" value="${storageSiteInstance?.endGate?.format("h:mma")}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:150px;">
              Gate Hours
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="openSunday">Start</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="openSunday">End</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'extendedHours', 'errors')}">
              <g:checkBox name="extendedHours" value="${storageSiteInstance?.extendedHours}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:200px;">
              <label for="extendedHours">Extended Hours Available</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_section_header">
            Site Features and Property Overview
          </div>
          <div class="formInstructions">
             Use this one paragraph description to sum-up your property's location, unique attributes and any other important information, such as:
            <p>
              "Bob-Jane's Self Storage is the newest self-storage that is located in the heart of the Smithtown Market District, accessible from the 85 Freeway. We have a clean, well-lighted, pest-free 3-story property with everything from walk-in closets to roll-up garages. "
            </p>
          </div>

          <div class="checkout_fields">
            <div style="width:660px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'description', 'errors')}">
              <fckeditor:editor
                name="description"
                width="650"
                height="300"
                toolbar="Basic">
                ${storageSiteInstance?.description}
              </fckeditor:editor>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:660px;">
              <label for="description">Property Overview</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="formInstructions">
            Build bullet lists that describe your site's features in three different sections: security/safety, convenience and amenities
          </div>

          <div class="checkout_fields">
            <div style="width:240px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'securityItems', 'errors')}">
              <div>
                Security/Safety Suggested Items:
                <ul>
                  <li>Gated Access</li>
                  <li>Individual Unit Alarms</li>
                  <li>Camera Surveillance</li>
                  <li>Well-lighted parking lot</li>
                  <li>Well-lighted hallways</li>
                  <li>Safety Intercoms in hallways</li>
                </ul>
              </div>
              <ul id="securityItemList">
                <g:each in="${storageSiteInstance?.securityItems}" status="i" var="c">
                  <li id="securityItem_${i}">
                    <input type="text" value="${c.bullet}" style="width:200px;" name="securityItem_${i}"/>  <a href="#" onclick="$('securityItem_${i}').remove();checkAddItem('security');">delete</a>
                  </li>
                </g:each>
              </ul>
              <p id="securityItemAdd">
                <a href="#" onclick="itemAdd('security');checkAddItem('security');">Add Item</a>
              </p>
            </div>
            <div style="width:240px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'convenienceItems', 'errors')}">
              <div>
                Convenience Suggested Items:
                <ul>
                  <li>Flexible Hours</li>
                  <li>Elevators</li>
                  <li>Wide Hallways</li>
                  <li>Covered Loading Areas & Docks</li>
                  <li>Business Convenience Center such as fax, internet, conference room</li>
                  <li>Payment Kiosk</li>
                  <li>Mailboxes for rent</li>
                  <li>Package Acceptance Services</li>
                  <li>UPS/Fedex shipping services</li>
                  <li>Online Billpay</li>
                </ul>
              </div>
              <ul id="convenienceItemList">
                <g:each in="${storageSiteInstance?.convenienceItems}" status="i" var="c">
                  <li id="convenienceItem_${i}">
                    <input type="text" value="${c.bullet}" style="width:200px;" name="convenienceItem_${i}"/>  <a href="#" onclick="$('convenienceItem_${i}').remove();checkAddItem('convenience');">delete</a>
                  </li>
                </g:each>
              </ul>
              <p id="convenienceItemAdd">
                <a href="#" onclick="itemAdd('convenience');checkAddItem('convenience');">Add Item</a>
              </p>
            </div>
            <div style="width:240px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'convenienceItems', 'errors')}">
              <div>
                Amenities Suggested Items:
                <ul>
                  <li>Free Move-in Truck or Rental Trucks</li>
                  <li>Wine Storage</li>
                  <li>Climate Controlled or Air Conditioned Storage</li>
                  <li>RV/Boat/Vehicle Storage</li>
                </ul>
              </div>
              <ul id="amenityItemList">
                <g:each in="${storageSiteInstance?.amenityItems}" status="i" var="c">
                  <li id="amenityItem_${i}">
                    <input type="text" value="${c.bullet}" style="width:200px;" name="amenityItem_${i}"/>  <a href="#" onclick="$('amenityItem_${i}').remove();checkAddItem('amenity');">delete</a>
                  </li>
                </g:each>
              </ul>
              <p id="amenityItemAdd">
                <a href="#" onclick="itemAdd('amenity');checkAddItem('amenity');">Add Item</a>
              </p>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:240px;">
              <label for="description">Security/Safety Features</label>
            </div>
            <div class="checkout_name" style="width:240px;">
              <label for="description">Convenience Features</label>
            </div>
            <div class="checkout_name" style="width:240px;">
              <label for="description">Amenities</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <sec:ifAnyGranted roles="ROLE_ADMIN">
          <div class="checkout_section_header">
            Site Owner/Manager
          </div>
          <div class="formInstructions">
            This ADMIN only feature allows Storitz to reassign the managerial owner of a site.  This can be used if a site is purchase
            and is now managed by a different operator.
          </div>

          <div class="checkout_fields">
            <div style="width:250px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'manager', 'errors')}">
              <g:select id="manager" name="manager.id" style="width:250px;" from="${UserRole.getUsersByRoleName('ROLE_MANAGER')}" optionValue="username" optionKey="id" value="${storageSiteInstance.getManager()?.id}" noSelection="['null': '']"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:250px;">
              <label for="manager">Manager User</label>
            </div>
            <div style="clear:both;"></div>
          </div>
          </sec:ifAnyGranted>

          <div class="checkout_section_header">
            Business Site Logo
          </div>

          <div class="checkout_fields">
            <div style="width:250px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'logo', 'errors')}">
              <g:if test="${storageSiteInstance?.logo}">
                <img src="${resource(file: storageSiteInstance.logo.src())}" alt="logo"/>
              </g:if>
              <input id="logo" type="file" style="width:250px;" name="logoFile"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:250px;">
              <label for="logo">Logo</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_section_header">
            Fees
          </div>

          <div class="checkout_fields">
            <div style="width:250px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'adminFee', 'errors')}">
              <g:textField name="adminFee" value="${storageSiteInstance?.adminFee}"/>
            </div>
            <div style="width:250px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'lockFee', 'errors')}">
              <g:textField name="lockFee" value="${storageSiteInstance?.lockFee}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:250px;">
              <label for="adminFee">Admin Fee</label>
            </div>
            <div class="checkout_name" style="width:250px;">
              <label for="lockFee">Lock Fee</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_section_header">
            Site Attributes
          </div>

          <div class="checkout_fields">
            <div style="width:250px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'isGate', 'errors')}">
              <g:checkBox name="isGate" value="${storageSiteInstance?.isGate}"/> <label for="isGate"><g:message code="storageSite.isGate.label" default="Gated Site Entry"/></label>
            </div>
            <div style="width:250px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'boxesAvailable', 'errors')}">
              <g:checkBox name="boxesAvailable" value="${storageSiteInstance?.boxesAvailable}"/> <label for="boxesAvailable"><g:message code="storageSite.boxesAvailable.label" default="Boxes Available"/></label>
            </div>
            <div style="width:250px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'requiresInsurance', 'errors')}">
              </label> <g:checkBox name="requiresInsurance" value="${storageSiteInstance?.requiresInsurance}"/> <label for="requiresInsurance"><g:message code="storageSite.requiresInsurance.label" default="Requires Insurance"/>
            </div>
            <div style="width:250px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'isKeypad', 'errors')}">
              <g:checkBox name="isKeypad" value="${storageSiteInstance?.isKeypad}"/> <label for="isKeypad"><g:message code="storageSite.isKeypad.label" default="Keypad Entry"/></label>
            </div>
            <div style="width:250px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'isUnitAlarmed', 'errors')}">
              <g:checkBox name="isUnitAlarmed" value="${storageSiteInstance?.isUnitAlarmed}"/> <label for="isUnitAlarmed"><g:message code="storageSite.isUnitAlarmed.label" default="Unit Alarmed"/></label>
            </div>
            <div style="width:250px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'isManagerOnsite', 'errors')}">
              <g:checkBox name="isManagerOnsite" value="${storageSiteInstance?.isManagerOnsite}"/> <label for="isManagerOnsite"><g:message code="storageSite.isManagerOnsite.label" default="Resident Manager"/></label>
            </div>
            <div style="width:250px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'hasElevator', 'errors')}">
              <g:checkBox name="hasElevator" value="${storageSiteInstance?.hasElevator}"/> <label for="hasElevator"><g:message code="storageSite.hasElevator.label" default="Elevator Available"/></label>
            </div>
            <div style="width:250px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'hasElevator', 'errors')}">
              <g:checkBox name="hasElevator" value="${storageSiteInstance?.hasElevator}"/> <label for="hasElevator"><g:message code="storageSite.hasElevator.label" default="Elevator Available"/></label>
            </div>
            <div style="width:250px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'hasElevator', 'errors')}">
              <g:checkBox name="isCamera" value="${storageSiteInstance?.isCamera}"/> <label for="isCamera"><g:message code="storageSite.isCamera.label" default="Video Security"/></label>
            </div>
            <div style="clear:both;height:15px;"></div>
            <div style="width:250px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'freeTruck', 'errors')}">
              <label for="freeTruck"><g:message code="storageSite.freeTruck.label" default="Free Moving Truck"/></label> <g:select name="freeTruck" from="${storitz.constants.TruckType.list()}" value="${storageSiteInstance?.freeTruck}" optionValue="display"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_section_header">
            Contacts
          </div>

          <div class="checkout_fields">
            <div style="width:500px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'contacts', 'errors')}">
              <ul>
                <g:each in="${storageSiteInstance?.contacts}" var="c">
                  <li style="list-style:none;">${c.name} - ${c.email}</li>
                </g:each>
              </ul>
            </div>
            <!-- Add new contact/manage contact -->
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_section_header">
            Special Offers
          </div>

          <div class="formInstructions">
            Check the special offers that you wish to allow on the Storitz site as Active.  You should pick 2-3 as featured offers that
            will be shown with search results and be more prominently displayed with the site information. Edit the name and description
            of the offer so that users understand the promotion.
          </div>


          <div class="checkout_fields">
            <div style="width:600px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'contacts', 'errors')}">
              <table>
                <tr>
                  <th>Active</th>
                  <th>Featured</th>
                  <th>Waive Admin Fee</th>
                  <th>Promotion Name</th>
                  <th>Description</th>
                </tr>
                <g:each in="${storageSiteInstance?.specialOffers.sort{it.id}}" var="o">
                  <tr>
                    <td><g:checkBox name="specialOffer_${o.id}" value="${o.active}"/></td>
                    <td><g:checkBox name="featuredOffer_${o.id}" value="${o.featured}"/></td>
                    <td><g:checkBox name="waiveAdmin_${o.id}" value="${o.waiveAdmin}"/></td>
                    <td><g:textField style="width:250px;" name="promoName_${o.id}" value="${o.promoName}"/> </td>
                    <td><g:textField style="width:250px;" name="promoDesc_${o.id}" value="${o.description}"/></td>
                  </tr>
                </g:each>
              </table>
            </div>
            <div style="clear:both;"></div>
          </div>

          <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_MANAGER">
          <div class="checkout_section_header">
            Rental/Lease Agreement
          </div>
          <div class="formInstructions">
            Please select the rental agreement that users will see when checking out through Storitz for this site.
          </div>

          <div class="checkout_fields">
            <div style="width:250px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'rentalAgreement', 'errors')}">
              <g:select id="rentalAgreement" name="rentalAgreement.id" style="width:250px;" from="${rentalAgreementList}" optionValue="title" optionKey="id" value="${storageSiteInstance.rentalAgreement?.id}" noSelection="['-1': '']"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:250px;">
              <label for="rentalAgreement">Rental/Lease Agreement</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          </sec:ifAnyGranted>

          <div class="checkout_section_header">
            Site Images
          </div>

          <div class="formInstructions">
            Add as many images in JPG, PNG, or GIF format that you like.  You can upload more than one at a time
            with this feature.
          </div>

          <div class="checkout_fields">
            <g:each in="${storageSiteInstance?.images}" var="i">
              <g:if test="${!i.isLogo}">
                <div id="image_${i}" style="width:250px;" class="checkout_value">
                  <img src="${resource(file: i.thumbnail())}" alt="image ${i}"/> - <g:link params="[siteImageId: i.id]" action="deleteImage" id="${storageSiteInstance?.id}" controller="storageSite">remove</g:link>
                </div>
              </g:if>
            </g:each>
            <div style="clear:both;height: 15px;"></div>
            <div style="width:250px;" class="checkout_value">
              <input type="file" style="width:250px;" name="imageFile" class="multi" accept="gif|jpg|png|jpeg"/>
            </div>
            <div style="clear:both;height: 15px;"></div>
          </div>

        </div>
        <div class="buttons">
          <span class="button"><g:actionSubmit action="update" value="${message(code: 'default.button.update.label', default: 'Update')}"/></span>
          <span class="button"><g:actionSubmit action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/></span>
          <span class="button"><g:actionSubmit action="show" value="${message(code: 'default.button.show.label', default: 'Show')}"/></span>
        </div>
      </g:uploadForm>
    </div>
  </div>
</div>
</body>
</html>
