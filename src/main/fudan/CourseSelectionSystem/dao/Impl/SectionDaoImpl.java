package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.SectionDao;
import main.fudan.CourseSelectionSystem.entity.*;

import java.lang.reflect.Array;
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
    public boolean addSection(Section section, Exam exam, List<TimeSlot> classTimeSlots, TimeSlot examTimeSlot, List<Teaches> teachesList) throws Exception{
        String timeSlotsSql = "insert into time_slot (time_slot_id, day, start_time, end_time) values (?, ?, ?, ?)";
        String sectionSql = "insert into section (course_id, section_id, year, semester, section_capacity, building, room_number, time_slot_id) values (?,?,?,?,?,?,?,?)";
        String teachesSql = "insert into teaches (teacher_id, course_id, section_id, year, semester)";
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
        argList.add(Arrays.asList(section.getCourse_id(), section.getSection_id(), section.getYear(), section.getSemester(), section.getSection_capacity(), section.getBuilding(), section.getRoom_number(), section.getTime_slot_id()));

        /*插入teaches*/
        for(Teaches teaches : teachesList) {
            sqlList.add(teachesSql);
            argList.add(Arrays.asList(teaches.getTeacher_id(), teaches.getCourse_id(), teaches.getSection_id(), teaches.getYear(), teaches.getSemester()));
        }
        return dao.transactionUpdate(sqlList, argList);
    }

    @Override
    public boolean deleteSection(int courseID, int sectionID, int year, String semester) {
        return false;
    }

    @Override
    public boolean updateSection(Section section) {
        return false;
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
