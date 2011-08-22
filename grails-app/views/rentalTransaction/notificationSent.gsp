<%@ page import="storitz.constants.TransactionType" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <title>Notifications sent</title>
</head>
<body class="checkout-error">
<h1>Notifications sent</h1>
<pre>
  Transaction ID: ${trans.id}
  Tenant name: ${trans.contactPrimary.firstName} ${trans.contactPrimary.lastName}
  Tenant email: ${trans.contactPrimary.email}
  Tenant phone: ${trans.contactPrimary.phone}
  Site name: ${trans.site.title}
  Site phone: ${trans.site.phone}
  Operator: ${trans.site.feed.operator_name}
</pre>
</body>
</html>