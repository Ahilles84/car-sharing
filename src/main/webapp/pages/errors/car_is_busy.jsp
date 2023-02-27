<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Car is busy</title>
</head>
<body>
<div>
    <h1>This car is busy. Choose another one, please!</h1>
</div>
<a href="<c:url value="/cars"/>">Cars list</a>
<a href="<c:url value="/index.jsp"/>">Main page</a>
</body>
</html>