<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree"  lay-filter="test" style="margin-left: 10px">
            <#if menu??>
                <#list menu as item>
                    <li class="layui-nav-item <#if item.id == currMid>layui-this</#if> <#if item.selected>layui-nav-itemed</#if> ">
                        <a href="<#if item.url != '#'></#if>${item.url}?currMid=${item.id}"><i class="layui-icon">${item.icon}</i>&nbsp;${item.name}</a>
                        <#if item.children?? && item.children?size gt 0>
                            <dl class="layui-nav-child">
                                <#list item.children as child>
                                    <dd><a class="<#if child.id == currMid>layui-this</#if>" href="${child.url}?currMid=${child.id}"><span style="margin-left: 25px"></span>${child.name}</a></dd>
                                </#list>
                            </dl>
                        </#if>
                    </li>
                </#list>
            </#if>
            <#--<li class="layui-nav-item"><a href="/menu/list"><i class="layui-icon">&#xe629;</i>&nbsp;角色管理</a></li>-->
            <#--<li class="layui-nav-item"><a href="/menu/list"><i class="layui-icon">&#xe600;</i>&nbsp;菜单管理</a></li>-->
            <#--<li class="layui-nav-item"><a href=""><i class="layui-icon">&#xe62c;</i>&nbsp;在线人员</a></li>-->
            <#--<li class="layui-nav-item"><a href=""><i class="layui-icon">&#xe609;</i>&nbsp;日志管理</a></li>-->
            <#--<li class="layui-nav-item layui-this"><a href="/user/list"><i class="layui-icon">&#xe613;</i>&nbsp;管理员</a></li>-->
        </ul>
    </div>
</div>
