<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>User list</title>
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

    <h1>User list<c:if test = "${userProfile.role == 'Mentor'}"> / Attendance</c:if></h1>

    <form action="attendanceServlet" method="post">
        <table class="user_list_table" align="center">
            <tr class="header">
                <td>Username</td>
                <td>Firstname</td>
                <td>Lastname</td>
                <td>E-mail</td>
                <td width="70px">Role</td>
                <c:if test = "${userProfile.role == 'Mentor'}">
                    <td width="60px">Attand.</td>
                    <td width="40px">%</td>
                </c:if>
            </tr>
        <c:forEach items="${userlist}" var="element">
            <tr class="content">
                <td>${element.getName()}</td>
                <td>${element.getFirstName()}</td>
                <td>${element.getLastName()}</td>
                <td>${element.getEmail()}</td>
                <td>${element.getRole()}</td>
                <c:if test = "${userProfile.role == 'Mentor'}">
                    <td>
                        <c:if test = "${element.getRole() == 'Student'}">
                            <select name="attendance" class="drop_down_button" required>
                                <option value="0">Out</option>
                                <option value="1">In</option>
                            </select>
                        </c:if>
                    </td>
                    <c:if test = "${element.getRole() == 'Student'}">
                        <td>${element.getAttendance()}</td>
                    </c:if>
>>>>>>> 627eadc72a6bd3ecf06f1753e54df6c8565d0922
                </c:if>
            </tr>
        </c:forEach>
        <c:if test = "${userProfile.role == 'Mentor'}">
           <tr class="content">
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td align="center"><input type="submit" value="Update" class="send_button"></td>
            </tr>
        </c:if>
        </table>
    </form>

<!-- ---------- CONTENT END HERE ---------- -->

    </div>

</body>
</html>
