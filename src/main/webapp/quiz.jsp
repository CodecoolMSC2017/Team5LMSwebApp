<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Assignments</title>
</head>
<body>

    <form action="quiz" method="get">

        <h3>Q1. What color is the sky on a sunny day?</h3>
        <input type="radio" name="answer1" value="blue" checked="checked">blue<br>
        <input type="radio" name="answer1" value="red">red<br>
        <input type="radio" name="answer1" value="green">green<br>
        <input type="submit" value="Login"  class="submit" />
    </form>



    <br />

<c:forEach items="${quizlist}" var="element">
    <form>
        <table>


            <tr class="content">
                <td>${element.question}</td>
                <td>${element.possibleAnswer1}</td>

                <td>${element.possibleAnswer2}</td>
                <td>${element.possibleAnswer3}</td>
            </tr>

        </table>
        </form>
</c:forEach>

</body>
