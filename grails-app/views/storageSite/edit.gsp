<%@ page import="com.storitz.User; com.storitz.UserRole" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Edit Storage Site" scope="request"/>
  <p:css name="timepicker" />
  <g:render template="/header_admin"/>

  <p:dependantJavascript>
  <p:javascript src="jquery.MetaData"/>
  <p:javascript src="jquery.MultiFile"/>
  <p:javascript src="jquery-ui-timepicker-addon.min"/>
  <script type="text/javascript">
    //<![CDATA[

    $(document).ready(function() {

      setupTimePickers();
      setupContactSelector();
    });

    function setupContactSelector() {
      $("input#contactName").autocomplete({source:"${createLink(controller:'user', action:'autocompleteUser')}"});
    }

    function setupTimePickers() {
      $("input#startMonday").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:8, minuteGrid:15});
      $("input#endMonday").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:18,minuteGrid:15});
      $("input#startTuesday").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:8, minuteGrid:15});
      $("input#endTuesday").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:18,minuteGrid:15});
      $("input#startWednesday").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:8, minuteGrid:15});
      $("input#endWednesday").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:18,minuteGrid:15});
      $("input#startThursday").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:8, minuteGrid:15});
      $("input#endThursday").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:18,minuteGrid:15});
      $("input#startFriday").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:8, minuteGrid:15});
      $("input#endFriday").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:18,minuteGrid:15});
      $("input#startSaturday").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:8, minuteGrid:15});
      $("input#endSaturday").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:18,minuteGrid:15});
      $("input#startSunday").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:8, minuteGrid:15});
      $("input#endSunday").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:18,minuteGrid:15});

      $("input#startMondayGate").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:8, minuteGrid:15});
      $("input#endMondayGate").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:18,minuteGrid:15});
      $("input#startTuesdayGate").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:8, minuteGrid:15});
      $("input#endTuesdayGate").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:18,minuteGrid:15});
      $("input#startWednesdayGate").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:8, minuteGrid:15});
      $("input#endWednesdayGate").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:18,minuteGrid:15});
      $("input#startThursdayGate").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:8, minuteGrid:15});
      $("input#endThursdayGate").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:18,minuteGrid:15});
      $("input#startFridayGate").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:8, minuteGrid:15});
      $("input#endFridayGate").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:18,minuteGrid:15});
      $("input#startSaturdayGate").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:8, minuteGrid:15});
      $("input#endSaturdayGate").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:18,minuteGrid:15});
      $("input#startSundayGate").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:8, minuteGrid:15});
      $("input#endSundayGate").timepicker({timeFormat:"hh:mmTT", ampm:true, hour:18,minuteGrid:15});
    }

    function checkAddItem(type) {
      var listName = type + 'ItemList';
      var listAdd = type + 'ItemAdd';
      if ($('#' + listName).children().length >= 10) {
        $('#' + listAdd).hide();
      }
      return false
    }

    function itemAdd(type) {
      var listName = type + 'ItemList';
      var lastInput = $('#' + listName + '> li:last > input');
      var lastInputName = lastInput.attr('name');
      var newItem = 1
      if (lastInputName) {
        if (lastInput.val().length == 0) {
          return
        }
        newItem = parseInt(lastInputName.substr(lastInputName.indexOf('_') + 1)) + 1;
      }
      var itemName = type + 'Item_' + newItem;
      var bulletId = type + 'BulletItem_' + newItem;
      var liElem = $('<li>', {
        id: bulletId
      })
      .append(
        $('<input>', {
          id: itemName,
          name: itemName,
          type: 'text',
          style: 'width:200px;'
        }))
      .append(
        $('<a>', {
          href: '#',
          text: 'delete',
          click: function() {
            $('#' + bulletId).remove();
            checkAddItem(type);
            return false;
          }
        })
      );
      $('#' + listName).append(liElem);
      $('#' + itemName).focus();
    }
    
    function addContact() {
      $.ajax(
      {
        url: "${createLink(controller:'storageSite', action:'addContact')}",
        method:'get',
        dataType: 'json',
        data: {
          id: ${storageSiteInstance.id},
          email:$("#contactName").val()
        },
        success:function(ret) {
          if (ret.userId > 0) {
              var itemId = 'contact_' + ret.userId;
              var newItem = $('<li>', {id: itemId}).text(ret.username + ' - ' + ret.email + ' - ' + ret.notificationTypes)
                .append($('<div>', { 'class': "right" })
                .append($('<a>',
                  {
                    href: '#',
                    click: function() {
                      deleteContact(ret.userId);
                      return false;
                    }
                  })
                  .text('remove')).append($('<div>', {style:'clear:both;'})
              ));
              $('#contacts').append(newItem);
          }
        }
      });
    }

    function addCaption(form, imgId) {
      var data = form.serialize();
      $.ajax(
      {
        url: "${createLink(controller:'storageSite', action:'addCaptionAndTag')}",
        method:'post',
        dataType: 'json',
        data: data,
        success:function(ret) {
          alert('submitted');
        }
      });
      return false;
    }

    function deleteContact(contactId) {
      $.ajax(
      {
        url:"${createLink(controller:'storageSite', action:'removeContact')}",
        method:'get',
        dataType: 'json',
        data: {
          id: ${storageSiteInstance.id},
          userId:contactId
        },
        success: function(ret) {
          $("#contact_" + contactId).remove();
        }
      });
    }

    function deleteImage(imgId) {
      $.ajax(
      {
        url: "${createLink(controller:'storageSite', action:'deleteImage')}",
        method: 'get',
        dataType: 'json',
        data: {
          id: ${storageSiteInstance.id},
          siteImageId:imgId
        },
        success: function(ret) {
          $("#image_" + imgId).remove();
        }
      });
    }

    function defaultImage(imgId) {
      var newDefault = 'default_' + imgId;
      $.ajax(
      {
        url: "${createLink(controller:'storageSite', action:'defaultImage')}",
        method:'get',
        dataType: 'json',
        data: {id: ${storageSiteInstance.id}, siteImageId:imgId },
        success:function(ret) {
          $('div[id^=default_]').each(function(elem) {
            if ($(this).attr('id') == newDefault) {
              $(this).text('Default Image');
            } else {
              var linkId = $(this).attr('id').substring(8);
              var link = $('<a>', {
                href:"#",
                click: function() {
                  defaultImage(linkId);
                  return false;
                }
              }).text('set as default');
              $(this).html(link);
            }
          });
        }
      });
    }

    //]]>
  </script>
  </p:dependantJavascript>

