
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

    <link href="../css/util.css" rel="stylesheet">

</head>

<body id="page-top">

<jsp:include page="../inc/frame_header.inc.jsp"/>

<div id="wrapper">

    <!-- Sidebar -->
    <jsp:include page="../inc/manager_slidebar.inc.jsp"/>

    <div id="content-wrapper">

        <div class="container-fluid">

            <div>
                <!--导入页面-->
                <div class="container">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <div class="card">
                                <div class="card-header">
                                    <h3>导入教室信息</h3>
                                </div>
                                <div class="card-body row">
                                    <div class="col-8">
                                        <input accept="*/*"
                                               type="file"
                                               class="form-control"
                                               name="image"
                                               id="import-class-room"
                                               value="">
                                    </div>
                                    <div class="col-4">
                                        <button id="t_import_class_room" type="button" class="btn btn-primary">插入教室数据列表</button>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div class="card">
                                <div class="card-header">
                                    <h3>导入课程信息</h3>
                                </div>
                                <div class="card-body row">
                                    <div class="col-8">
                                        <input accept="*/*"
                                               type="file"
                                               class="form-control"
                                               name="image"
                                               id="import-course"
                                               value="">
                                    </div>
                                    <div class="col-4">
                                        <button id="t_import_course" type="button" class="btn btn-primary">插入课程数据列表</button>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <%--学院数据--%>
                        <li class="list-group-item">
                            <div class="card">
                                <div class="card-header">
                                    <h3>导入学院信息</h3>
                                </div>
                                <div class="card-body row">
                                    <div class="col-8">
                                        <input accept="*/*"
                                               type="file"
                                               class="form-control"
                                               name="image"
                                               id="import-school"
                                               value="">
                                    </div>
                                    <div class="col-4">
                                        <button id="t_import_school" type="button" class="btn btn-primary">插入学院数据列表</button>
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

<script src="../js/bootstrap.min.js"></script>

<script src="../js/popper.min.js"></script>

</body>

</html>
