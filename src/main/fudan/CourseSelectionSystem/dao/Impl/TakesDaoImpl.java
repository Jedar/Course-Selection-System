package main.fudan.CourseSelectionSystem.dao.Impl;
import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.TakesDao;
import main.fudan.CourseSelectionSystem.entity.Section;
import main.fudan.CourseSelectionSystem.entity.Takes;
import main.fudan.CourseSelectionSystem.entity.TimeSlot;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName TakesDaoImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 20:12
 * @Version 1.0
 **/
public class TakesDaoImpl implements TakesDao {
    BaseDao<Takes> dao = new JDBCDao<>();

    @Override
    public Takes getTakes(int studentID, int courseID, int sectionID, int year, String semester) {
        return null;
    }

    @Override
    public boolean updateTakes(Takes takes) {
        return false;
    }

    @Override
    public boolean addTakes(Takes takes) throws SQLException {
        String sql = "insert into takes (student_id, course_id, section_id, year, semester) values (?,?,?,?,?)";
        return dao.update(sql, takes.getStudent_id(), takes.getCourse_id(), takes.getSection_id(), takes.getYear(), takes.getSemester());
    }

    @Override
    public boolean dropSection(int studentID, int courseID, int sectionID, int year, String semester) throws SQLException{
        String sql = "update takes " +
                     "set drop_flag = ? " +
                     "where (student_id, course_id, section_id, year, semester) = (?, ?, ?, ?, ?)";
        return dao.update(sql, true, studentID, courseID, sectionID, year, semester);
    }

    @Override
    public List<Section> getTimeConflictSectionList(int studentID, int courseID, int sectionID, int year, String semester) {
        String timeSlotSql = "select time_slot_id, day, start_time, end_time " +
                "from section natural time_slot " +
                "where (course_id, section_id, year, semester) = (?, ?, ?, ?)";
        BaseDao<TimeSlot> timeSlotDao = new JDBCDao<>();
        List<TimeSlot> timeSlotList = timeSlotDao.getForList(TimeSlot.class, timeSlotSql, courseID, sectionID, year, semester);
        BaseDao<Section> sectionDao = new JDBCDao<>();
        List<Section> sectionList = new LinkedList<>();
        String sectionSql = "select distinct course_id, section_id, year, semester, section_capacity, building, room_number, time_slot_id " +
                "from takes natural join section natural time_slot " +
                "where (student_id, day) = (?, ?) and (start_time between (?, ?) or ? between (start_time, end_time))";
        for(TimeSlot timeSlot : timeSlotList) {
            sectionList.addAll(sectionDao.getForList(Section.class, sectionSql, studentID, timeSlot.getDay(), timeSlot.getStart_time(), timeSlot.getEnd_time(), timeSlot.getStart_time()));
        }
        return sectionList;
    }

    @Override
    public List<Section> getExamConflictSectionList(int studentID, int courseID, int sectionID, int year, String semester) {
        String timeSlotIDSql = "select time_slot_id" +
                "from section natural exam " +
                "where (course_id, section_id, year, semester) = (?, ?, ?, ?)";
        int examTimeSlotID = dao.getForValue(timeSlotIDSql, courseID, sectionID, year, semester);
        String timeSlotSql = "select time_slot_id, day, start_time, end_time " +
                "from time_slot " +
                "where time_slot_id = ?";
        BaseDao<TimeSlot> timeSlotDao = new JDBCDao<>();
        List<TimeSlot> timeSlotList = timeSlotDao.getForList(TimeSlot.class, timeSlotSql, examTimeSlotID);
        BaseDao<Section> sectionDao = new JDBCDao<>();
        List<Section> sectionList = new LinkedList<>();
        String sectionSql = "select distinct course_id, section_id, year, semester, section_capacity, building, room_number, time_slot_id " +
                "from takes natural join section natural time_slot " +
                "where (student_id, day) = (?, ?) and (start_time between (?, ?) or ? between (start_time, end_time))";
        for(TimeSlot timeSlot : timeSlotList) {
            sectionList.addAll(sectionDao.getForList(Section.class, sectionSql, studentID, timeSlot.getDay(), timeSlot.getStart_time(), timeSlot.getEnd_time(), timeSlot.getStart_time()));
        }
        return null;
    }
}
