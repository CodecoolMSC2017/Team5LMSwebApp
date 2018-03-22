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
            <li><a class="active" href="credits.jsp">Credits</a></li>
            <li style="float:right"><a class="active" href="index.html">Logout</a></li>
        </ul>
    </header>
    <div class="content_frame">

<!-- ---------- CONTENT START HERE ---------- -->

    <h1>Edit User Profile</h1>

        <form action="registrationServlet" method="post">
        <table class="user_profile_table" align="center">
            <tr class="content">
                <td class="col-1">Username:</td>
                <td class="col-2"><input type="text" name="name" value="${userProfile.name}" class="input_field" readonly="readonly"></td>
            </tr>
            <tr class="content">
                <td class="col-1">First name:</td>
                <td class="col-2"><input type="text" name="firstname" value="${userProfile.name}" class="input_field"></td>
            </tr>
            <tr class="content">
                <td class="col-1">Last name:</td>
                <td class="col-2"><input type="text" name="lastname" value="${userProfile.name}" class="input_field"></td>
            </tr>
            <tr class="content">
                <td class="col-1">E-mail address: <span class="recommended">*</span></td>
                <td class="col-2"><input type="email" name="email" value="${userProfile.password}" class="input_field" readonly="readonly"></td>
            </tr>
            <tr class="content">
                <td class="col-1">Role:</td>
                <td class="col-2"><input type="text" name="name" value="${userProfile.role}" class="input_field" readonly="readonly"></td>
            </tr>
            <tr class="content" valign="top">
                <td class="col-1">Other:</td>
                <td class="col-2"><textarea rows="4" cols="65" name="other" value="${userProfile.role}" class="input_field"></textarea></td>
            </tr>
              <tr class="content">
                <td class="col-1">Password: <span class="recommended">*</span></td>
                <td class="col-2"><input type="password" name="password" value="" class="input_field" required></td>
            </tr>
            <tr class="content">
                <td class="col-1">Confirm password: <span class="recommended">*</span></td>
                <td class="col-2"><input type="password" name="password_confirm" value="" class="input_field" required></td>
            </tr>
        </table>
        <br><span class="recommended">* Recommended</span><br>
        <center>
        <input type="submit" value="Save Changes" class="send_button">
        <input type="reset" value="Reset" class="send_button">
        <input type="button" value="Cancel" class="send_button" onclick="history.back()">
        </center>
        </form>

<!-- ---------- CONTENT END HERE ---------- -->

    </div>

</body>
</html>
