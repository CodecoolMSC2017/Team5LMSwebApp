<!--
https://fontawesome.com/v4.7.0/icons/
-->

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
		<link rel="stylesheet" type="text/css" href="../css/stylesheet.css">
		<link rel="stylesheet" type="text/css" href="../css/menu_vertical.css">
		<link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css">
		<title>Edit Text Page : ${assignment.title}</title>
	</head>
	<body>
        <jsp:include page="importNavBar.jsp"/>
        <jsp:include page="importUserProfile.jsp"/>

		<!-- CONTENT START -->

		<div class="content">
		    <form action="EditTextPageServlet" method="post">

                <div class="content_title">
                    <div class="text">Edit Text Page : ${assignment.title}</div>
                </div>

                <h1>${assignment.description}</h1>
                <p>Estimated time: ${assignment.time}</p>

                <h1>Full description:</h1>
                <p>${assignment.fullDescription}</p>

                <center>
                    <input type="hidden" name="id" value="">
                    <input type="submit" class="submit" value="Submit">
                    <a href="AandQStoreServlet"><div class="submit">Cancel</div></a>
                </center>
            </form>
		</div>

		<!-- CONTENT END  -->

	</body>
</html>
