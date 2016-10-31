<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <spring:url value="/css/style.css" var="urlCss"/>
       <link rel="stylesheet" href="${urlCss}" type="text/css" />
    </head>
    
    <body onload='document.loginForm.username.focus();'>

        <div id="login-box">

            <h3>Login met uw HoGent email en wachtwoord</h3>

            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>
                
            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

           <form name='loginForm' action="<c:url value='/login' />" method='POST'>
                 <table>
                    <tr>
                        <td>Email:</td>
                        <td><input type='text' name='username' value=''></td>
                    </tr>
                    <tr>
                        <td>Wachtwoord:</td>
                        <td><input type='password' name='password' /></td>
                    </tr>
                    <tr>
                        <td colspan='2'><input name="submit" type="submit"
                                               value="LOG IN" /></td>
                    </tr>
                </table>

                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />

            </form>
        </div>

    </body>
</html>
