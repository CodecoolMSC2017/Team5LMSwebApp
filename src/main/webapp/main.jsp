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

    <div class="registration_box">
        <h1>Hello ${login.name}!</h1>
        OK, you logged in
        <form action="userlist" method="post">
            <input type="submit" value="Show user list" class="send_button">
        </form>

        <form action="" method="post">
            <input type="submit" value="..." class="send_button">
        </form>

        <form action="userProfileServlet" method="post">
            <input type="submit" value="Edit user profile" class="send_button">
        </form>

        <form action="curicullum" method="post">
            <input type="submit" value="Show aasignments" class="send_button">
        </form>
    </div>


</body>
</html>
