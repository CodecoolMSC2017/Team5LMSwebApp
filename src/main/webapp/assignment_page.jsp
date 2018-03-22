<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Assignment Page</title>
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


    <form>
    <table class="assignments_list_table">
        <tr class="header">
            <td>Nr.</td>
            <td>Title</td>
            <td>Description</td>
            <td>MaxScore</td>
            <td>Question</td>
        </tr>
        <c:forEach items="${assignlist}" var="element">
        <tr class="content">
            <td>${element.getNumber()}</td>
            <td>${element.getTitle()}</td>
            <td>${element.getDescription()}</td>
            <td>${element.getMaxScore()}</td>
            <td>${element.getQuestion()}</td>
        </tr>
        </c:forEach>
    </table>
    </form>


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
