<#import "blocks/common.ftlh" as c>
<#import "blocks/header.ftlh" as h>
<#import "blocks/footer.ftlh" as f>
<@c.page>
<head>
    <title>Материалы</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <@c.scripts />
</head>
<@h.main user! />
<main role="main">

    <section class="jumbotron text-center">
        <div class="container">
            <h1>Материалы</h1>
            <p class="lead text-muted">Здесь будут появляться все загруженные вами файлы.</p>
            <form method="post" action="/materials/upload" enctype="multipart/form-data">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <p><input type="file" name="files" multiple href="#" class="btn btn-primary my-2"></p>
                <p>
                    <button type="submit" href="#" class="btn btn-secondary my-2">Отправить</button>
                </p>
            </form>
        </div>
    </section>

    <div class="album py-5 bg-light">
        <div class="container">

            <div class="row">
                <#list attachments as attachment>
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <<#if attachment.fileName?ends_with(".jpeg") || attachment.fileName?ends_with(".png") ||
                        attachment.fileName?ends_with(".jpg")>img src="/materials/${attachment.fileName}"<#else>svg
                    </#if> class="bd-placeholder-img card-img-top" width="100%" height="225"
                    xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
                    aria-label="Placeholder: Thumbnail">
                    <title>Placeholder</title>
                    <rect width="100%" height="100%" fill="#55595c"></rect>
                    <text x="50%" y="50%" fill="#eceeef" dy=".3em"><#if
                        attachment.owner.username??>${attachment.owner.username!}<#else>${attachment.owner.email!}
                    </#if></text>
            <div class="card-body">
                <p class="card-text">${attachment.fileName}</p>
                <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                        <a href="/materials/${attachment.fileName}">
                            <button type="button" class="btn btn-sm btn-outline-secondary">Открыть</button>
                        </a>
                        <form action="/materials/delete">
                            <input type="hidden" name="material_to_delete" value="${attachment.id}"/>
                            <button type="submit" class="btn btn-sm btn-outline-secondary">Удалить</button>
                        </form>
                    </div>
                    <small class="text-muted">9 mins</small>
                </div>
            </div>
        </div>
    </div>
</#list>
</div>
</div>
</div>

</main>
<@f.main />
</body>
</@c.page>