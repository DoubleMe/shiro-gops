<#include "/views/bootstrap/header.ftl">
<#include "/views/bootstrap/leftMenu.ftl">
<div class="admin-main">
    <div class="search-button">
        <form id="top-search" method="get" action="/main">
            <div class="input-group">
                <input type="text" class="form-control" value="${q!''}">
                <span class="input-group-btn">
                        <button class="btn btn-default" type="button">搜索</button>
                    </span>
            </div>
        </form>
    </div>
    <div class="addBtn">
        <!-- 提供额外的视觉效果，标识一组按钮中的原始动作 -->
        <button type="button" class="btn btn-primary" onclick="window.location.href='/admin/shop/detail'">新增蔬果</button>
    </div>
    <div class="shop-show">
        <table width="100%" class="table">
            <tr>
                <td style="margin-left:10px;width: 5%">序号</td>
                <td style="margin-left:10px;width: 10%">商品名</td>
                <td style="margin-left:10px;width: 10%">单价(元)</td>
                <td style="margin-left:10px;width: 10%">产地</td>
                <td style="margin-left:10px;width: 10%">库存</td>
                <td style="margin-left:10px;width: 10%">操作</td>
            </tr>
        <#list products as p>
            <tr>
                <td style="margin-left:10px;width: 5%">${p.id}</td>
                <td style="margin-left:10px;width: 10%">${p.name}</td>
                <td style="margin-left:10px;width: 10%">${p.price!''}</td>
                <td style="margin-left:10px;width: 10%">产地</td>
                <td style="margin-left:10px;width: 10%">库存</td>
                <td style="margin-left:10px;width: 10%">
                    <a href="/admin/shop/detail?id=${p.id}">详情</a>
                    <a href="/admin/shop/detail?id=${p.id}">修改</a>
                    <a href="/admin/shop/detail">删除</a>
                </td>
            </tr>
        </#list>
        </table>
    </div>

</div>
<#include "/views/bootstrap/adminFooter.ftl">
