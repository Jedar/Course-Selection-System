<%--
  Created by IntelliJ IDEA.
  User: 38403
  Date: 2019/12/9
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<div id="wrapper">

    <!-- Sidebar -->
    <jsp:include page="../inc/manager_slidebar.inc.jsp"/>

    <div id="content-wrapper">

        <div class="container-fluid">

            <div>
                <!--管理页面-->
                <div class="container">
                    <ul class="list-group list-group-flush">
                        <%--管理教师数据--%>
                        <li class="list-group-item">
                            <h1>教师数据管理</h1>
                            <div id="manage-teacher">
                                <div class="card">
                                    <div class="card-header">
                                        <form>
                                            <div class="form-row">
                                                <div class="col-4">
                                                    <input id="t_num" type="text" class="form-control" placeholder="教师编号">
                                                </div>
                                                <div class="col">
                                                    <input id="t_name" type="text" class="form-control" placeholder="教师姓名">
                                                </div>
                                                <div class="col">
                                                    <input id="t_title" type="text" class="form-control" placeholder="教师职称">
                                                </div>
                                                <div class="col">
                                                    <input id="t_abbr" type="text" class="form-control" placeholder="教师所在学院">
                                                </div>
                                                <div class="col">
                                                    <button id="t_insert" type="button" class="btn btn-primary">插入教师数据</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-body row">
                                        <div class="col-8">
                                            <input accept="application/vnd.ms-excel"
                                                   type="file"
                                                   class="form-control"
                                                   name="image"
                                                   id="info-teachers"
                                                   value="">
                                        </div>
                                        <div class="col-4">
                                            <button id="t_insert_table" type="button" class="btn btn-primary">插入教师数据列表</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <!--管理学生数据-->
                        <li class="list-group-item">
                            <h1>学生数据管理</h1>
                            <div id="manager-student">
                                <div class="card">
                                    <div class="card-header">
                                        <form>
                                            <div class="form-row">
                                                <div class="col-4">
                                                    <input type="text" class="form-control" placeholder="学生编号">
                                                </div>
                                                <div class="col">
                                                    <input type="text" class="form-control" placeholder="学生姓名">
                                                </div>
                                                <div class="col">
                                                    <input type="text" class="form-control" placeholder="所属学院">
                                                </div>
                                                <div class="col">
                                                    <button type="button" class="btn btn-primary">插入学生数据</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-body row">
                                        <div class="col-8">
                                            <input accept="application/vnd.ms-excel"
                                                   type="file"
                                                   class="form-control"
                                                   name="image"
                                                   id="info-student"
                                                   value="">
                                        </div>
                                        <div class="col-4">
                                            <button type="button" class="btn btn-primary">插入学生数据列表</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <!--课程信息管理-->
                        <li class="list-group-item">
                            <h1>课程数据管理</h1>
                            <div id="student-teacher">
                                <div class="card">
                                    <div class="card-header">
                                        <form>
                                            <div class="form-row">
                                                <div class="col-4">
                                                    <input type="text" class="form-control" placeholder="课程编号">
                                                </div>
                                                <div class="col">
                                                    <input type="text" class="form-control" placeholder="节数编号">
                                                </div>
                                                <div class="col">
                                                    <input type="text" class="form-control" placeholder="开课年份">
                                                </div>
                                                <div class="col">
                                                    <input type="text" class="form-control" placeholder="开课学期">
                                                </div>
                                                <div class="col">
                                                    <button type="button" class="btn btn-danger">删除课程</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-body row">
                                        <div class="col-8">
                                            <input accept="application/vnd.ms-excel"
                                                   type="file"
                                                   class="form-control"
                                                   name="image"
                                                   id="info-section"
                                                   value="">
                                        </div>
                                        <div class="col-4">
                                            <button type="button" class="btn btn-primary">插入课程数据列表</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
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
