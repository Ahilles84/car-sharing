<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>Users list</h1>
<table>
    <thead>
    <tr>
        <th>First Name</th>
        <th>Second Name</th>
        <th>Age</th>
        <th>Login</th>
        <th>Role</th>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="users" scope="request" type="java.util.List"/>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.age}</td>
            <td>${user.login}</td>
            <td>${user.role}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<c:url value="/user/create"/>">Register</a>
<a href="<c:url value="/user/delete"/>">Delete User</a>
<a href="<c:url value="/index.jsp"/>">Main page</a>
</body>
</html>