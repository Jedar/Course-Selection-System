package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.SectionDao;
import main.fudan.CourseSelectionSystem.entity.*;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName SectionDaoImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 19:32
 * @Version 1.0
 **/
public class SectionDaoImpl implements SectionDao {
    BaseDao<Section> dao = new JDBCDao<>();

    @Override
    public boolean addSection(Section section, Exam exam, List<TimeSlot> classTimeSlots, TimeSlot examTimeSlot, List<Teaches> teachesList) throws SQLException {
        String timeSlotsSql = "insert into time_slot (time_slot_id, day, start_time, end_time) values (?, ?, ?, ?)";
        String sectionSql = "insert into section (course_id, section_id, year, semester, section_capacity, building, room_number, time_slot_id) values (?,?,?,?,?,?,?,?)";
        String examSql = "insert into exam (exam_date, course_id, section_id, year, semester, exam_time_slot_id, exam_type, exam_building, exam_room_number) values (?,?,?,?,?,?,?,?,?)";
        String teachesSql = "insert into teaches (teacher_id, course_id, section_id, year, semester) values (?,?,?,?,?)";
        List<String> sqlList = new LinkedList<>();
        List<List<Object>> argList = new LinkedList<>();
        /*插入上课时间的time_slot*/
        for(TimeSlot timeSlot : classTimeSlots) {
            sqlList.add(timeSlotsSql);
            argList.add(Arrays.asList(timeSlot.getTime_slot_id(), timeSlot.getDay(), timeSlot.getStart_time(), timeSlot.getEnd_time()));
        }

        /*插入考试时间的time_slot*/
        sqlList.add(timeSlotsSql);
        argList.add(Arrays.asList(examTimeSlot.getTime_slot_id(), examTimeSlot.getDay(), examTimeSlot.getStart_time(), examTimeSlot.getEnd_time()));

        /*插入section*/
        sqlList.add(sectionSql);
        argList.add(Arrays.asList(section.getCourse_id(), section.getSection_id(),
                section.getYear(), section.getSemester(), section.getSection_capacity(),
                section.getBuilding(), section.getRoom_number(), section.getTime_slot_id()));

        /*插入exam*/
        sqlList.add(examSql);
        argList.add(Arrays.asList(exam.getExam_date(), exam.getCourse_id(),
                exam.getSection_id(), exam.getYear(), exam.getSemester(),
                exam.getExam_time_slot_id(), exam.getExam_type(),
                exam.getExam_building(), exam.getExam_room_number()));

        /*插入teaches*/
        for(Teaches teaches : teachesList) {
            sqlList.add(teachesSql);
            argList.add(Arrays.asList(teaches.getTeacher_id(), teaches.getCourse_id(), teaches.getSection_id(), teaches.getYear(), teaches.getSemester()));
        }
        return dao.transactionUpdate(sqlList, argList);
    }

    @Override
    public boolean deleteSection(int courseID, int sectionID, int year, String semester) throws SQLException {
        String sql = "DELETE FROM `course_selection_system`.`section`\n" +
                "WHERE course_id = ? AND section_id = ? AND year = ? AND semester = ?;\n";
        return dao.update(sql, courseID, sectionID, year, semester);
    }

    @Override
    public boolean updateSection(Section section) throws SQLException {
        String sql = "UPDATE `course_selection_system`.`section`\n" +
                "SET \n" +
                "`section_capacity` = ?,\n" +
                "`building` = ?,\n" +
                "`room_number` = ?,\n" +
                "WHERE `course_id` = ? AND `section_id` = ? AND `year` = ? AND `semester` = ?;\n";
        return dao.update(sql, section.getSection_capacity(), section.getBuilding(),section.getRoom_number(),
                section.getCourse_id(), section.getSection_id(), section.getYear(), section.getSemester());
    }

    @Override
    public List<CompleteSection> getCriteriaSectionList(CriteriaSection criteriaSection) {
        return null;
    }

    @Override
    public List<CompleteSection> getSectionList() {
        return null;
    }

    @Override
    public int getStudentNum(Section section) {
        return 0;
    }

    @Override
    public List<Section> getConflictSectionList(CompleteSection section) {
        return null;
    }
}
