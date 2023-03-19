<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Guest user</title>
</head>
<body>
<div>
    <h1>Please authorise before continue</h1>
</div>
<a href="<c:url value="/login"/>">Sign in</a>
<a href="<c:url value="/user/delete"/>">Register</a>
<a href="<c:url value="/index.jsp"/>">Main page</a>
</body>
</html>