<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Curicullum View Pagee</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<c:forEach items="${assignlist}" var="element">
        <tr class="content">
            <td>${element.getAssignmentNumber()}</td>
            <td>${element.getAssignmentTitle()}</td>
            <td>${element.getAssignmentDescription()}</td>
            <td align="center">${element.getRole()}</td>
        </tr>
    </c:forEach>

</body>
