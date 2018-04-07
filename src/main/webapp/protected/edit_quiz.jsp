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
		<title>Edit Quiz : ${quiz.title}</title>
	</head>
	<body>
        <jsp:include page="importNavBar.jsp"/>
        <jsp:include page="importUserProfile.jsp"/>

		<!-- CONTENT START -->

		<div class="content">
		    <form action="QuizSaveServlet" method="post">
                <div class="content_title">
                    <div class="text">Title: <input type="text" name="title" value="${quiz.title}"></div>
                </div>
                <div class="text">
                    <p><h1>Short description:</h1></p>
                    <p><textarea rows="4" cols="50" name="description">${quiz.description}</textarea></p>
                    <p>
                        <b>Date:</b> <input type="date" name="date" value="${quiz.date}">
                        <b>Maximum points:</b> ${quiz.maxPoint}
                    </p>
                    <input type="hidden" name="id" value="${quiz.getId()}">
                </div>
                <c:forEach items="${quiz.getQuestions()}" var="question" varStatus="loop">
                    <div class="quiz_frame">
                        <div class="title">
                            <input type="hidden" name="QuId" value="${question.id}">
                            <div class="points"><input type="text" name="points" value="${question.point}"> pt</div>
                            <div class="question_no">
                                <a href="<c:url value="/protected/QuestionDelServlet"><c:param name="id" value="${quiz.getId()}${question.getId()}"/></c:url>"><i class="fa fa-trash-o fa-lg" aria-hidden="true" title="Delete question"></i></a>
                                Question ${loop.index}
                            </div>
                        </div>
                        <div class="question">
                            <div class="text"><input type="text" name="question_description" value="${question.description}"></div>
                            <c:forEach items="${question.getAnswers()}" var="answers">
                                <div class="answer">
                                    <i class="fa fa-circle-o fn-lg" aria-hidden="true"></i>
                                        <input type="hidden" name="answer_id" value="${answers.id}">
                                        <input type="text" name="answer_name" value="${answers.name}">
                                    <a href="<c:url value="/protected/AnswerDelServlet"><c:param name="id" value="${quiz.getId()}${answers.getId()}"/></c:url>"><i class="fa fa-trash-o fa-lg" aria-hidden="true" title="Delete answer"></i></a>
                                </div>
                            </c:forEach>
                            <a href="<c:url value="/protected/AnswerCreateServlet"><c:param name="id" value="${quiz.getId()}${question.getId()}"/></c:url>"><i class="fa fa-plus-square-o fa-2x" aria-hidden="true" title="Add answer"></i></a>
                        </div>
                    </div>
                </c:forEach>
                <div class="text">
                    <div class="add"><a href="<c:url value="/protected/QuestionCreateServlet"><c:param name="id" value="${quiz.getId()}"/></c:url>"><i class="fa fa-plus-square-o fa-2x" aria-hidden="true" title="Add new question"></i></a></div>
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
