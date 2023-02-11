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
    <link rel="stylesheet" href="pages/styles/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-left-align">
    <h1>Take and Drive!</h1>
    <h2>Hello, <c:out value="${sessionScope.login}"/>!</h2>
</div>

<div class="w3-container w3-center">
    <div class="w3-bar w3-padding-large w3-padding-24">
        <button class="w3-btn w3-hover-yellow w3-round-large" onclick="location.href='/login'">Login</button>
        <button class="w3-btn w3-hover-orange w3-round-large" onclick="location.href='/logout'">Logout</button>
        <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/user/read'">Users List
        </button>
        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/user/create'">Register</button>
        <button class="w3-btn w3-hover-red w3-round-large" onclick="location.href='/cars'">Cars list</button>
    </div>
</div>
</body>
</html>