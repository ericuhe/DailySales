

<%@ page import="com.bum.sales.DailyReceipt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'dailyReceipt.label', default: 'DailyReceipt')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${dailyReceiptInstance}">
            <div class="errors">
                <g:renderErrors bean="${dailyReceiptInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="weather"><g:message code="dailyReceipt.weather.label" default="Weather" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: dailyReceiptInstance, field: 'weather', 'errors')}">
                                    <g:textField name="weather" maxlength="64" value="${dailyReceiptInstance?.weather}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="comments"><g:message code="dailyReceipt.comments.label" default="Comments" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: dailyReceiptInstance, field: 'comments', 'errors')}">
                                    <g:textField name="comments" value="${dailyReceiptInstance?.comments}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="date"><g:message code="dailyReceipt.date.label" default="Date" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: dailyReceiptInstance, field: 'date', 'errors')}">
                                    <g:datePicker name="date" precision="day" value="${dailyReceiptInstance?.date}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="food"><g:message code="dailyReceipt.food.label" default="Food" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: dailyReceiptInstance, field: 'food', 'errors')}">
                                    <g:textField name="food" value="${fieldValue(bean: dailyReceiptInstance, field: 'food')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="beer"><g:message code="dailyReceipt.beer.label" default="Beer" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: dailyReceiptInstance, field: 'beer', 'errors')}">
                                    <g:textField name="beer" value="${fieldValue(bean: dailyReceiptInstance, field: 'beer')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="wine"><g:message code="dailyReceipt.wine.label" default="Wine" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: dailyReceiptInstance, field: 'wine', 'errors')}">
                                    <g:textField name="wine" value="${fieldValue(bean: dailyReceiptInstance, field: 'wine')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="liquor"><g:message code="dailyReceipt.liquor.label" default="Liquor" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: dailyReceiptInstance, field: 'liquor', 'errors')}">
                                    <g:textField name="liquor" value="${fieldValue(bean: dailyReceiptInstance, field: 'liquor')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="totalSales"><g:message code="dailyReceipt.totalSales.label" default="Total Sales" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: dailyReceiptInstance, field: 'totalSales', 'errors')}">
                                    <g:textField name="totalSales" value="${fieldValue(bean: dailyReceiptInstance, field: 'totalSales')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="mealsTax"><g:message code="dailyReceipt.mealsTax.label" default="Meals Tax" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: dailyReceiptInstance, field: 'mealsTax', 'errors')}">
                                    <g:textField name="mealsTax" value="${fieldValue(bean: dailyReceiptInstance, field: 'mealsTax')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="giftCertificates"><g:message code="dailyReceipt.giftCertificates.label" default="Gift Certificates" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: dailyReceiptInstance, field: 'giftCertificates', 'errors')}">
                                    <g:textField name="giftCertificates" value="${fieldValue(bean: dailyReceiptInstance, field: 'giftCertificates')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="totalReceipts"><g:message code="dailyReceipt.totalReceipts.label" default="Total Receipts" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: dailyReceiptInstance, field: 'totalReceipts', 'errors')}">
                                    <g:textField name="totalReceipts" value="${fieldValue(bean: dailyReceiptInstance, field: 'totalReceipts')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="week"><g:message code="dailyReceipt.week.label" default="Week" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: dailyReceiptInstance, field: 'week', 'errors')}">
                                    <g:select name="week.id" from="${com.bum.sales.Week.list()}" optionKey="id" value="${dailyReceiptInstance?.week?.id}"  />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
