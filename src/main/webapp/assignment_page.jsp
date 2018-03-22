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

    <h1>Assignment: ${assignment.title}</h1>


    <form>
    <table class="assignments_list_table">
        <tr class="header">
            <td width="10%">Nr.</td>
            <td width="45%">Title</td>
            <td width="45%">Description</td>
        </tr>
        <tr class="content">
            <td>${assignment.number}</td>
            <td>${assignment.title}</td>
            <td>${assignment.description}</td>
        </tr>
        <tr class="content">
            <td style="text-align: justify" colspan="3">
                ${assignment.description}
            </td>
        </tr>
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
