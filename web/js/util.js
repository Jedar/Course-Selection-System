function showTip(message) {
    $(".tip-content").html(message);
    $("#tip").removeClass('invisible').fadeIn("fast",function () {
        $("#tip").fadeOut(2000,function () {
            $("#tip").addClass('invisible');
        });
    });
}

function showError(message) {
    $(".error-content").html(message);
    $("#error").removeClass('invisible').fadeIn("fast",function () {
        $("#error").fadeOut(2000,function () {
            $("#error").addClass('invisible');
        });
    });
}

$(function () {
    $("#btn-logout").on("click",function () {
        $.post("./logout.us",{

        },function (result) {
            result = JSON.parse(result);
            if (result.success) {
                showTip("退出成功");
                window.location.href = result.link;
            }
            else {
                showError("系统繁忙，请稍后再试");
            }
        });
    });

});
