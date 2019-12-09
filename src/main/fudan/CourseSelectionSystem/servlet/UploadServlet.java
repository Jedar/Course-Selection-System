package main.fudan.CourseSelectionSystem.servlet;

import com.alibaba.fastjson.JSONObject;
import main.fudan.CourseSelectionSystem.consts.Message;
import main.fudan.CourseSelectionSystem.service.Impl.SectionServiceImpl;
import main.fudan.CourseSelectionSystem.service.Impl.StudentServiceImpl;
import main.fudan.CourseSelectionSystem.service.Impl.TeacherServiceImpl;
import main.fudan.CourseSelectionSystem.service.Impl.UploadServiceImpl;
import main.fudan.CourseSelectionSystem.service.SectionService;
import main.fudan.CourseSelectionSystem.service.StudentService;
import main.fudan.CourseSelectionSystem.service.TeacherService;
import main.fudan.CourseSelectionSystem.service.UploadService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.rmi.MarshalException;

/* 这个servlet专门处理上传数据事务 */
@WebServlet(name = "UploadServlet", value = "*.upld")
public class UploadServlet extends HttpServlet {
    private UploadService uploadService = new UploadServiceImpl();
    private TeacherService teacherService = new TeacherServiceImpl();
    private StudentService studentService = new StudentServiceImpl();
    private SectionService sectionService = new SectionServiceImpl();
    private JSONObject json = new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String servletPath = request.getServletPath();
        String methodName = servletPath.substring(5, servletPath.length() - 4);
        System.out.println(methodName);
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

    private void uploadTeacherData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String path = uploadService.handleUploadFile(request);
            teacherService.insertTeachersByExcel(path);
            responseMessage(request,response,true, Message.MSG_INSERT_SUCCESS);
        }
        catch (Exception e){
            responseMessage(request,response,false,e.getMessage());
        }
    }

    private void uploadStudentData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String path = uploadService.handleUploadFile(request);
            studentService.insertStudentsByExcel(path);
            responseMessage(request,response,true, Message.MSG_INSERT_SUCCESS);
        }
        catch (Exception e){
            responseMessage(request,response,false,e.getMessage());
        }
    }

    private void uploadSectionData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String path = uploadService.handleUploadFile(request);
            sectionService.insertSectionsByExcel(path);
            responseMessage(request,response,true, Message.MSG_INSERT_SUCCESS);
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
