<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <script src="http://www.google.com/jsapi" type="text/javascript"></script>
    <g:set var="title" value="User List"/>
    <g:render template="/header" />

    <script type="text/javascript">
//<![CDATA[
    google.load("prototype", "1.6.1.0");
    google.load("scriptaculous", "1.8.3");
//]]>

    FastInit.addOnLoad(setupAutocomplete);
  </script>

  </head>
  <body>
    <div id="body">
    <g:render template="/topnav" />
    <div id="stcontent">
      <g:render template="/logo_bar" />

        <div class="buttons">
            <span class="button"><a href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
            <span class="button"><g:link action="list">User List</g:link></span>
        </div>

        <div class="body">

          <div class="price_options checkout_header white">
            Create User
          </div>

            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${person}">
            <div class="errors">
                <g:renderErrors bean="${person}" as="list" />
            </div>
            </g:hasErrors>
          
            <g:form action="save" method="post" >

              <div class="formInstructions">
                To create a user, set their user id in the system and assign an initial password and email.  The user can
                change this password when they log in.  Assign privileges to the sites this user will manager.  Users can
                edit the information for these assigned sites, upload and delete pictures.  They cannot edit bank information
                or the lease agreements for their assigned sites.
              </div>

              <div class="checkout_section_header">
                User Name and Real Name
              </div>

              <div class="checkout_fields">
                <div style="width:200px;" class="checkout_value ${hasErrors(bean: person, field: 'username', 'errors')}">
                  <g:textField id="username" name="username" style="width: 180px;" value="${fieldValue(bean:person,field:'username')}" />
                </div>
                <div style="width:300px;" class="checkout_value ${hasErrors(bean: person, field: 'userRealName', 'errors')}">
                  <g:textField id="userRealName" name="userRealName" style="width: 280px;" value="${fieldValue(bean:person,field:'userRealName')}" />
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
                  <input type="password" id="passwd" name="passwd" style="width: 180px;" value="${fieldValue(bean:person,field:'password')}" />
                </div>
                <div style="width:200px;" class="checkout_value ${hasErrors(bean: person, field: 'repasswd', 'errors')}">
                  <input type="password" id="repasswd" name="repasswd" style="width: 180px;" value="${fieldValue(bean:person,field:'password')}" />
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
                  Manager and Enablement
                </div>

                <div class="checkout_fields">
                  <div style="width:300px;" class="checkout_value ${hasErrors(bean: person, field: 'manager', 'errors')}">
                    <g:select style="width:280px;" from="${com.storitz.User.list()}" value="${person?.manager?.id}"
                              optionKey="id" optionValue="userRealName" name="manager.id"
                              noSelection="['null':'No manager selected']"/>
                  </div>
                  <div style="width:300px;" class="checkout_value ${hasErrors(bean: person, field: 'enabled', 'errors')}">
                    <g:checkBox name="enabled" value="${person?.enabled}" /> &nbsp; Enabled
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

                <div class="formInstructions">
                  A corporate operator should be created with both ROLE_USER and ROLE_MANAGER set.  Simple users with site editing
                  privileges should only have ROLE_USER set and should have the Manager field set to their corporate manager.
                  Call center users should only have ROLE_CALLCENTER privilege set. ROLE_ADMIN is only to be used for Storitz
                  employees - it gives access to sensitive financial information.
                </div>

                <div class="checkout_fields">
                  <div style="width:650px;" class="checkout_value ${hasErrors(bean: person, field: 'authorities', 'errors')}">
                    <g:each var="role" in="${authorityList}">
                      <div style="margin: 0 1.5em;" class="left">
                        <g:checkBox name="${role.authority}"/> &nbsp; ${role.authority.encodeAsHTML()}
                      </div>
                    </g:each>
                  </div>
                  <div style="clear:both; height:10px;"></div>
                </div>

              </sec:ifAnyGranted>
              <sec:ifNotGranted roles="ROLE_ADMIN">
                <input type="hidden" name="ROLE_USER" value="on"/>
                <input type="hidden" name="enabled" value="true"/>
              </sec:ifNotGranted>

              <div class="checkout_section_header">
                Description
              </div>

              <div class="formInstructions">
                Describe this user - for example if they are a site manager of a particular facility, enter that
                description here.
              </div>

              <div class="checkout_fields">
                <div style="width:600px;" class="checkout_value ${hasErrors(bean: person, field: 'passwd', 'errors')}">
                  <textarea id="description" name="description" rows="80" cols="5">${fieldValue(bean:person,field:'description')}</textarea>
                </div>
                <div style="clear:both;"></div>
              </div>

              <div class="checkout_labels">
                <div class="checkout_name" style="width:600px;">
                  <label for="description">Description</label>
                </div>
                <div style="clear:both;"></div>
              </div>

              <div class="checkout_section_header">
                Email
              </div>

              <div class="checkout_fields">
                <div style="width:300px;" class="checkout_value ${hasErrors(bean: person, field: 'email', 'errors')}">
                  <input type="text" id="email" name="email" style="width: 280px;" value="${fieldValue(bean:person,field:'email')}"/>
                </div>
                <div style="clear:both;"></div>
              </div>

              <div class="checkout_labels">
                <div class="checkout_name" style="width:300px;">
                  <label for="email">Email</label>
                </div>
                <div style="clear:both;"></div>
              </div>

              <sec:ifAnyGranted roles="ROLE_ADMIN">

                <div class="checkout_section_header">
                  Account Attributes
                </div>

                <div class="formInstructions">
                  These should generally stay unchecked.  Ask before setting any of these.
                </div>

                <div class="checkout_fields">
                  <div style="width:650px;" class="checkout_value">
                    <div class="left" style="width: 200px;">
                      <g:checkBox name="accountExpired" value="${person?.accountExpired}" ></g:checkBox> &nbsp; Account Expired
                    </div>
                    <div class="left" style="width: 200px;">
                      <g:checkBox name="accountLocked" value="${person?.accountLocked}" ></g:checkBox> &nbsp; Account Locked
                    </div>
                    <div class="left" style="width: 200px;">
                      <g:checkBox name="passwordExpired" value="${person?.passwordExpired}" ></g:checkBox> &nbsp; Password Expired
                    </div>
                  </div>
                  <div style="clear:both;"></div>
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
                          <g:checkBox name="SITE_${site.id}" value="${siteMap[site]}"/> &nbsp; ${site.title.encodeAsHTML()}
                        </div>
                      </g:each>
                    </div>
                    <div style="clear:both; height:10px;"></div>
                  </div>

                  </sec:ifNotGranted>
              </sec:ifAnyGranted>

              <div class="buttons">
                  <span class="button"><input class="save" type="submit" value="Create" /></span>
              </div>
            </g:form>
        </div>
      </div>
    </div>
  </body>
</html>
