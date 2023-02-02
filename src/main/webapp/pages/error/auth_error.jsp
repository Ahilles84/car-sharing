<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: snowball
  Date: 28.01.2023
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User not authorised</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/styles/w3.css">
</head>
<body>
<div>
    <h1>Please sign in before continue.</h1>
</div>
    <a href="<c:url value="/login"/>">Sign in</a>
    <a href="<c:url value="/user/create"/>">Register</a>
    <a href="<c:url value="/index.jsp"/>">Main page</a>
</body>
</html>
