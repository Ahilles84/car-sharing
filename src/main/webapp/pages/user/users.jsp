<%--
  Created by IntelliJ IDEA.
  User: snowball
  Date: 13.01.2023
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<table>
  <thead>
    <tr>
      <th>First Name</th>
      <th>Second Name</th>
      <th>Age</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="user" items="${users}">
      <tr>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.age}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>
