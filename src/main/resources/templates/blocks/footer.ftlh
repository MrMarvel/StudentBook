<#macro main>
<script>
    $(function() {
    $('.backtotop').click(function(){
    $('html, body').animate({scrollTop:0}, 'slow');
    });
    });
    </script>
<div class="container" style="padding-top: 3rem;
    padding-bottom: 3rem;">
    <p class="float-right">
        <a class="backtotop" href="#" onclick="return false">Ввысь!</a>
    </p>
    <p>Сайт разработан с технологией © Bootstrap</p>
    <p>Хотите создать такой же? <a href="https://getbootstrap.com/">Посетите домашнюю страницу</a> или наш <a href="/docs/4.5/getting-started/introduction/">гайд для начинающих</a>.</p>
</div>
</#macro>