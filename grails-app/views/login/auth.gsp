<html>
<head>
    <meta name="layout" content="${gspLayout ?: 'main'}"/>
    <title><g:message code='springSecurity.login.title'/></title>
</head>

<body>
<div style="height: 100px;width: 500px;margin-left: 200px;margin-top: 100px;">
    <div id="login">
        <div class="inner">
            <div class="fheader"><g:message code='springSecurity.login.header'/></div>

            <g:if test='${flash.message}'>
                <div class="login_message">${flash.message}</div>
            </g:if>

            <form action="${postUrl ?: '/login/authenticate'}" method="POST" id="loginForm" class="cssform" autocomplete="off">
                <div class="form-group">
                    <label for="username"><g:message code='springSecurity.login.username.label'/>:</label>
                    <input type="email" class="form-control" name="${usernameParameter ?: 'username'}" id="username" aria-describedby="emailHelp" placeholder="Enter email">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label for="password"><g:message code='springSecurity.login.password.label'/>:</label>
                    <input type="password" class="form-control" name="${passwordParameter ?: 'password'}" id="password" placeholder="Password">
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" class="chk" name="${rememberMeParameter ?: 'remember-me'}" id="remember_me" <g:if test='${hasCookie}'>checked="checked"</g:if>>
                    <label class="form-check-label" for="remember_me"><g:message code='springSecurity.login.remember.me.label'/></label>

                </div>
                <button type="submit" id="submit" value="${message(code: 'springSecurity.login.button')} class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>

</div>
<script>
    (function() {
        document.forms['loginForm'].elements['${usernameParameter ?: 'username'}'].focus();
    })();
</script>
</body>
</html>
