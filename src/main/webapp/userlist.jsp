<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UserList</title>
</head>
<body>



<c:out value="Hello"/>

<c:forEach items="${userlist}" var="element">
  <tr>
    <td>${element.getMessage}</td>
    <td>${element.getPoster}</td>

  </tr>
</c:forEach>

<c:forEach items="${userlist}" var="element">
    <p>${element.getPoster}: ${element.getMessage}</p>
</c:forEach>


<c:forEach items="${userlist}" var="element">
    <tr>
        <td>poster: <c:out value="${element.getPoster}"/></td>
        <td>Message: <c:out value="${element.getMessage}"/></td>
    </tr>
</c:forEach>

<a href="index.html">Go back</a>
</body>
</html>
