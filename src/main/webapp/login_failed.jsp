<head>
    <meta http-equiv="refresh" content="2; url=?page=login" />
</head>


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
    <h1>Login failed!</h1>
    <p><b>${login.message}</b><br></p>
    <p><small>Rdirecting to <b>Login</b> page...<br><progress value="0" max="100" id="progressBar"></progress></small></p>
</div>
