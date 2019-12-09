<%@ page import="main.fudan.CourseSelectionSystem.entity.Profile" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="row-fix  bg-dark text-white container-fluid">
    <div class="row justify-content-center">
            <%
                boolean isLogin;
                isLogin = (session.getAttribute("user") != null);
            %>

            <% if(!isLogin){%>
            <div class="offset-1 col-md-4">
                <h5>Welcome to
                    <i>Little Course Selection System</i>
                </h5>
            </div>
            <div class="col-md-7"></div>

            <%}
            else {
                /* TODO: 注册登录事件 */
                Profile profile = new Profile();
            %>
            <div class="offset-1 col-md-4">
                <h5><a href="../jsp/login.jsp" class="a-white">Online Museum</a></h5>
            </div>
            <ul class="col-md-4 offset-md-3 nav nav-justified">
                <li class="nav-item">
                    <a href="../jsp/login.jsp" class="btn btn-link text-white"><i class="fa fa-home"></i> Home</a>
                </li>
                <li class="nav-item">
                    <a href="../jsp/login.jsp" class="btn btn-link text-white"><i class="fa fa-search"></i> Search</a>
                </li>
                <li class="nav-item">
                    <div class="dropdown">
                        <button class="dropdown-toggle btn btn-link text-white" id="dropdownMenuButton" data-toggle="dropdown">
                            <i class="fa fa-user-circle"></i> <%="Test User"%>
                        </button>
                        <div class="dropdown-menu bg-dark" aria-labelledby="dropdownMenuButton">
                            <a href="../jsp/login.jsp" class="text-white dropdown-item"><i class="fa fa-user"></i> 个人中心</a>
                            <a id="btn-logout" href="#" class="dropdown-item text-white "><i class="fa fa-sign-out"></i> 退出登陆</a>
                        </div>
                    </div>
                </li>
            </ul>
            <%
            }%>

        <div id="top-signin" class="invisible" data-sign="<%= isLogin?"1":"0" %>"></div>

    </div>
</nav>
