<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:if test="${login.name == null}">
        <!-- <meta http-equiv="refresh" content="0; url=index.html" /> -->
    </c:if>
    <title>User List</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

    <table class="user_table" align="center">
        <tr class="header">
            <td>Name</td>
            <td>E-mail</td>
            <td>Role</td>
        </tr>
    <c:forEach items="${userlist}" var="element">
        <tr class="content">
            <td>${element.getName()}</td>
            <td>${element.getEmail()}</td>
            <td align="center">${element.getRole()}</td>
        </tr>
    </c:forEach>
    </table>

</body>
</html>
