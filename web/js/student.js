$(function () {
    $("#searchCourse").on("click", function () {
        $.post("./searchCourse.ss",
            {
                courseID:$("#courseID").val(),
                sectionID:$("#sectionID").val(),
                courseName:$("#courseName").val()
            },function (result) {
                result=JSON.parse(result);
                if(result.success) {
                    list = result.sectionList;
                    var i;
                    var str = "";
                    for(i in list) {
                        str += "                <tr>\n" +
                            "                    <th scope=\"row\">"+list[i].course_id+"</th>\n" +
                            "                    <td>"+list[i].section_id+"</td>\n" +
                            "                    <td>"+new Date(list[i].year).getFullYear()+" "+list[i].semester+"</td>\n" +
                            "                    <td>"+list[i].course_name+"</td>\n" +
                            "                    <td><button type=\"button\" class=\"btn btn-link take-section\" data-target=" +list[i].course_id+"&"+list[i].section_id+"&"+list[i].year+"&"+list[i].semester+">选课</button></td>\n" +
                            "                </tr>";
                    }
                    $("#search-result").html(str);
                }else {
                    showError("请求出错");
                }
            })
    });

    $("#search-result").on("click","button",function () {
        alert("take-section");
        var target = $(this).attr("data-target");
        var node = $(this).parents("tr");
        var args = target.split("&");
        $.post("selectCourse.ss",
            {
                courseID:args[0],
                sectionID:args[1],
                year:args[2],
                semester:args[3]
            },function (result) {
                result=JSON.parse(result);
                if(result.success) {
                    showTip("选课成功!");
                    node.slideUp("slow");
                }else {
                    showError("选课失败!");
                }
            })
    });

    $("#submit-request").on("click", function () {
        alert("submit request");
        var courseID = $("#request-courseID").val();
        var sectionID = $("#request-sectionID").val();
        var year = $("#request-section-year").val();
        var semester = $("#request-section-semester").val();
        var content = $("#request-content");
        $.post("requestCourse.ss",
            {
                courseID:courseID,
                sectionID:sectionID,
                year:year,
                semester:semester,
                content:content
            },function (result) {
                result=JSON.parse(result);
                if(result.success) {
                    showTip("申请成功!");
                }else {
                    showError("申请失败!");
                }
            })
    });

    $(".drop-section").on("click", function () {
        alert("drop section");
        var target = $(this).attr("data-target");
        var node = $(this).parents("tr");
        var args = target.split("&");
        $.post("dropCourse.ss",
            {
                courseID:args[0],
                sectionID:args[1],
                year:args[2],
                semester:args[3]
            },function (result) {
                result=JSON.parse(result);
                if(result.success) {
                    showTip("退课成功!");
                    node.slideUp("slow");
                }else {
                    showError("退课失败!");
                }
            })
    })
});