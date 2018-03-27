<!--
https://fontawesome.com/v4.7.0/icons/
-->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
		<script type="text/javascript" src=""></script>
		<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
		<link rel="stylesheet" type="text/css" href="css/menu_vertical.css">
		<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
		<script src="#"></script>
		<title>Attendance</title>
	</head>
	<body>
		<header>
			<script src="js/header.js"></script>
		</header>

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
							<select name="attendance">
								<option value="0">Out</option>
								<option value="1">In</option>
							</select>
						</td>
					</tr>
                    </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td align="center"><input type="submit" value="Update" class="submit"></td>
                    </tr>
				</table>
			</div>
			</form>

		</div>
		<!-- CONTENT END  -->

	</body>
</html>
