<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Search Results</title>
    <jsp:include page="../partials/head.jsp"/>
</head>

<body>
    <jsp:include page="../partials/navbar.jsp"/>
    <h1>Search Results</h1>

    <c:forEach var="ad" items="${adList}">
        <div class="col-md-6">
            <h2>${ad.getTitle()}</h2>
            <p>${ad.getDescription()}</p>
<%--            <p>${ad.price}</p>--%>
<%--            <form action="/ads" method="get">--%>
<%--                <button>Click for Details</button>--%>
<%--                <input type="hidden" name="ad" value="${ad.id}">--%>
<%--            </form>--%>
        </div>
    </c:forEach>

    <%--<jsp:include page="/WEB-INF/partials/footer.jsp" />--%>
</body>
</html>