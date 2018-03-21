<table class="user_table" align="center">
    <tr class="header">
        <td>Name</td>
        <td>E-mail</td>
        <td>Role</td>
    </tr>
<c:forEach items="${userlist}" var="element">
    <tr class="content">
        <td>${element.getName()}</td>
        <td>${element.getEmail()}</td>
        <td align="center">${element.getRole()}</td>
    </tr>
</c:forEach>
</table>
