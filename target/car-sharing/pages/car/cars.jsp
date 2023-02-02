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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/styles/w3.css">
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
<c:if test="${requestScope.userType eq ADMIN}">
    <div><a href="<c:url value="/car/create"/>">Add new car</a></div>
</c:if>

</body>
</html>
