<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="refresh" content="5; url=index.html" />
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


    <div class="registration_box_ok">
        <h1>Registration Successful!</h1>
        <p><b>${registration.message}</b></p>
        <p style="text-align: left">
            <b>Name:</b> ${registration.name}<br>
            <b>E-mail:</b> ${registration.email}<br>
            <b>Password:</b> ${registration.password}<br>
            <b>Role:</b> ${registration.role}
        </p>
        <p><small>Redirecting to <b>Login</b> page...<br><progress value="0" max="100" id="progressBar"></progress></small></p>
    </div>

</body>
</html>
