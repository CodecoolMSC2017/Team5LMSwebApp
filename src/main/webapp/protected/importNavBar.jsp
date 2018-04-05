<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <body>
        <div class="menu_bar">
            <div class="menu_option">
                <button class="menu_button"><a href="#">Home</a></button>
            </div>
            <div class="menu_option">
                <button class="menu_button"><a href="AandQStoreServlet">Assignments</a></button>
            </div>

            <c:if test="${userProfile.getRole() == 'Student'}">
            <div class="menu_option">
                <button class="menu_button"><a href="#">Grades</a></button>
            </div>
            </c:if>

            <c:if test="${userProfile.getRole() == 'Mentor'}">
                <div class="menu_option">
                    <button class="menu_button"><a href="#">Stats</a></button>
                    <div class="sub_menu">
                        <a href="attendanceServlet">Attendance</a>

                        <a href="AttendanceHistoryServlet">Attendance History</a>
                        <a href="#">Assignment Status</a>
                        <a href="#">User Grades</a>
                        <a href="#">Charts</a>
                    </div>
                </div>
            </c:if>

            <div class="menu_option">
                <button class="menu_button"><a href="userListServlet">Users</a></button>
            </div>
            <div class="menu_option">
                <button class="menu_button"><a href="userProfileServlet?id=${userProfile.name}">Profile</a></button>
            </div>
            <div class="menu_option">
                <button class="menu_button"><a href="#">Help</a></button>
            </div>
            <div class="menu_option" style="position: absolute; bottom: 0;">
                <button class="menu_button"><a href="logoutServlet">Logout</a></button>
            </div>
        </div>
    </body>
</html>
