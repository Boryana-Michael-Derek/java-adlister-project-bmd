<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Creepster">
</head>
<style>
    body {
        font-family: "Creepster", sans-serif;
    }
</style>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container justify-content-center">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
<%--        <h3>${sessionScope.user.email}</h3>--%>
        <button onclick="window.location='/profile/edit'">Edit Profile</button>
    </div>

    <div class="container">
        <h1>Here are your ads!</h1>

        <c:forEach var="ad" items="${ads}">
            <div class="col-md-4">
                <h2>${ad.title}</h2>
                <p>${ad.description}</p>
                <form action="/ads" method="post">
                    <button type="submit" name="showad" value="${ad.id}">View Ad</button>
                </form>
                <form action="/edit/${ad.id}" method="get">
                    <button type="submit" name="editAd" value="${ad.id}">Edit Ad</button>
                </form>
                <form action="/delete" method="post">
                    <button type="submit" name="deleteAd" value="${ad.id}">Delete Ad</button>
                </form>
            </div>
        </c:forEach>
    </div>

    <!-- These are bundles of JS plugins and extra css to accommodate nav tab functionality-->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

</body>
</html>
