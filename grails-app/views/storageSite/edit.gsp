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
        type: 'text'
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
    <div class="nav">
      <span class="menuButton"><a class="home" href="${createLink(controller: 'admin', action: 'index')}">Admin</a></span>
      <span class="menuButton"><g:link class="list" action="list">List Sites</g:link></span>
      <sec:ifAnyGranted roles="ROLE_ADMIN">
        <span class="menuButton"><g:link class="create" action="create">Create new Site</g:link></span>
      </sec:ifAnyGranted>
    </div>
    <div class="body">
      <h1>Edit Site</h1>
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:hasErrors bean="${storageSiteInstance}">
        <div class="errors">
          <g:renderErrors bean="${storageSiteInstance}" as="list"/>
        </div>
      </g:hasErrors>
      <g:uploadForm method="post">
        <g:hiddenField name="id" value="${storageSiteInstance?.id}"/>
        <g:hiddenField name="version" value="${storageSiteInstance?.version}"/>
        <div class="dialog">
          <table>
            <tbody>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="title"><g:message code="storageSite.title.label" default="Title"/></label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'title', 'errors')}">
                <g:textField name="title" value="${storageSiteInstance?.title}"/>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <g:message code="storageSite.securityItems.label" default="Security/Safety Features"/>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'securityItems', 'errors')}">

                <ul id="securityItemList">
                  <g:each in="${storageSiteInstance?.securityItems}" status="i" var="c">
                    <li id="securityItem_${i}">
                      <input type="text" value="${c.bullet}" class="" name="securityItem_${i}"/>  <a href="#" onclick="$('securityItem_${i}').remove();checkAddItem('security');">delete</a>
                    </li>
                  </g:each>
                </ul>
                <p id="securityItemAdd">
                  <a href="#" onclick="itemAdd('security');checkAddItem('security');">Add Item</a>
                </p>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <g:message code="storageSite.convenienceItems.label" default="Convenience Features"/>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'convenienceItems', 'errors')}">

                <ul id="convenienceItemList">
                  <g:each in="${storageSiteInstance?.convenienceItems}" status="i" var="c">
                    <li id="convenienceItem_${i}">
                      <input type="text" value="${c.bullet}" class="" name="convenienceItem_${i}"/>  <a href="#" onclick="$('convenienceItem_${i}').remove();checkAddItem('convenience');">delete</a>
                    </li>
                  </g:each>
                </ul>
                <p id="convenienceItemAdd">
                  <a href="#" onclick="itemAdd('convenience');checkAddItem('convenience');">Add Item</a>
                </p>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <g:message code="storageSite.amenityItems.label" default="Amenity Features"/>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'amenityItems', 'errors')}">

                <ul id="amenityItemList">
                  <g:each in="${storageSiteInstance?.amenityItems}" status="i" var="c">
                    <li id="amenityItem_${i}">
                      <input type="text" value="${c.bullet}" class="" name="amenityItem_${i}"/>  <a href="#" onclick="$('amenityItem_${i}').remove();checkAddItem('amenity');">delete</a>
                    </li>
                  </g:each>
                </ul>
                <p id="amenityItemAdd">
                  <a href="#" onclick="itemAdd('amenity');checkAddItem('amenity');">Add Item</a>
                </p>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="description"><g:message code="storageSite.description.label" default="Description"/></label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'description', 'errors')}">
                <fckeditor:editor
                  name="description"
                  width="680"
                  height="300"
                  toolbar="Basic">
                  ${storageSiteInstance?.description}
                </fckeditor:editor>
              </td>
            </tr>

          <sec:ifAnyGranted roles="ROLE_ADMIN">
            <tr class="prop">
              <td valign="top" class="name">
                <label for="manager.id"><g:message code="siteLink.manager.label" default="Manager"/></label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: siteLinkInstance, field: 'manager', 'errors')}">
                <g:select name="manager.id" from="${UserRole.getUsersByRoleName('ROLE_MANAGER')}" optionValue="username" optionKey="id" value="${siteUser?.user?.id}" noSelection="['null': '']"/>
                <!-- siteUser user id = ${siteUser?.user?.id} -->
              </td>
            </tr>
          </sec:ifAnyGranted>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="address"><g:message code="storageSite.address.label" default="Address"/></label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'address', 'errors')}">
                <g:textField name="address" value="${storageSiteInstance?.address}"/>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="address2"><g:message code="storageSite.address2.label" default="Address2"/></label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'address2', 'errors')}">
                <g:textField name="address2" value="${storageSiteInstance?.address2}"/>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="city"><g:message code="storageSite.city.label" default="City"/></label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'city', 'errors')}">
                <g:textField name="city" value="${storageSiteInstance?.city}"/>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="state"><g:message code="storageSite.state.label" default="State"/></label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'state', 'errors')}">
                <g:textField name="state" value="${storageSiteInstance?.state}"/>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="zipcode"><g:message code="storageSite.zipcode.label" default="Zipcode"/></label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'zipcode', 'errors')}">
                <g:textField name="zipcode" value="${storageSiteInstance?.zipcode}"/>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <g:message code="storageSite.logo.label" default="Logo"/>
              </td>
              <td valign="top" class="value">
                <g:if test="${storageSiteInstance?.logo}">
                  <img src="${resource(file: storageSiteInstance.logo.src())}" alt="logo"/>
                </g:if>
                <input type="file" name="logoFile"/>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="phone"><g:message code="storageSite.phone.label" default="Phone"/></label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'phone', 'errors')}">
                <g:textField name="phone" value="${storageSiteInstance?.phone}"/>
              </td>
            </tr>

            <tr class="prop">
              <td colspan="2" valign="top"><h3>Hours of Operation</h3></td>

            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="openWeekday"><g:message code="storageSite.openWeekday.label" default="Weekdays"/></label>
              </td>
              <td valign="top" class="name">
                <g:checkBox name="openWeekday" value="${storageSiteInstance?.openWeekday}"/> Start <input type="text" class="timeInput" id="startWeekday" name="startWeekday" value="${storageSiteInstance?.startWeekday?.format("h:mma")}"/> End <input type="text" class="timeInput" id="endWeekday" name="endWeekday" value="${storageSiteInstance?.endWeekday?.format("h:mma")}"/>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="openSaturday"><g:message code="storageSite.openSaturday.label" default="Saturdays"/></label>
              </td>
              <td valign="top" class="name">
                <g:checkBox name="openSaturday" value="${storageSiteInstance?.openSaturday}"/> Start <input type="text" class="timeInput" id="startSaturday" name="startSaturday" value="${storageSiteInstance?.startSaturday?.format("h:mma")}"/> End <input type="text" class="timeInput" id="endSaturday" name="endSaturday" value="${storageSiteInstance?.endSaturday?.format("h:mma")}"/>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="openSunday"><g:message code="storageSite.openSunday.label" default="Sundays"/></label>
              </td>
              <td valign="top" class="name">
                <g:checkBox name="openSunday" value="${storageSiteInstance?.openSunday}"/> Start <input type="text" class="timeInput" id="startSunday" name="startSunday" value="${storageSiteInstance?.startSunday?.format("h:mma")}"/> End <input type="text" class="timeInput" id="endSunday" name="endSunday" value="${storageSiteInstance?.endSunday?.format("h:mma")}"/>  
              </td>
            </tr>

            <tr class="prop">
              <td colspan="2" valign="top"><h3>Fees</h3></td>

            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="adminFee"><g:message code="storageSite.adminFee.label" default="Admin Fee"/></label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'adminFee', 'errors')}">
                <g:textField name="adminFee" value="${storageSiteInstance?.adminFee}"/>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="lockFee"><g:message code="storageSite.lockFee.label" default="Lock Fee"/></label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'lockFee', 'errors')}">
                <g:textField name="lockFee" value="${storageSiteInstance?.lockFee}"/>
              </td>
            </tr>

            <tr class="prop">
              <td colspan="2" valign="top"><h3>Attributes</h3></td>

            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="isGate"><g:message code="storageSite.isGate.label" default="Gated Site Entry"/></label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'isGate', 'errors')}">
                <g:checkBox name="isGate" value="${storageSiteInstance?.isGate}"/>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="freeTruck"><g:message code="storageSite.freeTruck.label" default="Free Moving Truck"/></label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'freeTruck', 'errors')}">
                <g:select name="freeTruck" from="${storitz.constants.TruckType.list()}" value="${storageSiteInstance?.freeTruck}" optionValue="display"/>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="boxesAvailable"><g:message code="storageSite.boxesAvailable.label" default="Boxes Available"/></label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'boxesAvailable', 'errors')}">
                <g:checkBox name="boxesAvailable" value="${storageSiteInstance?.boxesAvailable}"/>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="requiresInsurance"><g:message code="storageSite.requiresInsurance.label" default="Requires Insurance"/></label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'requiresInsurance', 'errors')}">
                <g:checkBox name="requiresInsurance" value="${storageSiteInstance?.requiresInsurance}"/>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="isKeypad"><g:message code="storageSite.isKeypad.label" default="Keypad Entry"/></label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'isKeypad', 'errors')}">
                <g:checkBox name="isKeypad" value="${storageSiteInstance?.isKeypad}"/>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="isUnitAlarmed"><g:message code="storageSite.isUnitAlarmed.label" default="Unit Alarmed"/></label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'isUnitAlarmed', 'errors')}">
                <g:checkBox name="isUnitAlarmed" value="${storageSiteInstance?.isUnitAlarmed}"/>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="isManagerOnsite"><g:message code="storageSite.isManagerOnsite.label" default="Manager Onsite"/></label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'isManagerOnsite', 'errors')}">
                <g:checkBox name="isManagerOnsite" value="${storageSiteInstance?.isManagerOnsite}"/>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <label for="isCamera"><g:message code="storageSite.isCamera.label" default="Video Security"/></label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'isCamera', 'errors')}">
                <g:checkBox name="isCamera" value="${storageSiteInstance?.isCamera}"/>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <g:message code="storageSite.contacts.label" default="Contacts"/>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'contacts', 'errors')}">

                <ul>
                  <g:each in="${storageSiteInstance?.contacts}" var="c">
                    <li><g:link controller="siteContact" action="show" id="${c.id}">${c.name} - ${c.email}</g:link></li>
                  </g:each>
                </ul>
                <g:link controller="siteContact" action="create" params="['storageSite.id': storageSiteInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'siteContact.label', default: 'com.storitz.SiteContact')])}</g:link>

              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <g:message code="storageSite.specialOffers.label" default="Special Offers"/>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'specialOffers', 'errors')}">
                <ul>
                    <li>active featured promotion description</li>
                  <g:each in="${storageSiteInstance?.specialOffers}" var="o">
                    <li>active <g:checkBox name="specialOffer_${o.id}" value="${o.active}"/> featured <g:checkBox name="featuredOffer_${o.id}" value="${o.featured}"/> <g:textField name="promoName_${o.id}" value="${o.promoName}"/> <g:textField name="promoDesc_${o.id}" value="${o.description}"/></li>
                  </g:each>
                </ul>
              </td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name">
                <g:message code="storageSite.images.label" default="Images"/>
              </td>
              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'images', 'errors')}">

                <ul>
                  <g:each in="${storageSiteInstance?.images}" var="i">
                    <g:if test="${!i.isLogo}">
                      <li><img src="${resource(file: i.thumbnail())}" alt="image ${i}"/> - <g:link params="[siteImageId: i.id]" action="deleteImage" id="${storageSiteInstance?.id}" controller="storageSite">remove</g:link></li>
                    </g:if>
                  </g:each>
                </ul>
                <div>Add as many photos as you like:</div>
                <input type="file" name="imageFile" class="multi" accept="gif|jpg|png|jpeg"/>

              </td>
            </tr>

            </tbody>
          </table>
        </div>
        <div class="buttons">
          <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}"/></span>
          <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/></span>
          <span class="button"><g:actionSubmit class="table" action="show" value="${message(code: 'default.button.show.label', default: 'Show')}"/></span>
        </div>
      </g:uploadForm>
    </div>
  </div>
</div>
</body>
</html>
