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

    <div class="menu_on_top">
        <ul>
          <li><a class="active" href="main.jsp">Home</a></li>
          <li><a class="active" href="userlist.jsp">Userlist</a></li>
          <li><a class="active" href="curicullum.jsp">Assigments</a></li>
          <li><a class="active" href="">My Profile</a></li>
          <li style="float:right"><a class="active" href="index.html">Logout</a></li>
        </ul>
    </div>

    <form action="userlist" method="post">
        <input type="submit" value="Show user list" class="send_button">
    </form>

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
