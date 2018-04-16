<!--
https://fontawesome.com/v4.7.0/icons/
-->

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
		<link rel="stylesheet" type="text/css" href="../css/stylesheet.css">
		<link rel="stylesheet" type="text/css" href="../css/menu_vertical.css">
		<link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css">
		<title>${exercise.title}</title>
	</head>
	<body>
        <jsp:include page="importNavBar.jsp"/>
        <jsp:include page="importUserProfile.jsp"/>

		<!-- CONTENT START -->
		<div class="content">
			<div class="content_title">
				<div class="text">Exercise title</div>
			</div>
			<div class="exercise_description">
                <div class="informations">
                    Estimated time: ?? mins<br>
                    Maximum points: ?? <br>
                    Your points: ??
                </div>
                <h1>Exercise description title</h1>
                <p>Exercise description</p>
                <!-- ---------- SHOW IF CONTENT IS NOT NULL FROM HERE ---------- -->
                <h1>Exercise Full description title</h1>
                <p>Exercise Full description</p>
                <!-- ---------- SHOW IF CONTENT IS NOT NULL TO HERE ---------- -->
            </div>
            <form action="exerciseSaveServlet" method="post">
                <div class="exercise_question">
                    <h1>Exercise question title</h1>
                    <!-- ---------- SHOW IF CONTENT IS NOT NULL FROM HERE ---------- -->
                    <p>Exercise question</p>
                    <!-- ---------- SHOW IF CONTENT IS NOT NULL TO HERE ---------- -->
                    <p><textarea rows="15" cols="50" name="answer" value=""></textarea></p>
                </div>
                <center>
                    <input type="submit" class="submit" value="Submit">
                    <a href="AandQStoreServlet"><div class="submit">Cancel</div></a>
                </center>
            </form>
		</div>
		<!-- CONTENT END  -->

	</body>
</html>
