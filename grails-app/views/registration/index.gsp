<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>

</head>
<body>
<h3 style="color: #b21f2d">${message}</h3>


<g:form controller="registration" action="register">

    <div class="form-group col-md-4">
        <label for="name">Name</label>
        <g:textField name="name" class="form-control" id="inputName" placeholder="kapil"/>
    </div>
    <div class="form-group col-md-4">
        <label for="inputEmail4">Email</label>
        <g:textField name="email" type="email" class="form-control" id="inputEmail4" placeholder="xyz@kap.com"/>
    </div>
    <div class="form-group col-md-4">
        <label for="inputPassword4">Password</label>
        <g:passwordField name="password"  class="form-control" id="inputPassword4" placeholder="Password"/>
    </div>

<g:submitButton name="submit" class="btn btn-primary">SignUp</g:submitButton>
</g:form>

</body>
</html>
