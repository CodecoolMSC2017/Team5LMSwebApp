<!--
https://fontawesome.com/v4.7.0/icons/
-->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
		<link rel="stylesheet" type="text/css" href="../css/stylesheet.css">
		<link rel="stylesheet" type="text/css" href="../css/menu_vertical.css">
		<link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css">
		<title>Attendance</title>
	</head>
	<body>
        <jsp:include page="importNavBar.jsp"/>
        <jsp:include page="importUserProfile.jsp"/>

		<!-- CONTENT START -->
		<div class="content">
			<div class="content_title">
				<div class="text">Student Attendance</div>
			</div>

            <form action="attendanceServlet" method="post">
			<div class="attendance_frame">
				<table class="users_table">
					<tr class="title">
						<td class="name">Name</td>
						<td class="email">E-mail address</td>
						<td class="role">Att.%</td>
						<td class="presence">Presence</td>
					</tr>
                    <c:forEach items="${studentlist}" var="element">
					<tr>
						<td>${element.getName()}</td>
                        <td>${element.getEmail()}</td>
                        <td>${element.getAttendance()}</td>
						<td>
                            <input type="hidden" name="attendance" value="0"><input type="checkbox" onclick="this.previousSibling.value=1-this.previousSibling.value">
						</td>
					</tr>
                    </c:forEach>
				</table>
				<h1>${error}</h1>
			</div>
            <div class="button_right"><input type="submit" class="submit" value="Submit"></div>
			</form>

		</div>
		<!-- CONTENT END  -->

	</body>
</html>
