<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
  <title>Delete User</title>
</head>
<body>
<div>
  <h1>Input login of the user you want to delete:</h1>
</div>
<table>
  <thead>
  <tr>
    <th>Login</th>
  </tr>
  </thead>
  <tbody>
  <form action="<c:url value="/user/delete"/>" method="post">
    <tr>
      <td><label>
        <input type="text" name="Login" placeholder="login">
      </label></td>
      <td><input type="submit" value="SUBMIT"></td>
    </tr>
  </form>
  </tbody>
</table>
<a href="<c:url value="/index.jsp"/>">Main page</a>
</body>
</html>
