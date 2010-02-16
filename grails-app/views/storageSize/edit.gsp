

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit StorageSize</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">StorageSize List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New StorageSize</g:link></span>
        </div>
        <div class="body">
            <h1>Edit StorageSize</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${storageSizeInstance}">
            <div class="errors">
                <g:renderErrors bean="${storageSizeInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${storageSizeInstance?.id}" />
                <input type="hidden" name="version" value="${storageSizeInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="height">Height:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:storageSizeInstance,field:'height','errors')}">
                                    <input type="text" id="height" name="height" value="${fieldValue(bean:storageSizeInstance,field:'height')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Description:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:storageSizeInstance,field:'description','errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:storageSizeInstance,field:'description')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="length">Length:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:storageSizeInstance,field:'length','errors')}">
                                    <input type="text" id="length" name="length" value="${fieldValue(bean:storageSizeInstance,field:'length')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="width">Width:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:storageSizeInstance,field:'width','errors')}">
                                    <input type="text" id="width" name="width" value="${fieldValue(bean:storageSizeInstance,field:'width')}" />
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
