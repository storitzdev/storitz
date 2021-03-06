<%@ page import="com.storitz.UserRole; com.storitz.StorageSite" %>



<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Edit EDomico Feed" scope="request"/>
  <g:render template="/header_admin"/>
  <script type="text/javascript">
    //<![CDATA[

    function setupRemove() {
      $("a.removeLocation").click(function(event) {
        var parentDiv = $(this).parent(".newLocation");
        if (parentDiv.length > 0) {
          parentDiv.remove();
        } else {
          parentDiv = $(this).parent(".location");
          if (parentDiv.length > 0) {
            var locId = parentDiv[0].id.substring(5);
            $.ajax(
            {
              url: "${createLink(controller:'EDomico', action:'removeLocation')}",
              method:'get',
              dataType: 'json',
              data: {
                locId: locId,
              },
              success:function(ret) {
                parentDiv.remove();
              }
            });
          }
        }
        return false;
      });
    }

    $(document).ready(function() {

      setupRemove();

      $("a.addLocation").click(function(event) {
        var newCount = $("div.newLocation").length;
        var rowDiv = $("div#locationList div.newLocation:last");
        var found = false;
        if (rowDiv.length > 0) {
          rowDiv.find("input[name^='new']").each(function(index) {
            if ($(this).val() == '') {
              found = true;
            }
          });
        }
        if (found) return false;
        var newRow = $("<div>")
                .append($("<div>", {'class':'newLocation', id:'newLoc:_' + (newCount + 1)})
                .append($("<input>", {type:'text', name:'newSiteID:_' + (newCount + 1)}).css({width:'50px', 'margin-right':'20px'}))
                .append($("<input>", {type:'text', name:'newSiteName:_' + (newCount + 1)}).css({width:'150px', 'margin-right':'20px'}))
                .append($("<input>", {type:'text', name:'newAddress1:_' + (newCount + 1)}).css({width:'150px', 'margin-right':'20px'}))
                .append($("<input>", {type:'text', name:'newCity:_' + (newCount + 1)}).css({width:'150px', 'margin-right':'20px'}))
                .append($("<input>", {type:'text', name:'newState:_' + (newCount + 1)}).css({width:'50px', 'margin-right':'20px'}))
                .append($("<input>", {type:'text', name:'newZipcode:_' + (newCount + 1)}).css({width:'50px', 'margin-right':'20px'}))
                .append($("<a>", {href:'#', 'class':'removeLocation red'}).text('remove'))
                );
        $("div#locationList").append(newRow);
        $("div#locationList div:last input:first").focus();
        setupRemove();
        return false;
      });

    });

    //]]>
  </script>

