<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-12">
            <h2><a href="ads?showad=${ad.id}">${ad.title}</a></h2>
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
        </div>
        <form action="/ads" method="post">
            <button type="submit" name="showad" value="${ad.id}">Show Ad</button>
        </form>
    </c:forEach>

</div>

</body>
</html>
