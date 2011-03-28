
<%@ page import="com.bum.sales.DailyReceipt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'dailyReceipt.label', default: 'DailyReceipt')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'dailyReceipt.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="weather" title="${message(code: 'dailyReceipt.weather.label', default: 'Weather')}" />
                        
                            <g:sortableColumn property="comments" title="${message(code: 'dailyReceipt.comments.label', default: 'Comments')}" />
                        
                            <g:sortableColumn property="date" title="${message(code: 'dailyReceipt.date.label', default: 'Date')}" />
                        
                            <g:sortableColumn property="food" title="${message(code: 'dailyReceipt.food.label', default: 'Food')}" />
                        
                            <g:sortableColumn property="beer" title="${message(code: 'dailyReceipt.beer.label', default: 'Beer')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${dailyReceiptInstanceList}" status="i" var="dailyReceiptInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${dailyReceiptInstance.id}">${fieldValue(bean: dailyReceiptInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: dailyReceiptInstance, field: "weather")}</td>
                        
                            <td>${fieldValue(bean: dailyReceiptInstance, field: "comments")}</td>
                        
                            <td><g:formatDate date="${dailyReceiptInstance.date}" /></td>
                        
                            <td>${fieldValue(bean: dailyReceiptInstance, field: "food")}</td>
                        
                            <td>${fieldValue(bean: dailyReceiptInstance, field: "beer")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${dailyReceiptInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
