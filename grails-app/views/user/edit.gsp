<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="User List" scope="request"/>
  <g:render template="/header"/>

  <script type="text/javascript">
    //<![CDATA[
    //]]>
  </script>

</head>
<body>
<div id="body">
  <g:render template="/topnav"/>
  <div class="stcontent">
    <g:render template="/logo_bar"/>

    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><g:link action="list">User List</g:link></span>
      <span class="button"><g:link action="create">New User</g:link></span>
    </div>

    <div class="body">

      <div class="price_options checkout_header white">
        Edit User
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:hasErrors bean="${person}">
        <div class="errors">
          <g:renderErrors bean="${person}" as="list"/>
        </div>
      </g:hasErrors>

      <g:form method="post" id="${person?.id}">
        <input type="hidden" name="version" value="${person?.version}"/>
        <div class="dialog">

          <div class="formInstructions">
            Edit the information for the user below - make sure the passwords match if you are changing that field.
          </div>

          <div class="checkout_section_header">
            User Name and Real Name
          </div>

          <div class="checkout_fields">
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: person, field: 'username', 'errors')}">
              <g:textField id="username" name="username" style="width: 180px;" value="${fieldValue(bean:person,field:'username')}"/>
            </div>
            <div style="width:300px;" class="checkout_value ${hasErrors(bean: person, field: 'userRealName', 'errors')}">
              <g:textField id="userRealName" name="userRealName" style="width: 280px;" value="${fieldValue(bean:person,field:'userRealName')}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:200px;">
              <label for="username">User Name</label>
            </div>
            <div class="checkout_name" style="width:300px;">
              <label for="userRealName">User Real Name</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_section_header">
            Password
          </div>

          <div class="checkout_fields">
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: person, field: 'passwd', 'errors')}">
              <input type="password" id="passwd" name="passwd" style="width: 180px;" value="${fieldValue(bean: person, field: 'password')}"/>
            </div>
            <div style="width:200px;" class="checkout_value ${hasErrors(bean: person, field: 'repasswd', 'errors')}">
              <input type="password" id="repasswd" name="repasswd" style="width: 180px;" value="${fieldValue(bean: person, field: 'password')}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:200px;">
              <label for="passwd">Password</label>
            </div>
            <div class="checkout_name" style="width:200px;">
              <label for="repasswd">Re-enter Password</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <sec:ifAnyGranted roles="ROLE_ADMIN">

            <div class="checkout_section_header">
              Manager
            </div>

            <div class="checkout_fields">
              <div style="width:300px;" class="checkout_value ${hasErrors(bean: person, field: 'manager', 'errors')}">
                <g:select style="width:280px;" from="${com.storitz.User.list()}" value="${person?.manager?.id}"
                        optionKey="id" optionValue="userRealName" name="manager.id"
                        noSelection="['null':'No manager selected']"/>
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
              Roles
            </div>

            <div class="checkout_fields">
              <div style="width:650px;" class="checkout_value ${hasErrors(bean: person, field: 'authorities', 'errors')}">
                <g:each var="role" in="${roleMap.keySet()}">
                  <div style="margin: 0 1.5em;" class="left">
                    <g:checkBox name="${role.authority}" value="${roleMap[role]}"/> &nbsp; ${role.authority.encodeAsHTML()}
                  </div>
                </g:each>
              </div>
              <div style="clear:both; height:10px;"></div>
            </div>

          </sec:ifAnyGranted>
          <sec:ifNotGranted roles="ROLE_ADMIN">
            <input type="hidden" name="ROLE_USER" value="on"/>
          </sec:ifNotGranted>

          <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_MANAGER">

            <div class="checkout_section_header">
              Enable User
            </div>

            <div class="formInstructions">
              A user should be enabled if you wish them to log in and update content.  If they are
              being used merely as a notification contact, leave them disabled.
            </div>

            <div class="checkout_fields">
              <div style="width:300px;" class="checkout_value ${hasErrors(bean: person, field: 'enabled', 'errors')}">
                <g:checkBox name="enabled" value="${person?.enabled}"/> &nbsp; Enabled
              </div>
              <div style="clear:both;"></div>
            </div>

            <div class="checkout_section_header">
              Notification Types
            </div>

            <div class="formInstructions">
              If a user has notification types selected, then any event in our system like
              a new move-in or a chargeback will be sent to the appropriate set of users
              with the notification enabled.
            </div>

            <div class="checkout_fields">
              <div style="width:650px;" class="checkout_value">
                <g:each var="notificationType" in="${notificationMap.keySet()}">
                  <div style="margin: 0 1.5em;" class="left">
                    <g:checkBox name="${notificationType.notificationType}" value="${notificationMap[notificationType]}"/> &nbsp; ${notificationType.description}
                  </div>
                </g:each>
              </div>
              <div style="clear:both; height:10px;"></div>
            </div>

          </sec:ifAnyGranted>

          <sec:ifAnyGranted roles="ROLE_MANAGER">
            <sec:ifNotGranted roles="ROLE_ADMIN">
              <div class="checkout_section_header">
                Site Privileges
              </div>

              <div class="checkout_fields">
                <div style="width:650px;" class="checkout_value ${hasErrors(bean: person, field: 'authorities', 'errors')}">
                  <g:each var="site" in="${siteMap.keySet()}">
                    <div style="margin:0 1.5em; width: 250px;" class="left">
                      <g:checkBox name="SITE:_${site.id}" value="${siteMap[site]}"/> &nbsp; ${site.title.encodeAsHTML()}
                    </div>
                  </g:each>
                </div>
                <div style="clear:both; height:10px;"></div>
              </div>

            </sec:ifNotGranted>
          </sec:ifAnyGranted>

          <div class="checkout_section_header">
            Description and Email
          </div>

          <div class="checkout_fields">
            <div style="width:300px;" class="checkout_value ${hasErrors(bean: person, field: 'description', 'errors')}">
              <input type="text" id="description" name="description" style="width: 280px;" value="${fieldValue(bean: person, field: 'description')}"/>
            </div>
            <div style="width:300px;" class="checkout_value ${hasErrors(bean: person, field: 'email', 'errors')}">
              <input type="text" id="email" name="email" style="width: 280px;" value="${fieldValue(bean: person, field: 'email')}"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:300px;">
              <label for="description">Description</label>
            </div>
            <div class="checkout_name" style="width:300px;">
              <label for="email">Email</label>
            </div>
            <div style="clear:both;"></div>
          </div>

        </div>
        <div class="buttons">
          <span class="button"><g:actionSubmit class="save" value="Update"/></span>
          <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete"/></span>
          <span class="button"><g:link class="edit" action="show" id="${person?.id}">Cancel</g:link></span>
        </div>
      </g:form>
    </div>
  </div>
</div>
</body>
</html>
