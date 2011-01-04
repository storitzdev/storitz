<%@ page import="com.storitz.UserRole; com.storitz.StorageSite" %>



<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Edit QuikStor Feed" scope="request"/>
  <g:render template="/header"/>

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
              url: "${createLink(controller:'quikStor', action:'removeLocation')}",
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
                .append($("<div>", {'class':'newLocation', id:'newLoc:_'+(newCount+1)})
                  .append($("<input>", {type:'text', name:'newSitename:_'+(newCount+1)}).css({width:'150px', 'margin-right':'20px'}))
                  .append($("<input>", {type:'text', name:'newUsername:_'+(newCount+1)}).css({width:'150px', 'margin-right':'20px'}))
                  .append($("<input>", {type:'text', name:'newPassword:_'+(newCount+1)}).css({width:'150px', 'margin-right':'20px'}))
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
    <span class="button"><a href="${createLink(controller:'admin', action:'index')}">Admin</a></span>
    <span class="button"><g:link action="list">List QuikStor Feeds</g:link></span>
    <span class="button"><g:link action="create">Create QuikStor Feed</g:link></span>
  </div>
  <div class="body">

    <div class="price_options checkout_header white">
      Edit QuikStor Feed
    </div>

    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${quikStorInstance}">
      <div class="errors">
        <g:renderErrors bean="${quikStorInstance}" as="list"/>
      </div>
    </g:hasErrors>
    <g:form method="post">
      <g:hiddenField name="id" value="${quikStorInstance?.id}"/>
      <g:hiddenField name="version" value="${quikStorInstance?.version}"/>

      <div class="checkout_section_header">
        URL
      </div>

      <div class="formInstructions">
        This should be the URL for the WSDL service from QuikStor. Most sites use the default
      </div>

      <div class="checkout_fields">
        <div style="width:400px;" class="checkout_value ${hasErrors(bean: quikStorInstance, field: 'manager', 'errors')}">
          <g:textField name="url" id="url" style="width:380px;" value="${quikStorInstance?.url}"/>
        </div>
        <div style="clear:both;"></div>
      </div>

      <div class="checkout_labels">
        <div class="checkout_name" style="width:300px;">
          <label for="url">WSDL Url</label>
        </div>
        <div style="clear:both;"></div>
      </div>
      <div class="checkout_section_header">
        Manager
      </div>

      <div class="formInstructions">
        This should be a user created with ROLE_MANAGER privileges.  This user will have the rights to assign other
        users on this feed.
      </div>

      <div class="checkout_fields">
        <div style="width:300px;" class="checkout_value ${hasErrors(bean: quikStorInstance, field: 'manager', 'errors')}">
          <g:select name="manager.id" style="width:280px;" from="${com.storitz.UserRole.getUsersByRoleName('ROLE_MANAGER')}" optionKey="id" optionValue="username" value="${quikStorInstance?.manager?.id}" noSelection="['null': '']"/>
        </div>
        <div style="clear:both;"></div>
      </div>

      <div class="checkout_labels">
        <div class="checkout_name" style="width:300px;">
          <label for="manager.id">Manager</label>
        </div>
        <div style="clear:both;height: 10px;"></div>
      </div>

      <div class="checkout_section_header">
        Operator Information
      </div>

      <div class="checkout_fields">
        <div style="width:400px;" class="checkout_value ${hasErrors(bean: quikStorInstance, field: 'operatorName', 'errors')}">
          <g:textField name="operatorName" id="operatorName" style="width:380px;" value="${quikStorInstance?.operatorName}"/>
        </div>
        <div style="clear:both;"></div>
      </div>

      <div class="checkout_labels">
        <div class="checkout_name" style="width:400px;">
          <label for="operatorName">Operator Name</label>
        </div>
        <div style="clear:both;height: 10px;"></div>
      </div>

      <div class="checkout_section_header">
        Add/Edit Locations
      </div>
      <div style="margin-top:10px;">
        <div style="font-weight:bold; width: 150px;margin-right: 20px;" class="left">Site Name</div>
        <div style="font-weight:bold; width: 150px;margin-right: 20px;" class="left">User</div>
        <div style="font-weight:bold; width: 150px;margin-right: 20px;" class="left">Password</div>
        <div style="clear:both;height: 10px;"></div>
      </div>
      <div id="locationList">
      <g:each in="${quikStorInstance.locations}" status="i" var="loc">
        <div id="loc:_${loc.id}" class="location">
          <g:textField name="sitename:_${loc.id}" value="${loc.sitename}" style="width:150; margin-right:20px;"/>
          <g:textField name="username:_${loc.id}" value="${loc.username}" style="width:150; margin-right:20px;"/>
          <g:textField name="password:_${loc.id}" value="${loc.password}" style="width:150; margin-right:20px;"/>
          <a href="#" class="removeLocation red">remove</a>
        </div>
      </g:each>
      </div>
      <div class="buttons">
        <span class="button"><a href="#" class="addLocation">Add Location</a></span>
      </div>

      <div style="clear:both;height: 20px;"></div>
      <div class="buttons">
        <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}"/></span>
        <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/></span>
      </div>
    </g:form>

    <g:uploadForm action="uploadLogo" method="post" id="${quikStorInstance?.id}">
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
        <span class="button"><input class="save" type="submit" value="Upload" /></span>
      </div>
    </g:uploadForm>

  </div>
</div>
</div>
</body>
<p:renderDependantJavascript />
</html>
