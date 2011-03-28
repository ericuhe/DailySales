

<%@ page import="com.bum.sales.Week" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'week.label', default: 'Week')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${weekInstance}">
            <div class="errors">
                <g:renderErrors bean="${weekInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${weekInstance?.id}" />
                <g:hiddenField name="version" value="${weekInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="startDate"><g:message code="week.startDate.label" default="Start Date" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: weekInstance, field: 'startDate', 'errors')}">
                                    <g:datePicker name="startDate" precision="day" value="${weekInstance?.startDate}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="endDate"><g:message code="week.endDate.label" default="End Date" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: weekInstance, field: 'endDate', 'errors')}">
                                    <g:datePicker name="endDate" precision="day" value="${weekInstance?.endDate}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="dailyReceipts"><g:message code="week.dailyReceipts.label" default="Daily Receipts" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: weekInstance, field: 'dailyReceipts', 'errors')}">
                                    
<ul>
<g:each in="${weekInstance?.dailyReceipts?}" var="d">
    <li><g:link controller="dailyReceipt" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="dailyReceipt" action="create" params="['week.id': weekInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'dailyReceipt.label', default: 'DailyReceipt')])}</g:link>

                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="dailyDiscounts"><g:message code="week.dailyDiscounts.label" default="Daily Discounts" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: weekInstance, field: 'dailyDiscounts', 'errors')}">
                                    <g:select name="dailyDiscounts" from="${com.bum.sales.DailyDiscount.list()}" multiple="yes" optionKey="id" size="5" value="${weekInstance?.dailyDiscounts*.id}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="dailyCovers"><g:message code="week.dailyCovers.label" default="Daily Covers" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: weekInstance, field: 'dailyCovers', 'errors')}">
                                    <g:select name="dailyCovers" from="${com.bum.sales.DailyCover.list()}" multiple="yes" optionKey="id" size="5" value="${weekInstance?.dailyCovers*.id}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="dailyIncomes"><g:message code="week.dailyIncomes.label" default="Daily Incomes" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: weekInstance, field: 'dailyIncomes', 'errors')}">
                                    <g:select name="dailyIncomes" from="${com.bum.sales.DailyIncome.list()}" multiple="yes" optionKey="id" size="5" value="${weekInstance?.dailyIncomes*.id}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
