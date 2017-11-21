<#include "/views/header.ftl">
<div class="layui-body body-main">

    <form id="pageForm" action="/log/sql/list" method="get">
        <input type="hidden" name="page" value="${data.pageIndex}">
        <input type="hidden" name="size" value="${data.pageSize}">
        <input type="hidden" name="total" value="${data.total}">
    </form>
    <div>
        <table class="layui-table" >
            <thead>
            <tr>
                <th >ID</th>
                <th >sql</th>
                <th >sql参数</th>
                <th >操作员</th>
                <th >操作时间</th>
            </tr>
            </thead>
            <#list data.data as item>
                <tr>
                    <th>${item_index + 1}</th>
                    <th>${item.sqlContent}</th>
                    <th>${item.param}</th>
                    <th>${item.loginId}</th>
                    <th>${item.gmtModified?string('YYYY-MM-dd HH:mm:ss')}</th>
                </tr>
            </#list>
        </table>
        <div id="page"></div>
    </div>
</div>
<script src="/static/js/app/page.js"></script>