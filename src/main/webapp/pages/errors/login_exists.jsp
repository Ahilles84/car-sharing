<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login exists</title>
</head>
<body>
<div>
    <h1>User with such login already exists. Please choose another login.</h1>
</div>
<a href="<c:url value="/user/create"/>">Register</a>
<a href="<c:url value="/index.jsp"/>">Main page</a>
</body>
</html>