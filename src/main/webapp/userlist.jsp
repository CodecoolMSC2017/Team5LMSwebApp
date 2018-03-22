<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>User list</title>
</head>
<body>

    <header>
        <ul>
            <li><a class="active" href="home.jsp">Home</a></li>
            <li><a class="active" href="<c:url value='/userlist' />">User list</a></li>
            <li><a class="active" href="assignments.jsp">Assignments</a></li>
            <li><a class="active" href="<c:url value='/userProfileServlet' />">My Profile</a></li>
            <li><a class="active" href="credits.jsp">Credits</a></li>
            <li style="float:right"><a class="active" href="index.html">Logout</a></li>
        </ul>
    </header>
    <div class="content_frame">

<!-- ---------- CONTENT START HERE ---------- -->

    <h1>User list</h1>

    <table class="user_list_table" align="center">
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

<!-- ---------- CONTENT END HERE ---------- -->

    </div>

</body>
</html>
