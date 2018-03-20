<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:if test="${login.name == null}">
        <meta http-equiv="refresh" content="0; url=index.html" />
    </c:if>
    <title>Main page</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

    <script>
        var timeleft = 100;
        var downloadTimer = setInterval(function(){
          document.getElementById("progressBar").value = 100 - --timeleft;
          if(timeleft <= 0)
            clearInterval(downloadTimer);
        },50);
    </script>
    <style>
        #progressBar {
            width: 100%;
        }
    </style>

    <div class="registration_box">
        <h1>Hello ${login.name}!</h1>
        OK, you logged in
    </div>

</body>
</html>
