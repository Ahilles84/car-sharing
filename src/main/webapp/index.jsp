<%--
  Created by IntelliJ IDEA.
  User: steba
  Date: 13.01.2023
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new user</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>age</th>
    </tr>
    </thead>

    <tbody>
    <form action="/user/create" method="post">
        <tr>
            <td><input type="text" name="firstName" placeholder="put your firstname"></td>
            <td><input type="text" name="lastName" placeholder="put your lastname"></td>
            <td><input type="text" name="age" placeholder="put your age"></td>
            <td><input type="submit" value="CREATE"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
