<%--
  Created by IntelliJ IDEA.
  User: 38403
  Date: 2019/12/9
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Sidebar -->
<ul class="sidebar navbar-nav">
    <li class="nav-item">
        <a class="nav-link" id="v-pills-myCourse-tab" href="${pageContext.request.contextPath}/jsp/teacher_mycourse.jsp">
            <i class="fa fa-fw fa-tasks"></i>开设课程
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="v-pills-courseRequest-tab" href="${pageContext.request.contextPath}/jsp/teacher_sec_req.jsp">
            <i class="fa fa-fw fa-tasks"></i>选课事务申请
        </a>
    </li>
</ul>
