<div class="sidebar">
    <div class="container">
    <c:choose>
        <c:when test="${sessionScope.user == null}">
            <div class="login-links">
                <a href="${pageContext.request.contextPath}/login">Log In</a>
                <a href="${pageContext.request.contextPath}/create-account">Create Account</a>
                <%@include file="searchBar.jsp"%>
            </div>
        </c:when>
        <c:otherwise>

            <div class="user-links">
                Hello, ${sessionScope.user.getEmail()}! | <a href="${pageContext.request.contextPath}/logout">Log Out</a>
                <%@include file="searchBar.jsp"%>
                <a href="${pageContext.request.contextPath}/itemTracker.jsp">Item Tracker</a>
                <c:choose>
                    <c:when test="${sessionScope.isAdmin.equals(true)}">
                        <p>TODO: Admin identifier here</p>
                        <a href="${pageContext.request.contextPath}/admin">Admin Tools</a>
                    </c:when>
                </c:choose>
            </div>
        </c:otherwise>
    </c:choose>
    </div>
</div>
