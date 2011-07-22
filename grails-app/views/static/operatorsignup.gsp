<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <title>Add Your Self-Storage Facility to Storitz.com</title>
  <meta name="DESCRIPTION" content="Storage facility operators: Sign up with storitz.com for free. This page details what you need to know to start list your units on Storitz."/>
  <p:dependantJavascript>
    <script type="text/javascript">
      //<![CDATA[

      function setupForm() {

        $('select#softwareType').change(function(event) {
          if ($(this).val() == 'OTHER') {
            $('input#otherSoftware').attr('disabled', false).focus();
          } else {
            $('input#otherSoftware').attr('disabled', true).val('');
          }
        });

        $("input.phone").mask('999-999-9999');
        $('#errorMessage').hide();

        $.validator.addMethod("othersoftware", function(value, element) {
          if ($('#softwareType').val() == 'OTHER') {
            return value && value != '';
          }
          return true;
        }, "Missing other software");


        var validator = $('#operatorsignup')
                .validate({
          submitHandler: function(form) {
            $('#errorMessage').hide();
            // TODO - put up a processing image picture
            form.submit();
          },
          rules: {
          },
          messages: {
            "firstName": "Missing first name",
            "lastName": "Missing last name",
            "phone": "Missing phone",
            "companyName": "Missing company name",
            "email": {
              required: "Missing email",
              email: "Incorrect email"
            }
          },
          errorContainer: $("#errorMessage"),
          errorLabelContainer: $("#errorList"),
          errorClass: "validation-failed",
          wrapper: "li",
          ignore: ".ignore",
          invalidHandler: function(form, validator) {
            $('#errorMessage').show();
          },
          showErrors: function(errorMap, errorList) {
            $("#errorInfo").html("Please correct the " + this.numberOfInvalids() + " issue" + (this.numberOfInvalids() > 1 ? 's' : '') + " below and continue:");
            this.defaultShowErrors();
          }
        });
      }

      $(document).ready(function() {
        setupForm();
        jwplayer("videoContainer").setup({
          flashplayer: "${resource(file:'/jwplayer/player.swf')}",
          file: "${resource(file:'/video/add-your-facility-640x360-500kbps.mov')}",
          autostart: true,
          height: 360,
          width: 640
        });
      });

      //]]>
    </script>
  </p:dependantJavascript>
</head>
<body class="static operatorsignup">

<div class="right">
  <h1>Facility Operators: Sign Up Free Today!</h1>
  <p>Ready to sign up?  Send us your info and we'll get back to you right away!</p>

  <g:form controller="contactUs" action="operatorSignup" name="operatorsignup" method="post">
    <div class="line"><fieldset>
      <label for="firstName">First Name</label>
      <g:textField name="firstName" id="firstName" class="required text"/>
    </fieldset>
    <fieldset>
      <label for="lastName">Last Name</label>
      <g:textField name="lastName" id="lastName" class="required text"/>
    </fieldset></div>
    <div class="line"><fieldset><label for="companyName">Company Name</label>
    <g:textField name="companyName" id="companyName" class="required text"/></fieldset>
    <fieldset><label for="email">Your Email</label>
    <g:textField name="email" id="email" class="required email text"/></fieldset>
    <fieldset><label for="email">Phone (XXX-XXX-XXXX)</label>
    <g:textField name="phone" id="phone" class="required phone text"/></fieldset></div>
    <div class="line">
      <label for="softwareType">Storage Software Package</label>
      <fieldset>
        <g:select name="softwareType" id="softwareType" from="${storitz.constants.SoftwareType.list()}" optionValue="display"/>
        <g:textField placeholder="Other package name" name="otherSoftware" id="otherSoftware" disabled="true" class="othersoftware" class="text" />
      </fieldset>
    </div>
    <g:submitButton name="operatorsignup" class="save button green" value="Send" />
  </g:form>

  <h1>Get listed on Storitz and start renting units today!</h1>
  <ul>
    <li>Get a 90% conversation rate with Storitz rentals</li>
    <li>Gain access to an affiliate network with over 7 million unique visitors per month</li>
    <li>NO set-up costs</li>
    <li>NO monthly fees</li>
    <li>NO set-up required from you; we do all the work</li>
    <li>Month-to-month agreement &mdash; cancel at any time</li>
  </ul>
  <div class="video">
    <div id="videoContainer"></div>
  </div>

</div>
</body>
</html>