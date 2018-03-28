document.write('\
\
<div class="menu_bar">\
	<div class="menu_option">\
		<button class="menu_button"><a href="#">Home</a></button>\
	</div>\
	<div class="menu_option">\
		<button class="menu_button"><a href="AandQStoreServlet">Assignments</a></button>\
	</div>\
	<div class="menu_option">\
		<button class="menu_button"><a href="#">Grades (S)</a></button>\
	</div>\
	<div class="menu_option">\
		<button class="menu_button"><a href="#">Stats (M)</a></button>\
		<div class="sub_menu">\
			<a href="attendanceServlet">Attendance</a>\
			<a href="#">Assignment Status</a>\
			<a href="#">User Grades</a>\
			<a href="#">Charts</a>\
		</div>\
	</div>\
	<div class="menu_option">\
		<button class="menu_button"><a href="userlist">Users</a></button>\
	</div>\
	<div class="menu_option">\
		<button class="menu_button"><a href="userProfileServlet">Pofile</a></button>\
	</div>\
	<div class="menu_option">\
		<button class="menu_button"><a href="#">Help</a></button>\
	</div>\
	<div class="menu_option" style="position: absolute; bottom: 0;">\
		<button class="menu_button"><a href="#">Logout</a></button>\
	</div>\
</div>\
\
<div class="logged_in">\
	<div>\
              <div class="message">You are logged in as:</div>\
              <img src="images/user_pics/no_profile_pic.png">\
              <div class="name">Name</div>\
              <div class="role">Role</div>\
              <div class="else">something else</div>\
	</div>\
</div>\
\
');
