package test.DaoTest;

import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.Impl.JDBCDao;
import main.fudan.CourseSelectionSystem.dao.Impl.SectionDaoImpl;
import main.fudan.CourseSelectionSystem.dao.SectionDao;
import main.fudan.CourseSelectionSystem.entity.Exam;
import main.fudan.CourseSelectionSystem.entity.Section;
import main.fudan.CourseSelectionSystem.entity.Teaches;
import main.fudan.CourseSelectionSystem.entity.TimeSlot;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName TestSectionDao
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/6 11:07
 * @Version 1.0
 **/
public class TestSectionDao {
    public static void main(String[] args) {
       testAddSection();
    }

    public static void testAddSection() {
        Section section = new Section(102536, 2, 2019, "春季", 30, "Z2", "202", 3);
        Exam exam = new Exam(4, "2019-06-25", "开卷", 102536, 2, 2019, "春季");
        List<TimeSlot> classTimeSlotList = new LinkedList<>();
        TimeSlot classTimeSlot = new TimeSlot(3, "星期三", 2, 4);
        classTimeSlotList.add(classTimeSlot);
        TimeSlot examTimeSlot = new TimeSlot(4, "星期五", 2, 4);
        List<Teaches> teachesList = new LinkedList<>();
        Teaches teaches = new Teaches(102536, 2, 2019, "春季", "T10000001");
        teachesList.add(teaches);
        SectionDao sectionDao = new SectionDaoImpl();
        try{
            sectionDao.addSection(section, exam, classTimeSlotList, examTimeSlot, teachesList);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
