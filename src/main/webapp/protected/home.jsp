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
		<title>${quiz.title}</title>
	</head>
	<body>
        <jsp:include page="importNavBar.jsp"/>
        <jsp:include page="importUserProfile.jsp"/>

		<!-- CONTENT START -->

		<div class="content">

            <h1>Welcome!</h1>
            <p style="font-size: 1.2em; line-height: 1.5em">This learning management system (LMS) is a software application for the administration, documentation,
            tracking, reporting and delivery of educational courses or training programs.</p>
            <p style="font-size: 1.2em; line-height: 1.5em">It helps the Mentor deliver
            material to the Students, administer tests and other assignments, track Student progress, and manage
            record-keeping. This LMS is focused on online learning delivery but support a range of uses, acting as a
            platform for fully online courses, as well as several hybrid forms, such as blended learning and flipped
            classrooms. It can be complemented by other learning technologies such as a training management system to
            manage instructor-led training or a Learning Record Store to store and track learning data.</p>
            <center>
                <img src="../images/logo.png">
            </center>

		</div>

		<!-- CONTENT END  -->

	</body>
</html>
