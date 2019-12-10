<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Sidebar -->
<ul class="sidebar navbar-nav">
    <li class="nav-item">
        <a class="nav-link"
           id="v-pills-allTeachers-tab"
           href="${pageContext.request.contextPath}/jsp/manager_teacherlist.jsp">
            <i class="fa fa-fw fa-tasks"></i>
            <span>教师名单</span>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link"
           id="v-pills-allStudents-tab"
           href="${pageContext.request.contextPath}/jsp/manager_studentlist.jsp">
            <i class="fa fa-fw fa-tasks"></i>
            <span>学生名单</span>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link"
           id="v-pills-allCourses-tab"
           href="${pageContext.request.contextPath}/jsp/manager_courselist.jsp">
            <i class="fa fa-fw fa-tasks"></i>
            <span>课程列表</span>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link"
           id="v-pills-manage-tab"
           href="${pageContext.request.contextPath}/jsp/manager_main.jsp">
            <i class="fa fa-fw fa-tasks"></i>
            <span>管理</span>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link"
           id="v-pills-import-tab"
           href="${pageContext.request.contextPath}/jsp/manager_import.jsp">
            <i class="fa fa-fw fa-tasks"></i>
            <span>导入</span>
        </a>
    </li>
</ul>
