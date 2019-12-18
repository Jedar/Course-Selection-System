package test.DaoTest;

import main.fudan.CourseSelectionSystem.dao.Impl.RequestDaoImpl;
import main.fudan.CourseSelectionSystem.dao.RequestDao;
import main.fudan.CourseSelectionSystem.entity.Request;

import java.sql.Date;

public class TestRequestDao {

    private static RequestDao dao = new RequestDaoImpl();

    private static Request request = new Request();

    public static void main(String[] args) {
        init();
//        test_add();
//        test_get_by_course();
//        test_get_by_stuID();
//        test_update();
//        test_get_by_course();
//        test_get_by_stuID();
//        test_delete();
//        test_get_by_course();
        test_get_by_stuID();
        test_get_request_by_teacher();
    }

    private static void init(){
        request.setStudent_id("S10000001");
        request.setCourse_id(102536);
        request.setSection_id(1);
        request.setSemester("春季");
        request.setYear(2019);
        request.setReply_content("hello");
    }

    private static void test_add(){
        try {
            dao.addRequest(request);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void test_delete(){
        try {
            dao.deleteRequest(request.getStudent_id(), request.getCourse_id(), request.getSection_id(), request.getYear(), request.getSemester());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void test_update(){
        try {
            request.setPass_or_not("fail");
            request.setReply_content("Fail");
            dao.updateRequest(request);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void test_get_by_course(){
        try {
            System.out.println(dao.getRequestListBySection(request.getCourse_id(), request.getSection_id(), request.getYear(), request.getSemester()));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void test_get_by_stuID(){
        try {
            System.out.println(dao.getRequestListByStudent(request.getStudent_id()));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void test_get_request_by_teacher(){
        try {
            System.out.println(dao.getRequestOf("T10000001"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
