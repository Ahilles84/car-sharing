<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Sign in</title>
</head>
<body>
<div>
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
            <td><input type="submit" value="SUBMIT"></td>
        </tr>
    </form>
    </tbody>
</table>
<a href="<c:url value="/index.jsp"/>">Main page</a>
</body>
</html>