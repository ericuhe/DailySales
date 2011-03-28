
<%@ page import="com.bum.sales.DailyReceipt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'dailyReceipt.label', default: 'DailyReceipt')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="dailyReceipt.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: dailyReceiptInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="dailyReceipt.weather.label" default="Weather" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: dailyReceiptInstance, field: "weather")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="dailyReceipt.comments.label" default="Comments" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: dailyReceiptInstance, field: "comments")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="dailyReceipt.date.label" default="Date" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${dailyReceiptInstance?.date}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="dailyReceipt.food.label" default="Food" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: dailyReceiptInstance, field: "food")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="dailyReceipt.beer.label" default="Beer" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: dailyReceiptInstance, field: "beer")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="dailyReceipt.wine.label" default="Wine" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: dailyReceiptInstance, field: "wine")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="dailyReceipt.liquor.label" default="Liquor" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: dailyReceiptInstance, field: "liquor")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="dailyReceipt.totalSales.label" default="Total Sales" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: dailyReceiptInstance, field: "totalSales")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="dailyReceipt.mealsTax.label" default="Meals Tax" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: dailyReceiptInstance, field: "mealsTax")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="dailyReceipt.giftCertificates.label" default="Gift Certificates" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: dailyReceiptInstance, field: "giftCertificates")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="dailyReceipt.totalReceipts.label" default="Total Receipts" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: dailyReceiptInstance, field: "totalReceipts")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="dailyReceipt.week.label" default="Week" /></td>
                            
                            <td valign="top" class="value"><g:link controller="week" action="show" id="${dailyReceiptInstance?.week?.id}">${dailyReceiptInstance?.week?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${dailyReceiptInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
