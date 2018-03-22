<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Edit Profile</title>
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

    <h1>Edit User Profile</h1>

        <form action="registrationServlet" method="post">
        <table class="user_profile_table" align="center">
            <tr class="content">
                <td class="col-1">Name:</td>
                <td class="col-2"><input type="text" name="name" value="${userProfile.name}" class="input_field"  readonly="readonly"></td>
            </tr>
            <tr class="content">
                <td class="col-1">E-mail address:</td>
                <td class="col-2"><input type="email" name="email" value="${userProfile.password}" class="input_field" required></td>
            </tr>
            <tr class="content">
                <td class="col-1">Role:</td>
                <td class="col-2"><input type="text" name="name" value="${userProfile.role}" class="input_field"  readonly="readonly"></td>
            </tr>
            <tr class="content">
                <td class="col-1">Password:</td>
                <td class="col-2"><input type="password" name="password" value="" class="input_field" required></td>
            </tr>
            <tr class="content">
                <td class="col-1">Confirm password:</td>
                <td class="col-2"><input type="password" name="password_confirm" value="" class="input_field" required></td>
            </tr>
        </table>
        </form>

        <center>
        <br>
        <input type="submit" value="Save Changes" class="send_button">
        <input type="button" value="Cancel" class="send_button" onclick="history.back()">
        </center>

<!-- ---------- CONTENT END HERE ---------- -->

    </div>

</body>
</html>
