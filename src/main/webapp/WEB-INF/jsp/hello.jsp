<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <spring:url value="/css/style.css" var="urlCss"/>
        <link rel="stylesheet" href="${urlCss}" type="text/css" /> 
    </head>
    <body>
        <c:if test="${not empty error}">
            <div id="error" class="error">
                ${error}
            </div>
        </c:if>
        <table class="tabel">
            <tr>
                <th>Vandaag</th>
                <th>Datum</th>
            </tr>
            <tr>
                <td>
                    <spring:url value="/overzichtUitgeleend/" var="showUrlUit"/> 
                    <form:form action="${showUrlUit}" method="POST">
                        <input type="submit" value="Overzicht Uitgeleend" class="btn-succes"/>
                    </form:form>
                </td>
                <td>
                    <spring:url value="/overzichtGereserveerd/" var="showUrlGer"/> 
                    <form:form action="${showUrlGer}${datum}" modelAttribute="datum" method="POST">
                        <p>
                            <form:input path="datum"/><br>
                            <form:errors path="datum" cssClass="error"/>
                        </p>
                        <input type="submit" value="Overzicht Gereserveerd" class="btn-succes"/>
                    </form:form>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:url var="logoutUrl" value="/logout"/>
                    <form action="${logoutUrl}" method="post">
                        <input type="submit" value="Log out" class="btn-logout" />
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>            
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>