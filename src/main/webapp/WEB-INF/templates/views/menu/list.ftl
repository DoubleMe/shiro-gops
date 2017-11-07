<#include "/views/header.ftl">
<div class="layui-body body-main">

    <form id="pageForm" action="/menu/list" method="get">
        <input type="hidden" name="page" value="${data.pageIndex}">
        <input type="hidden" name="size" value="${data.pageSize}">
        <input type="hidden" name="total" value="${data.total}">
        <div class="layui-form-item">
            <label style="float: left;padding: 9px 15px;font-weight: 400;font-size: medium">菜单:</label>
            <div class="layui-input-inline">
                <input type="text" name="name" lay-verify="required" placeholder="请输入菜单名称" value="${query.name!''}" autocomplete="off" class="layui-input">
            </div>

            <div class="layui-input-inline" style="float: right">
                <button class="layui-btn" lay-submit="" lay-filter="pageForm">搜索</button>
                <button class="layui-btn add-menu" type="button">新增</button>
            </div>
        </div>
    </form>
    <div>
        <table class="layui-table" >
            <thead>
            <tr>
                <th >ID</th>
                <th >菜单名称</th>
                <th >链接</th>
                <th >父菜单</th>
                <th >图标</th>
                <th >类型</th>
                <th >操作</th>
            </tr>
            </thead>
            <#list data.data as item>
                <tr>
                    <th>${item_index + 1}</th>
                    <th>${item.name}</th>
                    <th>${item.url}</th>
                    <th>${item.parentId!''}</th>
                    <th><i class="layui-icon">${item.icon}</i></th>
                    <th>${(item.type==0)?string("菜单","按钮")}</th>
                    <th><a class="mod-menu" data-id="${item.id}" href="#">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="btn-del"  data-url="/menu/del/${item.id}" href="#">删除</a>
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
            <label class="layui-form-label">菜单名称</label>
            <div class="layui-input-inline">
                <input type="text" name="name" required lay-verify="required" placeholder="请输入菜单名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">链接</label>
            <div class="layui-input-inline">
                <input type="text" name="url" required lay-verify="required" placeholder="请输入链接" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">图标</label>
            <div class="layui-input-inline">
                <input type="text" name="icon" required lay-verify="required" placeholder="请输入图标" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">父菜单</label>
            <div class="layui-input-inline">
                <select id="parentId" name="parentId" lay-search >

                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">菜单类型</label>
            <div class="layui-input-block">
                <input id="abc" type="radio" name="type" value="0" title="链接">
                <input type="radio" name="type" value="1" title="按钮">
            </div>
        </div>

    </form>
</div>
<#include "/views/footer.ftl">
<script src="/static/js/app/page.js"></script>
<script src="/static/js/app/app.js"></script>
<script>

    layui.use(['form', 'layer','table'], function(){
        var layer = layui.layer;
        var form = layui.form;
        //新增菜单
        $('.add-menu').on('click',function () {
            document.getElementById("saveForm").reset();
            ajax("/menu/list","",function (r) {
                createSelect("#parentId",r,"name","id");
                form.render();
                open('新增菜单',"/menu/save",['400px', '400px']);
            })
        })

        //修改菜单
        $('.mod-menu').on('click',function () {
            var id = $(this).data("id");
            $('input[name=id]').val(id);

            createSelect("#parentId","/menu/list","name","id")
            ajax("/menu/detail/" + id,"",function (res) {
                $('input[name=name]').val(res.data.name);
                $('input[name=url]').val(res.data.url);
                $('input[name=icon]').val(res.data.icon);
                $('input[name=type][value=' + res.data.type + ']').prop("checked",true);
                ajax("/menu/list","",function (r) {
                    createSelect("#parentId",r,"name","id",res.data.parentId);
                    form.render();
                    open('修改菜单',"/menu/save",['400px', '400px']);
                })
            })
        })
    });
</script>