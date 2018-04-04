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
		<title>Assignments</title>
	</head>
	<body>
        <jsp:include page="importNavBar.jsp"/>
        <jsp:include page="importUserProfile.jsp"/>

		<!-- CONTENT START -->

		<div class="content">
			<div class="content_title">
				<div class="text">Assignments</div>
				<c:if test="${userProfile.role == 'Mentor'}">
				    <div class="add"><a href="#"><i class="fa fa-plus-square-o fa-lg" aria-hidden="true"></i></a></div>
				</c:if>
			</div>

		    <div class="assignment_frame">
                <c:forEach items="${AandQlist}" var="element">
                    <div class="title">
                        <c:if test="${userProfile.role == 'Mentor'}">
                            <div class="admin">
                                <a href="#"><i class="fa fa-plus-square-o fa-lg" aria-hidden="true"></i></a>
                                <a href="#"><i class="fa fa-pencil-square-o fa-lg" aria-hidden="true"></i></a>
                                <a href="#"><i class="fa fa-trash-o fa-lg" aria-hidden="true"></i></a>
                            </div>
                        </c:if>
                        <div class="text">${element.getTitle()}</div>
                    </div>
                    <div class="topic_items">
                        <c:forEach items="${element.assignments}" var="assign">
                            <div class="topic_item">
                                <table class="table">
                                    <tr>
                                        <td class="col-1"><a href="<c:url value="/protected/Assignement"><c:param name="id" value="${assign.getId()}"/></c:url>"><i class="fa fa-file-text-o fa-lg" aria-hidden="true"></i></a></td>
                                        <td class="col-2"><a href="<c:url value="/protected/Assignement"><c:param name="id" value="${assign.getId()}"/></c:url>">${assign.getTitle()}</a></td>
                                        <c:if test="${userProfile.role == 'Mentor'}">
                                            <td class="col-edit">
                                                <a href="#"><i class="fa fa-pencil-square-o fa-lg" aria-hidden="true" alt="Edit"></i></a>
                                            </td>
                                            <td class="col-del">
                                                <a href="#"><i class="fa fa-trash-o fa-lg" aria-hidden="true" alt="Delete"></i></a>
                                            </td>
                                            <td class="col-published">
                                                <form action="publishAssignmentServlet" method="post">
                                                    <input type="hidden" name="id" value=${assign.getId()}>
                                                    <c:if test="${assign.isPublished() == true}">
                                                            <input type="checkbox" onclick="this.form.submit();" alt="Publish" checked>
                                                    </c:if>
                                                    <c:if test="${assign.isPublished() == false}">
                                                            <input type="checkbox" onclick="this.form.submit();" alt="Publish">
                                                    </c:if>
                                                </form>
                                            </td>
                                        </c:if>
                                    </tr>
                                </table>
                            </div>
                        </c:forEach>
                        <c:forEach items="${element.quizzes}" var="quiz">
                            <div class="topic_item">
                                <table class="table">
                                    <tr>
                                        <td class="col-1"><a href="<c:url value="/protected/Quiz"><c:param name="id" value="${quiz.getId()}"/></c:url>"><i class="fa fa-list-ol fa-lg" aria-hidden="true"></i></a></td>
                                        <td class="col-2"><a href="<c:url value="/protected/Quiz"><c:param name="id" value="${quiz.getId()}"/></c:url>">${quiz.getTitle()}</a></td>
                                        <td class="col-3"><a href="<c:url value="/protected/Quiz"><c:param name="id" value="${quiz.getId()}"/></c:url>">${quiz.getMaxPoint()} pts</a></td>
                                        <td class="col-4"><a href="<c:url value="/protected/Quiz"><c:param name="id" value="${quiz.getId()}"/></c:url>">${quiz.getDate()}</a></td>
                                        <c:if test="${userProfile.role == 'Mentor'}">
                                            <td class="col-edit">
                                                <a href="#"><i class="fa fa-pencil-square-o fa-lg" aria-hidden="true" alt="Edit"></i></a>
                                            </td>
                                            <td class="col-del">
                                                <a href="#"><i class="fa fa-trash-o fa-lg" aria-hidden="true" alt="Delete"></i></a>
                                            </td>
                                            <td class="col-published">
                                                <form action="publishAssignmentServlet" method="post">
                                                    <input type="hidden" name="id" value=${quiz.getId()}>
                                                    <c:if test="${quiz.isPublished() == true}">
                                                            <input type="checkbox" onclick="this.form.submit();" alt="Publish" checked>
                                                    </c:if>
                                                    <c:if test="${quiz.isPublished() == false}">
                                                            <input type="checkbox" onclick="this.form.submit();" alt="Publish">
                                                    </c:if>
                                                </form>
                                            </td>
                                        </c:if>
                                    </tr>
                                </table>
                            </div>
                        </c:forEach>
                    </div>
			        <hr>
                </c:forEach>
			</div>
		</div>

		<!-- CONTENT END  -->

	</body>
</html>
