layui.use('layer', function () {

    var layer = layui.layer;

    $('.btn-del').on('click',function () {
        var _this = $(this);
        var url = _this.data('url');

        //询问框
        layer.confirm('确定删除此数据吗?', {
            btnAlign: 'c',
            btn: ['确定','取消'] //按钮
        }, function(){
            ajax(url,"",function (res) {
                if (res.success) {
                    layer.msg(res.message);
                }
                setTimeout(function () {
                    window.location.reload();
                }, 1000);
            })
        }, function(){

        });

    })


});

/**
 * 打开弹出层
 * @param title
 * @param action
 */
function open(title, action ,area) {
    //页面层
    layer.open({
        type: 1,//Page层类型
        area: area,
        title: title,
        anim: 1, //0-6的动画形式，-1不开启
        content: $('.window-add-menu'),
        btn: ['确认', '关闭'],
        btnAlign: 'c',
        scrollbar: false,
        zIndex: 1000,
        yes: function (index) {
            ajax(action, $('#saveForm').serialize(), function (res) {

                if (res.success) {
                    layer.msg(res.message);
                }
                setTimeout(function () {
                    layer.close(index);
                    window.location.reload();
                }, 1000);
            })
        }
    });
}

/**
 * ajax请求
 * @param url
 * @param data
 * @param callback
 */
function ajax(url, data, callback) {
    $.ajax({
        type: "post",
        url: url,
        dataType: "json",
        data: data,
        success: function (res) {

            callback(res);
            setTimeout(function () {
                if (!res.success) {
                    layer.msg(res.message);
                }
            }, 1000);
        }

    });
}

/**
 * 初始化select 下拉框
 * @param id dom 对象
 * @param dataUrl 接口获取url
 * @param name 接口返回对象显示名称
 * @param value 接口返回对象值
 */
function createSelect(id, res, name, value, optionId) {

    var html = "<option value=''></option>";
    if (res.success && res.data.length > 0) {
        var data = res.data;
        for (var i = 0; i < data.length; i++) {
            html += "<option value='" + data[i][value] + "'";
            if (!!optionId && optionId == data[i][value]){
                html += " selected";
            }
            html += ">" + data[i][name] + "</option>";
        }

        $(id).html(html);
    }
}