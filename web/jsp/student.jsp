<%--
  Created by IntelliJ IDEA.
  User: Peng Deng
  Date: 2019/12/9
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Message</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../font/font-awesome-4.7.0/css/font-awesome.min.css">
    <script type="text/javascript" rel="script" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/student.js"></script>
</head>
<body>
<main class="container">
    <div class="row">
        <div class="col-3">
            <ul class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                <li>
                    <a class="nav-link" id="v-pills-myCourse-tab" data-toggle="pill" href="#v-pills-myCourse" role="tab" aria-controls="v-pills-myCourse" aria-selected="false">我的课表</a>
                </li>
                <li>
                    <a class="nav-link" id="v-pills-selectCourse-tab" data-toggle="pill" href="#v-pills-selectCourse" role="tab" aria-controls="v-pills-selectCourse" aria-selected="false">选课</a>
                </li>
                <li>
                    <a class="nav-link" id="v-pills-courseRequest-tab" data-toggle="pill" href="#v-pills-courseRequest" role="tab" aria-controls="v-pills-courseRequest" aria-selected="false">选课事务申请</a>
                </li>
                <li>
                    <a class="nav-link" id="v-pills-myScore-tab" data-toggle="pill" href="#v-pills-myScore" role="tab" aria-controls="v-pills-addFriend" aria-selected="false">我的成绩</a>
                </li>
                <li>
                    <a class="nav-link" id="v-pills-myExam-tab" data-toggle="pill" href="#v-pills-myExam" role="tab" aria-controls="v-pills-request" aria-selected="false">我的考试</a>
                </li>
            </ul>
        </div>
        <div class="col-9">
            <div class="tab-content" id="v-pills-tabContent">
                <div class="tab-pane fade" id="v-pills-myCourse" role="tabpanel" aria-labelledby="v-pills-messages-tab">
                    <div class="unreadMessage" id="unreadMessage">
                        <div class="card">
                            <div class="card-header" id="heading1">
                                <div class="row">
                                    <figure class="col-2">
                                        <img src="../resource/019010.jpg" class="figure-img rounded" width="50" height="50" alt="" />
                                    </figure>
                                    <div class="col-4 offset-1 align-self-center">
                                        <h4>From: Admin</h4>
                                    </div>
                                    <div class="col-2 offset-2 align-self-center">
                                        <div class="justify-content-center">
                                            <button class="btn btn-info" type="button" data-toggle="collapse" data-target="#collapse1" aria-expanded="true" aria-controls="collapse1">阅读</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="collapse1" class="collapse show" aria-labelledby="heading1" data-parent="#unreadMessage">
                                <div class="card-body">
                                    <form>
                                        <div class="form-group">
                                            <label for="message">Content</label>
                                            <textarea class="form-control" readonly id="message" rows="3"></textarea>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header" id="heading2">
                                <div class="row">
                                    <figure class="col-2">
                                        <img src="../resource/019010.jpg" class="figure-img rounded" width="50" height="50" alt="" />
                                    </figure>
                                    <div class="col-4 offset-1 align-self-center">
                                        <h4>From: Admin</h4>
                                    </div>
                                    <div class="col-2 offset-2 align-self-center">
                                        <div class="justify-content-center">
                                            <button class="btn btn-info" type="button" data-toggle="collapse" data-target="#collapse2" aria-expanded="true" aria-controls="collapse2">阅读</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="collapse2" class="collapse show" aria-labelledby="heading1" data-parent="#unreadMessage">
                                <div class="card-body">
                                    <form>
                                        <div class="form-group">
                                            <label for="message">Content</label>
                                            <textarea class="form-control" readonly id="message1" rows="3"></textarea>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="v-pills-selectCourse" role="tabpanel" aria-labelledby="v-pills-selectCourse-tab">
                    <div class="card">
                        <div class="card-header">
                            <form>
                                <div class="form-row">
                                    <div class="col-4">
                                        <input type="text" class="form-control" placeholder="课程代码" id="courseID">
                                    </div>
                                    <div class="col">
                                        <input type="text" class="form-control" placeholder="课程序号" id="sectionId">
                                    </div>
                                    <div class="col">
                                        <input type="text" class="form-control" placeholder="课程名" id="courseName">
                                    </div>
                                    <div class="col">
                                        <button type="button" class="btn btn-primary" id="searchCourse">搜索</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <table class="table">
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                            <td><button type="button" class="btn btn-link">选课</button></td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                            <td><button type="button" class="btn btn-link">选课</button></td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>Larry</td>
                            <td>the Bird</td>
                            <td>@twitter</td>
                            <td><button type="button" class="btn btn-link">选课</button></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="tab-pane fade" id="v-pills-courseRequest" role="tabpanel" aria-labelledby="v-pills-courseRequest-tab">
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
                <div class="tab-pane fade" id="v-pills-myScore" role="tabpanel" aria-labelledby="v-pills-myScore-tab">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">课程代码</th>
                            <th scope="col">课程名称</th>
                            <th scope="col">学分</th>
                            <th scope="col">课程序号</th>
                            <th scope="col">任课老师</th>
                            <th scope="col">成绩</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>Larry</td>
                            <td>the Bird</td>
                            <td>@twitter</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="tab-pane fade" id="v-pills-myExam" role="tabpanel" aria-labelledby="v-pills-myExam-tab">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">课程代码</th>
                            <th scope="col">课程序号</th>
                            <th scope="col">课程名称</th>
                            <th scope="col">考试日期</th>
                            <th scope="col">考试安排</th>
                            <th scope="col">考试地点</th>
                            <th scope="col">考试方式</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>Larry</td>
                            <td>the Bird</td>
                            <td>@twitter</td>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>
</body>
</html>
