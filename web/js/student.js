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
                            "                    <td>"+list[i].year+" "+list[i].semester+"</td>\n" +
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
                alert("get result");
                alert(result);
                result=JSON.parse(result);
                if(result.success) {
                    showTip("选课成功!");
                    node.slideUp("slow");
                }else {
                    showError("选课失败!");
                }
            })
    });
});