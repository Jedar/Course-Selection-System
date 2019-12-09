$(function () {
    checkIsSign();
    $("#btn-login").on("click",function () {
        var pwd = md5($("#user-psw").val());
        // alert(pwd+"\n"+$("#user-psw").val());
        $.post( "./login.us", {
            username:$("#user-name").val(),
            password:pwd
        },function (result) {
            result = JSON.parse(result);
            if(result.success){
                showTip("登陆成功");
                $('.card-body').html('<div class="alert alert-success">\n' +
                    '  登陆成功\n' +
                    '</div>');
                $('.card-footer').html("");
                window.location.href = result.link;
            }
            else{
                showError(result.message);
            }
        });
    });

    function checkIsSign() {
        var isSign = $("#top-signin").attr('data-sign');
        if (isSign === '1'){
            $('.card-body').html('<div class="alert alert-success">\n' +
                '用户已登陆\n' +
                '</div>');
            $('.card-footer').html("");
        }
    }
});