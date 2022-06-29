<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Search Results</title>
    <jsp:include page="../partials/head.jsp"/>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Creepster">
</head>
<style>
    body {
        font-family: "Creepster", sans-serif;
        background-size: cover;
        background: url("https://images.pexels.com/photos/3454270/pexels-photo-3454270.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2") no-repeat scroll center;
    }
</style>

<body>
    <jsp:include page="../partials/navbar.jsp"/>
                <h1 class="text-center">Search Results</h1>

    <c:forEach var="ad" items="${adList}">
        <div class="col-md-6">
            <h2>${ad.getTitle()}</h2>
            <p>${ad.getDescription()}</p>
        </div>
    </c:forEach>


    <!-- These are bundles of JS plugins and extra css to accommodate nav tab functionality-->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

</body>
</html>