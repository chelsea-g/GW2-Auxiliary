<%@include file="template/head.jsp"%>
<body>
<%@include file="template/header.jsp"%>
<%@include file="template/nav.jsp"%>
<!--TODO: make this page inaccessible while logged in-->
<div class="container">
    <form action="try-create-account" method="POST">
        <table>
            <tr><td>Account Email: <input type="text" name="email" value="${email}"/></td></tr>
            <tr><td>Password: <input type="password" name="password" /></td></tr>
            <tr><td>Repeat Password: <input type="password" name="repeatPassword" /></td></tr>
            <tr><td>API Key: <input type="text" name="apiKey" value="${apiKey}" /></td></tr>
            <tr><td><input type="submit" value="Create Account" /></td></tr>
        </table>
    </form>
</div>
<%@include file="template/footer.jsp"%>
</body>
</html>