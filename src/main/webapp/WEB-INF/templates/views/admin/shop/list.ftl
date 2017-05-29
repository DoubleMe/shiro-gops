<#include "/views/bootstrap/header.ftl">
<#include "/views/bootstrap/leftMenu.ftl">
<div class="admin-main">
    <div class="search-button">
        <form id="top-search" method="get" action="/admin/shop/list">
            <div class="input-group">
                <input type="text" class="form-control" name="q" value="${q!''}">
                <span class="input-group-btn">
                        <button class="btn btn-default" type="submit">搜索</button>
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
                <td style="margin-left:10px;width: 20%">操作</td>
            </tr>
        <#list products as p>
            <tr>
                <td style="margin-left:10px;width: 5%">${p_index + 1}</td>
                <td style="margin-left:10px;width: 10%">${p.name}</td>
                <td style="margin-left:10px;width: 10%">#{p.price;m1M2}</td>
                <td style="margin-left:10px;width: 10%">${p.cd}</td>
                <td style="margin-left:10px;width: 10%">${p.kc}</td>
                <td style="margin-left:10px;width: 20%">
                    <a href="/admin/shop/detail?id=${p.id}">详情</a>
                    <a href="/admin/shop/detail?id=${p.id}">修改</a>
                    <a href="#" class="btn-del" data-id="${p.id}">删除</a>
                </td>
            </tr>
        </#list>
        </table>
    </div>

</div>
<#include "/views/bootstrap/adminFooter.ftl">

<script>
    /**
     * ajax 请求数据
     * @param URL  请求方法
     * @param data 数据参数
     * @param call 回调方法
     */
    function ajaxData(URL, data, call) {
        $.ajax({
            type: "POST",
            url: URL,
            data: data,
            dataType: "json",
            success: function (res) {
                console.log(res);
                return call(res);
            }
        });
    }

    $(".btn-del").on("click",function(){
        var id = $(this).data("id");
        ajaxData("/admin/shop/del/" + id,"",function (res) {
            alert(res.message);
            if (!res.error){
                window.location.href="/admin/shop/list"
            }
        })
    })
</script>