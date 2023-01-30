<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: snowball
  Date: 28.01.2023
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
    <link rel="stylesheet" href="pages/styles/w3.css">
</head>
<body>
<div class="w3-container w3-blue-grey w3-opacity w3-left-align">
    <h1>Please sign in!</h1>
</div>
<table>
    <thead>
    <tr>
        <th>Login</th>
        <th>Password</th>
    </tr>
    </thead>
    <tbody>
    <form action="<c:url value="/login"/>" method="post">
        <tr>
            <td><label>
                <input type="text" name="Login" placeholder="login">
            </label></td>
            <td><label>
                <input type="text" name="Password" placeholder="password">
            </label></td>
            <td><input type="submit" value="SUBMIT" class="w3-btn w3-green w3-round-large w3-margin-bottom"></td>
        </tr>
    </form>
    </tbody>
</table>
    <a href="<c:url value="/index.html"/>">Main page</a>
</body>
</html>
