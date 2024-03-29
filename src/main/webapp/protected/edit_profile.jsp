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
		<title>Edit Profile</title>
	</head>
	<body>
        <jsp:include page="importNavBar.jsp"/>
        <jsp:include page="importUserProfile.jsp"/>

		<!-- CONTENT START -->
		<div class="content">
			<div class="content_title">
				<div class="text">Edit Profile</div>
			</div>

			<div class="profile_frame">
			    <div class="profile_image">
			        <img src="../images/user_pics/no_profile_pic.png">
				</div>
				<form action="userProfileSaveServlet" method="post">
					<table class="table">
						<tr>
							<td class="title">User Name:</td>
							<td class="info"><input type="text" name="user_name" value="${profile.getName()}" readonly></td>
						</tr>
						<tr>
							<td class="title">First name:</td>
							<td class="info"><input type="text" name="first_name" value="${profile.getFirstName()}"></td>
						</tr>
						<tr>
							<td class="title"> Last name:</td>
							<td class="info"><input type="text" name="last_name" value="${profile.getLastName()}"></td>
						</tr>
						<tr>
							<td class="title">E-mail address:</td>
							<td class="info"><input type="email" name="email" value="${profile.getEmail()}"></td>
						</tr>
						<tr>
							<td class="title">Role:</td>
							<td class="info"><input type="text" name="role" value="${profile.getRole()}" readonly></td>
						</tr>
						<tr>
							<td class="title">Password:</td>
							<td class="info"><input type="text" name="password" value="${profile.getPassword()}"></td>
						</tr>
						<tr>
							<td class="title">Introduction:</td>
							<td class="info"><input type="text" name="introduction" value="current introduction"></td>
						</tr>
						<tr>
							<td class="title">Profile picture:</td>
							<td class="info"><input type="file" name="profile_picture"></td>
						</tr>
					</table>
					<center>
					    <input type="hidden" name="id" value="${profile.getName()}">
						<input type="submit" class="submit" value="Submit">
						<a href="userProfileServlet?id="><div class="submit">Cancel</div></a>
					</center>
				</form>
			</div>

		</div>
		<!-- CONTENT END  -->

	</body>
</html>
