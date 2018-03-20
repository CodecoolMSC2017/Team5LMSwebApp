<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UserList</title>
</head>
<body>

<table width="60%" border="1" colspan="0" rowspan="0" align="center">
    <tr align="center">
        <td><b>Name</b</td>
        <td><b>E-Mail</b</td>
        <td><b>Role</b></td>
    </tr>
<c:forEach items="${userlist}" var="element">
    <tr>
        <td>${element.getName()}</td>
        <td>${element.getEmail()}</td>
        <td>${element.getRole()}</td>
    </tr>
</c:forEach>
</table>

</body>
</html>
