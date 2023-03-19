<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to our car-sharing!</title>
</head>
<body>
<div>
    <h1>Take and Drive!</h1>
    <h2>Hello, <c:out value="${sessionScope.login}" default="guest"/>!</h2>
</div>

<div>
    <div>
        <button onclick="location.href='/login'">Login</button>
        <button onclick="location.href='/logout'">Logout</button>
        <button onclick="location.href='/user/create'">Register</button>
        <button onclick="location.href='/cars'">Cars list</button>
    </div>
</div>
</body>
</html>