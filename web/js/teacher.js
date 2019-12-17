$(function () {

    $("#btn_upload_grade").on("click",function () {
        var c_id = $("#c_id").val();
        var c_sec = $("#c_sec").val();
        var c_year = $("#c_year").val();
        var c_semester = $("#c_semester").val();
        alert(c_id);
        if(c_id === "" || c_sec === "" || c_year === "" || c_semester === ""){
            showError("字段为空");
            return;
        }
        var fordata = new FormData();
        var item = $('#import-upload-grade');
        if(item.val() === ""){
            showError("未选择上传数据");
            return;
        }
        var element = $(this);
        $(this).addClass("disabled");
        var data = item[0].files[0];
        fordata.append('c_id',c_id);
        fordata.append('c_sec',c_sec);
        fordata.append('c_year',c_year);
        fordata.append('c_semester',c_semester);
        fordata.append('files',data);
        $.ajax({
            type: 'post',
            url: "./uploadGradeData.upld",
            data: fordata,
            cache: false,
            processData: false,
            contentType: false,
            success: function (data) {
                element.removeClass("disabled");
                alert(data);
            },
            error: function () {
                element.removeClass("disabled");
                alert(data);
            }
        });
    });
});