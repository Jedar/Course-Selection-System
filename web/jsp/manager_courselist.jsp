<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="main.fudan.CourseSelectionSystem.service.SectionService" %>
<%@ page import="main.fudan.CourseSelectionSystem.service.Impl.SectionServiceImpl" %>
<%@ page import="main.fudan.CourseSelectionSystem.entity.CompleteSection" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    SectionService sectionService = new SectionServiceImpl();
    List<CompleteSection> list = sectionService.getCourseList();
    request.setAttribute("courseList",list);
%>
<jsp:useBean id="courseList" type="java.util.List<main.fudan.CourseSelectionSystem.entity.CompleteSection>" scope="request"/>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Course Selection System</title>

    <!-- Custom fonts for this template-->
    <link href="../font/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="../css/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="../css/sb-admin.css" rel="stylesheet">

    <link href="../css/util.css" rel="stylesheet">

    <link href="../css/bootstrap.min.css" rel="stylesheet">

</head>

<body id="page-top">

<jsp:include page="../inc/frame_header.inc.jsp"/>

<div id="wrapper">

    <!-- Sidebar -->
    <jsp:include page="../inc/manager_slidebar.inc.jsp"/>

    <div id="content-wrapper">

        <div class="container-fluid">
            <!--课程列表-->
            <div class="container">
                <div>
                    <h1>课程列表</h1>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">课程编号</th>
                            <th scope="col">课程名称</th>
                            <th scope="col">课程学期</th>
                            <th scope="col">上课教室</th>
                            <th scope="col">上课时间</th>
                            <th scope="col">任课老师</th>
                            <th scope="col">考试时间</th>
                            <th scope="col">考试形式</th>
                            <th scope="col">考试教室</th>
                            <th scope="col">容量</th>
                            <th scope="col">已选人数</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${courseList}">
                            <tr>
                                <th scope="row">${item.course_id}.${item.section_id}</th>
                                <td>${item.course_name}</td>
                                <td>${item.semester}</td><!--应该有年份，但是不知道为什么sql读不出来T_T-->
                                <td>${item.building}${item.room_number}</td>
                                <td>${item.course_time}</td>
                                <td>${item.teachers}</td>
                                <td>${item.exam_time}</td>
                                <td>${item.exam_type}</td>
                                <td>${item.exam_building}${item.exam_room_number}</td>
                                <td>${item.section_capacity}</td>
                                <td>${item.current_student_num}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <jsp:include page="../inc/frame_footer.inc.jsp"/>

    </div>
    <!-- /.content-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.html">Logout</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/bootstrap.bundle.js"></script>

<!-- Core plugin JavaScript-->
<script src="../js/jquery.easing.js"></script>

<!-- Page level plugin JavaScript-->
<script src="../js/jquery.dataTables.js"></script>
<script src="../js/dataTables.bootstrap4.js"></script>

<!-- Custom scripts for all pages-->
<script src="../js/sb-admin.js"></script>

<script src="../js/manager.js"></script>
<script src="../js/util.js"></script>

</body>

</html>
