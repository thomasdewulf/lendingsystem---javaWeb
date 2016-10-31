<%-- 
    Document   : overzichtUitgeleendeMaterialen
    Created on : 14-mei-2016, 16:13:41
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
        <h1>Uitgeleende Materialen</h1>
        <table>
            <tr>
                <th>Materiaal</th>
                <th>Gebruiker</th>
                <th>Indiendatum</th>
                <th>Status</th>
            </tr>
            <c:forEach items="${reservaties}" var="reservatie">
                <c:forEach items="${reservatie.reservatieLijnen}" var="lijn">
                    <tr>
                        <td>${lijn.product.artikelnaam}</td>
                        <td>${reservatie.user}</td>
                        <td>${reservatie.eindDatum}</td>
                        <td>${reservatie.reservatieStatus}</td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </table>
        <br>
        <br>
        <a href="<c:url value="welcome.htm"/>">Terug</a>       
    </body>
</html>