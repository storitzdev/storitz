<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <meta name="DESCRIPTION" content="Storage site operators signup with Storitz.  This page details what you need to know to start hosting your sites with Storitz."/>
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

      <h1>Be part of Storitz and start renting units today!</h1>

      <p>
      <ul>
        <li>$0 up-front investment</li>
        <li>$0 subscription fees</li>
        <li>Lowest Commissions - <em>Guaranteed</em></li>
        <li>Month-to-Month Agreement</li>
        <li>Easy to get started</li>
      </ul>
    </p>
      <div id="videoContainer"></div>
      <p>
      <strong>Why?</strong>
        <ul>
          <li>Get Tenants – for your vacant units, at your prices and promotions.</li>
          <li>Get them for no up-front cost, and with no set up effort (we do all the setup for you)</li>
        </ul>
    </p>
    <p>
      <strong>How?</strong>
        <ul>
          <li>Storitz advertises online and offline to draw traffic to its site.</li>
          <li>Storitz integrates with your management software and rents your storage units</li>
          <li>Storitz does not get paid until it delivers you a prepaid tenant.</li>
        </ul>
    </p>
    <p>
      <strong>Wait, Something is Different Here...</strong>
        <ul>
          <li>That’s right.  We are not like other online “reservation centers”; we do not offer leads or reservations that have little or no obligation to the customer and require you to a) close the deal and b) reconcile end-of-month invoices to see which leads actually turned into rentals.</li>
          <li>Instead, we simply rent the unit in advance to your customer, with whatever move-in promotions and fees you require.  We pay you the move-in transaction amount, and then you pay us our one-time move-in booking commission.</li>
        </ul>
    </p>
      <p>
      <strong>How much does it cost me?</strong>
        <ul>
          <li>We have the lowest commissions in the industry, starting at $40 per move-in. No subscriptions, no exceptions. No hidden fees.</li>
        </ul>
    </p>
      <p>
      <strong>How much do I control the way my properties look on Storitz?</strong>
        <ul>
          <li>Complete control. If you change rents in your software program, the rents automatically update on Storitz.  Add, edit or delete images, your company logo, or descriptive text of your property,  at anytime</li>
        </ul>
    </p>
      <p>
      <strong>What else do I get?</strong>
        <ul>
          <li>Want to see how you are stacking up against your competition on Storitz? Full reporting and analytics related to your locations and performance on Storitz.</li>
          <li>You control all email notifications, reporting and analytics access for your employees</li>
        </ul>
    </p>
      <p>
      <strong>Now wait a second. Do I still have to build my pages?</strong>
        <ul>
          <li>We do all the set up for you. After you create a software login for us, we will build your property page(s) and prepare them for you to review. You review them and approve them, and then we  put them on our live Website and start renting units.</li>
        </ul>
    </p>
      <p>
      <strong>Great.. How do I get started?</strong>
        <ul>
          <li>Easy: fill-out the form below and click “send”, or simply call us at (877) 456-2929.</li>
        </ul>
    </p>
      <p>
        Not quite there yet, and you still want to know more? Call us (877) 456-2929 or email our Business Development Specialist, Eric G. Morse <a href="mailto:sales@storitz.com?subject=New%20Operator%20Question">sales@storitz.com</a>
      </p>

      <h2 class="checkout_header">
        Add Your Facility
      </h2>

      <div id="errorMessage" class="formErrors">
        <div id="errorInfo" class="errorInfo"></div>
        <div id="errorList" class="errorList"></div>
      </div>

      <g:form controller="contactUs" action="operatorSignup" name="operatorsignup" method="post">
        <label for="firstName">First Name</label>
        <g:textField name="firstName" id="firstName" class="required"/>
        <label for="lastName">Last Name</label>
        <g:textField name="lastName" id="lastName"class="required"/>
        <label for="companyName">Company Name</label>
        <g:textField name="companyName" id="companyName" class="required"/>
        <label for="email">Your Email</label>
        <g:textField name="email" id="email" class="required email"/>
        <label for="email">Phone (XXX-XXX-XXXX)</label>
        <g:textField name="phone" id="phone" class="required phone"/>
        <label for="softwareType">Storage Software Package</label>
        <fieldset>
          <g:select name="softwareType" id="softwareType" from="${storitz.constants.SoftwareType.list()}" optionValue="display"/>
          <g:textField placeholder="Other package name" name="otherSoftware" id="otherSoftware" disabled="true" class="othersoftware" />
        </fieldset>
        <g:submitButton name="operatorsignup" class="save" value="Send" />
      </g:form>

  </div>
</body>
<p:renderDependantJavascript/>
</html>