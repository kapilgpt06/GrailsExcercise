<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>

    <nav class="navbar navbar-expand-lg  navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <sec:ifLoggedIn>

                    <li class="nav-item">
                        <g:link controller="topic" action="create" class="navbar-brand">  create Topic  </g:link>
                    </li>


                </sec:ifLoggedIn>>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
            <sec:ifLoggedIn>

                <li class="nav-item">
                    <g:link class="navbar-brand">  hello <sec:username/></g:link>
                </li>
                <li class="nav-item">
                    <g:link controller="user" action="logOut" class="navbar-brand"> LOGOUT</g:link>
                </li>


            </sec:ifLoggedIn>>

        </div>
    </nav>

    <g:layoutHead/>
</head>

<body>
<g:layoutBody/>

    <asset:javascript src="application.js"/>

</body>
</html>
