<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit Profile" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Edit your profile</h1>
    <form action="/profile/edit" method="POST">
        <div class="form-group">
            <label for="username">Username:</label>
            <input id="username" name="username" class="form-control" type="text" value="${username}">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input id="email" name="email" class="form-control" type="text" value="${email}">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input id="password" name="password" class="form-control" type="password">
        </div>
        <div class="form-group">
            <label for="confirm_password">Confirm Password</label>
            <input id="confirm_password" name="confirm_password" class="form-control" type="password">
        </div>
<%--        <c:if test="${passwordError}">--%>
            <c:out value="${passwordError}"/>
<%--        </c:if>--%>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>
