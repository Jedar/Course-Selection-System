
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Message</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../font/font-awesome-4.7.0/css/font-awesome.min.css">
    <script type="text/javascript" rel="script" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/bootstrap.min.js"></script>
</head>
<body>
<main class="container">
    <div class="row">
        <!--侧边栏-->
        <div class="col-3">
            <ul class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                <!--<li>-->
                <!--<a class="nav-link active " id="v-pills-receivedMessage-tab" data-toggle="pill" href="#v-pills-receivedMessage" role="tab" aria-controls="v-pills-receivedMessage" aria-selected="true">选课</a>-->
                <!--</li>-->
                <!--<li class="mx-auto">-->
                <!--<a class="nav-link" id="v-pills-readMessage-tab" data-toggle="pill" href="#v-pills-readMessage" role="tab" aria-controls="v-pills-readMessage" aria-selected="false">已读 <span class="badge badge-pill badge-secondary">4</span></a>-->
                <!--</li>-->
                <!--<li class="mx-auto">-->
                <!--<a class="nav-link" id="v-pills-unreadMessage-tab" data-toggle="pill" href="#v-pills-unreadMessage" role="tab" aria-controls="v-pills-unreadMessage" aria-selected="false">未读 <span class="badge badge-pill badge-secondary">4</span></a>-->
                <!--</li>-->
                <%--教师管理侧边按钮--%>
                <li>
                    <a class="nav-link"
                       id="v-pills-allTeachers-tab"
                       data-toggle="pill"
                       href="#v-pills-allTeachers"
                       role="tab"
                       aria-controls="v-pills-allTeachers"
                       aria-selected="false">
                        老师名单
                    </a>
                </li>
                <%--学生管理侧边按钮--%>
                <li>
                    <a class="nav-link"
                       id="v-pills-allStudents-tab"
                       data-toggle="pill"
                       href="#v-pills-allStudents"
                       role="tab"
                       aria-controls="v-pills-allStudents"
                       aria-selected="false">
                        学生名单
                    </a>
                </li>
                <%--课程管理侧边按钮--%>
                <li>
                    <a class="nav-link"
                       id="v-pills-allCourses-tab"
                       data-toggle="pill"
                       href="#v-pills-allCourses"
                       role="tab"
                       aria-controls="v-pills-allCourses"
                       aria-selected="false">
                        课程列表
                    </a>
                </li>
                <li>
                    <a class="nav-link"
                       id="v-pills-manage-tab"
                       data-toggle="pill"
                       href="#v-pills-manage"
                       role="tab"
                       aria-controls="v-pills-manage"
                       aria-selected="false">
                        管理
                    </a>
                </li>
            </ul>
        </div>
        <!--内容区-->
        <div class="col-9">
            <div class="tab-content" id="v-pills-tabContent">
                <!--教师列表-->
                <div class="tab-pane fade" id="v-pills-allTeachers" role="tabpanel" aria-labelledby="v-pills-allTeachers-tab">
                    <div id="manage-teacher">
                        <div class="card">
                            <div class="card-header">
                                <form>
                                    <div class="form-row">
                                        <div class="col-4">
                                            <input type="text" class="form-control" placeholder="教师编号">
                                        </div>
                                        <div class="col">
                                            <input type="text" class="form-control" placeholder="教师姓名">
                                        </div>
                                        <div class="col">
                                            <input type="text" class="form-control" placeholder="教师职称">
                                        </div>
                                        <div class="col">
                                            <input type="text" class="form-control" placeholder="教师所在学院">
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-primary">插入教师数据</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="card-body">
                                <input accept="application/vnd.ms-excel"
                                       type="file"
                                       class="form-control"
                                       name="image"
                                       id="info-image"
                                       value="">
                                <button type="button" class="btn btn-primary">插入教师数据列表</button>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="v-pills-myScore" role="tabpanel" aria-labelledby="v-pills-myScore-tab">
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">教师编号</th>
                                <th scope="col">教师姓名</th>
                                <th scope="col">教师职称</th>
                                <th scope="col">教师所在学院</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th scope="row">T10000001</th>
                                <td>Otto</td>
                                <td>教授</td>
                                <td>SOFT</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!--学生列表-->
                <div class="tab-pane fade" id="v-pills-allStudents" role="tabpanel" aria-labelledby="v-pills-allStudents-tab">
                    <div class="accordion" id="accordionExample">
                        <div class="card">
                            <div class="card-header" id="headingOne">
                                <div class="row">
                                    <figure class="col-2">
                                        <img src="../resource/019010.jpg" class="figure-img rounded" width="100" height="100" alt="" />
                                    </figure>
                                    <div class="col-4 offset-1 align-self-center">
                                        <h4>Admin</h4>
                                        <p><i class="fa fa-map-marker" aria-hidden="true"></i>上海</p>
                                    </div>
                                    <div class="col-2 offset-2 align-self-center">
                                        <div class="justify-content-center">
                                            <button class="btn btn-info" type="button" data-toggle="collapse" data-target="#collapseFriend" aria-expanded="false" aria-controls="collapseFriend">发消息</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div id="collapseFriend" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                                <div class="card-body">
                                    <form>
                                        <div class="form-group">
                                            <label for="messageContent">Content</label>
                                            <textarea class="form-control" id="messageContent" rows="3"></textarea>
                                        </div>
                                    </form>
                                    <button class="btn btn-primary">Send</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--课程列表-->
                <div class="tab-pane fade" id="v-pills-allCourses" role="tabpanel" aria-labelledby="v-pills-allCourses-tab">
                    <form>
                        <div class="form-group">
                            <label for="requestName">Name</label>
                            <input type="text" class="form-control" id="requestName" placeholder="username">
                        </div>
                        <div class="form-group">
                            <label for="requestContent">Content</label>
                            <textarea class="form-control" id="requestContent" rows="3"></textarea>
                        </div>
                        <button class="btn btn-primary">Send</button>
                    </form>
                </div>
                <!--管理页面-->
                <div class="tab-pane fade" id="v-pills-manage" role="tabpanel" aria-labelledby="v-pills-manage-tab">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <div class="row">
                                <figure class="col-2">
                                    <img src="../resource/019010.jpg" class="figure-img rounded" width="100" height="100" alt="" />
                                </figure>
                                <div class="col-4 offset-1 align-self-center">
                                    <h4>Admin</h4>
                                    <p>我是来自XX群聊的XXX</p>
                                </div>
                                <div class="col-2 offset-2 align-self-center">
                                    <div class="justify-content-center">
                                        <button class="btn btn-info" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">同意</button>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</main>
</body>
</html>
