<%-- 
    Document   : MyExam.jsp
    Created on : 8 Nov 2025, 3:22:13 pm
    Author     : anngu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="NewServlet" method="post">
            Enter an integer array:
            <input type="text" name="a" value="${aValue}">
            <br>
            Choose an option:
            <input type="radio" name="option" value="Odd" checked> Odd
            <input type="radio" name="option" value="Even"> Even
            <br>
            Result:
            <input type="text" name="result" 
                   value="${result}" readonly>
            <br>
            <input type="submit" value="COUNT" >
            <div>${message}</div>
        </form>

        <br>
        List of Executions:
        <table border="1">
            <thead>
                <tr>
                    <th>Array</th>
                    <th>Option</th>
                    <th>Result</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${execList}" var="item">
                    <tr>
                        <td>${item.getArray()}</td>
                        <td>${item.getOption()}</td>
                        <td>${item.getResult()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
