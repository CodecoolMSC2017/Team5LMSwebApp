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
            <li><a class="active" href="home.jsp"><img src="images/menu_home.png">Home</a></li>
            <li><a class="active" href="<c:url value='/userlist' />"><img src="images/menu_userlist.png"">User list</a></li>
            <li><a class="active" href="<c:url value='/curriculum' />"><img src="images/menu_assignments.png"">Assignments</a></li>
            <li><a class="active" href="<c:url value='/userProfileServlet' />"><img src="images/menu_profile.png"">My Profile</a></li>
            <li><a class="active" href="credits.jsp"><img src="images/menu_credits.png"">Credits</a></li>
            <li style="float:right"><a class="active" href="index.html">Logout</a></li>
        </ul>
    </header>
    <div class="content_frame">

<!-- ---------- CONTENT START HERE ---------- -->

    <h1>User Profile</h1>

        <table class="user_profile_table" align="center">
            <tr class="content">
                <td class="col-1">Username:</td>
                <td class="col-2">${userProfile.name}</td>
            </tr>
            <tr class="content">
                <td class="col-1">First name:</td>
                <td class="col-2">${userProfile.firstName}</td>
            </tr>
            <tr class="content">
                <td class="col-1">Last name:</td>
                <td class="col-2">${userProfile.lastName}</td>
            </tr>
            <tr class="content">
                <td class="col-1">E-mail address:</td>
                <td class="col-2">${userProfile.email}</td>
            </tr>
            <tr class="content">
                <td class="col-1">Password:</td>
                <td class="col-2">${userProfile.password}</td>
            </tr>
            <tr class="content">
                <td class="col-1">Role:</td>
                <td class="col-2">
                    ${userProfile.role}
                    <c:if test = "${userProfile.role == 'Mentor'}">
                        <img src="images/mentor.ico" style="margin-bottom: -4px;">
                    </c:if>
                </td>
            </tr>
            <tr class="content">
                <td class="col-1">Other:</td>
                <td class="col-2"></td>
            </tr>
        </table>

        <center>
        <br>
<!--
        <form action="editprofile.jsp">
            <input type="submit" value="Edit" href="editProfileServlet">
        </form>
-->

        <div class="submit_div"><a href="<c:url value='/editProfileServlet' />">My Profile</a></div>
        </center>
        <br>

<!-- ---------- CONTENT END HERE ---------- -->

    </div>

</body>
</html>
