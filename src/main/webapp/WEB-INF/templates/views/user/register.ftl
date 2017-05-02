<#include "/views/header.ftl">
<div class="register">
    <div style="text-align: center">
        <h1>江山蔬果公司用户注册</h1>
    </div>
    <form id="userInfo" name="form1" method="post" action="/user/add">
        <table>
            <tr>
                <td class="name">用户名：</td>
                <td>
                    <input id="text1" type="text" name="userName" >
                    <div id="div1" style="display:inline">
                    </div>
                </td>
            </tr>
            <tr>
                <td class="name">登录名：</td>
                <td>
                    <input id="text2" type="text" name="loginId">
                    <div id="div2" style="display:inline">
                    </div>
                </td>
            </tr>
            <tr>
                <td class="name">密码：</td>
                <td>
                    <input id="text3" type="password" name="userPwd">
                    <div id="div3" style="display:inline">
                    </div>
                </td>
            </tr>
            <tr>
                <td class="name">用户地址：</td>
                <td>
                    <input id="text4" type="text" name="addr">
                    <div id="div4" style="display:inline">
                    </div>
                </td>
            </tr>
            <tr align="center">
                <td></td>
                <td style="text-align: left">
                    <a href="#" class="button orange" onclick="document.getElementById('userInfo').submit();">立即注册</a>
                </td>
            </tr>
        </table>
    </form>
</div>

<#include "/views/footer.ftl">