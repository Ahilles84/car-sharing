<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cars</title>
</head>
<body>
<h1>Cars list</h1>
<table>
    <thead>
    <tr>
        <th>Model</th>
        <th>RegNumber</th>
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
<a href="<c:url value="/user/create"/>">Register</a>
<a href="<c:url value="/index.jsp"/>">Main page</a>
<a href="<c:url value="/car/booking"/>">Book a car</a>
</body>
</html>