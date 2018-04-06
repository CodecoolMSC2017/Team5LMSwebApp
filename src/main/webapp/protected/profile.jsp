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
		<title>Profile</title>
	</head>
	<body>
        <jsp:include page="importNavBar.jsp"/>
        <jsp:include page="importUserProfile.jsp"/>

		<!-- CONTENT START -->
		<div class="content">
			<div class="content_title">
				<div class="text">Profile</div>
			</div>

			<div class="profile_frame">
			    <div class="profile_image">
			        <img src="../images/user_pics/no_profile_pic.png">
				</div>
				<table class="table">
					<tr>
						<td class="title">User Name:</td>
						<td class="info">${profile.name}</td>
					</tr>
					<tr>
						<td class="title">First name:</td>
						<td class="info">${profile.firstName}</td>
					</tr>
					<tr>
						<td class="title">Last name:</td>
						<td class="info">${profile.lastName}</td>
					</tr>
					<tr>
						<td class="title">E-mail address:</td>
						<td class="info">${profile.email}</td>
					</tr>
					<tr>
						<td class="title">Role:</td>
						<td class="info">
						    ${profile.role}
                            <c:if test="${profile.role != 'Mentor' && userProfile.role == 'Mentor'}">
                                <a href="<c:url value="/protected/UserPromoteServlet"><c:param name="id" value="${profile.name}"/></c:url>"><div class="submit"><i class="fa fa-graduation-cap fa-lg" aria-hidden="true" title="Promote to Mentor"></i> Promote to Mentor</div></a>
                            </c:if>
                        </td>
					</tr>
					<tr>
						<td class="title">Password:</td>
						<td class="info">
						    <c:if test="${userProfile.name == profile.name}">
                                ${profile.password}
                            </c:if>
						    <c:if test="${userProfile.name != profile.name}">
						        ******
                            </c:if>
                        </td>
					</tr>
					<tr>
						<td class="title">Introduction:</td>
						<td class="info"></td>
					</tr>
				</table>
				<c:if test="${userProfile.name == profile.name || userProfile.role == 'Mentor'}">
                    <center>
                        <a href="userProfileEdit?id=${profile.name}"><div class="submit">Edit Profile</div></a>
                    </center>
                </c:if>
			</div>

		</div>
		<!-- CONTENT END  -->

	</body>
</html>
