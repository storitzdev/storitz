<%@ page import="com.storitz.RentalTransaction; com.storitz.StorageSite" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Create Storage Site" scope="request"/>
  <g:render template="/header"/>

  <script type="text/javascript">
    //<![CDATA[
    //]]>
  </script>

</head>
<body>
<div id="body">

  <div class="stcontent">
    <g:render template="/logo_bar"/>

    <div style="clear: both;height: 10px"></div>
    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><a href="${createLink(action: 'findCall')}">Refresh List</a></span>
    </div>
    <div class="body">

      <div class="price_options checkout_header white">
        Call Center Active Search List
      </div>

      <g:form action="smartCall" method="GET">
        <span>Caller's Session ID</span><g:textField name="id" value=""/>
        <span class="buttonSmall"><input type="submit" name="Go" value="Go"/></span>
        <hr/>
        <table class="callCenterCalls">
          <tr><th>Call</th><th>Name</th><th>Site Title</th><th>City</th><th>ST</th><th>Search address</th><th>Page</th></tr>
          <g:each in="${calls}" var="e" status="i">
            <g:set var="rt" value="${e.value.rentalTransaction?.id ? RentalTransaction.get(e.value.rentalTransaction.id) : e.value.rentalTransaction}"/>
            <g:set var="site" value="${e.value.rentalTransaction.site ? e.value.rentalTransaction.site : StorageSite.get(e.value.site)}"/>
            <tr class="${i % 2 == 0 ? 'rowEven' : 'rowOdd'}">
              <td><g:link action="smartCall" id="${e.key}">${e.key}</g:link></td>
              <td>${rt.contactPrimary?.firstName} ${rt.contactPrimary?.lastName} ${rt.contactPrimary?.suffixName}</td>
              <td>${site?.title}</td><td>${site?.city}</td><td>${site?.state?.display}</td>
              <td>${e?.value?.address}</td>
              <td>${e?.value?.page}</td>
            </tr>
          </g:each>
        </table>
      </g:form>
    </div>
    <div style="height:50px;"></div>
  </div>
</div>
</body>
<p:renderDependantJavascript/>
</html>
