<#include "/views/bootstrap/header.ftl">
<#include "/views/bootstrap/leftMenu.ftl">
<div class="admin-main">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">
            <#if data??>修改蔬果<#else>新增蔬果</#if>
            </h3>
        </div>
        <div class="panel-body">
            <div class="shop-data">
                <form class="bs-example bs-example-form" role="form" action="/admin/shop/add">
                    <div class="input-group row">
                        <span class="input-group-addon">名称</span>
                        <input type="text" class="form-control" name="name" placeholder="请输入蔬果名称" value="${data.name!''}">
                    </div>
                    <div class="input-group row">
                        <span class="input-group-addon">产地</span>
                        <input type="text" class="form-control" name="cd" placeholder="请输入蔬果产地" value="${data.cd!''}">
                    </div>
                    <div class="input-group row">
                        <span class="input-group-addon">单价</span>
                        <input type="text" class="form-control" name="price" placeholder="请输入蔬果单价" value="${data.price!''}">
                    </div>

                    <div class="input-group row">
                        <span class="input-group-addon">库存</span>
                        <input type="text" class="form-control" name="kc" placeholder="请输入蔬果库存" value="${data.kc!''}">
                    </div>
                    <div class="input-group row">
                        <span class="input-group-addon">图片</span>
                        <input type="text" class="form-control" name="imageUrl" placeholder="请输入图片名称" value="${data.imageUrl!''}">
                    </div>

                    <div class="input-group row">
                        <span class="input-group-addon">简介</span>
                        <textarea class="form-control" rows="6" name="productDesc">${data.productDesc!''}</textarea>
                    </div>
                    <div class="sub_btn">
                        <button type="submit" class="btn btn-primary"><#if data??>修改<#else>新增</#if></button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>
<#include "/views/bootstrap/adminFooter.ftl">
