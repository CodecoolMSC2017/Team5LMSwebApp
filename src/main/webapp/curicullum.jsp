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
        <table>
            <tr class="content">
                <td>${element.getNumber()}</td>
                <td>${element.getTitle()}</td>
                <td>${element.getDescription()}</td>
            </tr>
        </table>
    </c:forEach>

</body>
