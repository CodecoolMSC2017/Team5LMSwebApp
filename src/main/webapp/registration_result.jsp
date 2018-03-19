<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="refresh" content="5; url=index.html" />
    <title>Registration Test Page</title>
</head>
<body>

<h1>${registration.message}</h1>
<p style="font-size: 0.8em">
    <b>Name:</b> ${registration.name}<br>
    <b>E-mail:</b> ${registration.email}<br>
    <b>Password:</b> ${registration.password}<br>
    <b>Role:</b> ${registration.role}
</p>
<p>Redirecting to <b>index.html</b> in 5 seconds</p>
</body>
</html>
