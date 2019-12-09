$.validator.setDefaults({
    submitHandler: function(form) {
        // alert("提交事件!");
        form.submit();
    }
});

$(function () {
    $("#t_insert").on("click",function () {
        var t_number = $("t_num").val();
        var t_name = $("t_name").val();
        var t_title = $("t_title").val();
        var t_abbr = $("t_abbr").val();
        $.post( "./login.us", {
            t_number:t_number,
            t_name:t_name,
            t_title:t_title,
            t_abbr:t_abbr
        },function (result) {
            result = JSON.parse(result);
            if(result.success){
                showTip("插入成功");
            }
            else{
                showError(result.message);
            }
        });
    });
    $("#t_insert_table").on("change",function () {
        var file = this.files[0];
        var img = $("#img-preview");
        if (!file){
            img.addClass('invisible');
            return;
        }
        if (!(/^image\/png$|jpeg$/.test(file.type))){
            img.addClass('invisible');
            return;
        }
        img.removeClass('invisible');
        var oburl = window.URL.createObjectURL(file);
        img.attr("src", oburl) ;
    });


});