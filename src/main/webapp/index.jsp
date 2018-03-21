<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta http-equiv="refresh" content="0; url=?page=login" />

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bla Bla Bla...</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body style="margin:0px; padding:0px;">

<header style="width: 100%; height: 75px; top: 0; position: fixed; background-color:yellow;">
</header>

<div style="width:800px; background-color: white; height:auto; border:1px solid black; margin:0px auto; padding:75px 10px 10px 10px;">
    <div style="width:200px; float:left">
        <ul>
            <li><a href="?page=home">Home</a></li>
            <li><a href="?page=userlist">User List</a></li>
            <li><a href="?page=assignment">Assignment</a></li>
        </ul>
    </div>
    <div style="width:600px; float:left">


        <% if(request.getParameter("page").equals("login")) { %>
            <jsp:include page="login.jsp"/>
        <% } else if(request.getParameter("page").equals("login_failed")) { %>
            <jsp:include page="login_failed.jsp"/>
        <% } else if(request.getParameter("page").equals("registration")) { %>
            <jsp:include page="registration.jsp"/>
        <% } else if(request.getParameter("page").equals("registration_failed")) { %>
            <jsp:include page="registration_failed.jsp"/>


        <% } else if(request.getParameter("page").equals("home")) { %>
            <jsp:include page="home.jsp"/>
        <% } else if(request.getParameter("page").equals("userlist")) { %>
            <jsp:include page="userlist.jsp"/>
        <% } else if(request.getParameter("page").equals("assignment")) { %>
            <jsp:include page="serlist.jsp"/>

        <% } else { %>
            <jsp:include page="home.jsp"/>
        <% } %>

    </div>
    <div style="clear:both"></div>
</div>

</body>
</html>
