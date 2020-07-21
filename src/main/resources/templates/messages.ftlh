<#import "blocks/common.ftlh" as c>
<#import "blocks/header.ftlh" as h>
<#import "blocks/footer.ftlh" as f>
<@c.page>
<head>
    <title>Домашняя страница</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
</head>
<body>
<@h.main />
<div>
    <form method="post">
        <input type="text" name="text" placeholder="Введите сообщение">
        <input type="text" name="tag" placeholder="Тэг">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить</button>
    </form>
</div>
<div>Список сообщений</div>
<form method="get">
    <input type="text" name="filter" placeholder="Тег" value="${filter}">
    <button type="submit">Найти</button>
</form>
<#list messages as m>
<div>
    <b>${m.id}</b>
    <span>${m.text}</span>
    <span>${m.tag}</span>
    <span>от <#if m.author.username??>${m.author.username}<#else>${m.author.email}</#if></span>
</div>
</#list>
<@f.main />
</body>
</@c.page>