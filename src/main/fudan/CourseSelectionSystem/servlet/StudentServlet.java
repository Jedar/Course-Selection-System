package main.fudan.CourseSelectionSystem.servlet;

import com.alibaba.fastjson.JSONObject;
import main.fudan.CourseSelectionSystem.consts.Constant;
import main.fudan.CourseSelectionSystem.entity.CompleteSection;
import main.fudan.CourseSelectionSystem.entity.CriteriaSection;
import main.fudan.CourseSelectionSystem.entity.Request;
import main.fudan.CourseSelectionSystem.service.Impl.RequestServiceImpl;
import main.fudan.CourseSelectionSystem.service.Impl.SectionServiceImpl;
import main.fudan.CourseSelectionSystem.service.Impl.TakeCourseServiceImpl;
import main.fudan.CourseSelectionSystem.service.RequestService;
import main.fudan.CourseSelectionSystem.service.SectionService;
import main.fudan.CourseSelectionSystem.service.TakeCourseService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "StudentServlet", value="*.ss")
public class StudentServlet extends HttpServlet {
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
        doPost(request, response);
    }

    /*搜索课程*/
    private void searchCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("search course");
        String courseIDStr = request.getParameter("courseID");
        String sectionIDStr = request.getParameter("sectionID");
        String courseName = request.getParameter("courseName");
        int courseID = -1;
        int sectionID = -1;
        if(courseIDStr != null) {
            try {
                courseID = Integer.parseInt(courseIDStr);
            }catch (Exception e) {
                courseID = -1;
            }
        }
        if(sectionIDStr != null) {
            try{
                sectionID = Integer.parseInt(sectionIDStr);
            }catch (Exception e) {
                sectionID = -1;
            }
        }
        if(courseName == null) {
            courseName = "";
        }
        CriteriaSection section = new CriteriaSection(courseName, courseID, sectionID);
        SectionService service = new SectionServiceImpl();
        List<CompleteSection> sectionList = service.searchSections(section);

        System.out.println(sectionList);
        JSONObject object = new JSONObject();
        object.put("success", true);
        object.put("sectionList", sectionList);

        response.getWriter().println(object.toJSONString());
    }

    /*选课*/
    private void selectCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("select a course");
        JSONObject object = takeORdropClass(true, request);
        response.getWriter().println(object.toJSONString());
    }

    /*退课*/
    private void dropCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("drop a course");
        JSONObject object = takeORdropClass(false, request);
        response.getWriter().println(object.toJSONString());
    }

    /*选课申请*/
    private void requestCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String courseIDStr = request.getParameter("courseID");
        String sectionIDStr = request.getParameter("sectionID");
        String yearStr = request.getParameter("year");
        String semester = request.getParameter("semester");
        String content = request.getParameter("content");
        int courseID, sectionID;
        Date year;
        JSONObject object = new JSONObject();
        if(courseIDStr == null || sectionIDStr == null || yearStr == null || semester == null || content == null) {
            object.put("success", false);
        }else {
            try{
                courseID = Integer.parseInt(courseIDStr);
                sectionID = Integer.parseInt(sectionIDStr);
                year = new Date(Integer.parseInt(yearStr));
                HttpSession session = request.getSession();
                String studentID = (String) session.getAttribute(Constant.SESSION_USER);
                RequestService service = new RequestServiceImpl();
                Request sectionRequest = new Request(studentID, courseID, sectionID, year, semester, content, "未处理", "");
                boolean success = service.addRequest(sectionRequest);
                object.put("success", success);
            }catch(Exception e){
                object.put("success", false);
            }
        }
    }

    private JSONObject takeORdropClass(boolean flag, HttpServletRequest request) {
        String courseIDStr = request.getParameter("courseID");
        String sectionIDStr = request.getParameter("sectionID");
        String yearStr = request.getParameter("year");
        String semester = request.getParameter("semester");
        int courseID, sectionID;
        Date year;
        JSONObject object = new JSONObject();
        if(courseIDStr == null || sectionIDStr == null || yearStr == null || semester == null) {
            object.put("success", false);
        }else{
            try{
                courseID = Integer.parseInt(courseIDStr);
                sectionID = Integer.parseInt(sectionIDStr);
                year = Date.valueOf(yearStr);
                String studentID = "S10000001";

                TakeCourseService service = new TakeCourseServiceImpl();
                boolean success;
                if(flag) {
                    success = service.selectCourse(studentID, courseID, sectionID, year, semester);
                }else {
                    success = service.dropCourse(studentID, courseID, sectionID, year, semester);
                }
                object.put("success", success);
            }catch(Exception e){
                object.put("success", false);
            }
        }
        return object;
    }
}
