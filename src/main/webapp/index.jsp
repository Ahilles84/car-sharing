<%--
  Created by IntelliJ IDEA.
  User: snowball
  Date: 13.01.2023
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
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
</div>

<div>
    <div>
        <button onclick="location.href='/login'">Login</button>
        <button onclick="location.href='/logout'">Logout</button>
        <button onclick="location.href='/user/read'">Users List</button>
        <button onclick="location.href='/user/create'">Register</button>
        <button onclick="location.href='/cars'">Cars list</button>
    </div>
</div>
</body>
</html>