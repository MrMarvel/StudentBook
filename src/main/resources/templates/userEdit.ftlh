<#import "blocks/common.ftlh" as c>
<#import "blocks/header.ftlh" as h>
<#import "blocks/footer.ftlh" as f>

<@c.page>
<head>
    <@c.scripts />
    <title>Редактор пользователя</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
<@h.main user! />
<form action="/user" method="post" class="container mt-5 album py-5 bg-light">
    <input type="hidden" name="id" value="${(redacting_user.id)!}">
    <input type="text" name="username" value="${(redacting_user.username)!}">
    <input type="text" name="email" value="${(redacting_user.email)!}">
    <input type="text" name="password" value="${(redacting_user.password)!}">
    <#list roles as role>
    <div>
        <label><input type="checkbox" name="${role}" ${redacting_user.roles?seq_contains(role)?string("checked","")} />${role}</label>
    </div>
    </#list>
<label><input type="checkbox" name="active" <#if user.active>checked</#if>> Активирован</label>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit">Сохранить изменения</button>
</form>
<@f.main />
</body>
</@c.page>
