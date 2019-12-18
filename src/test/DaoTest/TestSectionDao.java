package test.DaoTest;

import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.Impl.JDBCDao;
import main.fudan.CourseSelectionSystem.dao.Impl.SectionDaoImpl;
import main.fudan.CourseSelectionSystem.dao.SectionDao;
import main.fudan.CourseSelectionSystem.entity.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
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
    private static SectionDao sectionDao = new SectionDaoImpl();
    private static Section section = new Section(102536, 2, 2019, "春季", 30, "Z2", "202", 3);
    public static void main(String[] args) {
//         testAddSection();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 1, 1);
        Date date = (Date) calendar.getTime();
        System.out.println(date);

//        test_section_list();
//        test_delete();

//        test_conflict();
//


//        test_student_num();

//        test_update();
    }

    public static void testAddSection() {
        List<TimeSlot> classTimeSlotList = new LinkedList<>();
        TimeSlot classTimeSlot = new TimeSlot(3, "星期三", 2, 4);
        classTimeSlotList.add(classTimeSlot);
        TimeSlot examTimeSlot = new TimeSlot(4, "星期五", 2, 4);
        List<Teaches> teachesList = new LinkedList<>();
        Teaches teaches = new Teaches(102536, 2, 2019, "春季", "T10000001");
        teachesList.add(teaches);
        try{
            Exam exam = new Exam(4, "2019-06-25", "开卷", 102536, 2, 2019, "春季","z2","201");
            sectionDao.addSection(section, exam, classTimeSlotList, examTimeSlot, teachesList);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test_delete(){
        try {
            sectionDao.deleteSection(section.getCourse_id(),section.getSection_id(), section.getYear(), section.getSemester());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void test_update(){
        try {
            section.setSection_capacity(123);
            sectionDao.updateSection(section);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void test_section_list(){
        try {
            List<CompleteSection> sections = sectionDao.getSectionList();
            for (CompleteSection section: sections){
                System.out.println(section);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test_student_num(){
        try {
            System.out.println(sectionDao.getStudentNum(section));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test_conflict(){
        CompleteSection cs = new CompleteSection();
        cs.setCourse_time("星期四,2-6");
        cs.setBuilding("z2");
        cs.setRoom_number("201");
        cs.setExam_building("z2");
        cs.setExam_room_number("201");
        cs.setExam_time("星期五,5-5");
        System.out.println(cs);
        try {
            System.out.println("Exam conflict");
            List<Section> sections = sectionDao.getExamConflictSectionList(cs);
            for (Section section: sections){
                System.out.println(section);
            }
            System.out.println("Course conflict");
            sections = sectionDao.getCourseConflictSectionList(cs);
            for (Section section: sections){
                System.out.println(section);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void testAddSection() {
//        Section section = new Section(102537, 1, 2019, "春季", 30, "Z2", "203", 5);
//        Exam exam = new Exam(6, "2019-06-25", "开卷", 102536, 2, 2019, "春季", );
//        List<TimeSlot> classTimeSlotList = new LinkedList<>();
//        TimeSlot classTimeSlot = new TimeSlot(3, "星期三", 2, 4);
//        classTimeSlotList.add(classTimeSlot);
//        TimeSlot examTimeSlot = new TimeSlot(4, "星期五", 2, 4);
//        List<Teaches> teachesList = new LinkedList<>();
//        Teaches teaches = new Teaches(102536, 2, 2019, "春季", "T10000001");
//        teachesList.add(teaches);
//        SectionDao sectionDao = new SectionDaoImpl();
//        try{
//            sectionDao.addSection(section, exam, classTimeSlotList, examTimeSlot, teachesList);
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
