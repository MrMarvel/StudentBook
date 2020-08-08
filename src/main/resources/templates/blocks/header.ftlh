<#macro main user>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <h5 class="my-0 mr-md-auto font-weight-normal">Электронный Журнал Студента</h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="/">Главная ЭЖС</a>
        <a class="p-2 text-dark" href="/user">Пользователи</a>
        <a class="p-2 text-dark" href="/messages">Сообщения</a>
    </nav>
    <#if user?has_content>
    <a class="btn btn-outline-primary" href="/user/${(user.id)!}">Личный кабинет</a>
    <#else>
    <a class="btn btn-outline-primary" href="/login">Авторизация</a>
    </#if>
</div>
</#macro>