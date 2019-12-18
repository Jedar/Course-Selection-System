package test.DaoTest;

import main.fudan.CourseSelectionSystem.dao.DaoRepository;
import main.fudan.CourseSelectionSystem.dao.TeachesDao;
import main.fudan.CourseSelectionSystem.entity.Teaches;
import main.fudan.CourseSelectionSystem.service.Impl.TeacherServiceImpl;
import main.fudan.CourseSelectionSystem.service.TeacherService;

import java.util.List;

public class TestTeachesDao {
    private static TeachesDao teachesDao = DaoRepository.getTeachesDao();

    public static void main(String[] args) {
        test_teaches_list();
    }

    private static void test_teaches_list(){
        TeacherService service = new TeacherServiceImpl();
        List<Teaches> teachesList = service.getTeachesListOf("T10000001");
        System.out.println(teachesList.size());
        for (Teaches t : teachesList){
            System.out.println(t);
        }
        for (Teaches t : teachesList){
            System.out.println(service.getStudentsList(t));
        }

    }
}
