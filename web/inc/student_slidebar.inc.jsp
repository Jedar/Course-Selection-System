<%--
  Created by IntelliJ IDEA.
  User: 38403
  Date: 2019/12/9
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" rel="script" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" rel="script" src="../js/student.js"></script>
<script type="text/javascript" rel="script" src="../js/util.js"></script>
<!-- Sidebar -->
<ul class="sidebar navbar-nav">
    <li class="nav-item">
        <a class="nav-link" id="v-pills-myCourse-tab" href="${pageContext.request.contextPath}/jsp/student_mycourse.jsp">
            <i class="fa fa-fw fa-tasks"></i>我的课表
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="v-pills-selectCourse-tab" href="${pageContext.request.contextPath}/jsp/student_select.jsp">
            <i class="fa fa-fw fa-tasks"></i>选课
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="v-pills-courseRequest-tab" href="${pageContext.request.contextPath}/jsp/student_sec_req.jsp">
            <i class="fa fa-fw fa-tasks"></i>选课事务申请
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="v-pills-myRequest-tab" href="${pageContext.request.contextPath}/jsp/student_myrequest.jsp">
            <i class="fa fa-fw fa-tasks"></i>申请结果
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="v-pills-myScore-tab" href="${pageContext.request.contextPath}/jsp/student_mygrade.jsp">
            <i class="fa fa-fw fa-tasks"></i>我的成绩
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="v-pills-myExam-tab" href="${pageContext.request.contextPath}/jsp/student_myexam.jsp">
            <i class="fa fa-fw fa-tasks"></i>我的考试
        </a>
    </li>
</ul>
