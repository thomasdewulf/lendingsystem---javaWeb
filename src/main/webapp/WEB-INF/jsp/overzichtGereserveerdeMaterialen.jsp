<%-- 
    Document   : overzichtGereserveerdeMaterialen
    Created on : 14-mei-2016, 16:15:11
    Author     : Maarten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gereserveerde Materialen</h1>
        <table>
            <tr>
                <th>Materiaal</th>
                <th>Gebruiker</th>
                <th>Ophaaldatum</th>
            </tr>
            <c:forEach items="${reservaties}" var="reservatie">
                <c:forEach items="${reservatie.reservatieLijnen}" var="lijn">
                    <tr>
                        <td>${lijn.product.artikelnaam}</td>
                        <td>${reservatie.user}</td>
                        <td>${reservatie.startDatum}</td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </table>
        <br>
        <br>
        <a href="<c:url value="/redirect.htm"/>">Terug</a> 
    </body>
</html>
