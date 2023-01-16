<%--
  Created by IntelliJ IDEA.
  User: snowball
  Date: 16.01.2023
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cars</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Model</th>
        <th>Reg Number</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="car" items="${cars}">
        <tr>
            <td>${car.model}</td>
            <td>${car.registrationNumber}</td>
            <td>${car.status ? "Busy" : "Free"}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
