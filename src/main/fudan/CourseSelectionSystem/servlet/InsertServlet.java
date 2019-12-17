package main.fudan.CourseSelectionSystem.servlet;

import com.alibaba.fastjson.JSONObject;
import main.fudan.CourseSelectionSystem.consts.Message;
import main.fudan.CourseSelectionSystem.entity.Student;
import main.fudan.CourseSelectionSystem.entity.Teacher;
import main.fudan.CourseSelectionSystem.service.Impl.StudentServiceImpl;
import main.fudan.CourseSelectionSystem.service.Impl.TeacherServiceImpl;
import main.fudan.CourseSelectionSystem.service.StudentService;
import main.fudan.CourseSelectionSystem.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "InsertServlet", value = "*.ins")
public class InsertServlet extends HttpServlet {
    private JSONObject json = new JSONObject();
    private StudentService studentService = new StudentServiceImpl();
    private TeacherService teacherService = new TeacherServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String servletPath = request.getServletPath();
        String methodName = servletPath.substring(5, servletPath.length() - 4);
        System.out.println(methodName);
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

    private void insertStudentData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String student_id = request.getParameter("s_id");
        String student_name = request.getParameter("s_name");
        String student_abbr = request.getParameter("s_abbr");
        Student student = new Student();
        student.setStudent_id(student_id);
        student.setStudent_name(student_name);
        student.setSchool_abbr(student_abbr);
        try {
            boolean flag = studentService.insertStudent(student);
            responseMessage(request,response,flag, Message.MSG_INSERT_SUCCESS);
        }
        catch (Exception e){
            responseMessage(request,response,false,e.getMessage());
        }
    }

    private void insertTeacherData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String teacher_id = request.getParameter("t_id");
        String teacher_name = request.getParameter("t_name");
        String teacher_abbr = request.getParameter("t_abbr");
        String teacher_title = request.getParameter("t_title");
        Teacher teacher = new Teacher();
        teacher.setTeacher_id(teacher_id);
        teacher.setTeacher_name(teacher_name);
        teacher.setSchool_abbr(teacher_abbr);
        teacher.setTitle(teacher_title);
        try {
            boolean flag = teacherService.insertTeacher(teacher);
            responseMessage(request,response,flag, Message.MSG_INSERT_SUCCESS);
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
