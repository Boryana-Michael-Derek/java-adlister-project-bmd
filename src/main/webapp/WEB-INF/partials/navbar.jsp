<%--<nav class="navbar navbar-default">--%>
<%--    <div class="container-fluid">--%>
<%--        <!-- Brand and toggle get grouped for better mobile display -->--%>
<%--        <div class="navbar-header">--%>
<%--            <a class="navbar-brand" href="/ads">Adlister</a>--%>
<%--        </div>--%>
<%--        <ul class="nav navbar-nav navbar-right">--%>
<%--            <li><a href="/ads/create">Create Ad</a></li>--%>
<%--            <li><a href="/profile">Profile</a></li>--%>
<%--            <li><a href="/login">Login</a></li>--%>
<%--            <li><a href="/logout">Logout</a></li>--%>
<%--        </ul>--%>
<%--    </div><!-- /.navbar-collapse -->--%>
<%--    </div><!-- /.container-fluid -->--%>
<%--</nav>--%>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/ads">Adlister</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse align-items-center" id="navbarSupportedContent">
        <ul class="nav navbar-nav navbar-right">

            <li><a href="/login?from=${pageContext.request.requestURI}">Login</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>

            <li class="nav-item active">
                <a class="nav-link" href="/ads/create">Create Ad</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/profile">Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">Logout</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/ads/search" id="navbarDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
                    Categories
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Cool</a>
                    <a class="dropdown-item" href="#">Weird</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Boring</a>
                </div>
            </li>

        </ul>
        <form class="form-inline my-2 my-lg-0 align-items-center">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>

</nav>


<%--<nav class="navbar navbar-expand-lg navbar-light bg-light">--%>
<%--    <a class="navbar-brand" href="/ads">Adlister</a>--%>
<%--    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--        <span class="navbar-toggler-icon"></span>--%>
<%--    </button>--%>

<%--    <div class="collapse navbar-collapse" id="navbarSupportedContent">--%>
<%--        <ul class="navbar-nav mr-auto">--%>
<%--            <li class="nav-item active">--%>
<%--                <a class="nav-link" href="/login">Login<span class="sr-only">(current)</span></a>--%>
<%--            </li>--%>
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link" href="/logout">Logout</a>--%>
<%--            </li>--%>
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link" href="/profile">Profile</a>--%>
<%--            </li>--%>
<%--            <li class="nav-item dropdown">--%>
<%--                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-expanded="false">--%>
<%--                    Categories--%>
<%--                </a>--%>
<%--                <div class="dropdown-menu" aria-labelledby="navbarDropdown">--%>
<%--                    <a class="dropdown-item" href="#">Old</a>--%>
<%--                    <a class="dropdown-item" href="#">Random</a>--%>
<%--                    <div class="dropdown-divider"></div>--%>
<%--                    <a class="dropdown-item" href="#">Weird</a>--%>
<%--                </div>--%>
<%--            </li>--%>
<%--&lt;%&ndash;            <li class="nav-item">&ndash;%&gt;--%>
<%--&lt;%&ndash;                <a class="nav-link disabled">Disabled</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </li>&ndash;%&gt;--%>
<%--        </ul>--%>
<%--        <form class="form-inline my-2 my-lg-0">--%>
<%--            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">--%>
<%--            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</nav>--%>