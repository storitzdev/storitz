<%@ page import="java.text.DateFormat" contentType="text/html" %>
<html>
  <head>
    <title>Storitz ACH Deposit Notification</title>
  </head>
  <body>
  <div>
    <div style="z-index: 100; float: left; margin-top: 22px;">
      <g:link controller="home" action="index">
        <storitz:image src="${createLinkTo(dir:'images', file:'logo_storitz.gif', absolute: true)}" absolute="true" style="border-style: none;" width="950" height="61" alt="Storitz Logo"/>
      </g:link>
    </div>
    <div style="clear: both;"></div>
  </div>
  <div style="margin-left: 50px;">
    <storitz:image src="${createLinkTo(dir:'images', file:'tagline_clickstoredone.gif', absolute: true)}" absolute="true" style="border-style: none;" width="170" height="21" alt="Click. Store. Done."/>
  </div>
  <div style="height: 3em;"></div>

  <p>
    ${DateFormat.getDateInstance(DateFormat.FULL, Locale.US).format(new Date())}
  </p>
  <p>
    Dear Storitz Partner,
  </p>
  <p>
    We have transferred money to your ACH account on file.  Please go to the reporting page for details: <g:link controller="reports" action="index">Reports Menu</g:link> 
  </p>
  <p>
    We thank you for your continued partnership with Storitz. Please contact us if you have any questions or concerns.
  </p>
  <p>
    <div>Phone: (877) 456-2929</div>
    <div>Email: info@storitz.com</div>
  </p>
  </body>
</html>