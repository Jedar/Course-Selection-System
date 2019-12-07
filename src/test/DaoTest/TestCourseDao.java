package test.DaoTest;

import main.fudan.CourseSelectionSystem.dao.CourseDao;
import main.fudan.CourseSelectionSystem.dao.Impl.CourseDaoImpl;
import main.fudan.CourseSelectionSystem.entity.Course;

public class TestCourseDao {
    private static CourseDao dao = new CourseDaoImpl();

    private static Course course = new Course();

    public static void main(String[] args) {
        init();
        test_get_course_list();
        test_insert();
        test_get_course_list();
        test_update();
        test_get_course_list();
        test_delete();
        test_get_course_list();
    }

    private static void init(){
        course.setCourse_id(102533);
        course.setCourse_name("测试课程");
        course.setSchool_abbr("SOFT");
        course.setCredits(2);
        course.setCredit_hours(2);
    }

    private static void test_insert(){
        try {
            dao.addCourse(course);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void test_delete(){
        try {
            dao.deleteCourse(course.getCourse_id());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void test_update(){
        course.setCourse_name("测试课程2");
        try {
            dao.updateCourse(course);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void test_get_course_list(){
        try {
            System.out.println(dao.getCourseList(course.getCourse_id()));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
