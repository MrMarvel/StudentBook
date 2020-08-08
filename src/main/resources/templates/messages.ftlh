<#import "blocks/common.ftlh" as c>
<#import "blocks/header.ftlh" as h>
<#import "blocks/footer.ftlh" as f>
<@c.page>
<head>
    <title>Домашняя страница</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <@c.scripts />
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<@h.main user! />
<div>
    <form method="post" enctype="multipart/form-data">
        <input type="text" name="text" placeholder="Введите сообщение">
        <input type="text" name="tag" placeholder="Тэг">
        <input type="file" name="file" placeholder="Картинка">
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
    <span>
        <#if m.filename??>
            <img src="/img/${m.filename}">
        </#if>
    </span>
    <span>от <#if m.author.username??>${m.author.username}<#else>${m.author.email}</#if></span>
</div>
</#list>
<@f.main />
</body>
</@c.page>