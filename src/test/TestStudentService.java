package test;

import main.fudan.CourseSelectionSystem.service.Impl.StudentServiceImpl;
import main.fudan.CourseSelectionSystem.service.StudentService;

public class TestStudentService {
    private static StudentService studentService = new StudentServiceImpl();

    public static void main(String[] args) {
        test_insert();
    }

    private static void test_insert(){
        try {
            studentService.insertStudentsByExcel("resources/data/students.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
