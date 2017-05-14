<#include "/views/header.ftl">
<div class="top-main">
    <form id="top-search" method="get" action="/main">
        <div class="search-wrapper">
            <input value="${pageNum}" name="page" type="hidden" id="pageNum">
            <div class="search-box">
                <div id="arrow8" class="search-toggle">
                    宝贝<span class="down-icon"></span>
                </div>
                <input name="q" value="${q!''}" class="search-in" type="text" placeholder="请输入菜名">
                <input type="submit" class="search-but" value="搜索">
                <div data-toggle="hidden-box" id="nav-box8" class="search-toggle-box">店铺</div>
            </div>
        </div>
    </form>

</div>
<div class="g-box">
    <div class="main">
        <div class="main-title">
            <h1>美味蔬果<span class="show-title">下面有超多美味的蔬果等你品尝哦！</span></h1>
        </div>
        <ul>
        <#list products as p>
            <li>
                <div onclick="window.location.href='/detail/${p.id}'" class="product-box <#if p_index%2 == 1>main-right<#else >main-left</#if>">
                    <div class="inner-info">
                        <div class="inner-left">
                            <img class="product-img" src="/static/img/${p.imageUrl}"/>
                        </div>
                        <div class="inner-right">
                            <div class="product-name">商品名:${p.name}</div>
                            <div class="product-info">
                        <span>商品介绍:${p.productDesc}

                        </span>
                            </div>
                            <div class="product-price">
                                <p><span class="orange">￥${p.price!''}</span>
                                    <span class="send-free">包邮</span>

                                    <span>&nbsp;&nbsp;月消29件</span>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </li>
        </#list>
        </ul>
    </div>
    <div class="product-page">
        <#if totalPage gt 1>
        <ul class="page" maxshowpageitem="8" pagelistcount="${size}" id="page"></ul>
     </#if>
    </div>
</div>

<#include "/views/footer.ftl">
<script>
    function toPage(index) {
        if (index == $('#pageNum').val()){
            return;
        }
        $('#pageNum').attr("value",index);
        $('#top-search').submit();
    }
    $("#page").initPage(${total}, ${pageNum}, toPage);
</script>
