<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Test Page</title>
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
        <h1>${login.message}</h1>
        OK, you logged in
    </div>

</body>
</html>