</head>
<body>
<div id="body">
  <g:render template="/topnav"/>
  <div class="stcontent">
    <g:render template="/logo_bar"/>
    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Admin</a></span>
      <span class="button"><g:link action="list">List EDomico Feeds</g:link></span>
      <span class="button"><g:link action="create">Create EDomico Feed</g:link></span>
    </div>
    <div class="body">

      <div class="price_options checkout_header white">
        Edit EDomico Feed
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:hasErrors bean="${edomicoInstance}">
        <div class="errors">
          <g:renderErrors bean="${edomicoInstance}" as="list"/>
        </div>
      </g:hasErrors>
      <g:form method="post">
        <g:hiddenField name="id" value="${edomicoInstance?.id}"/>
        <g:hiddenField name="version" value="${edomicoInstance?.version}"/>

        <div class="checkout_section_header">
          Manager
        </div>

        <div class="formInstructions">
          This should be a user created with ROLE_MANAGER privileges.  This user will have the rights to assign other
          users on this feed.
        </div>

        <div class="checkout_fields">
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'manager', 'errors')}">
             <g:select name="manager.id" style="width:280px;" from="${com.storitz.UserRole.getUsersByRoleName('ROLE_MANAGER')}" optionKey="id" optionValue="username" value="${edomicoInstance?.manager?.id}" noSelection="['null': '']"/>
          </div>
          <div style="clear:both;"></div>
        </div>


        <div class="checkout_labels">
          <div class="checkout_name" style="width:300px;">
            <label for="manager.id">Manager</label>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_section_header">
          CenterShift Account Information
        </div>

        <div class="formInstructions">
          This information should come from CenterShift and the operator
        </div>




          <div class="checkout_fields">
                <div style="width:400px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'edomicoClientID', 'errors')}">
                  <g:textField name="edomicoClientID" id="edomicoClientID" style="width:380px;" value="${edomicoInstance?.edomicoClientID}"/>
                </div>
                <div style="clear:both;"></div>
              </div>

              <div class="checkout_labels">
                <div class="checkout_name" style="width:400px;">
                  <label for="edomicoClientID">Client ID</label>
                </div>
                <div style="clear:both;"></div>
              </div>

          <div class="checkout_fields">
                <div style="width:400px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'edomicoWebServicesKey', 'errors')}">
                  <g:textField name="edomicoWebServicesKey" id="edomicoWebServicesKey" style="width:380px;" value="${edomicoInstance?.edomicoWebServicesKey}"/>
                </div>
                <div style="clear:both;"></div>
              </div>

              <div class="checkout_labels">
                <div class="checkout_name" style="width:400px;">
                  <label for="edomicoWebServicesKey">Web Services Key</label>
                </div>
                <div style="clear:both;"></div>
              </div>

        <div class="checkout_section_header">
          Operator Information
        </div>

        <div class="checkout_fields">
          <div style="width:400px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'operatorName', 'errors')}">
            <g:textField name="operatorName" id="operatorName" style="width:380px;" value="${edomicoInstance?.operatorName}"/>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:400px;">
            <label for="operatorName">Operator Name</label>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_fields">
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'address1', 'errors')}">
            <g:textField id="address1" name="address1" style="width: 280px;" value="${edomicoInstance?.address1}"/>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:300px;">
            <label for="address1">Address Line 1</label>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_fields">
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'address2', 'errors')}">
            <g:textField id="address2" name="address2" style="width: 280px;" value="${edomicoInstance?.address2}"/>
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
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'city', 'errors')}">
            <g:textField id="city" name="city" style="width: 280px;" value="${edomicoInstance?.city}"/>
          </div>
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'state', 'errors')}">
            <g:textField id="state" name="state" style="width: 280px;" value="${edomicoInstance?.state}"/>
          </div>
           <div style="width:120px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'zipcode', 'errors')}">
            <g:textField id="zipcode" name="zipcode" style="width: 100px;" value="${edomicoInstance?.zipcode}"/>
          </div>

          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:300px;">
            <label for="city">City</label>
          </div>
            <div class="checkout_name" style="width:300px;">
              <label for="state">State</label>
            </div>
          <div class="checkout_name" style="width:120px;">
            <label for="zipcode">Zip Code</label>
          </div>
          <div style="clear:both;height:10px;"></div>
        </div>

          <div class="checkout_fields">
            <div style="width:300px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'reservationMoveInDescription', 'errors')}">
              <fckeditor:config CustomConfigurationsPath="${storitz.javascriptLink(src:'fckstoritz')}"/>
              <fckeditor:editor
                      name="reservationMoveInDescription"
                      width="650"
                      height="300"
                      toolbar="Storitz">
                ${edomicoInstance?.reservationMoveInDescription}
              </fckeditor:editor>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" stype="width:300px">
              <label for="reservationMoveInDescription">Reservation Move-In Description</label>
            </div>
            <div style="clear:both;"></div>
          </div>

        <div class="checkout_fields">
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'transactionBoxLink', 'errors')}">
            <g:textField id="transactionBoxLink" name="transactionBoxLink" style="width: 280px;" value="${edomicoInstance?.transactionBoxLink}"/>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" stype="width:300px">
            <label for="transactionBoxLink">Transaction Box Link</label>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_fields">
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'transactionBoxBody', 'errors')}">
            <fckeditor:config CustomConfigurationsPath="${storitz.javascriptLink(src:'fckstoritz')}"/>
            <fckeditor:editor
                    name="transactionBoxBody"
                    width="650"
                    height="300"
                    toolbar="Storitz">
              ${edomicoInstance?.transactionBoxBody}
            </fckeditor:editor>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" stype="width:300px">
            <label for="transactionBoxBody">Transaction Box Body</label>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_section_header">
          Commission Schedule
        </div>

        <div class="checkout_fields">
          <div style="width:400px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'commissionSchedule', 'errors')}">
            <g:select name="commissionSchedule.id" id="commissionSchedule" class="validate-selection" style="width:200px;" from="${commissionScheduleList}" value="${edomicoInstance?.commissionSchedule}" optionKey="id" optionValue="scheduleName"/>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:400px;">
            <label for="commissionSchedule">Commission Schedule</label>
          </div>
          <div style="clear:both;"></div>
        </div>



          <div class="checkout_section_header">
            Add/Edit Locations
          </div>
          <div style="margin-top:10px;">
            <div style="font-weight:bold; width: 50px;margin-right: 20px;" class="left">Site ID</div>
            <div style="font-weight:bold; width: 150px;margin-right: 20px;" class="left">Site Name</div>
            <div style="font-weight:bold; width: 150px;margin-right: 20px;" class="left">Address1</div>
            <div style="font-weight:bold; width: 150px;margin-right: 20px;" class="left">City</div>
            <div style="font-weight:bold; width: 50px;margin-right: 20px;" class="left">State</div>
            <div style="font-weight:bold; width: 50px;margin-right: 20px;" class="left">Zip</div>
            <div style="clear:both;height: 10px;"></div>
          </div>
          <div id="locationList">
            <g:each in="${edomicoInstance.locations}" status="i" var="loc">
              <div id="loc:_${loc.id}" class="location">
                <g:textField name="siteid:_${loc.id}" value="${loc.siteID}" style="width:50px; margin-right:20px;"/>
                <g:textField name="sitename:_${loc.id}" value="${loc.siteName}" style="width:150px; margin-right:20px;"/>
                <g:textField name="address1:_${loc.id}" value="${loc.address1}" style="width:150px; margin-right:20px;"/>
                <g:textField name="city:_${loc.id}" value="${loc.city}" style="width:150px; margin-right:20px;"/>
                <g:textField name="state:_${loc.id}" value="${loc.state}" style="width:50px; margin-right:20px;"/>
                <g:textField name="zipcode:_${loc.id}" value="${loc.zipcode}" style="width:50px; margin-right:20px;"/>
                <a href="#" class="removeLocation red">remove</a>
              </div>
            </g:each>
          </div>
          <div class="buttons">
            <span class="button"><a href="#" class="addLocation">Add Location</a></span>
          </div>










        <div class="buttons">
          <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}"/></span>
          <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/></span>
        </div>
      </g:form>
      <g:uploadForm action="uploadLogo" method="post" id="${edomicoInstance?.id}">
        <div class="checkout_section_header">
          Upload Logo
        </div>
        <div class="formInstructions">
          Uploading a logo here will apply it to all the sites that belong to this feed.  Be careful with feeds that may have more than one brand.
        </div>

        <div class="checkout_fields">
          <div style="width:400px;" class="checkout_value">
            <input type="file" name="logoFile" id="logo"/>
          </div>
          <div style="clear:both;"></div>
        </div>
        <div class="checkout_labels">
          <div class="checkout_name" style="width:400px;">
            <label for="logo">Logo</label>
          </div>
          <div style="clear:both;"></div>
        </div>
        <div class="buttons">
          <span class="button"><input class="save" type="submit" value="Upload"/></span>
        </div>
      </g:uploadForm>

    </div>
  </div>
</div>
</body>
<p:renderDependantJavascript/>
</html>
