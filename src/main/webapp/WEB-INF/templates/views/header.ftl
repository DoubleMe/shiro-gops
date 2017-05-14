<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="shortcut icon" href="/favicon.ico"/>
    <link href="/static/css/common.css" rel="stylesheet" type="text/css">
    <link href="/static/css/taobao.css" rel="stylesheet" type="text/css">
    <link href="/static/css/reset.css" rel="stylesheet" type="text/css">
    <link href="/static/css/style.css" rel="stylesheet" type="text/css">
    <link href="/static/css/page.css" rel="stylesheet" type="text/css">
    <link href="/static/css/login.css" rel="stylesheet" type="text/css">
    <link href="/static/css/jquery.spinner.css" rel="stylesheet" type="text/css">
    <link href="/static/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/static/js/jquery/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="/static/js/app/app.js"></script>
    <script type="text/javascript" src="/static/js/page.js"></script>
    <script type="text/javascript" src="/static/js/jquery.spinner.js"></script>
    <title>江山蔬果</title>
</head>
<div class="top-wrapper">
    <div class="top-info">
        <div class="top-left">
            <div data-toggle="arrowdown" id="arrow1" class="user-name">
                <#if userId??><a href="/login">你好,${userName!''}</a>
                <#else >
                    <a href="/login">请登录</a>
                </#if>
            </div>
            <div data-toggle="arrowdown" id="arrow2" class="msg-info">
                <i class="fa fa-envelope fa-gray"></i>
                <a href="/user/toRegister">注册</a>
            </div>
        </div>
        <!--top-right-->
        <div class="top-right">
            <div data-toggle="arrowdown" id="arrow4" class="user-name">
                <i class="fa fa-shopping-cart fa-orange"></i>
                <a href="#">购物车 |</a>
            </div>

            <div data-toggle="arrowdown" id="arrow6" class="user-name">
                <a href="/user/admin/toLogin">卖家中心 |</a>
            </div>
            <a class="a-float-left" href="#">联系客服</a>
        </div>
    </div>
</div>
</html>
