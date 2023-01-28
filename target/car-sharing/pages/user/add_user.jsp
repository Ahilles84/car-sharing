<%--
  Created by IntelliJ IDEA.
  User: steba
  Date: 13.01.2023
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new user</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
    <div class="w3-container w3-blue-grey w3-opacity w3-left-align">
        <h1>Please fill in the form below.</h1>
    </div>
<table>
    <thead>
    <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Age</th>
        <th>Login</th>
        <th>Password</th>
        <th>User Type</th>
    </tr>
    </thead>

    <tbody>
    <form action="<c:url value="/user/create"/>" method="post">
        <tr>
            <td><label>
                <input type="text" name="firstName" placeholder="enter your firstname">
            </label></td>
            <td><label>
                <input type="text" name="lastName" placeholder="enter your lastname">
            </label></td>
            <td><label>
                <input type="text" name="age" placeholder="enter your age">
            </label></td>
            <td><label>
                <input type="text" name="login" placeholder="enter your login">
            </label></td>
            <td><label>
                <input type="text" name="password" placeholder="enter your password">
            </label></td>
            <td><label>
                <input type="text" name="userType" placeholder="choose your userType">
            </label></td>
<%--            <p>--%>
<%--                <label>--%>
<%--                    <select size="2">--%>
<%--                        <option disabled>choose your userType</option>--%>
<%--                        <option value="USER">USER</option>--%>
<%--                        <option value="ADMIN">ADMIN</option>--%>
<%--                    </select>--%>
<%--                </label>--%>
<%--            </p>--%>
            <td><input type="submit" value="CREATE" class="w3-btn w3-green w3-round-large w3-margin-bottom"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
