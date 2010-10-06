<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:layoutHead />
        <g:javascript library="application" />				
    </head>
    <body>
        <div id="spinner" class="spinner" style="display:none;">
            <p:image src="spinner.gif" alt="Spinner" />
        </div>	
        <div class="logo"><p:image src="grails_logo.jpg" alt="Grails" /></div>
        <g:layoutBody />		
    </body>	
</html>