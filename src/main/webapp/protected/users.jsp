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
		<title>Users</title>
	</head>
	<body>
        <jsp:include page="importNavBar.jsp"/>
        <jsp:include page="importUserProfile.jsp"/>

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
					<c:if test="${userProfile.role == 'Mentor'}">
                        <c:forEach items="${mentorlist}" var="element">
                            <tr>
                                <td><a href="<c:url value="/protected/userProfileServlet"><c:param name="id" value="${element.getName()}"/></c:url>">${element.getName()}</a></td>
                                <td>
                                     <a href="mailto:${element.getEmail()}?subject=Message from LMS site" title="Send e-mail">${element.getEmail()}</a>
                                </td>
                                <td><a href="<c:url value="/protected/userProfileServlet"><c:param name="id" value="${element.getName()}"/></c:url>">${element.getRole()}</a</td>
                            </tr>
                        </c:forEach>
					</c:if>
					<c:forEach items="${studentlist}" var="element">
                        <tr>
                            <td><a href="<c:url value="/protected/userProfileServlet"><c:param name="id" value="${element.getName()}"/></c:url>">${element.getName()}</a></td>
                                <td>
                                    <a href="mailto:${element.getEmail()}?subject=Message from LMS site" title="Send e-mail">${element.getEmail()}</a>
                                </td>
                            <td><a href="<c:url value="/protected/userProfileServlet"><c:param name="id" value="${element.getName()}"/></c:url>">${element.getRole()}</a></td>
                        </tr>
                    </c:forEach>
				</table>
			</div>

		</div>
		<!-- CONTENT END  -->

	</body>
</html>
