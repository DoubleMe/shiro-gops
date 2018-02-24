<#include "/views/header.ftl">
<div class="layui-body body-main">

    <form id="pageForm" action="/menu/list" method="get">
        <input type="hidden" name="page" value="${data.pageIndex}">
        <input type="hidden" name="size" value="${data.pageSize}">
        <input type="hidden" name="total" value="${data.total}">
        <div class="layui-form-item">
            <#--<label style="float: left;padding: 9px 15px;font-weight: 400;font-size: medium">菜单:</label>-->
            <#--<div class="layui-input-inline">-->
                <#--<input type="text" name="name" lay-verify="required" placeholder="请输入菜单名称" value="${query.name!''}" autocomplete="off" class="layui-input">-->
            <#--</div>-->

            <div class="layui-input-inline" style="float: right">
                <#--<button class="layui-btn" lay-submit="" lay-filter="pageForm">搜索</button>-->
                <button class="layui-btn add-menu" type="button">新增</button>
            </div>
        </div>
    </form>
    <div>
        <table class="layui-table" >
            <thead>
            <tr>
                <th >ID</th>
                <th >角色</th>
                <th >角色代码</th>
                <th >操作员</th>
                <th >操作</th>
            </tr>
            </thead>
            <#list data.data as item>
                <tr>
                    <th>${item_index + 1}</th>
                    <th>${item.name}</th>
                    <th>${item.salt}</th>
                    <th>${item.loginId}</th>
                    <th><a class="layui-btn layui-btn-radius  layui-btn-small layui-btn-primary mod-menu" data-id="${item.id}" data-name="${item.name}" data-salt="${item.salt}" href="#">修改</a>
                        <a class="layui-btn layui-btn-radius  layui-btn-small layui-btn-primary btn-del"  data-url="/role/del?id=${item.id}" href="#">删除</a>
                        <a class="layui-btn layui-btn-radius  layui-btn-small layui-btn-primary btn-refresh"  data-url="/role/refresh?roleId=${item.id}" href="#">刷新权限</a>
                        <button class="layui-btn layui-btn-radius  layui-btn-small layui-btn-primary btn-add-auth"  data-id="${item.id}" data-url="/auth/list" href="#">权限列表</button>
                    </th>
                </tr>
            </#list>
        </table>
        <div id="page"></div>
    </div>
</div>
<!-- 新增菜单 -->
<div class="window-add-menu" style="display: none">
    <form id="saveForm" class="layui-form" action="" style="margin-top: 20px">
        <input type="hidden" name="id">
        <div class="layui-form-item">
            <label class="layui-form-label">角色</label>
            <div class="layui-input-inline">
                <input type="text" name="name" required lay-verify="required" placeholder="请输入菜单名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">角色代码</label>
            <div class="layui-input-inline">
                <input type="text" name="salt" required lay-verify="required" placeholder="请输入链接" autocomplete="off" class="layui-input">
            </div>
        </div>
        ${token()}
    </form>
</div>

<!-- 新增菜单 -->
<div class="window-add-auth" style="display: none;margin-left: 50px">
    <div id="menu" style="margin:auto;"></div>
</div>
<#include "/views/footer.ftl">
<script src="/static/js/app/page.js"></script>
<script>

    layui.use(['form', 'layer','table'], function(){
        var layer = layui.layer;
        var form = layui.form;
        var table = layui.table;
        //新增菜单
        $('.add-menu').on('click',function () {
            document.getElementById("saveForm").reset();

            open('新增角色',"/role/save",['350px', '250px']);
        })

        //修改菜单
        $('.mod-menu').on('click',function () {
            var _this = $(this);
            $('input[name=id]').val(_this.data("id"));
            $('input[name=name]').val(_this.data("name"));
            $('input[name=salt]').val(_this.data("salt"));

            open('修改菜单',"/role/save",['350px', '250px']);
        })

        //新增权限
        $('.btn-add-auth').on('click',function () {
            var roleId = $(this).data("id");
            //展示已知数据
            table.render({
                id:'auth',
                elem: '#menu',
                url:$(this).data("url"),
                method:'post',
                where: {roleId: roleId},
//                height: 272,
                width: 344,
                cols: [[ //标题栏
                    {checkbox: true} //默认全选
                    ,{field: 'id', title: 'ID', width: 50}
                    ,{field: 'name', title: '菜单名称', width: 120}
                    ,{field: 'url', title: 'url', width: 120}

                ]]
                ,skin: 'row' //表格风格
                ,even: true
                ,page: false //是否显示分页
                ,limit: 10 //每页默认显示的数量
            });

            //页面层
            layer.open({
                type: 1,//Page层类型
                area: ['450px','400px'],
                title: '权限列表',
                anim: 1, //0-6的动画形式，-1不开启
                content: $('.window-add-auth'),
                btn: ['修改', '取消'],
                btnAlign: 'c',
                scrollbar: false,
                yes: function (index) {
                    var checkStatus = table.checkStatus('auth');

                    var menuId = '';
                    for (var i = 0; i < checkStatus.data.length; i++){
                        menuId += checkStatus.data[i].id + ',';
                    }

                    ajax("/auth/save",{'roleId':roleId,'menuId':menuId},function (res) {
                        layer.close(index);
                        setTimeout(function () {
                            if (res.success) {
                                layer.msg(res.message);
                            }
                        }, 1000);
                    })
                }
            });
        });
    });
</script>