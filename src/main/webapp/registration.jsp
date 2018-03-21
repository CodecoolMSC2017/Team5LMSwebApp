<div class="registration_box">
    <h1>Registration</h1>
    <form action="registrationServlet" method="post">
        <p>Name:<br><input type="text" name="name" value="" class="input_field" required></p>
        <p>E-mail:<br><input type="email" name="email" value="" class="input_field" required></p>
        <p>Password:<br><input type="password" name="password" value="" class="input_field" required><br>
        Confirm password:<br><input type="password" name="password_confirm" value="" class="input_field" required><br></p>
        <p>Role:
        <select name="role" class="drop_down_button" required>
            <option value="student">Student</option>
            <option value="mentor">Mentor</option>
        </select></p>
        <input type="submit" value="Submit" class="send_button">
        <input type="button" value="Cancel" class="send_button" onclick="history.back()">
    </form>
</div>
