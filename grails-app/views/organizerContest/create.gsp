<%@ page import="storitz.constants.TransactionType; storitz.constants.SearchType; storitz.constants.UnitType; storitz.constants.TruckType; com.storitz.OrganizerContest" %>
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
    <g:render template="/topnav"/>
    <div class="stcontent" style="margin-top:15px;">

        <div id="headerdiv" style="border:1">

            <div class="left" style="width:300px;margin-right:15px;">
                <g:link controller="home" action="index">
                    <storitz:image src="storitz-logo.png" width="241" height="77" class="noborder"/>
                </g:link>
            </div>
            <div class="left" style="width:635px;">
                <div>
                    <div class="left bannerMastheadAlt">
                        <div class="bannerMastheadAltText"><h2>Simplify Your Search for Self Storage.</h2></div>
                         <div class="bannerMastheadAltText"><h2>Compare Thousands of Units with One Click.</h2></div>
                    </div>
                    <div class="left tollFree">
                        <div style="font-family:verdana;font-size:9px;text-transform:capitalize;color:#266e00;line-height:15px;margin: 10px 0 0 34px;">NEED ASSISTANCE?</div>
                        <div style="font-family:verdana; font-weight: bold; font-size:13px;color:#fff;margin-left: 34px;">(877) 456-2929</div>
                    </div>
                    <div style="clear:both;"></div>
                </div>
            </div>

            <!-- Search Form -->
            <div id="searchform" style="float:right; padding:0; margin:0;">
                <g:form controller="home" action="index" class="search-form" id="gsearch" method="get">
                    <fieldset>
                            <legend class="hidden">search</legend>
                            <input class="text" type="text" id="address" name="address" value="Enter Address or Zip" title="Enter Address or Zip"/>
                            <input type="submit" class="submit" id="btn-search" value="" title="search submit"/>
                        </fieldset>
                </g:form>
            </div>

            <div style="clear:both;"></div>

            <!-- AddThis Button BEGIN -->
            <div class="addthis_toolbox addthis_default_style" style="float:right; padding:0; margin:0">
                <a class="addthis_button_facebook_like" fb:like:layout="button_count" style="padding:0; margin:0"></a>
                <a class="addthis_button_tweet" style="padding:0; margin:0"></a>
                <a class="addthis_counter addthis_pill_style" style="padding:0; margin:0"></a>
            </div>
            <script type="text/javascript">var addthis_config = {"data_track_clickback":true};</script>
            <script type="text/javascript" src="http://s7.addthis.com/js/250/addthis_widget.js#pubid=ra-4db86126250eded7"></script>
            <!-- AddThis Button END -->

        </div> <!-- END HEADER DIV -->

        <div style="clear:both;"></div>

        <div class="thinline"></div>

        <g:link controller="organizerContest" action="create"><div class="organizerbanner"></div></g:link>

    <!-- ################# -->
    <!-- CONTENT GOES HERE -->
    <!-- ################# -->


        <g:if test="${flash.saved}">
            <div id="contestthankyou" style="text-align:center">
                <h1 class="bold">Thanks for entering!</h1>
                <p>Please tell your friends...</p>
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

                <h1 class="bold">Get a head start on spring cleaning with <span class="organizerPink">3 months of free storage</span> from storitz.com.</h1>

                <p>Plus, since moving into storage can be a messy process, you'll get a day with a Professional Organizer who will help you sort, organize and declutter your space.</p>

                <p>Storitz has already simplified your search for self storage. Let us help you simplify your life. Enter now!</p>
                <g:form controller="organizerContest" action="addEntry">
                    <table>
                        <tbody>

                        <tr class="orgprop">
                            <td valign="top" class="name">
                                <span class="left"><storitz:image src="pink_organizer_button_1_sm.gif" alt="Your Contact Info"/></span>
                                <label class="right" for="firstName"><g:message code="organizerContest.firstName.label" default="First Name"/></label>
                            </td>
                            <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'firstName', 'errors')}">
                                <g:textField name="firstName" class="required" value="${organizerContestInstance?.firstName}"/>
                                <g:hasErrors bean="${organizerContestInstance}" field="firstName">
                                    <span style="color: red;">Required</span>
                                </g:hasErrors>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="top" class="name">
                                <label class="right" for="lastName"><g:message code="organizerContest.lastName.label" default="Last Name"/></label>
                            </td>
                            <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'lastName', 'errors')}">
                                <g:textField name="lastName" class="required"  value="${organizerContestInstance?.lastName}"/>
                                <g:hasErrors bean="${organizerContestInstance}" field="lastName">
                                    <span style="color: red;">Required</span>
                                </g:hasErrors>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="top" class="name">
                                <label class="right" for="phone"><g:message code="organizerContest.phone.label" default="Phone Number"/></label>
                            </td>
                            <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'phone', 'errors')}">
                                <g:textField name="phone" class="required"  value="${organizerContestInstance?.phone}"/>
                                <g:hasErrors bean="${organizerContestInstance}" field="phone">
                                    <span style="color: red;">Required</span>
                                </g:hasErrors>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="top" class="name">
                                <label class="right" for="email"><g:message code="organizerContest.email.label" default="Email Address"/></label>
                            </td>
                            <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'email', 'errors')}">
                                <g:textField name="email" class="required"  value="${organizerContestInstance?.email}"/>
                                <g:hasErrors bean="${organizerContestInstance}" field="email">
                                    <span style="color: red;">Required</span>
                                </g:hasErrors>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="top" class="name">
                                <label class="right" for="twitterName"><g:message code="organizerContest.twitterName.label" default="Twitter Name (optional)"/></label>
                            </td>
                            <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'twitterName', 'errors')}">
                                <g:textField name="twitterName" value="${organizerContestInstance?.twitterName}"/>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="top" class="name">&nbsp;</td>
                            <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'sendMeUpdates', 'errors')}">
                                <g:checkBox class="left" name="sendMeUpdates" value="${organizerContestInstance?.sendMeUpdates}" checked="true"/>
                                <label style="padding-left:10px;" for="sendMeUpdates"><g:message code="organizerContest.sendMeUpdates.label" default=""/>Yes, I want to receive updates from Storitz about new contests, features and storage news.</label>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="top" class="name">
                                <span class="left"><storitz:image src="pink_organizer_button_2_sm.gif" alt="Your Primary Residence"/></span>
                                <label class="right" for="address1"><g:message code="organizerContest.address1.label" default="Address Line 1"/></label>
                            </td>
                            <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'address1', 'errors')}">
                                <g:textField name="address1" class="required"  value="${organizerContestInstance?.address1}"/>
                                <g:hasErrors bean="${organizerContestInstance}" field="address1">
                                    <span style="color: red;">Required</span>
                                </g:hasErrors>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="top" class="name">
                                <label class="right" for="address2"><g:message code="organizerContest.address2.label" default="Address Line 2"/></label>
                            </td>
                            <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'address2', 'errors')}">
                                <g:textField name="address2" value="${organizerContestInstance?.address2}"/>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="top" class="name">
                                <label class="right" for="city"><g:message code="organizerContest.city.label" default="City"/></label>
                            </td>
                            <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'city', 'errors')}">
                                <g:textField name="city" class="required"  value="${organizerContestInstance?.city}"/>
                                <g:hasErrors bean="${organizerContestInstance}" field="city">
                                    <span style="color: red;">Required</span>
                                </g:hasErrors>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="top" class="name">
                                <label class="right" for="state"><g:message code="organizerContest.state.label" default="State"/></label>
                            </td>
                            <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'state', 'errors')}">
                                <g:select name="state" class="required"  from="${storitz.constants.State?.values()}" keys="${storitz.constants.State?.values()*.name()}" value="${organizerContestInstance?.state?.name()}"/>
                                <g:hasErrors bean="${organizerContestInstance}" field="state">
                                    <span style="color: red;">Required</span>
                                </g:hasErrors>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="top" class="name">
                                <span class="left"><storitz:image src="pink_organizer_button_3_sm.gif" alt="About Storage"/></span>
                                <label class="right" for="zipcode"><g:message code="organizerContest.zipcode.label" default=""/>Zip Code where you are<br>looking for storage?</label>
                            </td>
                            <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'zipcode', 'errors')}">
                                <g:textField name="zipcode" class="required"  value="${organizerContestInstance?.zipcode}"/>
                                <g:hasErrors bean="${organizerContestInstance}" field="zipcode">
                                    <span style="color: red;">Required</span>
                                </g:hasErrors>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="top" class="name">
                                <label class="right" for="referralSource"><g:message code="organizerContest.referralSource.label" default=""/>How did you find out<br>about Storitz.com?</label>
                            </td>
                            <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'referralSource', 'errors')}">
                                <g:select name="referralSource" id="referralSource" from="${storitz.constants.OrganizerContestReferral.selectList()}"/>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="top" class="name">
                                <label class="right" for="essayWhyStorage"><g:message code="organizerContest.essayWhyStorage.label" default=""/>Tell us in 2000 characters or<br>less why you need storage</label>
                            </td>
                            <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'essayWhyStorage', 'errors')}">
                                <g:textArea class="required"  cols="50" rows="5" name="essayWhyStorage" value="${organizerContestInstance?.essayWhyStorage}"/>
                                <g:hasErrors bean="${organizerContestInstance}" field="essayWhyStorage">
                                    <span style="color: red;">Required</span>
                                </g:hasErrors>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="top" class="name"><span class="left"><storitz:image src="pink_organizer_button_4_sm.gif" alt="Terms and Conditions"/></span></td>
                            <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'readTermsAndConditions', 'errors')}">
                                <g:checkBox class="required left" name="readTermsAndConditions" value="${organizerContestInstance?.readTermsAndConditions}"/>
                                <label style="padding-left:10px;" for="readTermsAndConditions"><g:message code="organizerContest.readTermsAndConditions.label" default=""/>Yes, I have read and agree to the Storitz Terms and Conditions</label>
                                <g:hasErrors bean="${organizerContestInstance}" field="readTermsAndConditions">
                                    <p style="color: red;">Required</p>
                                </g:hasErrors>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="top" class="name">&nbsp;</td>
                            <td valign="top" class="name">
                                <textarea style="width:610px; height: 50px;" name="termText" id="termText">Storage property owner does not carry insurance to cover the loss or damage of your items. Your existing Homeowner’s Insurance or Renter’s Insurance may cover items you keep in storage. Alternatively, you may select (are required to select) the level of monthly insurance coverage that you may pay for as part of your monthly rent. By Checking Here, I acknowledge that I am responsible for damage or loss to my goods while stored at Storage Property. By checking here, I agree to not store hazardous items according to Federal Code, which includes but is not limited to Tires, Oil, Gasoline or Flammables, Paints, Environmental or Toxic Waste and Perishable Food.
                                </textarea>
                            </td>
                        </tr>

                        <tr class="orgprop">
                            <td valign="top" class="name">&nbsp;</td>
                            <td valign="top" class="name"><span class="organizerButton"><g:submitButton name="create" class="organizerButton" value="${message(code: 'default.button.submit.label', default: 'Submit')}"/></span></td>
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


    <g:render template="/footer_no_analytics"/>
</div>
</body>
<p:renderDependantJavascript/>
</html>
