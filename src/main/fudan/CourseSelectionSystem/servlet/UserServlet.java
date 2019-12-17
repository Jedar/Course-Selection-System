package main.fudan.CourseSelectionSystem.servlet;

import com.alibaba.fastjson.JSONObject;
import main.fudan.CourseSelectionSystem.consts.Constant;
import main.fudan.CourseSelectionSystem.consts.Message;
import main.fudan.CourseSelectionSystem.entity.Profile;
import main.fudan.CourseSelectionSystem.service.Impl.ProfileServiceImpl;
import main.fudan.CourseSelectionSystem.service.ProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "UserServlet", value = "*.us")
public class UserServlet extends HttpServlet {
    private ProfileService profileService = new ProfileServiceImpl();
    private JSONObject json = new JSONObject();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String servletPath = request.getServletPath();
        String methodName = servletPath.substring(5, servletPath.length() - 3);
        try {
            /*利用反射得到对应的方法*/
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            /*调用方法*/
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    /*用户登陆*/
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("username");
        String pwd = request.getParameter("password");
        Profile profile = new Profile();
        profile.setProfile_id(name);
        profile.setPassword(pwd);

        /* 获取登陆后跳转的页面 */
        String url = getServletConfig().getInitParameter("homePage");
        String blockPage = (String)request.getSession().getAttribute(Constant.SESSION_BLOCK_PAGE);
        if (blockPage != null){
            url = blockPage;
        }
        try{
            if(!profileService.login(name,pwd)) {
                json.put("success", false);
                json.put("message", Message.MSG_LOGIN_FAILED);
                json.put("link",request.getContextPath());
                response.getWriter().println(json.toJSONString());
            }else {
                HttpSession session = request.getSession();
                profile.setPermission(profileService.getPermission(profile.getProfile_id()));
                session.setAttribute(Constant.SESSION_USER,profile.getProfile_id());
                session.setAttribute(Constant.SESSION_PERMISSION,profile.getPermission());
                json.put("success", true);
                json.put("message", Message.MSG_LOGIN_SUCCESS);
                json.put("link",request.getContextPath()+url);
                response.getWriter().println(json.toJSONString());
            }
        }
        catch (Exception e){
            json.put("success", false);
            json.put("message", Message.MSG_LOGIN_UNKNOWN);
            json.put("link",request.getContextPath()+url);
            response.getWriter().println(json.toJSONString());
        }
    }

    /*用户登出*/
    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute(Constant.SESSION_USER);
        request.getSession().removeAttribute(Constant.SESSION_USER);
        json.put("success", true);
        json.put("link",request.getContextPath()+"/jsp/home.jsp");
        response.getWriter().println(json.toJSONString());
    }

}
