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
<@h.main user! />
<div class="container mt-5 album py-5 bg-light">
    <h1>Пользователи</h1>
        <table class="alert alert-info mt-2">
            <thead>
            <tr>
                <th>Имя</th>
                <th>Почта</th>
                <th>Роль</th>
                <th>Активирован</th>
                <th></th>
            </tr>
            </thead>
            <#list users as u>
            <tbody>
            <td>${(u.username)!}</td>
            <td>${u.email}</td>
            <td><#list u.roles as r>${r}<#sep>, </#list></td>
            <td>${u.active?string("ДА","НЕТ")}</td>
            <td><a href="/user/${u.id}">изменить</td>
            </tbody>
            </#list>
        </table>
</div>
<@f.main />
</body>
</@c.page>
