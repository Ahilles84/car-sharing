<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admins page</title>
</head>
<body>
<div>
    <h1>Car-sharing "Taken' Drive!"</h1>
    <h2>Hello, <c:out value="${sessionScope.login}"/>!</h2>
</div>

<div>
    <div>
        <button onclick="location.href='/logout'">Logout</button>
        <button onclick="location.href='/user/create'">Register</button>
        <button onclick="location.href='/cars'">Cars list</button>
        <button onclick="location.href='/users'">Users list</button>
        <button onclick="location.href='/car/create'">Add new car</button>
    </div>
</div>
<a href="<c:url value="/index.jsp"/>">Main page</a>
</body>
</html>