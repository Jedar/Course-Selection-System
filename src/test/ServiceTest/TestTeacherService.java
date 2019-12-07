package test.ServiceTest;

import main.fudan.CourseSelectionSystem.service.Impl.TeacherServiceImpl;
import main.fudan.CourseSelectionSystem.service.TeacherService;

public class TestTeacherService {
    private static TeacherService teacherService = new TeacherServiceImpl();

    public static void main(String[] args) {
        test_insert();
    }

    private static void test_insert(){
        try {
            teacherService.insertTeachersByExcel("resources/data/teacher.xlsx");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
