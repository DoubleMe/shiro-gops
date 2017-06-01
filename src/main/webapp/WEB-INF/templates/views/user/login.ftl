<#include "/views/header.ftl">
<div class="align:center">
            登录
</div>
<div id="login" class="login">
    <div>${msg!''}</div>
    <form method="post" action="/user/login">
        <input type="hidden" name="type" value="0">
        <input type="text" required="required" placeholder="用户名" name="userName">
        <input type="password" required="required" placeholder="密码" name="userPwd">
        <button class="but" type="submit">登录</button>
    </form>
</div>
