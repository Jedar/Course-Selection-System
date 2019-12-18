package test.DaoTest;

import main.fudan.CourseSelectionSystem.dao.Impl.TakesDaoImpl;
import main.fudan.CourseSelectionSystem.dao.TakesDao;
import main.fudan.CourseSelectionSystem.entity.Takes;

import java.sql.Date;
import java.sql.SQLException;

/**
 * @ClassName TestTakesDao
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/7 11:00
 * @Version 1.0
 **/
public class TestTakesDao {
    public static void main(String[] args) {
        testAddTakes();
        testDropSection();
    }

    public static void testAddTakes(){
        Takes takes = new Takes("S10000002", 102536, 2, 2019, "春季", "A", false);
        TakesDao takesDao = new TakesDaoImpl();
        try {
            takesDao.addTakes(takes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void testDropSection() {
        TakesDao takesDao = new TakesDaoImpl();
        try {
            takesDao.dropSection("S10000003", 102536, 2, 2019, "春季");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void testGetTimeConflictSectionList() {

    }

    public static void testGetExamConflictSectionList() {

    }
}
