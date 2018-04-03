<!--
https://fontawesome.com/v4.7.0/icons/
-->

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
		<script type="text/javascript" src=""></script>
		<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
		<link rel="stylesheet" type="text/css" href="css/menu_vertical.css">
		<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
		<script src="#"></script>
		<title>LMS</title>
	</head>
	<body style="background: url(images/background_bw.jpg);">
		<!-- CONTENT START -->
		<div class="login_frame">
			<div class="like_content">
				<div class="logo"></div>
				<div class="title">LMS</div>
				<div class="form">
					<form action="loginServlet" method="post">
						<input type="text" name="name_or_email" placeholder="User name or E-mail" value="">
						<input type="password" name="password" placeholder="Password" value="">
						<input type="submit" class="submit" value="Login">
					</form>
				</div>
			</div>
		    <div class="error">${error}</div>
		</div>
		<div class="content">
			<div class="registration_frame">
				<h1>Sign Up</h1>
				<p style="margin-bottom: 20px">It's free and always will be.</p>
				<form action="registrationServlet" method="post">
					<p><input class="field" type="text" size="45" name="name" placeholder="User name" value="" required></p>
					<p><input class="field" type="text" size="19" name="first_name" placeholder="First name" value="">
					<input class="field" type="text" size="19" name="last_name" placeholder="Last name" value=""></p>
					<p><input class="field" type="email" size="45" name="email" placeholder="E-mail" value="" required></p>
					<p><input class="field" type="password" size="45" name="password" placeholder="Password" value="" required></p>
					<p>Birthday:<br>
					<input class="field" type="date" name="birthday"></p>
					<p style="font-size: 0.85em">By clicking Create Account, you agree to our Terms and that you have read our Data Policy, including our Cookie Use.</p>
					<p style="font-size: 0.85em; color: #ff0000">${message}</p>
					<p><input type="submit" class="submit" value="Create Account"></p>
				</form>
			</div>
		</div>
		<!-- CONTENT END  -->
	</body>
</html>
