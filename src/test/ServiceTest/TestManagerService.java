package test.ServiceTest;


import main.fudan.CourseSelectionSystem.service.Impl.ManagerServiceImpl;
import main.fudan.CourseSelectionSystem.service.ManagerService;

public class TestManagerService {
    private static ManagerService service = new ManagerServiceImpl();

    public static void main(String[] args) {
        test_insert();
    }

    private static void test_insert(){
        try {
            service.insertManagerByExcel("resources/data/manager.xlsx");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
