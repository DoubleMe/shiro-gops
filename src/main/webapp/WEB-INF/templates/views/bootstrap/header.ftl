<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="shortcut icon" href="/favicon.ico"/>
    <link href="/static/css/bootstrap/fileinput.min.css.css" rel="stylesheet" type="text/css">
    <link href="/static/css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="/static/css/common.css" rel="stylesheet" type="text/css">
    <link href="/static/css/taobao.css" rel="stylesheet" type="text/css">
    <link href="/static/css/reset.css" rel="stylesheet" type="text/css">
    <link href="/static/css/style.css" rel="stylesheet" type="text/css">
    <link href="/static/css/page.css" rel="stylesheet" type="text/css">
    <link href="/static/css/login.css" rel="stylesheet" type="text/css">
    <link href="/static/css/admin.css" rel="stylesheet" type="text/css">
    <link href="/static/css/jquery.spinner.css" rel="stylesheet" type="text/css">
    <link href="/static/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/static/js/jquery/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="/static/js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="/static/js/bootstrap/fileinput.min.js"></script>
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
			</#if>
            </div>
        </div>
        <!--top-right-->
        <div class="top-right">
            <a class="a-float-left" href="#">退出登录</a>
        </div>
    </div>
</div>
<div class="top-tit">
    <div class="text-show">
        江山蔬果管理系统
    </div>
</div>
</html>
