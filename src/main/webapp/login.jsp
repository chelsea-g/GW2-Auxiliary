<%@include file="template/head.jsp"%>
<body>
<%@include file="template/header.jsp"%>
<%@include file="template/nav.jsp"%>
    <div class="container">

        <form action="j_security_check" method="POST">
            <table>
                <tr><td>Account Email: <input type="text" name="j_username" value="${email}"/></td></tr>
                <tr><td>Password: <input type="password" name="j_password" /></td></tr>
                <tr><td><input type="submit" value="Log In" /></td></tr>
            </table>
        </form>

    </div>
</body>
<%@include file="template/footer.jsp"%>
</html>