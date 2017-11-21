<#include "/views/header.ftl">
<div class="layui-body body-main">
    <div>
        <table class="layui-table" >
            <thead>
            <tr>
                <th >ID</th>
                <th >登录名</th>
                <th >用户名</th>
                <th >角色</th>
                <th >登录时间</th>
            </tr>
            </thead>
            <#list data as item>
                <tr>
                    <th>${item_index + 1}</th>
                    <th>${item.loginId}</th>
                    <th>${item.userName}</th>
                    <th>${item.role}</th>
                    <th>
                        <#if item.loginTime??>
                            ${item.loginTime?string('yyyy-MM-dd : HH:mm:ss')}
                        </#if>
                    </th>

                </tr>
            </#list>
        </table>
    </div>
</div>
<script src="/static/js/app/page.js"></script>
