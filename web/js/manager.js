$(function () {
    $("#t_insert").on("click",function () {
        var t_number = $("#t_num").val();
        var t_name = $("#t_name").val();
        var t_title = $("#t_title").val();
        var t_abbr = $("#t_abbr").val();
        if(t_number === "" || t_name === "" || t_title === "" || t_abbr === ""){
            showError("字段为空");
            return;
        }
        $.post( "./insertTeacherData.ins", {
            t_id:t_number,
            t_name:t_name,
            t_title:t_title,
            t_abbr:t_abbr
        },function (result) {
            result = JSON.parse(result);
            if(result.success){
                showTip("插入成功");
            }
            else{
                showMessage(result.message);
            }
        });
    });

    $("#t_insert_table").on("click",function () {
        var fordata = new FormData();
        var item = $('#info-teachers');
        if(item.val() === ""){
            showError("未选择上传数据");
            return;
        }
        var element = $(this);
        $(this).addClass("disabled");
        var data = item[0].files[0];
        fordata.append('files',data);
        $.ajax({
            type: 'post',
            url: "./uploadTeacherData.upld",
            data: fordata,
            cache: false,
            processData: false,
            contentType: false,
            success: function (data) {
                element.removeClass("disabled");
                data = JSON.parse(data);
                if(data.success){
                    showTip("插入成功");
                }
                else{
                    alert(data.message);
                    showMessage(data.message);
                }
            },
            error: function () {
                element.removeClass("disabled");
                showMessage(data.message);
            }
        });
    });

    $("#s_insert").on("click",function () {
        var s_id = $("#s_id").val();
        var s_name = $("#s_name").val();
        var s_abbr = $("#s_abbr").val();
        if(s_id === "" || s_name === "" || s_abbr === ""){
            showError("字段为空");
            return;
        }
        $.post( "./insertStudentData.ins", {
            s_id:s_id,
            s_name:s_name,
            s_abbr:s_abbr
        },function (result) {
            result = JSON.parse(result);
            if(result.success){
                showTip("插入成功");
            }
            else{
                showMessage(result.message);
            }
        });
    });

    $("#s_insert_table").on("click",function () {
        var fordata = new FormData();
        var item = $('#info-student');
        if(item.val() === ""){
            showError("未选择上传数据");
            return;
        }
        var element = $(this);
        $(this).addClass("disabled");
        var data = item[0].files[0];
        fordata.append('files',data);
        $.ajax({
            type: 'post',
            url: "./uploadStudentData.upld",
            data: fordata,
            cache: false,
            processData: false,
            contentType: false,
            success: function (data) {
                element.removeClass("disabled");
                data = JSON.parse(data);
                if(data.success){
                    showTip("插入成功");
                }
                else{
                    showMessage(data.message);
                }
            },
            error: function () {
                element.removeClass("disabled");
                showMessage(data);
            }
        });
    });

    $("#s_delete").on("click",function () {
        var c_id = $("#c_id").val();
        var c_sec = $("#c_sec").val();
        var c_year = $("#c_year").val();
        var c_semester = $("#c_semester").val();
        if(c_id === "" || c_sec === "" || c_year === "" || c_semester === ""){
            showError("字段为空");
            return;
        }
        $.post( "./deleteSection.sec", {
            c_id:c_id,
            c_sec:c_sec,
            c_year:c_year,
            c_semester:c_semester
        },function (result) {
            result = JSON.parse(result);
            if(result.success){
                showTip("删除成功");
            }
            else{
                showMessage(result.message);
            }
        });
    });

    $("#c_insert_table").on("click",function () {
        var fordata = new FormData();
        var item = $('#info-section');
        if(item.val() === ""){
            showError("未选择上传数据");
            return;
        }
        var element = $(this);
        $(this).addClass("disabled");
        var data = item[0].files[0];
        fordata.append('files',data);
        $.ajax({
            type: 'post',
            url: "./uploadSectionData.upld",
            data: fordata,
            cache: false,
            processData: false,
            contentType: false,
            success: function (data) {
                element.removeClass("disabled");
                data = JSON.parse(data);
                if(data.success){
                    showTip("插入成功");
                }
                else{
                    showMessage(data.message);
                }
            },
            error: function () {
                element.removeClass("disabled");
                showMessage(data.message);
            }
        });
    });


    $("#t_import_class_room").on("click",function () {
        var fordata = new FormData();
        var item = $('#import-class-room');
        if(item.val() === ""){
            showError("未选择上传数据");
            return;
        }
        var element = $(this);
        $(this).addClass("disabled");
        var data = item[0].files[0];
        fordata.append('files',data);
        $.ajax({
            type: 'post',
            url: "./uploadClassRoomData.upld",
            data: fordata,
            cache: false,
            processData: false,
            contentType: false,
            success: function (data) {
                element.removeClass("disabled");
                data = JSON.parse(data);
                if(data.success){
                    showTip("插入成功");
                }
                else{
                    showMessage(data.message);
                }
            },
            error: function () {
                element.removeClass("disabled");
                showMessage(data.message);
            }
        });
    });

    $("#t_import_course").on("click",function () {
        var fordata = new FormData();
        var item = $('#import-course');
        if(item.val() === ""){
            showError("未选择上传数据");
            return;
        }
        var element = $(this);
        $(this).addClass("disabled");
        var data = item[0].files[0];
        fordata.append('files',data);
        $.ajax({
            type: 'post',
            url: "./uploadCourseData.upld",
            data: fordata,
            cache: false,
            processData: false,
            contentType: false,
            success: function (data) {
                element.removeClass("disabled");
                data = JSON.parse(data);
                if(data.success){
                    showTip("插入成功");
                }
                else{
                    showMessage(data.message);
                }
            },
            error: function () {
                element.removeClass("disabled");
                showMessage(data);
            }
        });
    });

    $("#t_import_school").on("click",function () {
        var fordata = new FormData();
        var item = $('#import-school');
        if(item.val() === ""){
            showError("未选择上传数据");
            return;
        }
        var element = $(this);
        $(this).addClass("disabled");
        var data = item[0].files[0];
        fordata.append('files',data);
        $.ajax({
            type: 'post',
            url: "./uploadSchoolData.upld",
            data: fordata,
            cache: false,
            processData: false,
            contentType: false,
            success: function (data) {
                element.removeClass("disabled");
                data = JSON.parse(data);
                if(data.success){
                    showTip("插入成功");
                }
                else{
                    showMessage(data.message);
                }
            },
            error: function () {
                element.removeClass("disabled");
                showMessage(data);
            }
        });
    });


});