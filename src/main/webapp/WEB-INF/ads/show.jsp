<%--
  Created by IntelliJ IDEA.
  User: michaelkestler
  Date: 6/22/22
  Time: 1:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Showing Individual Ads"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<form class="container bg-danger">
    <div class="col-md-12">
        <h1><c:out value="${ad.title}" /></h1>
        <p><c:out value="${ad.description}" /></p>

        <form action="${pageContext.request.contextPath}/ads" method="get">
            <input type="submit" name="showad" value="Back to Ads">

        </form>
    </div>
</form>

</body>
</html>


