<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new user</title>
</head>
<body>
<div>
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
            <td><input type="submit" value="CREATE"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>