$(function () {
    $("#publishBtn").click(publish);
});

function publish() {
    $("#publishModal").modal("hide");

    let title = $("#recipient-name").val();
    let content = $("#message-text").val();

    $.post(
        //路径
        CONTEXT_PATH + "/discuss/add",
        // 访问参数 以对象发送
        {"title": title, "content": content},
        function (data) {
            // 解析字符串
            data = $.parseJSON(data);
            // 在提示框中显示返回信息
            $("#hintModal").text(data.msg);
            // 显示提示框
            $("#hintModal").modal("show");
            // 2秒之后隐藏提示框
            setTimeout(function () {
                $("#hintModal").modal("hide");
                // 成功就刷新页面
                if (data.code == 0) {
                    window.location.reload();
                }
            }, 2000);
        }
    );

}