<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new car</title>
</head>
<body>
<div>
    <h1>Please fill in the form below.</h1>
</div>
<table>
    <thead>
    <tr>
        <th>Model</th>
        <th>Reg. Number</th>
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
            <td><input type="submit" value="CREATE"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
