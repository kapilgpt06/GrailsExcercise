
<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>create Topic</title>
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>

</head>
<body>
<br>
<g:form controller="topic" action="save">
    Name <g:textField name="name"/>
    <g:submitButton name="submit"/>
</g:form>

</body>
</html>
