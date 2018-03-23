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

    <h1>Edit User Profile</h1>

        <form action="editProfileSaveServlet" method="post" oninput="result.value=!!password_confirm.value&&(password.value==password_confirm.value)?'Match!':'Nope!'">
        <table class="user_profile_table" align="center">
            <tr class="content">
                <td class="col-1">Username:</td>
                <td class="col-2"><input type="text" name="name" value="${userProfile.name}" class="input_field" readonly="readonly"></td>
            </tr>
            <tr class="content">
                <td class="col-1">First name:</td>
                <td class="col-2"><input type="text" name="firstname" value="${userProfile.firstName}" class="input_field"></td>
            </tr>
            <tr class="content">
                <td class="col-1">Last name:</td>
                <td class="col-2"><input type="text" name="lastname" value="${userProfile.lastName}" class="input_field"></td>
            </tr>
            <tr class="content">
                <td class="col-1">E-mail address: <span class="recommended">*</span></td>
                <td class="col-2"><input type="email" name="email" value="${userProfile.email}" class="input_field" readonly="readonly"></td>
            </tr>
            <tr class="content">
                <td class="col-1">Role:</td>
                <td class="col-2"><input type="text" name="role" value="${userProfile.role}" class="input_field" readonly="readonly"></td>
            </tr>
            <tr class="content" valign="top">
                <td class="col-1">Other:</td>
                <td class="col-2"><textarea rows="4" cols="65" name="other" value="${userProfile.role}" class="input_field"></textarea></td>
            </tr>
              <tr class="content">
                <td class="col-1">Password: <span class="recommended">*</span></td>
                <td class="col-2"><input id="password" name="password" type="password" pattern="^\S{6,}$" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Must have at least 6 characters' : ''); if(this.checkValidity()) form.password_confirm.pattern = this.value;" placeholder="" required></td>
            </tr>
            <tr class="content">
                <td class="col-1">Confirm password: <span class="recommended">*</span></td>
                <td class="col-2"><input id="password_confirm" name="password_confirm" type="password" pattern="^\S{6,}$" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Please enter the same Password as above' : '');" placeholder="" required></td>
            </tr>
        </table>

        <br><span class="recommended">* Recommended</span><br>
        <center>
        <input type="submit" value="Save Changes" class="submit">
        <input type="reset" value="Reset" class="submit">
        <input type="button" value="Cancel" class="submit" onclick="history.back()">
        </center>
        </form>

<!-- ---------- CONTENT END HERE ---------- -->

    </div>

</body>
</html>
