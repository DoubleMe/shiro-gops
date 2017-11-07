layui.use(['laypage', 'layer','table'], function(){
    var table = layui.table;
    var laypage = layui.laypage;
    var layer = layui.layer;


    // 分页
    if (!!$("#pageForm")) {
        pageTo();
    }
    function pageTo() {
        var EP = $("#pageForm");
        var pageNo = EP.find('input[name=page]').val();
        var pageSize = EP.find('input[name=size]').val();
        var total = EP.find('input[name=total]').val();
        var pageCount = Math.ceil(total / pageSize);

        if (pageCount <= 1){
            return false;
        }
        //调用分页
        laypage.render({
            elem: 'page',
            count: total,
            limit: pageSize,
            curr: pageNo,
            jump: function(obj,first){
                EP.find('input[name=page]').val(obj.curr);
                if (!first) { //点击跳页触发函数自身，并传递当前页：obj.curr
                    EP.submit();
                }
            }
        });
    }
});


