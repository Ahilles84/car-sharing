<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Wrong credentials</title>
</head>
<body>
    <div>
        <h1>Login or password is wrong. Please try again or register.</h1>
    </div>
    <a href="<c:url value="/login"/>">Sign in</a>
    <a href="<c:url value="/user/create"/>">Register</a>
    <a href="<c:url value="/index.jsp"/>">Main page</a>
</body>
</html>
