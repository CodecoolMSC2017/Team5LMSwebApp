<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <body>
        <div class="menu_bar">

            <a href="HomeServlet"><div class="menu_option">Home</div></a>
            <a href="AandQStoreServlet"><div class="menu_option">Assignments</div></a>

            <c:if test="${userProfile.getRole() == 'Student'}">
                <a href="#"><div class="menu_option">Grades</div></a>
            </c:if>

            <c:if test="${userProfile.getRole() == 'Mentor'}">
                <div class="menu_option">
                    Stats
                    <div class="sub_menu">
                        <a href="attendanceServlet">Attendance</a>
                        <a href="AttendanceHistoryServlet">Attendance History</a>
                    </div>
                </div>
            </c:if>

            <a href="userListServlet"><div class="menu_option">Users</div></a>
            <a href="userProfileServlet?id=${userProfile.name}"><div class="menu_option">Profile</div></a>

            <a href="logoutServlet"><div class="menu_option" style="position: absolute; bottom: 0;">Logout</div></a>
        </div>
    </body>
</html>
