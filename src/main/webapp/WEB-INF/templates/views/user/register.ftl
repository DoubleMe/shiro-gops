<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>用户登录</title>
    <link rel="stylesheet" href="/static/js/layui/css/layui.css">
    <script src="/static/js/layui/layui.js"></script>
</head>
<div class="layui-body" style="margin-top:10%;margin-left: 15%">
    <form id="form" class="layui-form" action="/user/register" method="post">
        <div class="layui-form-item">
            <div class="layui-form-item">
                <label class="layui-form-label">名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="userName" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">账号</label>
                <div class="layui-input-inline">
                    <input type="text" name="loginId" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                    <input type="password" name="password" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux"></div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <a class="layui-btn ajax-btn" lay-filter="demo1">注册</a>
                <a class="layui-btn" href="/login">登陆</a>
            </div>
        </div>
    </form>
</div>
</html>
<script src="/static/js/jquery/jquery-2.2.4.min.js"></script>
<script src="/static/js/layui/layui.js"></script>
<script src="/static/js/app/app.js"></script>
<script>
    layui.use('form', function(){
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功

        //但是，如果你的HTML是动态生成的，自动渲染就会失效
        //因此你需要在相应的地方，执行下述方法来手动渲染，跟这类似的还有 element.init();
        form.render();
        
        $('.ajax-btn').on('click',function () {

            ajax('/user/register',$('#form').serialize(),function (res) {

                if (res.success) {
                    layer.msg(res.message);
                }
                setTimeout(function () {
                    window.location.href = res.data;
                }, 1000);

            });


        })
    });
</script>
