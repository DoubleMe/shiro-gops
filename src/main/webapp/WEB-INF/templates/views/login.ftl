<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>用户登录</title>
    <link rel="stylesheet" href="/static/js/layui/css/layui.css">
    <script src="/static/js/layui/layui.js"></script>
</head>
<div class="layui-body" style="margin-top:15%;margin-left: 20%">
    <form class="layui-form" action="/login" method="post" id="loginForm">
        <div>
            ${msg!''}
        </div>
        <div class="layui-form-item">
            <div class="layui-form-item">
                <label class="layui-form-label">账号</label>
                <div class="layui-input-inline">
                    <input type="text" name="userName" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                    <input type="password" name="userPwd" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux"></div>
            </div>
        </div>
        <#--<div class="layui-form-item">-->
            <#--<div class="layui-input-block">-->
                <#--<input type="checkbox" name="rememberMe"  value="1"  checked=""  lay-skin="primary">记住我-->
            <#--</div>-->
        <#--</div>-->
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="loginForm">登陆</button>
                <a class="layui-btn" type="button" href="/user/register">注册</a>
            </div>
        </div>
    </form>
</div>
</html>

<script>
    layui.use(['form','layer'], function(){
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
        var layer = layui.layer;

        var kickout = '${kickout}';

        if ("1" == kickout){
            layer.msg("该账号在其他地方登录");
        }

        //但是，如果你的HTML是动态生成的，自动渲染就会失效
        //因此你需要在相应的地方，执行下述方法来手动渲染，跟这类似的还有 element.init();
        form.render();
    });
</script>
