package test.ServiceTest;

import main.fudan.CourseSelectionSystem.service.Impl.StudentServiceImpl;
import main.fudan.CourseSelectionSystem.service.StudentService;

public class TestStudentService {
    private static StudentService studentService = new StudentServiceImpl();

    public static void main(String[] args) {
//        test_insert();
        double gpa = (double) studentService.getGPA("S10000001");
        System.out.println(gpa);
    }

    private static void test_insert(){
        try {
            studentService.insertStudentsByExcel("resources/data/students.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
