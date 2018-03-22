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

    <form action="attendanceServlet" method="post">
        <table class="user_list_table" align="center">
            <tr class="header">
                <td>Username</td>
                <td>Firstname</td>
                <td>Lastname</td>
                <td>E-mail</td>
                <td>Role</td>
                <c:if test = "${userProfile.role == 'Mentor'}">
                    <td>Att.</td>
                </c:if>
            </tr>
        <c:forEach items="${userlist}" var="element">
            <tr class="content">
                <td>${element.getName()}</td>
                <td>${element.getFirstName()}</td>
                <td>${element.getLastName()}</td>
                <td>${element.getEmail()}</td>
                <td align="center">${element.getRole()}</td>
                <c:if test = "${userProfile.role == 'Mentor'}">
                    <td><input type="checkbox" name="attendance"></td>
                </c:if>
            </tr>
        </c:forEach>
        </table>

        <c:if test = "${userProfile.role == 'Mentor'}">
           <div style="text-align: right"><input type="submit" value="Update attance" class="send_button"></div>
        </c:if>
    </form>

<!-- ---------- CONTENT END HERE ---------- -->

    </div>

</body>
</html>
