<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>User Profile</title>
</head>
<body>

    <header>
        <ul>
            <li><a class="active" href="home.jsp">Home</a></li>
            <li><a class="active" href="<c:url value='/userlist' />">User list</a></li>
            <li><a class="active" href="assignments.jsp">Assignments</a></li>
            <li><a class="active" href="<c:url value='/userProfileServlet' />">My Profile</a></li>
            <li style="float:right"><a class="active" href="index.html">Logout</a></li>
        </ul>
    </header>
    <div class="content_frame">

<!-- ---------- CONTENT START HERE ---------- -->

    <h1>${userProfile.name}</h1>

        <table>
            <tr>
                <td> Your name</td>
                <td>${userProfile.name}</td>
            </tr>
            <tr>
                <td>E-mail address</td>
                <td>${userProfile.email}</td>
            </tr>
            <tr>
                <td>Password</td>
                <td>${userProfile.password}</td>
            </tr>
            <tr>
                <td>Role</td>
                <td>${userProfile.role}</td>
            </tr>
        </table>


<!-- ---------- CONTENT END HERE ---------- -->

    </div>

</body>
</html>
