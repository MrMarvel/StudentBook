<#import "blocks/common.ftlh" as c>
<#import "blocks/header.ftlh" as h>
<#import "blocks/footer.ftlh" as f>

<@c.page>
<head>
    <title>Список пользователей</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
<@h.main />
<div class="container mt-5 album py-5 bg-light">
    <h1>Пользователи</h1>
    <#list users as u>
        <div class="alert alert-info mt-2">
            <h3>${u.id}</h3>
            <h3><#if u.email??>${u.email}<#else>-none-</#if></h3>
            <h3><#if u.username??>${u.username}<#else>-none-</#if></h3>
            <h3><#if u.username??>${u.username}<#else>-none-</#if></h3>
            <h3>Фиг тебе, а не пароль</h3>
            <h3><a href="/id/${u.id}">Детальнее</a></h3>
        </div>
    </#list>
</div>
<@f.main />
</body>
</@c.page>
