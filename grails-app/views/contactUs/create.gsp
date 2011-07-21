<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" scope="request" value="Contact Us"/>
  <meta name="DESCRIPTION" content="Contact Storitz with questions, partnership opportunities, technical support or operator sign up."/>
</head>
<body class="static">
<div class="right">
  <h1>Contact Us</h1>
  <p>Please contact us by choosing a subject and entering a valid email.  We will get back to you as soon as possible.</p>
  <g:hasErrors bean="${contactUsInstance}">
    <div class="errors">
      Whoops! Please correct the following problems and submit your message again:
      <ul>
        <g:eachError bean="${contactUsInstance}" field="userEmail"><li>Please enter a valid email address.</li></g:eachError>
        <g:eachError bean="${contactUsInstance}" field="message"><li>Please enter a message.</li></g:eachError>
      </ul>
    </div>
  </g:hasErrors>
  <g:form action="save" method="post">
    <label for="contactType">Subject</label>
    <g:select name="contactType" id="contactType" from="${storitz.constants.ContactType.list()}" optionValue="display" value="${contactUsInstance?.contactType}"/>
    <label for="userEmail">Your email</label>
    <g:textField name="userEmail" id="userEmail" value="${contactUsInstance?.userEmail}"/>
    <label for="message">Message</label>
    <g:textArea name="message" id="message" rows="12" cols="80" style="width:600px; height:300px;" value="${contactUsInstance?.message}"/>
    <br /><g:submitButton name="create" class="save" value="${message(code: 'default.button.send.label', default: 'Send')}"/>
  </g:form>
</div>
</body>
</html>
