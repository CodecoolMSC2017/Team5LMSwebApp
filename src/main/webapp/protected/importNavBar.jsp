<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <body>
        <div class="menu_bar">

            <a href="HomeServlet">
                <div class="menu_option">
                    <img src="../images/logo.png"><br>
                    Home
                </div>
            </a>

            <a href="AandQStoreServlet">
                <div class="menu_option">
                    <i class="fa fa-file-text-o fa-2x" aria-hidden="true"></i><br>
                    Assignments
                </div>
            </a>

            <c:if test="${userProfile.getRole() == 'Student'}">
                <a href="#">
                    <div class="menu_option">
                        <i class="fa fa-bar-chart fa-2x" aria-hidden="true"></i><br>
                        Grades
                    </div>
                </a>
            </c:if>

            <c:if test="${userProfile.getRole() == 'Mentor'}">
                <div class="menu_option">
                    <i class="fa fa-bar-chart fa-2x" aria-hidden="true"></i><br>
                    Stats
                    <div class="sub_menu">
                        <a href="attendanceServlet">Attendance</a>
                        <a href="AttendanceHistoryServlet">Attendance History</a>
                    </div>
                </div>
            </c:if>

            <a href="userListServlet">
                <div class="menu_option">
                    <i class="fa fa-users fa-2x" aria-hidden="true"></i><br>
                    Users
                </div>
            </a>

            <a href="userProfileServlet?id=${userProfile.name}">
                <div class="menu_option">
                    <i class="fa fa-user-circle-o fa-2x" aria-hidden="true"></i><br>
                    Profile
                </div>
            </a>



            <a href="logoutServlet">
                <div class="menu_option" style="position: absolute; bottom: 0;">
                    <i class="fa fa-sign-out fa-2x" aria-hidden="true"></i><br>
                    Logout
                </div>
            </a>

        </div>
    </body>
</html>
