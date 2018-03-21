<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Curicullum View Pagee</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

    <header>
        <ul>
            <li><a class="active" href="home.jsp">Home</a></li>
            <li><a class="active" href="<c:url value='/userlist' />">Userlist</a></li>
            <li><a class="active" href="assigments.jsp">Assigments</a></li>
            <li><a class="active" href="<c:url value='/userProfileServlet' />">My Profile</a></li>
            <li style="float:right"><a class="active" href="index.html">Logout</a></li>
        </ul>
    </header>
    <form action="curicullum" method="post">
        <input type="submit" value="Show aasignments" class="send_button">
    </form>

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

</body>
