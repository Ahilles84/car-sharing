<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User not found</title>
</head>
<body>
<div>
    <h1>User with such login not found. Please try again.</h1>
</div>
<a href="<c:url value="/user/delete"/>">Register</a>
<a href="<c:url value="/index.jsp"/>">Main page</a>
</body>
</html>

