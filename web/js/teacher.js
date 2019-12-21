$(function () {

    $(".btn-accept-request").on("click",function () {
        var item = $(this);
        var c_id = item.attr("data-course-id");
        var c_sec = item.attr("data-section-id");
        var c_year = item.attr("data-year");
        var c_semester = item.attr("data-semester");
        var c_stu = item.attr("data-student-id");
        $.post( "./accept.req", {
            c_id:c_id,
            c_sec:c_sec,
            c_year:c_year,
            c_semester:c_semester,
            c_student:c_stu
        },function (result) {
            result = JSON.parse(result);
            if(result.success){
                showTip("操作成功");
                item.parent().html("已通过");
            }
            else{
                showError("操作失败");
            }
        });
    });

    $(".btn-refuse-request").on("click",function () {
        var item = $(this);
        var c_id = item.attr("data-course-id");
        var c_sec = item.attr("data-section-id");
        var c_year = item.attr("data-year");
        var c_semester = item.attr("data-semester");
        var c_stu = item.attr("data-student-id");
        $.post( "./refuse.req", {
            c_id:c_id,
            c_sec:c_sec,
            c_year:c_year,
            c_semester:c_semester,
            c_student:c_stu
        },function (result) {
            result = JSON.parse(result);
            if(result.success){
                showTip("操作成功");
                item.parent().html("已拒绝")
            }
            else{
                showError("操作失败");
            }
        });
    });

    $(".course-select").on("click",function () {
        var item = $(this);
        var c_id = item.attr("data-course-id");
        var c_sec = item.attr("data-section-id");
        var c_year = item.attr("data-year");
        var c_semester = item.attr("data-semester");
        $("#c_id").val(c_id);
        $("#c_sec").val(c_sec);
        $("#c_year").val(c_year);
        $("#c_semester").val(c_semester);
    });

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