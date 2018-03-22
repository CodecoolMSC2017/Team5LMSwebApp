<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Main page</title>
</head>
<body>

    <header>
        <ul>
            <li><a class="active" href="home.jsp">Home</a></li>
            <li><a class="active" href="<c:url value='/userlist' />">User list</a></li>
            <li><a class="active" href="<c:url value='/curriculum' />">Assignments</a></li>
            <li><a class="active" href="<c:url value='/userProfileServlet' />">My Profile</a></li>
            <li><a class="active" href="credits.jsp">Credits</a></li>
            <li style="float:right"><a class="active" href="index.html">Logout</a></li>
        </ul>
    </header>
    <br><br><br>
    <div class="news_on_main">

<!-- ---------- CONTENT START HERE ---------- -->

        <h1>Some fake News!</h1>
        <h2>Trump announces $50bn in China tariffs</h2>
        <p>The US plans to impose tariffs on about $50bn in Chinese goods and limit the countrys investment in the US in retaliation for years of alleged intellectual property theft.</p>
        <br>
        <p>The White House said the actions were necessary to counter unfair competition from Chinas state-led economy.</p>


<!-- ---------- CONTENT END HERE ---------- -->

    </div>
    <br><br><br>
    <div class="news_on_main">

<!-- ---------- CONTENT START HERE ---------- -->

        <h1>Everyone failed at PA!!!</h1>
        <h2>Students at Codecool starts Riot!!!</h2>
        <p>bla bla bla asdlaskdlask dlkasd asdj k slkd jaskj askjaksdj ajs jasdkj akej qwkejaskdja jk sdaksjd kasj kjasd </p>
        <br>
        <p>The asdk asl kdasélj daskfjasklfj asklfjasfljkasfk jasék</p>




<!-- ---------- CONTENT END HERE ---------- -->

    </div>
    <br><br><br>
    <div class="news_on_main">

<!-- ---------- CONTENT START HERE ---------- -->

        <h1>Some other fake News!</h1>
        <h2>Tasdasd asd s ad as </h2>
        <p>Tfgxdfg f ffgdg df cf fgcfcfc  cfgcxxf gfxcdf  xdxf  dxcfx d xcx d xdfxcx  dxfx  dxdfx xfdxd dxdx dxdfx d xfdx dfx </p>
        <br>
        <p>The sd as as das das das das dasd </p>



<!-- ---------- CONTENT END HERE ---------- -->

    </div>

</body>
</html>
