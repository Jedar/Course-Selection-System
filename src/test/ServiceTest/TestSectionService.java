package test.ServiceTest;

import main.fudan.CourseSelectionSystem.service.Impl.SectionServiceImpl;
import main.fudan.CourseSelectionSystem.service.SectionService;

public class TestSectionService {
    private static SectionService service = new SectionServiceImpl();

    public static void main(String[] args) {
        test_insert();
    }

    public static void test_insert(){
        try {
            service.insertSectionsByExcel("resources/data/sections.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
