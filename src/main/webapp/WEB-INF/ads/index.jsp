<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Creepster">

</head>
<style>
    body {
        font-family: "Creepster", sans-serif;
        /*background-image: url("https://images.pexels.com/photos/3454270/pexels-photo-3454270.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");*/
        /*object-fit: cover;*/
        background-size: cover;
        background: url("https://images.pexels.com/photos/3454270/pexels-photo-3454270.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2") no-repeat scroll center;
    }

    .buttons {
        display: flex;
        justify-content: center;
    }

    h1 {
        display: flex;
        justify-content: center;
    }

    /*.card-columns { @include media-breakpoint-only(sm) {*/
    /*    column-count: 4;*/
    /*}*/
    /*}*/
    /*.card {*/
    /*    min-width: 100px;*/
    /*}*/
    @media (min-width: 768px) {
        .card {
            /*!*column-count: 3;*!*/
            /*min-width: 100%;*/
            /*max-width: 100%;*/
            /*padding: 10px;*/
        }
    }
</style>
<body>
<div id="background-image"></div>
    <jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<form action="/ads" method="POST" class="">
    <input class="form-control" name="search" type="search" placeholder="Search">
    <button class="btn btn-outline-success" type="submit">Search</button>
</form>
<div class="container" style=" margin: auto">
    <h1>Browse our creepy stuff</h1>
    <%--    <div class="card-deck">--%>
    <%--            <div class="card-deck">--%>
    <c:forEach var="ad" items="${ads}">
        <%--            <div class="row">--%>
<%--        <div class="card">--%>
        <div class="col-sm-12 col-md-6 col-xl-4" style="text-align: center; background-image: linear-gradient(45deg, black, darkgray)">
                <%--                <div class="card-body text-center">--%>
                <%--                    <div class="flex-column">--%>
<%--            <h2><a href="/ads/show.jsp">${ad.title}</a></h2>--%>
            <h2 style="color:red;font-size:2em">${ad.title}</h2>
            <p style="color:red">${ad.description}</p>
            <div class=" buttons">
                <form style="padding: 5px" action="/ads" method="post">
                    <button class="inline" id="view-ad" type="submit" name="showAd"
                            value="${ad.id}">
                        View Ad
                    </button>
                </form>
                <form style="padding: 5px" action="/edit/${ad.id}" method="get">
                    <button class="inline" id="edit-ad" type="submit" name="editAd"
                            value="${ad.id}">
                        Edit Ad
                    </button>
                </form>
                <form style="padding: 5px" action="/delete/${ad.id}" method="get">
                    <button class="inline" id="delete-ad" type="submit" name="deleteAd"
                            value="${ad.id}">
                        Delete Ad
                    </button>
                </form>

            </div>
        </div>
<%--        </div>--%>
        <%--</div>--%>
    </c:forEach>
    <%--            </div>--%>
</div>

<%--</div>--%>


<!-- These are bundles of JS plugins and extra css to accommodate nav tab functionality-->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>

</body>
</html>
