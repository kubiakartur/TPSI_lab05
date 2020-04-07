<%-- 
    Document   : Lab05_z2
    Created on : 2020-04-06, 11:11:18
    Author     : Moya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lab05 lista studentow</title>
    </head>
    <body>
        <table>
            <c:forEach items="${wypis_listy}" var="osoba">
                <p> 
                    <tr>
                        <td>${osoba.getFirstName()}</td>
                        <td>${osoba.getLastName()}</td>
                        <td>${osoba.getEmail()}</td>
                    </tr>
                </p>
            </c:forEach>
        </table>
        <form action='${Lab05_zadanie2.java}' method='post'>
        Przedstaw się ładnie:
        <input type='text' name='firstName'>
        <input type='text' name='lastName'>
        <input type='text' name='email'>
        <input type='submit'>
        </form>
        <p><a href="/Lab04">Powrot</a></p>
    </body>
</html>
