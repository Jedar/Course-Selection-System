<%@ page import="main.fudan.CourseSelectionSystem.service.SectionService" %>
<%@ page import="main.fudan.CourseSelectionSystem.service.Impl.SectionServiceImpl" %>
<%@ page import="main.fudan.CourseSelectionSystem.entity.CompleteSection" %>
<%@ page import="java.util.List" %>
<%@ page import="main.fudan.CourseSelectionSystem.consts.Constant" %>
<%@ page import="main.fudan.CourseSelectionSystem.entity.CriteriaSection" %><%--
  Created by IntelliJ IDEA.
  User: 38403
  Date: 2019/12/9
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//    String studentID = (String) session.getAttribute(Constant.SESSION_USER);
    String studentID = "S10000001";
    SectionService service = new SectionServiceImpl();
    List<CompleteSection> sections = service.searchSections(new CriteriaSection());
    request.setAttribute("sectionList", sections);
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

    <!-- Custom fonts for this template-->
    <link href="../font/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="../css/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="../css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">

<jsp:include page="../inc/frame_header.inc.jsp"/>
<jsp:useBean id="sectionList" type="java.util.List<main.fudan.CourseSelectionSystem.entity.CompleteSection>" scope="request"/>

<div id="wrapper">

    <!-- Sidebar -->
    <jsp:include page="../inc/student_slidebar.inc.jsp"/>

    <div id="content-wrapper">
        <div class="container-fluid">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">课程代码</th>
                    <th scope="col">课程名</th>
                    <th scope="col">任课老师</th>
                    <th scope="col">上课地点</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="section" items="${sectionList}">
                    <c:set var="i" value="${sectionList.indexOf(section)}">
                        <tr>
                            <th scope="row">${sectionList.get(i).course_id}</th>
                            <td>${sectionList.get(i).course_name}</td>
                            <td>${sectionList.get(i).teachers}</td>
                            <td>${sectionList.get(i).exam_building}</td>
                        </tr>
                    </c:set>
                </c:forEach>
                </tbody>
            </table>
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

</body>

</html>

