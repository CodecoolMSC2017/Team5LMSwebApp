<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Assignments</title>
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
    <br />
<c:forEach items="${quizlist}" var="element">
    <form>
        <table>
            <tr class="content">
                <h3>${element.question}</h3>
                <td>${element.possibleAnswer1}</td>
                <input type="radio" name="answer1" value="${element.possibleAnswer1}" checked="checked">${element.possibleAnswer1}<br>
                <input type="radio" name="answer1" value="${element.possibleAnswer2}" checked="checked">${element.possibleAnswer2}<br>
                <input type="radio" name="answer1" value="${element.possibleAnswer3}" checked="checked">${element.possibleAnswer3}<br>
                <input type="submit" value="Submit"  class="submit" />
            </tr>
        </table>
        </form>
</c:forEach>
</div>
</body>
