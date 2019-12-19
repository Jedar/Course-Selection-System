<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="main.fudan.CourseSelectionSystem.service.RequestService" %>
<%@ page import="main.fudan.CourseSelectionSystem.service.Impl.RequestServiceImpl" %>
<%@ page import="main.fudan.CourseSelectionSystem.entity.Request" %>
<%@ page import="java.util.List" %>
<%@ page import="main.fudan.CourseSelectionSystem.consts.Constant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    RequestService service = new RequestServiceImpl();
    String user = (String)request.getSession().getAttribute(Constant.SESSION_USER);
    if(user == null){
        user = "T10000001";
    }
    List<Request> list = service.getRequestOf(user);
    request.setAttribute("rlist",list);
%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Course Selection System</title>

    <link href="../css/bootstrap.min.css" rel="stylesheet">

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
    <jsp:include page="../inc/teacher_slidebar.inc.jsp"/>

    <div id="content-wrapper">

        <div class="container-fluid">

            <div class="container">
                <!--申请列表-->
                <div class="container">
                    <div>
                        <h1>申请列表</h1>
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">课程编号</th>
                                <th scope="col">课程名称</th>
                                <th scope="col">课程年份</th>
                                <th scope="col">课程学期</th>
                                <th scope="col">学生学号</th>
                                <th scope="col">学生姓名</th>
                                <th scope="col">申请内容</th>
                                <th scope="col">处理状态</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${rlist}">
                                <tr>
                                    <th scope="row">${item.course_id}.${item.section_id}</th>
                                    <td>${item.course_name}</td>
                                    <td>${item.year}</td>
                                    <td>${item.semester}</td>
                                    <td>${item.student_id}</td>
                                    <td>${item.student_name}</td>
                                    <td>${item.request_content}</td>
                                    <td>
                                        <c:if test="${item.pass_or_not == 'unhandle'}">
                                            <button class="btn btn-primary btn-accept-request"
                                                    data-course-id="${item.course_id}"
                                                    data-section-id="${item.section_id}"
                                                    data-year="${item.year}"
                                                    data-semester="${item.semester}"
                                                    data-student-id="${item.student_id}"
                                            >
                                                通过申请
                                            </button>
                                            <button class="btn btn-danger btn-refuse-request"
                                                    data-course-id="${item.course_id}"
                                                    data-section-id="${item.section_id}"
                                                    data-year="${item.year}"
                                                    data-semester="${item.semester}"
                                                    data-student-id="${item.student_id}"
                                            >
                                                拒绝申请
                                            </button>
                                        </c:if>
                                        <c:if test="${item.pass_or_not == 'pass'}">
                                            <span class="label label-success">已通过</span>
                                        </c:if>
                                        <c:if test="${item.pass_or_not == 'fail'}">
                                            <span class="label label-warning">已通过</span>
                                        </c:if>
                                    </td>
                                    <%--<td>${item.pass_or_not}</td>--%>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
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

<script src="../js/util.js"></script>

<script src="../js/teacher.js"></script>

</body>

</html>
