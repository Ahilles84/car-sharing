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
    <title>Users</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/styles/w3.css">
</head>
<body class="w3-light-grey">
  <h1>Users list</h1>
  <h2>New user "<c:out value="${sessionScope.newLogin}"/>" created successfully!</h2>
<table>
  <thead>
    <tr>
      <th>First Name</th>
      <th>Second Name</th>
      <th>Age</th>
      <th>Login</th>
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
      </tr>
    </c:forEach>
  </tbody>
</table>
  <a href="<c:url value="/user/create"/>">Register</a>
  <a href="<c:url value="/index.jsp"/>">Main page</a>
</body>
</html>
