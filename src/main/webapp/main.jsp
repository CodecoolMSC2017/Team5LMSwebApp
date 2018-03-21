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

<header>
    Hello ${login.name}!
</header>

<div class="site_frame">
    <div class="site_frame_left_column">

<!-- LEFT COLUMN START HERE -->

        <form action="userlist" method="post">
            <input type="submit" value="Show user list" class="send_button">
        </form>

        <form action="userProfileServlet" method="post">
            <input type="submit" value="Edit user profile" class="send_button">
        </form>

        <form action="curicullum" method="post">
            <input type="submit" value="Show aasignments" class="send_button">
        </form>

<!-- LEFT COLUMN END HERE -->

    </div>
    <div class="site_frame_right_column">

<!-- CONTENT START HERE -->



<!-- CONTENT END HERE -->

    </div>
    <div style="clear:both"></div>
</div>

</body>
</html>
