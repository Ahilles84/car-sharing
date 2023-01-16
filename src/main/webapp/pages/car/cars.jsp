<%--
  Created by IntelliJ IDEA.
  User: snowball
  Date: 16.01.2023
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cars</title>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th>Model</th>
        <th>Reg Number</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="cars" scope="request" type="java.util.List"/>
    <c:forEach var="car" items="${cars}">
        <tr>
            <td>${car.model}</td>
            <td>${car.registrationNumber}</td>
            <td>${car.status ? "Busy" : "Free"}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<style type="text/css">
    .table {
        width: 100%;
        border: none;
        margin-bottom: 20px;
    }
    .table thead th {
        font-weight: bold;
        text-align: left;
        border: none;
        padding: 10px 15px;
        background: #d8d8d8;
        font-size: 14px;
    }
    .table thead tr th:first-child {
        border-radius: 8px 0 0 8px;
    }
    .table thead tr th:last-child {
        border-radius: 0 8px 8px 0;
    }
    .table tbody td {
        text-align: left;
        border: none;
        padding: 10px 15px;
        font-size: 14px;
        vertical-align: top;
    }
    .table tbody tr:nth-child(even){
        background: #f3f3f3;
    }
    .table tbody tr td:first-child {
        border-radius: 8px 0 0 8px;
    }
    .table tbody tr td:last-child {
        border-radius: 0 8px 8px 0;
    }
</style>

</body>
</html>
