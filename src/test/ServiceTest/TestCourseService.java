package test.ServiceTest;

import main.fudan.CourseSelectionSystem.service.CourseService;
import main.fudan.CourseSelectionSystem.service.Impl.CourseServiceImpl;

public class TestCourseService {
    private static CourseService service = new CourseServiceImpl();

    public static void main(String[] args) {
        test_insert();
    }

    public static void test_insert(){
        try {
            service.insertCoursesByExcel("resources/data/course.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
