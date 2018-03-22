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
            <li><a class="active" href="<c:url value='/curriculum' />">Assignments</a></li>
            <li><a class="active" href="<c:url value='/userProfileServlet' />">My Profile</a></li>
            <li><a class="active" href="credits.jsp">Credits</a></li>
            <li style="float:right"><a class="active" href="index.html">Logout</a></li>
        </ul>
    </header>
    <div class="content_frame">

<!-- ---------- CONTENT START HERE ---------- -->

    <h1>Assignments</h1>

    <table class="assignments_list_table">
        <tr class="header">
            <td>Nr.</td>
            <td>Title</td>
            <td>Description</td>
            <td>MaxScore</td>
            <td></td>
        </tr>
        <c:forEach items="${assignlist}" var="element">
     <form action="showAssignmentServlet" method="post">
        <tr class="content">
            <td>
                ${element.getNumber()}
                <input type="hidden" type="text" name="number" value="${element.getNumber()}">
            </td>
            <td>${element.getTitle()}</td>
            <td>${element.getDescription()}</td>
            <td>${element.getMaxScore()}</td>
            <td><input type="submit" value="Show" class="send_button"></td>
        </tr>
    </form>
        </c:forEach>
    </table>

<!-- ---------- CONTENT END HERE ---------- -->

    </div>


<script>
function myFunction() {
      var div = document.getElementById("myDIV");
      div.innerHTML = "AFJASFAS";
 }
</script>

</body>
</html>
