<%--
  Created by IntelliJ IDEA.
  User: snowball
  Date: 29.01.2023
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new car</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/styles/w3.css">
</head>
<body>
<div class="w3-container w3-blue-grey w3-opacity w3-left-align">
    <h1>Please fill in the form below.</h1>
</div>
<table>
    <thead>
    <tr>
        <th>Model</th>
        <th>Reg. Number</th>
        <th>Status</th>
    </tr>
    </thead>

    <tbody>
    <form action="<c:url value="/car/create"/>" method="post">
        <tr>
            <td><label>
                <input type="text" name="model" placeholder="model">
            </label></td>
            <td><label>
                <input type="text" name="registrationNumber" placeholder="reg. №">
            </label></td>
            <td><label>
                <input type="text" name="status" placeholder="status">
            </label></td>
            <td><input type="submit" value="CREATE" class="w3-btn w3-green w3-round-large w3-margin-bottom"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>

