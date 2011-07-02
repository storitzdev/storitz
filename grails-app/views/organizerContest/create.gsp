<%@ page import="org.codehaus.groovy.grails.commons.ConfigurationHolder; storitz.constants.TransactionType; storitz.constants.SearchType; storitz.constants.UnitType; storitz.constants.TruckType; com.storitz.OrganizerContest" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:fb="http://www.facebook.com/2008/fbml" xml:lang="en">
<head>
    <g:render template="/header_home"/>
    <p:javascript src="contest" />
</head>
<body>
<div id="body">

    <div class="stcontent" style="margin-top:15px;">

        <div id="headerdiv" style="border:1">

            <div class="left" style="width:300px;margin-right:15px;">
                <g:link controller="home" action="index">
                    <storitz:image src="storitz-logo-small.png" class="noborder"/>
                </g:link>
            </div>
            <div class="left" style="width:635px;">
                <div id="searchform" style="float:right; padding-right:3px; margin:0;">
                    <g:form controller="home" action="index" class="search-form" id="gsearch" method="get">
                        <fieldset>
                                <legend class="hidden">search</legend>
                                <input class="text" type="text" id="address" name="address" value="Enter Address or Zip" title="Enter Address or Zip"/>
                                <input type="submit" class="submit" id="btn-search" value="" title="search submit"/>
                            </fieldset>
                    </g:form>
                </div>

                <div style="clear:both;"></div>
            </div>

        </div> <!-- END HEADER DIV -->

        <div style="clear:both;"></div>

        <div class="organizerbanner"></div>

    <!-- ################# -->
    <!-- CONTENT GOES HERE -->
    <!-- ################# -->


        <g:if test="${flash.saved}">
            <div id="contestthankyou" style="text-align:center">
                <h1 class="bold">Thanks for entering!</h1>
                    <p><strong>Thanks for Entering for a chance to win a day of organization with Justin Klosky!</strong></p>
                    <p>Be sure to check back on July 31<sup>st</sup> 2011 when we announce our finalists!</p>
                    <p>In the meantime, share the contest with your friends using the links below:</p>
                    <p><g:link controller="organizerContest" action="create">${ConfigurationHolder.config.grails.serverURL}/organizer</g:link></p>
                <div class="share_buttons">
                    <iframe src="http://www.facebook.com/plugins/like.php?app_id=197442326973686&amp;href=http%3A%2F%2Fwww.storitz.com%2Forganizer&amp;send=false&amp;layout=button_count&amp;width=90&amp;show_faces=false&amp;action=like&amp;colorscheme=light&amp;font&amp;height=21" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:90px; height:21px;" allowTransparency="true"></iframe>
                    <a href="http://twitter.com/share" class="twitter-share-button" data-text="I just entered to win a day of organization with Justin Klosky!" data-via="storitzdotcom">Tweet</a>
                </div>
            </div>
        </g:if>
        <g:elseif test="${flash.closed}">
            <div id="contestclosed" style="text-align:center">
                <h1 class="bold">We're sorry. Entries are no longer being accepted for the Pro Organizer Contest.</h1>
                <h1 class="bold"><span class="organizerPink">Please come back on June 30, 2011 when we will announce the winner.</span></h1>
                <p>Meanwhile, please tell your friends about Storitz...</p>
                <p>&nbsp;</p>
                <!-- AddThis Button BEGIN -->
                <div class="addthis_toolbox addthis_default_style addthis_32x32_style" style="position:relative;left:345px;padding:10px;">
                    <a class="addthis_button_preferred_1"></a>
                    <a class="addthis_button_preferred_2"></a>
                    <a class="addthis_button_preferred_3"></a>
                    <a class="addthis_button_preferred_4"></a>
                    <a class="addthis_button_compact"></a>
                    <a class="addthis_counter addthis_bubble_style"></a>
                </div>
                <script type="text/javascript" src="http://s7.addthis.com/js/250/addthis_widget.js#pubid=xa-4dd1d59d1d9a21cd"></script>
                <!-- AddThis Button END -->
            </div>
        </g:elseif>
        <g:else>
            <div id="contestformdiv">
                <g:if test="${flash.message}">
                    <div class="message">${flash.message}</div>
                </g:if>

                <h1 class="bold">Get a handle on your summer situation with <span class="organizerPink">3 months of free storage</span> from storitz.com.</h1>
                <div id="contest_top">
                <div class="organizer_intro">
                    <iframe src="http://www.facebook.com/plugins/like.php?app_id=197442326973686&amp;href=http%3A%2F%2Fwww.storitz.com%2Forganizer&amp;send=false&amp;layout=button_count&amp;width=450&amp;show_faces=false&amp;action=like&amp;colorscheme=light&amp;font&amp;height=21" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:450px; height:21px;" allowTransparency="true"></iframe>
                    <p>Staying Organized is a challenge for anyone. Get Organized, once and for all? Put your seasonal
                    stuff in storage, clean out the garage, clear out your den, redecorate the living room?</p>

                    <p>Enter below to win 3 months of FREE storage and a day with professional organizer and founder of
                    the O.C.D. Experience, Justin Klosky. Justin Klosky will organize your home or office space as well
                    as provide the winner with tips and tricks for maintaining an organized lifestyle. 5 finalists will
                    be chosen from all the entries received, which will then be voted on by our facebook fans. </p>
                </div>

                <div class="video_container">
                    <iframe width="465" height="270" src="https://www.youtube.com/embed/${videoId}" frameborder="0" allowfullscreen></iframe>
                </div>
                </div>
                <div style="clear:both;"></div>
                <g:form controller="organizerContest" action="addEntry">
                    <table>
                        <tbody>

                        <tr class="orgprop">
                            <td valign="middle" class="name">
                                <span class="left"><storitz:image src="1-your-contact-info.gif" alt="Your Contact Info"/></span>
                                <label class="right firstfield" for="firstName"><g:message code="organizerContest.firstName.label" default="First Name"/></label>
                            </td>
                            <td valign="middle" class="value ${hasErrors(bean: organizerContestInstance, field: 'firstName', 'errors')}">
                                <g:textField name="firstName" class="required" value="${organizerContestInstance?.firstName}"/>
                                <g:hasErrors bean="${organizerContestInstance}" field="firstName">
                                    <span style="color: red;">Required</span>
                                </g:hasErrors>
                            </td>

                            <td valign="middle" class="name">
                                <label class="right" for="lastName"><g:message code="organizerContest.lastName.label" default="Last Name"/></label>
                            </td>
                            <td valign="middle" class="value ${hasErrors(bean: organizerContestInstance, field: 'lastName', 'errors')}">
                                <g:textField name="lastName" class="required"  value="${organizerContestInstance?.lastName}"/>
                                <g:hasErrors bean="${organizerContestInstance}" field="lastName">
                                    <span style="color: red;">Required</span>
                                </g:hasErrors>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="middle" class="name">
                                <label class="right" for="phone"><g:message code="organizerContest.phone.label" default="Phone Number"/></label>
                            </td>
                            <td valign="middle" class="value ${hasErrors(bean: organizerContestInstance, field: 'phone', 'errors')}">
                                <g:textField name="phone" class="required phone"  value="${organizerContestInstance?.phone}"/>
                                <g:hasErrors bean="${organizerContestInstance}" field="phone">
                                    <span style="color: red;">Required</span>
                                </g:hasErrors>
                            </td>

                            <td valign="middle" class="name">
                                <label class="right" for="email"><g:message code="organizerContest.email.label" default="Email Address"/></label>
                            </td>
                            <td valign="middle" class="value ${hasErrors(bean: organizerContestInstance, field: 'email', 'errors')}">
                                <g:textField name="email" class="required"  value="${organizerContestInstance?.email}"/>
                                <g:hasErrors bean="${organizerContestInstance}" field="email">
                                    <span style="color: red;">Required (valid email addresses only)</span>
                                </g:hasErrors>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="middle" class="name">
                                <span class="left"><storitz:image src="2-your-primary-residence.gif" alt="Your ZIPs"/></span>
                                <label class="right firstfield" for="zipcode"><g:message code="organizerContest.zipcode.label" default=""/>Zip Code</label>
                            </td>
                            <td valign="middle" class="value ${hasErrors(bean: organizerContestInstance, field: 'zipcode', 'errors')}">
                                <g:textField name="zipcode" class="required"  value="${organizerContestInstance?.zipcode}"/>
                                <g:hasErrors bean="${organizerContestInstance}" field="zipcode">
                                    <span style="color: red;">Required</span>
                                </g:hasErrors>
                            </td>
                            <td valign="middle" class="name">
                                <label class="right" for="zipcode2"><g:message code="organizerContest.zipcode2.label" default=""/>Storage Zip Code<br>(California Only)</label>
                            </td>
                            <td valign="middle" class="value ${hasErrors(bean: organizerContestInstance, field: 'zipcode2', 'errors')}">
                                <g:textField name="zipcode2" class="required"  value="${organizerContestInstance?.zipcode2}"/>
                                <g:hasErrors bean="${organizerContestInstance}" field="zipcode2">
                                    <span style="color: red;">Required. Only California Zip Codes (90001 - 96162) are allowed</span>
                                </g:hasErrors>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="top" class="name">
                                <table>
                                    <tr>
                                        <span class="left"><storitz:image src="3-about-you-getting-organization.gif" alt="About Storage" style="margin-top:11px;"/></span>
                                    </tr>
                                    <tr class="right">
                                        <label class="right" for="essayWhyStorage" style="padding-top:23px"><g:message code="organizerContest.essayWhyStorage.label" default=""/>Tell us in 120 characters or<br>less why you need Justin to<br>help organize your space.</label>
                                    </tr>
                                </table>
                            </td>
                            <td valign="middle" class="value ${hasErrors(bean: organizerContestInstance, field: 'essayWhyStorage', 'errors')}">
                                <g:textArea class="required"  cols="50" rows="5" name="essayWhyStorage" value="${organizerContestInstance?.essayWhyStorage}"/>
                                <g:hasErrors bean="${organizerContestInstance}" field="essayWhyStorage">
                                    <span style="color: red;">Required</span>
                                </g:hasErrors>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="middle" class="name">&nbsp;</td>
                            <td valign="middle" class="value ${hasErrors(bean: organizerContestInstance, field: 'sendMeUpdates', 'errors')}">
                                <g:checkBox class="left" name="sendMeUpdates" value="${organizerContestInstance?.sendMeUpdates}" checked="true"/>
                                <label style="padding-left:10px;" for="sendMeUpdates"><g:message code="organizerContest.sendMeUpdates.label" default=""/>Yes, I want to receive updates from Storitz.</label>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="middle" class="name"><span class="left"><storitz:image src="4-terms-and-conditions.gif" alt="Terms and Conditions"/></span></td>
                            <td valign="middle" class="value ${hasErrors(bean: organizerContestInstance, field: 'readTermsAndConditions', 'errors')}">
                                <g:checkBox class="tac required left" name="readTermsAndConditions" value="${organizerContestInstance?.readTermsAndConditions}"/>
                                <label style="padding-left:7px;" for="readTermsAndConditions"><g:message code="organizerContest.readTermsAndConditions.label" default=""/>
                                Yes, I have read and agree to the <a href='#' onClick='centeredPopup("<g:createLinkTo absolute="true" file="/static/contestrules.gsp"/>","myWindow","500","350","yes")'>Contest Rules.</a>
                                </label>
                                <g:hasErrors bean="${organizerContestInstance}" field="readTermsAndConditions">
                                    <p style="color: red;">Required. You must agree to the Storitz terms and conditions to enter.</p>
                                </g:hasErrors>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="middle" class="name">&nbsp;</td>
                            %{--<td valign="middle" class="name"><span class="organizerButton"><g:submitButton name="create" class="organizerButton" value="${message(code: 'default.button.submit.label', default: 'Submit')}"/></span></td>--}%
                            <td valign="middle" class="name"><g:submitButton name="create" class="organizerButton" value=""/></td>
                        </tr>

                        </tbody>
                    </table>
                </g:form>
            </div>
        </g:else>


    <!-- ################# -->
    <!-- END CONTENT GOES HERE -->
    <!-- ################# -->
    </div>

    <p:dependantJavascript>
        <script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
        <script>
            var popupWindow = null;
            function centeredPopup(url,winName,w,h,scroll){
                LeftPosition = (screen.width) ? (screen.width-w)/2 : 0;
                TopPosition = (screen.height) ? (screen.height-h)/2 : 0;
                settings =
                        'height='+h+',width='+w+',top='+TopPosition+',left='+LeftPosition+',scrollbars='+scroll+',resizable'
                popupWindow = window.open(url,winName,settings)
            }
            $(document).ready(function() {
                if ($.browser.msie) {
                    $(".orgprop tr.right label.right").css("padding-left", "162px");
                }
             });
        </script>
    </p:dependantJavascript>
</div>
</body>
<p:renderDependantJavascript/>
</html>
