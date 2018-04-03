<!--
https://fontawesome.com/v4.7.0/icons/
-->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
		<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
		<link rel="stylesheet" type="text/css" href="css/menu_vertical.css">
		<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
		<title>Assignments</title>
	</head>
	<body>
        <jsp:include page="importNavBar.jsp"/>
        <jsp:include page="importUserProfile.jsp"/>

		<!-- CONTENT START -->
		<div class="content">
			<div class="content_title">
				<div class="text">Assignments</div>
				<div class="add"><a href="#"><i class="fa fa-plus-square-o fa-lg" aria-hidden="true"></i></a></div>
			</div>

		    <div class="assignment_frame">
                <c:forEach items="${AandQlist}" var="element">
                    <div class="title">
                        <div class="text">${element.getTitle()}</div>
                    </div>
                    <div class="topic_items">

                        <c:forEach items="${element.assignments}" var="assign">
                        <div class="topic_item">
                            <table class="table">
                                <tr>
                                    <td class="col-1"><a href="<c:url value="/Assignement"><c:param name="id" value="${assign.getId()}"/></c:url>"><i class="fa fa-file-text-o fa-lg" aria-hidden="true"></i></a></td>
                                    <td class="col-2"><a href="<c:url value="/Assignement"><c:param name="id" value="${assign.getId()}"/></c:url>">${assign.getTitle()}</a></td>
                                </tr>
                            </table>
                        </div>
                        </c:forEach>

                        <c:forEach items="${element.quizzes}" var="quiz">
                        <div class="topic_item">
                            <table class="table">
                                <tr>
                                    <td class="col-1"><a href="<c:url value="/Quiz"><c:param name="id" value="${quiz.getId()}"/></c:url>"><i class="fa fa-list-ol fa-lg" aria-hidden="true"></i></a></td>
                                    <td class="col-2"><a href="<c:url value="/Quiz"><c:param name="id" value="${quiz.getId()}"/></c:url>">${quiz.getTitle()}</a></td>
                                    <td class="col-3"><a href="<c:url value="/Quiz"><c:param name="id" value="${quiz.getId()}"/></c:url>">${quiz.getMaxPoint()} pts</a></td>
                                    <td class="col-4"><a href="<c:url value="/Quiz"><c:param name="id" value="${quiz.getId()}"/></c:url>">${quiz.getDate()}</a></td>
                                </tr>
                            </table>
                        </div>
                        </c:forEach>
                    </div>
			    <hr>
                </c:forEach>


				<div class="title">
					<div class="admin">
						<a href="#"><i class="fa fa-plus-square-o fa-lg" aria-hidden="true"></i></a>
						<a href="#"><i class="fa fa-pencil-square-o fa-lg" aria-hidden="true"></i></a>
						<a href="#"><i class="fa fa-trash-o fa-lg" aria-hidden="true"></i></a>
					</div>
					<div class="text">Hardcoded Mentor view</div>
				</div>
				<div class="topic_items">
					<div class="topic_item">
						<table class="table">
							<tr>
								<td class="col-1"><a href="#"><i class="fa fa-file-text-o fa-lg" aria-hidden="true"></i></a></td>
								<td class="col-2"><a href="#">Page Title 1</a></td>
								<td class="col-edit">
									<a href="#"><i class="fa fa-pencil-square-o fa-lg" aria-hidden="true"></i></a>
								</td>
								<td class="col-del">
									<a href="#"><i class="fa fa-trash-o fa-lg" aria-hidden="true"></i></a>
								</td>
							</tr>
						</table>
					</div>
					<div class="topic_item">
						<table class="table">
							<tr>
								<td class="col-1"><a href="#"><i class="fa fa-file-text-o fa-lg" aria-hidden="true"></i></a></td>
								<td class="col-2"><a href="#">Page Title 2</a></td>
								<td class="col-edit">
									<a href="#"><i class="fa fa-pencil-square-o fa-lg" aria-hidden="true"></i></a>
								</td>
								<td class="col-del">
									<a href="#"><i class="fa fa-trash-o fa-lg" aria-hidden="true"></i></a>
								</td>
							</tr>
						</table>
					</div>
					<div class="topic_item">
						<table class="table">
							<tr>
								<td class="col-1"><a href="#"><i class="fa fa-list-ol fa-lg" aria-hidden="true"></i></a></td>
								<td class="col-2"><a href="#">Quiz Title</a></td>
								<td class="col-3"><a href="#">14 pts</a></td>
								<td class="col-4"><a href="#">Oct 20, 2025</a></td>
								<td class="col-edit">
									<a href="#"><i class="fa fa-pencil-square-o fa-lg" aria-hidden="true"></i></a>
								</td>
								<td class="col-del">
									<a href="#"><i class="fa fa-trash-o fa-lg" aria-hidden="true"></i></a>
								</td>
							</tr>
						</table>
					</div>
				</div>


			</div>
		</div>
		<!-- CONTENT END  -->

	</body>
</html>
