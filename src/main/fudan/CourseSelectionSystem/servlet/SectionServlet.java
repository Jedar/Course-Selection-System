package main.fudan.CourseSelectionSystem.servlet;

import com.alibaba.fastjson.JSONObject;
import main.fudan.CourseSelectionSystem.consts.Message;
import main.fudan.CourseSelectionSystem.entity.Section;
import main.fudan.CourseSelectionSystem.service.Impl.SectionServiceImpl;
import main.fudan.CourseSelectionSystem.service.SectionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Date;

@WebServlet(name = "SectionServlet", value = "*.sec")
public class SectionServlet extends HttpServlet {
    private JSONObject json = new JSONObject();
    public SectionService sectionService = new SectionServiceImpl();

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

    private void deleteSection(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        Section section = new Section();

        try {
            section.setCourse_id(Integer.parseInt(request.getParameter("c_id")));
            section.setSection_id(Integer.parseInt(request.getParameter("c_sec")));
            section.setYear(Integer.parseInt(request.getParameter("c_year")));
            section.setSemester(request.getParameter("c_semester"));
            System.out.println(section);
            boolean flag = sectionService.deleteSection(section);
            responseMessage(request,response,flag, (flag)?Message.MSG_DELETE_SUCCESS:Message.MSG_DELETE_FAILED);
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
