
<nav class="navbar navbar-expand-sm navbar-dark bg-dark align-items-center">

    <a class="navbar-brand d-flex align-items-center" id="logo" href="/ads">
        <div style="color:red;font-size:2em">CreepyList</div>
    </a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse d-flex justify-content-end align-items-center" id="navbarSupportedContent">
            <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link mx-1" href="/login">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link mx-1" href="/register">Register</a>
            </li>
            <li class="nav-item">
                <a class="nav-link mx-1" href="/profile">Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link mx-1" href="/logout">Logout</a>
            </li>
                <li class="nav-item">
                    <a class="nav-link mx-1" href="/ads/create">Create Ad</a>
                </li>
            <li class="nav-item dropdown ml-1 mr-5">
                <a class="nav-link dropdown-toggle" href="/ads/search" id="navbarDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
                    Categories
                </a>
                <div class="dropdown-menu mx-1" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/ads/search?search=cool" class="search" value="cool">Cool</a>
                    <a class="dropdown-item" href="/ads/search?search=weird" class="search" value="weird">Weird</a>
                    <a class="dropdown-item" href="/ads/search?search=boring" class="search" value="boring">Boring</a>
                    <a class="dropdown-item" href="/ads/search?search=random" class="search" value="random">Random</a>
                    <a class="dropdown-item" href="/ads/search?search=new" class="search" value="new">New</a>
                    <a class="dropdown-item" href="/ads/search?search=old" class="search" value="old">Old</a>
                </div>
            </li>
        </ul>
<%--        <form action="/ads/search" method="GET" class="form-inline ml-1 my-2 my-sm-0">--%>
<%--            <input class="form-control mr-sm-2" name="search" type="search" placeholder="Search">--%>
<%--            <button class="btn btn-outline-danger" type="submit">Search</button>--%>
<%--        </form>--%>
        <form action="/ads" method="POST" class="">
            <input class="form-control" name="search" type="search" placeholder="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>

    </div>
</div>


</nav>
