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
			<div class="content_title">
				<div class="text">${quiz.title}</div>
				<div class="add"><a href="#"><i class="fa fa-pencil-square-o fa-lg" aria-hidden="true"></i></a></div>
			</div>

			<h1>${quiz.description}</h1>
			<p>Date: ${quiz.date}, Maximum points: ${quiz.maxPoint} </p>

			<form action="quizSubmit" method="post">
			<c:forEach items="${quiz.getQuestions()}" var="question" varStatus="loop">
				<div class="quiz_frame">
					<div class="title">
						<div class="points">${question.point} pt</div>
						<div class="question_no">Question ${loop.index}</div>
					</div>
					<div class="question">
						<div class="text">${question.description}</div>
						<c:forEach items="${question.getAnswers()}" var="answers">
							<div class="answer"><input type="radio" name="answer" value="${answers.getName()}">${answers.name}</div>
						</c:forEach>
					</div>
				</div>
			</c:forEach>
			<div class="quiz_button"><input type="submit" class="submit" value="Submit"></div>
			</form>


		</div>
		<!-- CONTENT END  -->

	</body>
</html>
