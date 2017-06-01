<#include "/views/header.ftl">
<div class="order-main">
    <div class="top">
        <div class="logo-buy">
            <h1>江山蔬果</h1>
        </div>
        <div class="stepbar">
            <ol>
                <li class="s">确认订单信息-></li>
                <li>付款-></li>
                <li>确认收货-></li>
                <li>双方互评</li>
            </ol>

        </div>
    </div>
    <div class="address">
        <p class="title">确认收货信息</p>
        <div class="line"></div>
        <div class="user">
            <ul>
                <li>
                    <div class="user-inf"><input type="radio" name="addr">杭州市滨江区 姓名 : 余余 联系电话 : 18370230202</div>
                </li>
                <li>
                    <div class="user-inf"><input type="radio" name="addr">杭州市上城区 姓名 : 余余 联系电话 : 18370230202</div>
                </li>
                <li>
                    <div class="user-inf"><input type="radio" name="addr">杭州市下城区 姓名 : 余余 联系电话 : 18370230202</div>
                </li>
                <li>
                    <div class="user-inf"><input type="radio" name="addr">杭州市西湖区 姓名 : 余余 联系电话 : 18370230202</div>
                </li>
                <li>
                    <div class="user-inf"><input type="radio" name="addr">杭州市萧山区 姓名 : 余余 联系电话 : 18370230202</div>
                </li>
            </ul>
        </div>
    </div>
    <div class="product">
        <p class="title">商品信息</p>
        <div class="line"></div>
        <div class="info">
            <div class="detail">
                <table width="100%" style="margin-top: 10px;border-collapse:separate; border-spacing:0px 10px;">
                    <tr>
                        <td style="margin-left:20px;width: 20%">商品名</td>
                        <td style="margin-left:20px;width: 30%">商品属性</td>
                        <td style="margin-left:20px;width: 20%">单价</td>
                        <td style="margin-left:20px;width: 20%">数量</td>
                        <td style="margin-left:20px;width: 10%">小计</td>
                    </tr>
                    <tr>
                        <td style="margin-left:20px;width: 20%">${detail.name}</td>
                        <td style="margin-left:20px;width: 30%">${detail.productDesc}</td>
                        <td style="margin-left:20px;width: 20%">${detail.price}</td>
                        <td style="margin-left:20px;width: 20%"><input type="text" class="spinner"/></td>
                        <td style="margin-left:20px;width: 10%">${detail.price}</td>
                    </tr>

                </table>
                <hr/>
                <div class="total">
                    合计： ${detail.price}元
                </div>
            </div>
            <div class="buy">
                <a href="#" class="button orange">立即付款</a>
            </div>
        </div>
    </div>
</div>

<#include "/views/footer.ftl">
<script>
    $('.spinner').spinner();
</script>