</head>
<body>
<div id="body">
  <g:render template="/topnav"/>
  <div class="stcontent">
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

          <sec:ifAnyGranted roles="ROLE_ADMIN, ROLE_MANAGER">
            <div class="checkout_section_header">
              Bank Account Information
            </div>

            <div class="formInstructions">
              Please enter the bank account information for this site.  It will be used to make ACH transfers from Storitz to this account
              for Move-Ins.  Make sure the 9 digit ABA (Routing) code is accurate and that the account number is entered as numbers without dashes or spaces.
            </div>

            <div class="checkout_fields">
              <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance.bankAccount, field: 'accountName', 'errors')}">
                <input type="text" style="width: 180px;" id="bankAccount.accountName" name="bankAccount.accountName" value="${storageSiteInstance?.bankAccount?.accountName}"/>
              </div>
              <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance.bankAccount, field: 'bankName', 'errors')}">
                <input type="text" style="width: 180px;" id="bankAccount.bankName" name="bankAccount.bankName" value="${storageSiteInstance?.bankAccount?.bankName}"/>
              </div>
              <div style="clear:both;"></div>
            </div>

            <div class="checkout_labels">
              <div class="checkout_name" style="width:200px;">
                <label for="bankAccount.accountName">Name on Account</label>
              </div>
              <div class="checkout_name" style="width:200px;">
                <label for="bankAccount.bankName">Bank Name</label>
              </div>
              <div style="clear:both;"></div>
            </div>

            <div class="checkout_fields">
              <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance.bankAccount, field: 'routeCode', 'errors')}">
                <input type="text" style="width: 180px;" id="bankAccount.routeCode" name="bankAccount.routeCode" value="${storageSiteInstance?.bankAccount?.routeCode}"/>
              </div>
              <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance.bankAccount, field: 'acctNo', 'errors')}">
                <input type="text" style="width: 180px;" id="bankAccount.acctNo" name="bankAccount.acctNo" value="${storageSiteInstance?.bankAccount?.acctNo}"/>
              </div>
              <div style="clear:both;"></div>
            </div>

            <div class="checkout_labels">
              <div class="checkout_name" style="width:200px;">
                <label for="bankAccount.routeCode">ABA/Route Code (9-digit)</label>
              </div>
              <div class="checkout_name" style="width:200px;">
                <label for="bankAccount.acctNo">Account Number</label>
              </div>
              <div style="clear:both;height:10px"></div>
            </div>

          </sec:ifAnyGranted>

          <div class="checkout_section_header">
            Hours of Operation
          </div>

          <div class="checkout_fields">
            <div style="width:150px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'openMonday', 'errors')}">
              <g:checkBox name="openMonday" value="${storageSiteInstance?.openMonday}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'startMonday', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="startMonday" name="startMonday" value="${storageSiteInstance?.startMonday?.format("h:mma")}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'endMonday', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="endMonday" name="endMonday" value="${storageSiteInstance?.endMonday?.format("h:mma")}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:150px;">
              <label for="openMonday">Open Monday</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="startMonday">Start</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="endMonday">End</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:150px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'openTuesday', 'errors')}">
              <g:checkBox name="openTuesday" value="${storageSiteInstance?.openTuesday}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'startTuesday', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="startTuesday" name="startTuesday" value="${storageSiteInstance?.startTuesday?.format("h:mma")}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'endTuesday', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="endTuesday" name="endTuesday" value="${storageSiteInstance?.endTuesday?.format("h:mma")}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:150px;">
              <label for="openTuesday">Open Tuesday</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="startTuesday">Start</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="endTuesday">End</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:150px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'openWednesday', 'errors')}">
              <g:checkBox name="openWednesday" value="${storageSiteInstance?.openWednesday}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'startWednesday', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="startWednesday" name="startWednesday" value="${storageSiteInstance?.startWednesday?.format("h:mma")}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'endWednesday', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="endWednesday" name="endWednesday" value="${storageSiteInstance?.endWednesday?.format("h:mma")}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:150px;">
              <label for="openWednesday">Open Wednesday</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="startWednesday">Start</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="endWednesday">End</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:150px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'openThursday', 'errors')}">
              <g:checkBox name="openThursday" value="${storageSiteInstance?.openThursday}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'startThursday', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="startThursday" name="startThursday" value="${storageSiteInstance?.startThursday?.format("h:mma")}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'endThursday', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="endThursday" name="endThursday" value="${storageSiteInstance?.endThursday?.format("h:mma")}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:150px;">
              <label for="openThursday">Open Thursday</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="startThursday">Start</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="endThursday">End</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:150px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'openFriday', 'errors')}">
              <g:checkBox name="openFriday" value="${storageSiteInstance?.openFriday}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'startFriday', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="startFriday" name="startFriday" value="${storageSiteInstance?.startFriday?.format("h:mma")}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'endFriday', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="endFriday" name="endFriday" value="${storageSiteInstance?.endFriday?.format("h:mma")}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:150px;">
              <label for="openFriday">Open Friday</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="startFriday">Start</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="endFriday">End</label>
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
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'startMondayGate', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="startMondayGate" name="startMondayGate" value="${storageSiteInstance?.startMondayGate?.format("h:mma")}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'endMondayGate', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="endMondayGate" name="endMondayGate" value="${storageSiteInstance?.endMondayGate?.format("h:mma")}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:150px;">
              Monday Gate Hours
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="startMondayGate">Start</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="endMondayGate">End</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:150px;" class="checkout_value">
              &nbsp;
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'startTuesdayGate', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="startTuesdayGate" name="startTuesdayGate" value="${storageSiteInstance?.startTuesdayGate?.format("h:mma")}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'endTuesdayGate', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="endTuesdayGate" name="endTuesdayGate" value="${storageSiteInstance?.endTuesdayGate?.format("h:mma")}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:150px;">
              Tuesday Gate Hours
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="startTuesdayGate">Start</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="endTuesdayGate">End</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:150px;" class="checkout_value">
              &nbsp;
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'startWednesdayGate', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="startWednesdayGate" name="startWednesdayGate" value="${storageSiteInstance?.startWednesdayGate?.format("h:mma")}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'endWednesdayGate', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="endWednesdayGate" name="endWednesdayGate" value="${storageSiteInstance?.endWednesdayGate?.format("h:mma")}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:150px;">
              Wednesday Gate Hours
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="startWednesdayGate">Start</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="endWednesdayGate">End</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:150px;" class="checkout_value">
              &nbsp;
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'startThursdayGate', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="startThursdayGate" name="startThursdayGate" value="${storageSiteInstance?.startThursdayGate?.format("h:mma")}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'endThursdayGate', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="endThursdayGate" name="endThursdayGate" value="${storageSiteInstance?.endThursdayGate?.format("h:mma")}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:150px;">
              Thursday Gate Hours
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="startThursdayGate">Start</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="endThursdayGate">End</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:150px;" class="checkout_value">
              &nbsp;
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'startFridayGate', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="startFridayGate" name="startFridayGate" value="${storageSiteInstance?.startFridayGate?.format("h:mma")}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'endFridayGate', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="endFridayGate" name="endFridayGate" value="${storageSiteInstance?.endFridayGate?.format("h:mma")}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:150px;">
              Friday Gate Hours
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="startFridayGate">Start</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="endFridayGate">End</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:150px;" class="checkout_value">
              &nbsp;
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'startSaturdayGate', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="startSaturdayGate" name="startSaturdayGate" value="${storageSiteInstance?.startSaturdayGate?.format("h:mma")}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'endSaturdayGate', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="endSaturdayGate" name="endSaturdayGate" value="${storageSiteInstance?.endSaturdayGate?.format("h:mma")}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:150px;">
              Saturday Gate Hours
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="startSaturdayGate">Start</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="endSaturdayGate">End</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:150px;" class="checkout_value">
              &nbsp;
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'startSundayGate', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="startSundayGate" name="startSundayGate" value="${storageSiteInstance?.startSundayGate?.format("h:mma")}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'endSundayGate', 'errors')}">
              <input type="text" class="timeInput" style="width: 180px;" id="endSundayGate" name="endSundayGate" value="${storageSiteInstance?.endSundayGate?.format("h:mma")}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:150px;">
              Sunday Gate Hours
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="startSundayGate">Start</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="endSundayGate">End</label>
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
            <div style="clear:both;height:10px;"></div>
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
              <fckeditor:config CustomConfigurationsPath="${storitz.javascriptLink(src:'fckstoritz')}" />
              <fckeditor:editor
                name="description"
                width="650"
                height="300"
                toolbar="Storitz">
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
                    <input type="text" value="${c.bullet}" style="width:200px;" name="securityItem_${i}"/>  <a href="#" onclick="$('#securityItem_${i}').remove();checkAddItem('security');">delete</a>
                  </li>
                </g:each>
              </ul>
              <p id="securityItemAdd">
                <a href="#" onclick="itemAdd('security');checkAddItem('security');return false;">Add Item</a>
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
                    <input type="text" value="${c.bullet}" style="width:200px;" name="convenienceItem_${i}"/>  <a href="#" onclick="$('#convenienceItem_${i}').remove();checkAddItem('convenience');">delete</a>
                  </li>
                </g:each>
              </ul>
              <p id="convenienceItemAdd">
                <a href="#" onclick="itemAdd('convenience');checkAddItem('convenience'); return false;">Add Item</a>
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
                    <input type="text" value="${c.bullet}" style="width:200px;" name="amenityItem_${i}"/>  <a href="#" onclick="$('#amenityItem_${i}').remove();checkAddItem('amenity');">delete</a>
                  </li>
                </g:each>
              </ul>
              <p id="amenityItemAdd">
                <a href="#" onclick="itemAdd('amenity');checkAddItem('amenity'); return false;">Add Item</a>
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
            <div style="width:210px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'adminFee', 'errors')}">
              <g:textField name="adminFee" style="width:190px;" value="${storageSiteInstance?.adminFee}"/>
            </div>
            <div style="width:210px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'deposit', 'errors')}">
              <g:textField name="deposit" style="width:190px;" value="${storageSiteInstance?.deposit}"/>
            </div>
            <div style="width:210px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'lockFee', 'errors')}">
              <g:textField name="lockFee" style="width:190px;" value="${storageSiteInstance?.lockFee}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:210px;">
              <label for="adminFee">Admin Fee</label>
            </div>
            <div class="checkout_name" style="width:210px;">
              <label for="deposit">Deposit</label>
            </div>
            <div class="checkout_name" style="width:210px;">
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
              <g:checkBox name="requiresInsurance" value="${storageSiteInstance?.requiresInsurance}"/> <label for="requiresInsurance"><g:message code="storageSite.requiresInsurance.label" default="Requires Insurance"/>
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
            <div style="width:250px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'isCamera', 'errors')}">
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
              <ul id="contacts">
                <g:each var="contact" in="${contacts}">
                  <li id="contact_${contact.id}">
                    ${contact.username} - ${contact.email} - ${User.showNotificationTypes(contact)}
                    <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_MANAGER">
                      <div class="right">
                        <a href="#" onclick="deleteContact(${contact.id}); return false;">remove</a>
                      </div>
                      <div style="clear:both;"></div>
                    </sec:ifAnyGranted>
                  </li>
                </g:each>
              </ul>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div class="checkout_labels checkout_name" style="margin: 2px 10px 0 0">
              <label for="contactName">Search for Contact</label>
            </div>
            <div style="width:300px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'rentalAgreement', 'errors')}">
              <input type="text" style="width: 300px;" id="contactName" />
            </div>
            <div class="checkout_value">
              <span class="buttonSmall"><a href="#" onclick="addContact(); return false;">Add Contact</a></span>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_section_header">
            Special Offers
          </div>

          <div class="formInstructions">
            Check the special offers that you wish to allow on the Storitz site as active.  You should pick 2-3 as featured offers that
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
            <div style="clear:both;height: 15px;"></div>
          </div>

          <div class="checkout_section_header">
            Property Protection
          </div>

          <div class="formInstructions">
            Check the property protection that you wish to allow on the Storitz site as active.
          </div>


          <div class="checkout_fields">
            <div style="width:600px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'contacts', 'errors')}">
              <table>
                <tr>
                  <th>Active</th>
                  <th>Description</th>
                </tr>
                <g:each in="${storageSiteInstance?.insurances.sort{it.id}}" var="ins">
                  <tr>
                    <td><g:checkBox name="insurance_${ins.id}" value="${ins.active}"/></td>
                    <td><g:formatNumber number="${ins.premium}" type="currency" currencyCode="USD" />/mo. Coverage: <g:formatNumber number="${ins.totalCoverage}" type="currency" currencyCode="USD" /> Theft: <g:formatNumber number="${ins.percentTheft}" type="percent" /></td>
                  </tr>
                </g:each>
              </table>
            </div>
            <div style="clear:both;height: 15px;"></div>
          </div>

          <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_MANAGER">
            <div class="checkout_section_header">
              Disable Rental Insurance Waiver
            </div>
            <div class="formInstructions">
              Check this box if your site requires that a user purchase one of the insurance options provided.
            </div>
            <div class="checkout_fields">
              <div style="width:400px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'noInsuranceWaiver', 'errors')}">
                <g:checkBox name="noInsuranceWaiver" value="${storageSiteInstance?.noInsuranceWaiver}"/>&nbsp;Require Insurance Purchase with rental
              </div>
              <div style="clear:both;height: 15px;"></div>
            </div>

            <div class="checkout_section_header">
              Use Prorated Calculations
            </div>
            <div class="formInstructions">
              Check this box if your site uses prorating in the rental calculations.  Uncheck if you use anniversary calculations.
            </div>
            <div class="checkout_fields">
              <div style="width:400px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'useProrating', 'errors')}">
                <g:checkBox name="useProrating" value="${storageSiteInstance?.useProrating}"/>&nbsp;Use Prorating for Rental Calculations
              </div>
              <div style="clear:both;height: 15px;"></div>
            </div>

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

            <div class="checkout_section_header">
              Disable Site
            </div>
            <div class="formInstructions">
              Check this box if you want the site disabled from listings.
            </div>

            <div class="checkout_fields">
              <div style="width:150px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'disabled', 'errors')}">
                <g:checkBox name="disabled" value="${storageSiteInstance?.disabled}"/>&nbsp;Disabled
              </div>
              <div style="clear:both;height: 15px;"></div>
            </div>

          </sec:ifAnyGranted>

          <sec:ifAnyGranted roles="ROLE_ADMIN">
            <div class="checkout_section_header">
              Use Net Commission
            </div>
            <div class="formInstructions">
              Check this box if this site will be paid net commission every month.  Default is to pay gross and invoice for commission.
            </div>
            <div class="checkout_fields">
              <div style="width:400px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'netCommission', 'errors')}">
                <g:checkBox name="netCommission" value="${storageSiteInstance?.netCommission}"/>&nbsp;Use Net Commission Payments for ACH
              </div>
              <div style="clear:both;height: 15px;"></div>
            </div>


          </sec:ifAnyGranted>
          <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_MANAGER">
            <div class="checkout_section_header">
              Allow Push Pricing
            </div>
            <div class="formInstructions">
              Check this box if this site will allow us to use their push price on our website.
            </div>
            <div class="checkout_fields">
              <div style="width:400px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'allowPushPrice', 'errors')}">
                <g:checkBox name="netCommission" value="${storageSiteInstance?.allowPushPrice}"/>&nbsp;Allow Push Pricing
              </div>
              <div style="clear:both;height: 15px;"></div>
            </div>
          </sec:ifAnyGranted>


          <div class="checkout_section_header">
            Site Images
          </div>

          <div class="formInstructions">
            Add as many images in JPG, PNG, or GIF format that you like.  You can upload more than one at a time
            with this feature.  You can also load a zip archive of image files and it will process all of them.
          </div>

          <div id="siteImages" class="checkout_fields">
            <g:each in="${storageSiteInstance?.images}" var="i">
              <g:if test="${!i.isLogo}">
                <div id="image_${i.id}" style="width:300px;" class="checkout_value">
                  <div class="left" style="margin-right: 10px;">
                    <img src="${resource(file: i.thumbnail())}" alt="image ${i.id}"/>
                  </div>
                  <div class="left">
                    <div>
                      <a href="#" onclick="deleteImage(${i.id}); return false;">remove</a>
                    </div>
                    <div id="default_${i.id}">
                      <g:if test="${i.isCover}">
                        Default Image
                      </g:if>
                      <g:else>
                        <a href="#" onclick="defaultImage(${i.id}); return false;">set as default</a>
                      </g:else>
                    </div>
                  </div>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                  <div style="clear:both;">
                      <div style="clear:both;"><div class="left" style="width:60px;">Caption:</div><div class="left"><input name="caption_${i.id}" style="width: 200px;" value="${i.caption}"></div></div>
                      <div style="clear:both;"><div class="left" style="width:60px;">Tags:</div><div class="left"><input name="tags_${i.id}" style="width: 200px;" value="${i.tags}"></div></div>
                      <div id="captionResult_${i.id}" style="clear:both;"></div>
                  </div>
                </sec:ifAnyGranted>
                </div>
              </g:if>
            </g:each>
            <div style="clear:both;height: 15px;"></div>
            <div style="width:250px;" class="checkout_value">
              <input type="file" style="width:250px;" name="imageFile" class="multi" accept="gif|jpg|png|jpeg|zip"/>
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
<p:renderDependantJavascript />
</html>
