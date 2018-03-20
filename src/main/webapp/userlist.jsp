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

<c:forEach items="${userlist}" var="element">
   <form action="page" method="post">
       <input type="hidden" name="title" value=${element.getName()}>
       <input type="hidden" name="content" value=${element.getMessage()}>
       <input type="submit" value=${element.getEmail()}>
   </form>
</c:forEach>

</body>
</html>
