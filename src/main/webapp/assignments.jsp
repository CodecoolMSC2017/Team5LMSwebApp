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
            <li><a class="active" href="home.jsp">Home</a></li>
            <li><a class="active" href="<c:url value='/userlist' />">User list</a></li>
            <li><a class="active" href="assignments.jsp">Assignments</a></li>
            <li><a class="active" href="<c:url value='/userProfileServlet' />">My Profile</a></li>
            <li style="float:right"><a class="active" href="index.html">Logout</a></li>
        </ul>
    </header>
    <div class="content_frame">

<!-- ---------- CONTENT START HERE ---------- -->

    <h1>Assignments</h1>

    <form action="curicullum" method="post">
        <input type="submit" value="Show aasignments" class="send_button">
    </form>
    <br>
    <c:forEach items="${assignlist}" var="element">
        <form action="/action_page.php">
        <table>
            <tr class="content">
              Change numbers: <input type="number" name="change"><td>${element.getNumber()}</td>
              <td>${element.getTitle()}</td>
              <td>${element.getDescription()}</td>
            </tr>
        </table>
        </form>
    </c:forEach>

<!-- ---------- CONTENT END HERE ---------- -->

    </div>

</body>
</html>
