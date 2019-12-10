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
    <jsp:include page="../inc/teacher_slidebar.inc.jsp"/>

    <div id="content-wrapper">

        <div class="container-fluid">

            <div class="container">
                <%--内容填充在这里--%>
                    <div class="card">
                        <div class="card-header">
                            <h3>导入课程成绩信息</h3>
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <form>
                                    <div class="form-row justify-content-center">
                                        <div class="offset-1"><h3>课程信息：</h3></div>
                                        <div class="col-2">
                                            <input id="c_id" type="text" class="form-control" placeholder="课程编号">
                                        </div>
                                        <div class="col-2">
                                            <input id="c_sec" type="text" class="form-control" placeholder="节数编号">
                                        </div>
                                        <div class="col-2">
                                            <input id="c_year" type="text" class="form-control" placeholder="开课年份">
                                        </div>
                                        <div class="col-3">
                                            <input id="c_semester" type="text" class="form-control" placeholder="开课学期">
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <br/>
                            <div class="row justify-content-center">
                                <div class="offset-1"></div>
                                <div class="col-7">
                                    <input accept="*/*"
                                           type="file"
                                           class="form-control"
                                           name="image"
                                           id="import-upload-grade"
                                           value="">
                                </div>
                                <div class="col-4">
                                    <button id="btn_upload_grade" type="button" class="btn btn-primary">导入课程成绩</button>
                                </div>
                            </div>

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

<script src="../js/teacher.js"></script>

<script src="../js/util.js"></script>
</body>

</html>

