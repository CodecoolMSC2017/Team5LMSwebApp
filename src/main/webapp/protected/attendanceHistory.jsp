<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
		<link rel="stylesheet" type="text/css" href="../css/stylesheet.css">
		<link rel="stylesheet" type="text/css" href="../css/menu_vertical.css">
		<link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css">
		<title>Attendance</title>
	</head>
	<body>
        <jsp:include page="importNavBar.jsp"/>
        <jsp:include page="importUserProfile.jsp"/>

		<!-- CONTENT START -->

		<div class="content">
			<div class="content_title">
				<div class="text">Attendance History</div>
			</div>

			<div class="text">
                <center>
                    <form action="AttendanceHistoryServlet" method="post">
                        <select name="title">
                            <c:forEach items="${attendanceHistory}" var="element">
                              <option value="${element.getTitle()}">${element.getTitle()}</option>
                            </c:forEach>
                        </select>
                        <input type="submit" class="submit" value="Submit">
                    </form>

                    <h1>${title}</h1>
                    <c:forEach items="${students}" var="element">
                        <p>${element.getName()}</p>
                    </c:forEach>

                </center>
		    </div>
        </div>

		<!-- CONTENT END  -->

	</body>
</html>
