<!--
https://fontawesome.com/v4.7.0/icons/
-->

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
                </div>
                <div class="text">
                    <p><h1>Short description:</h1></p>
                    <p><textarea rows="4" cols="50" name="description">${quiz.description}</textarea></p>
                    <p>
                        <b>Date:</b> <input type="text" name="date" value="${quiz.date}">
                        <b>Maximum points:</b> <input type="number" name="date" value="${quiz.maxPoint}">
                    </p>



                    <input type="hidden" name="id" value="${quiz.getId()}">

                    <c:forEach items="${quiz.getQuestions()}" var="question">
                        <div class="quiz_frame">
                            <div class="title">
                                <div class="points">${question.getMaxPoint()} pt</div>
                                <div class="question_no">${quiz.getTitle()}</div>
                            </div>
                            <div class="question">
                                <div class="text">${question.getDescription()}</div>
                                <c:forEach items="${question.getAnswers()}" var="answers">
                                    <div class="answer">
                                        <input type="radio" name="question${loop.index}" value="${answers.getName()}">${answers.getName()}
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </c:forEach>



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
