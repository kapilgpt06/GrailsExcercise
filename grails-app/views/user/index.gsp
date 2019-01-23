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
<g:render template="show" model="[userList:userList]"></g:render><br>
<g:render template="/topic/show" model="[myTopicList:myTopicList]"></g:render><br>
<g:render template="/topic/otherTopicShow" model="[otherTopicList:otherTopicList]"></g:render><br>
<g:render template="followedTopic" model="[followedTopic:followedTopic]"></g:render><br>


</body>
</html>
