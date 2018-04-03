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
		<script src="js/import_html.js"></script>
		<title>Users</title>
	</head>
	<body>
        <div importNavBar="importNavBar.jsp"></div>
        <script>importNavBar();</script>
        <div importUserProfile="importUserProfile.jsp"></div>
        <script>importUserProfile();</script>

		<!-- CONTENT START -->
		<div class="content">
			<div class="content_title">
				<div class="text">Users</div>
			</div>

			<div class="users_frame">
				<table class="users_table">
					<tr class="title">
						<td class="name">Name</td>
						<td class="email">E-mail address</td>
						<td class="role">Role</td>
					</tr>
					<c:forEach items="${users}" var="element">
					<tr>
						<td>${element.getName()}</td>
						<td>${element.getEmail()}</td>
						<td>${element.getRole()</td>
					</tr>
					</c:forEach>
					<c:forEach items="${studentlist}" var="element">
                    <tr>
                        <td>${element.getName()}</td>
                        <td>${element.getEmail()}</td>
                        <td>Student</td>
                    </tr>
                    </c:forEach>
				</table>
			</div>

		</div>
		<!-- CONTENT END  -->

	</body>
</html>
