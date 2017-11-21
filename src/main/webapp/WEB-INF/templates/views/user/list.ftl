<#include "/views/header.ftl">
<div class="layui-body body-main">
    <form id="pageForm" action="/user/list" method="get">
        <input type="hidden" name="page" value="${data.pageIndex}">
        <input type="hidden" name="size" value="${data.pageSize}">
        <input type="hidden" name="total" value="${data.total}">
    </form>
    <div>
        <table class="layui-table">
            <thead>
            <tr>
                <th >ID</th>
                <th >用户名</th>
                <th >登陆账号</th>
                <th >盐</th>
                <th >操作</th>
            </tr>
            </thead>
            <#list data.data as item>
                <tr>
                    <th>${item_index + 1}</th>
                    <th>${item.userName}</th>
                    <th>${item.loginId}</th>
                    <th>${item.salt}</th>
                    <th>
                        <#--<a class="layui-btn layui-btn-radius  layui-btn-small layui-btn-primary btn-del"  data-url="/user/del/${item.id}" href="#">删除</a>-->
                        <a class="layui-btn layui-btn-radius  layui-btn-small layui-btn-primary btn-add-user"  data-id="${item.id}" href="#">分配角色</a>
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
        <input type="hidden" name="userId">
        <div class="layui-form-item">
            <label class="layui-form-label">当前角色</label>
            <div class="layui-input-inline">
                <input id="name" type="text" placeholder="请输入菜单名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户角色</label>
            <div class="layui-input-inline">
                <select id="role" name="roleId">

                </select>
            </div>
        </div>

    </form>
</div>
<#include "/views/footer.ftl">
<script src="/static/js/app/page.js"></script>
<script>
    layui.use(['form', 'layer','table'], function(){
        var form = layui.form;
        //新增菜单
        $('.btn-add-user').on('click',function () {
            var userId = $(this).data('id');
            ajax("/user/role/detail",{'userId':userId},function (res) {
                var roleId = '';
                $('input[name=userId]').val(userId);
                if (res.data != null){
                    $('input[name=id]').val(res.data.id);
                    $('#name').val(res.data.name);
                    roleId = res.data.id;
                }else {
                    $('#name').val('暂无角色');
                }

                ajax("/role/list","",function (r) {
                    createSelect("#role",r,"name","id",roleId);
                    form.render();
                    open('分配权限',"/user/role/save",['400px', '400px']);
                })
            })

        })
    })
</script>
