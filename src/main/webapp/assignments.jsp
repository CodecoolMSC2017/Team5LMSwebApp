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

    <form action="curriculum" method="post">
        <input type="submit" value="Show assignments" class="send_button">
    </form>
    <br>
    <c:forEach items="${assignlist}" var="element">
        <table>
            <tr class="content">

              <td>${element.getNumber()}</td>
                <c:set var="savedNumber" value="${element.getNumber()}" />
              <td>${element.getTitle()}</td>

              <c:forEach items="${assignlist}" var="element">

              <div id="myDIV">


                <c:if test = "${element.getNumber() == savedNumber}">
                  ${element.getDescription()}

                  </c:if>
               </div>
                </c:forEach>
            </tr>
        </table>
        </form>
    </c:forEach>

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
