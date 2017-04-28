<#macro nodata list>
    <#if list>
    <#else >
    <div class="g-nodata">
        <div>
            未找到符合条件的患者，查询医院数据，可能需要较长时间！</br>
            <a href="#" class="J-findHosp">点击查找</a>
        </div>
    </div>

    </#if>
</#macro>
<!--数据打码 data 目标字符串 dataType 类型 默认0-->
<#macro dataMask data dataType = 0>
    <#if data>
        <#local mask="***********">
        <#local pre="${data?substring(0,3)}">
        <#local aft="${data?substring(14)}">
        ${pre+mask+aft}
    </#if>
</#macro>
<!--截取数据 data 目标字符串 length  截取长度 默认20-->
<#macro dataSub data length = 20>
    <#if data?length gt length >
        <#local preData="${data?substring(0,length)}">
        <#local aftData="...">
        ${preData + aftData}
    <#else >
        ${data}
    </#if>
</#macro>
<!--数字装换 超过一万 以万为单位-->
<#macro numChange data>
    <#if data gt 10000 >
        <#assign t = data/10000/>
        <#local preData="#{t;m0M2}">
        <#local aftData="万">
    ${preData + aftData}
    <#else >
    #{data;m0M2}
    </#if>
</#macro>