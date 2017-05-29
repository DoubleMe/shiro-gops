<#include "/views/header.ftl">

<div class="product-detail">
    <div class="title">
    这是一个商品详情页
</div>
    <div class="product-main">
            <div class="product-main-left">
                <img class="image" src="/static/img/${detail.imageUrl}"/>
            </div>
            <div class="product-main-right">
                <div class="name">
                    ${detail.name}
                </div>

                <div class="introduce">&nbsp;&nbsp;
                ${detail.productDesc}
                </div>
                <div class="price">价格:
                    <span class="orange">￥${detail.price}</span>
                    <span class="send-free">包邮</span>

                    <span>&nbsp;&nbsp;月消29件 | 192条评论</span>
                </div>
                <div class="num">
                    <div class="ps-l">
                        剩余数量:  ${detail.kc}
                    </div>
                </div>
                <div class="tb-action">
                    <a href="/order/${detail.id}" class="button orange addcar">点此购买</a>
                    <a href="#" class="button orange addcar">加入购物车</a>
                </div>
            </div>
    </div>
</div>
<#include "/views/footer.ftl">
