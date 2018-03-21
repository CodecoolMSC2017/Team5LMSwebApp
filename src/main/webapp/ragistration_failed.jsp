<head>
    <meta http-equiv="refresh" content="2; url=?page=registration" />
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
    <h1>Registration unsuccessful!</h1>
    <p><b>${registration.message}</b><br><br></p>
    <p><small>Redirecting to <b>Registration</b> page...<br><progress value="0" max="100" id="progressBar"></progress></small></p>
</div>
