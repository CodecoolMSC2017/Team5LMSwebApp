<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="refresh" content="2; url=registration.htm" />
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
        },20);
    </script>
    <style>
        #progressBar {
            width: 100%;
        }
    </style>


    <div class="registration_box_error">
        <h1>Registration unsuccessful!</h1>
        <p><b>${registration.message}</b><br><br></p>
        <p><small>Redirecting to <b>Registration</b> page...<br><progress value="0" max="100" id="progressBar"></progress></small></p>
    </div>

</body>
</html>
