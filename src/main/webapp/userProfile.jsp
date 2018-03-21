<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UserProfile</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

    <div class="menu_on_top">
        <ul>
          <li><a class="active" href="main.jsp">Home</a></li>
          <li><a class="active" href="<c:url value='/userlist' />">Userlist</a></li>
          <li><a class="active" href="curicullum.jsp">Assigments</a></li>
          <li><a class="active" href="">My Profile</a></li>
          <li style="float:right"><a class="active" href="index.html">Logout</a></li>
        </ul>
    </div>

    <div class="user_profile">
        <table>
            <tr>
                <td> Your name</td>
                <td>${login.name}</td>
            </tr>
            <tr>
                <td>E-mail address</td>
                <td>${login.email}</td>
            </tr>
            <tr>
                <td>Password</td>
                <td>${login.password}</td>
            </tr>
            <tr>
                <td>Role</td>
                <td>${login.role}</td>
            </tr>
        </table>
    </div>

</body>
</html>
