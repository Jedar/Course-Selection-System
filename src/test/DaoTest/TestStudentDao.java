package test.DaoTest;

import main.fudan.CourseSelectionSystem.dao.Impl.StudentDaoImpl;
import main.fudan.CourseSelectionSystem.dao.StudentDao;
import main.fudan.CourseSelectionSystem.entity.CompleteSection;

import java.util.List;

/**
 * @ClassName TestStudentDao
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/6 18:35
 * @Version 1.0
 **/
public class TestStudentDao {
    public static void main(String[] args) {
        testGetGPA("S10000001");
    }
    public static void testGetGPA(String studentID) {
        StudentDao studentDao = new StudentDaoImpl();
        System.out.println(studentDao.getGPA(studentID));
        List<CompleteSection> list = studentDao.getSelectedSectionList("S10000001");
        System.out.println(list);
    }
}
