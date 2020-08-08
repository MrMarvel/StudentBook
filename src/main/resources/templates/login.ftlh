<#import "blocks/common.ftlh" as c>
<#import "blocks/auth.ftlh" as a>
<@c.page>
<head>
    <@c.scripts />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://getbootstrap.com/docs/4.5/examples/sign-in/signin.css" />
    <title>Авторизация</title>
</head>
<@a.login />
</@c.page>