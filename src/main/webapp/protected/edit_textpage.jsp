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
                    <div class="text">Title: <input type="text" name="title" value="${assignment.title}"></div>
                </div>
                <div class="text">
                    <p><h1>Short description:</h1></p>
                    <p><textarea rows="4" cols="50" name="description">${assignment.description}</textarea></p>
                    <p><b>Estimated time:</b> <input type="number" name="estimatedtime" value="${assignment.time}"> minutes</p>
                    <p><h1>Full description:</h1></p>
                    <p><textarea rows="15" cols="50" name="fulldescription">${assignment.fullDescription}</textarea></p>
                </div>
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
