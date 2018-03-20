<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UserList</title>
</head>
<body>

<TABLE BORDER="1" CELLPADDING="3" CELLSPACING="1">
<TR>
   <TH>Hash</TH>
   <TH>Name</TH>
   <TH>Count</TH>
</TR>
<c:forEach var="rr" items="${userlist}">
<TR>
   <TD>${rr.name}</TD>
   <TD>${rr.email}</TD>
   <TD>${rr.password}</TD>
</TR>
</c:forEach>
</TABLE>

</body>
</html>
