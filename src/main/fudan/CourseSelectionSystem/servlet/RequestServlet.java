package main.fudan.CourseSelectionSystem.servlet;

import com.alibaba.fastjson.JSONObject;
import main.fudan.CourseSelectionSystem.consts.Constant;
import main.fudan.CourseSelectionSystem.entity.Request;
import main.fudan.CourseSelectionSystem.service.Impl.RequestServiceImpl;
import main.fudan.CourseSelectionSystem.service.RequestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "RequestServlet", value = "*.req")
public class RequestServlet extends HttpServlet {
    private JSONObject json = new JSONObject();
    private RequestService service = new RequestServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String servletPath = request.getServletPath();
        String methodName = servletPath.substring(5, servletPath.length() - 4);
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

    private void accept(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            int course_id = Integer.parseInt(request.getParameter("c_id"));
            int sec_id = Integer.parseInt(request.getParameter("c_sec"));
            String stu = request.getParameter("c_student");
            int year = Integer.parseInt(request.getParameter("c_year"));
            String semester = request.getParameter("c_semester");
            /* 这里可能需要先查询一下数据库里有没有数据 */
            Request req = new Request();
            req.setPass_or_not(Constant.REQ_PASS);
            req.setReply_content(Constant.REQ_PASS);
            service.readRequest(req);
            if (service.readRequest(req)){
                responseMessage(request,response,true,Constant.REQ_PASS);
                /* TODO:为学生选上课程，需要邓朋完成 */
            }
            else{
                responseMessage(request,response,false,"操作失败");
            }
        }
        catch (Exception e){
            responseMessage(request,response,false,e.getMessage());
        }
    }

    private void refuse(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            int course_id = Integer.parseInt(request.getParameter("c_id"));
            int sec_id = Integer.parseInt(request.getParameter("c_sec"));
            String stu = request.getParameter("c_student");
            int year = Integer.parseInt(request.getParameter("c_year"));
            String semester = request.getParameter("c_semester");
            /* 这里可能需要先查询一下数据库里有没有数据 */
            Request req = new Request();
            req.setPass_or_not(Constant.REQ_FAIL);
            req.setReply_content(Constant.REQ_FAIL);
            if (service.readRequest(req)){
                responseMessage(request,response,true,Constant.REQ_FAIL);
            }
            else{
                responseMessage(request,response,false,"操作失败");
            }

        }
        catch (Exception e){
            responseMessage(request,response,false,e.getMessage());
        }
    }

    private void responseMessage(HttpServletRequest request,HttpServletResponse response,boolean flag,String msg) throws IOException {
        json.put("success", flag);
        json.put("message", msg);
        json.put("link",request.getContextPath());
        response.getWriter().println(json.toJSONString());
    }
}
