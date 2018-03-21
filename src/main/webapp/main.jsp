<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:if test="${login.name == null}">
        <!-- <meta http-equiv="refresh" content="0; url=index.html" /> -->
    </c:if>
    <title>Main page</title>
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

    <div class="registration_box">
        <h1>Hello ${login.name}!</h1>
        OK, you logged in

        <form action="userProfileServlet" method="post">
            <input type="submit" value="Edit user profile" class="send_button">
        </form>
    </div>


</body>
</html>
