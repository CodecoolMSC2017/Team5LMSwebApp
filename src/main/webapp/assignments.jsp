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

<!-- ---------- CONTENT START HERE ---------- -->

    <h1>Assignments</h1>

    <table class="assignments_list_table">
        <tr class="header">
            <td>Nr.</td>
            <td>Title</td>
            <td>Description</td>
            <td>TimeToLearn(hour)</td>
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
                    <td>${element.getTime()}</td>
                    <td><input type="submit" value="Show" class="submit"></td>
                </tr>
            </form>



        </c:forEach>



    </table>
    <form action="quizservlet" method="post">
    <h1>Python Quiz</h1>
        <td><input type="submit" value="Show Quiz" class="submit"></td>
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
