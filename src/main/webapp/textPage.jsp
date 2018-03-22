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

    <h1>Add a Text Page</h1>


    <div class="text_page" align="center">
        <form action="textPageServlet">
            <input type="text" id="title" name="title" placeholder="Please enter the title of text here">
        <br>
        <br>
        <textarea rows="4" cols="50" name="comment" form="usrform">
        Enter text here...</textarea>
        </form>
        <center>
        <br>
        <form action="textPage.jsp">
            <input type="submit" value="Save">
        </form>
        </center>
    </div>

<!-- ---------- CONTENT END HERE ---------- -->

    </div>

</body>
</html>
