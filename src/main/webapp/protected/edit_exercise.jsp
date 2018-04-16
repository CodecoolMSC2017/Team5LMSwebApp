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
            <form action="exerciseSaveServlet" method="post">
                <div class="content_title">
                    <div class="text">Title: <input type="text" name="exercise_title" value="" required></div>
                </div>
                <div class="exercise_description">
                    <h1>
                        Estimated time: <input type="number" name="estimatedtime" value="" required> mins<br>
                        Maximum points: ...
                    </h1>
                    <h1>Short description title: <input type="text" name="exercise_short_description_title" value="Exercise short description title" required></h1>
                    <p><textarea rows="5" cols="50" name="exercise_short_description" value="Exercise short description">Exercise short description</textarea></p>
                    <!-- ---------- SHOW IF CONTENT IS NOT NULL FROM HERE ---------- -->
                    <h1>Full description title: <input type="text" name="exercise_full_description_title" value="Exercise Full description title"></h1>
                    <p><textarea rows="5" cols="50" name="exercise_full_description" value="Exercise Full description">Exercise Full description</textarea></p>
                    <!-- ---------- SHOW IF CONTENT IS NOT NULL TO HERE ---------- -->
                </div>
                <div class="quiz_frame">
                    <div class="title">
                        <div class="points"><input type="text" name="points" value="" required> pt</div>
                        <div class="question_no">
                            <a href="#"><i class="fa fa-trash-o fa-lg" aria-hidden="true" title="Delete question"></i></a>
                            <input type="text" name="question_description" placeholder="Question title" value="" required>
                        </div>
                    </div>
                    <div class="question">
                        <div class="text"><b>Exercise details:</b> <textarea rows="5" cols="50" name="exercise_question_details" value="Exercise question details">Exercise question details</textarea></div>
                        <div class="text"><b>Correct answer:</b> <input type="text" name="correct_answer" value="" required></div>
                    </div>
                </div>
                <div class="text">
                    <div class="add"><a href="#"><i class="fa fa-plus-square-o fa-2x" aria-hidden="true" title="Add new question"></i></a></div>
                    <center>
                        <input type="submit" class="submit" value="Submit">
                        <a href="AandQStoreServlet"><div class="submit">Cancel</div></a>
                    </center>
                </div>
            </form>
		</div>
		<!-- CONTENT END  -->

	</body>
</html>
