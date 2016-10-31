<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Access is denied</title>
    </head>
    <body>
        <h1>HTTP Status 403 - Access is denied</h1>

        <c:url var="logoutUrl" value="/logout"/>
        <form action="${logoutUrl}" method="post">
            <input type="submit" value="Sign out" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>            
        </form>

    </body>
</html>
