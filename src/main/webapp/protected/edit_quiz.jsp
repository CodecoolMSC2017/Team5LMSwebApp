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
		    <form action="QuizEditServlet" method="post">
                <div class="content_title">
                    <div class="text">Title: <input type="text" name="title" value="${quiz.title}"></div>
                    <div class="add"><a href="<c:url value="/protected/QuestionCreateServlet"><c:param name="id" value="${quiz.getId()}"/></c:url>"><i class="fa fa-plus-square-o fa-lg" aria-hidden="true" title="Add"></i></a></div>
                </div>
                <div class="text">
                    <p><h1>Short description:</h1></p>
                    <p><textarea rows="4" cols="50" name="description">${quiz.description}</textarea></p>
                    <p>
                        <b>Date:</b> <input type="text" name="date" value="${quiz.date}">
                        <b>Maximum points:</b> <input type="number" name="date" value="${quiz.maxPoint}">
                    </p>
                    <input type="hidden" name="id" value="${quiz.getId()}">
                </div>
                <center>
                    <input type="submit" class="submit" value="Submit">
                    <a href="AandQStoreServlet"><div class="submit">Cancel</div></a>
                </center>
            </form>
            <c:forEach items="${quiz.getQuestions()}" var="question" varStatus="loop">
                <div class="quiz_frame">
                    <div class="title">

                        <div class="admin">
                            <a href="AandQStoreCreateServlet"><i class="fa fa-plus-square-o fa-lg" aria-hidden="true" title="Add"></i></a>
                            <a href="<c:url value="/protected/AandQStoreEditServlet"><c:param name="id" value="${element.getId()}"/></c:url>"><i class="fa fa-pencil-square-o fa-lg" aria-hidden="true" title="Edit"></i></a>
                            <a href="<c:url value="/protected/QuestionDelServlet"><c:param name="id" value="${quiz.getId()}${question.getId()}"/></c:url>"><i class="fa fa-trash-o fa-lg" aria-hidden="true" title="Delete"></i></a>
                        </div>

                        <div class="points">${question.point} pt</div>
                        <div class="question_no">Question ${loop.index}</div>
                    </div>
                    <div class="question">
                        <div class="text">${question.description}</div>
                        <c:forEach items="${question.getAnswers()}" var="answers">
                            <div class="answer">
                                <input type="radio" name="question${loop.index}" value="${answers.getName()}" required>${answers.name}
                                <div class="admin">
                                    <a href="<c:url value="/protected/AandQStoreEditServlet"><c:param name="id" value="${element.getId()}"/></c:url>"><i class="fa fa-pencil-square-o fa-lg" aria-hidden="true" title="Edit"></i></a>
                                    <a href="<c:url value="/protected/AandQStoreDelServlet"><c:param name="id" value="${element.getId()}"/></c:url>"><i class="fa fa-trash-o fa-lg" aria-hidden="true" title="Delete"></i></a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </c:forEach>
		</div>

		<!-- CONTENT END  -->

	</body>
</html>
