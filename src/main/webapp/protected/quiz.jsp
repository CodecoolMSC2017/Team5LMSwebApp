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
			</div>

			<h1>${quiz.description}</h1>
			<p><b>Date:</b> ${quiz.date}, <b>Maximum points:</b> ${quiz.maxPoint}</p>
            <p><b>Your total points:</b> ${points}</p>

			<form action="quizSubmit" method="post">
			    <input type="hidden" name="id" value="${quiz.id}">
                <c:forEach items="${quiz.getQuestions()}" var="question" varStatus="loop">
                    <div class="quiz_frame">
                        <div class="title">
                            <div class="points">${question.point} pt</div>
                            <div class="question_no">Question ${loop.index}</div>
                        </div>
                        <div class="question">
                            <div class="text">${question.description}</div>
                            <c:forEach items="${question.getAnswers()}" var="answers">
                                <div class="answer">
                                    <c:if test="${not empty points && answers.getName() == question.getGoodAnswer()}">
                                        <div class="show_correct_answer">
                                            <div class="sign">Correct Answer</div>
                                            <div class="triangle"></div>
                                        </div>
                                    </c:if>
                                    <c:if test="${empty points && userProfile.role == 'Student'}">
                                        <input type="radio" name="question${loop.index}" value="${answers.getName()}" required>
                                    </c:if>
                                    ${answers.name}
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>
                <c:if test="${empty points && userProfile.role == 'Student'}">
                    <center><input type="submit" class="submit" value="Submit"></center>
                </c:if>
			</form>
		</div>

		<!-- CONTENT END  -->

	</body>
</html>
