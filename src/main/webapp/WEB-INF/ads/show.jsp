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

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Creepster">
</head>
<style>
    body {
        font-family: "Creepster", sans-serif;
    }
</style>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<%--<form class="container bg-danger">--%>
    <div class="col-md-12">
        <h1>${ad.title}</h1>
        <p>${ad.description}</p>
        <a href="/ads">Back to Ads</a>
    </div>
<%--</form>--%>


<!-- These are bundles of JS plugins and extra css to accommodate nav tab functionality-->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>


</body>
</html>


