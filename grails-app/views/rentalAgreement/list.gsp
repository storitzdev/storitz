<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="List Rental Agreements"/>
  <g:render template="/header"/>

  <script type="text/javascript">
    //<![CDATA[
    //]]>
  </script>

</head>
<body>
<div id="body">
  <g:render template="/topnav"/>
  <div id="stcontent">
    <g:render template="/logo_bar" />

    <div style="clear: both;height: 10px"></div>
    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_MANAGER">
        <span class="button"><g:link action="create">Add Agreement</g:link></span>
      </sec:ifAnyGranted>
    </div>

    <div class="body">

      <div class="price_options checkout_header white">
        List Rental/Lease Agreements
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>

      <div class="list">
        <table>
          <thead>
          <tr>

            <g:sortableColumn property="id" title="${message(code: 'rentalAgreement.id.label', default: 'Id')}"/>

            <g:sortableColumn property="title" title="${message(code: 'rentalAgreement.title.label', default: 'Agreement')}"/>

            <g:sortableColumn property="owner" title="${message(code: 'rentalAgreement.agreementOwner.label', default: 'Owner')}"/>

            <g:sortableColumn property="file" title="${message(code: 'rentalAgreement.file.label', default: 'PDF')}"/>

          </tr>
          </thead>
          <tbody>
          <g:each in="${rentalAgreementInstanceList}" status="i" var="rentalAgreementInstance">
            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

              <td><g:link action="show" id="${rentalAgreementInstance.id}">${fieldValue(bean: rentalAgreementInstance, field: "id")}</g:link></td>

              <td>${fieldValue(bean: rentalAgreementInstance, field: "title")}</td>

              <td>${rentalAgreementInstance?.agreementOwner?.username}</td>

              <td><a href="${resource(file:rentalAgreementInstance.src())}" target="_blank"><img src="${resource(dir:'images', file:'icn_pdf.jpg')}" alt="PDF"/></a> </td>

            </tr>
          </g:each>
          </tbody>
        </table>
      </div>
      <div class="paginateButtons">
        <g:paginate total="${rentalAgreementInstanceTotal}" params="[sitename:params?.sitename]"/>
      </div>
    </div>
  </div>
</div>
</body>
</html>
