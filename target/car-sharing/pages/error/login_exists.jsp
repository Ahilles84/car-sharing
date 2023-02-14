<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: snowball
  Date: 22.01.2023
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login exists</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/styles/w3.css">
</head>
<body>
    <div>
        <h1>User with such login already exists. Please choose another login.</h1>
    </div>
    <a href="<c:url value="/user/create"/>">Register</a>
    <a href="<c:url value="/index.jsp"/>">Main page</a>
</body>
</html>
