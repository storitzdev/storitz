<%@ page import="org.codehaus.groovy.grails.commons.ConfigurationHolder" %>
<div id="footer">
    <span>&copy; 2011 Storitz Inc. All rights reserved.</span>
    <g:link controller="static" action="aboutus">About Us</g:link>
    <g:link controller="static" action="terms" class="piped">Terms</g:link>
    <g:link controller="static" action="privacy" class="piped">Privacy Policy</g:link>
    <g:link controller="static" action="customerservice" class="piped"> Customer Service</g:link>
    <g:link controller="static" action="operatorsignup" class="piped operators">Facility Operators</g:link>
    <g:if test="${ConfigurationHolder.config?.storitz?.rentals?.sandboxMode}"><span style="color: red">sandbox mode enabled</span></g:if>
</div>
<p:javascript src="all" />