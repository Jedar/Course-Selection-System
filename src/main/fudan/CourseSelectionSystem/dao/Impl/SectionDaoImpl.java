package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.SectionDao;
import main.fudan.CourseSelectionSystem.entity.*;
import main.fudan.CourseSelectionSystem.util.Utils;

import java.lang.reflect.Array;
import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

/**
 * @ClassName SectionDaoImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 19:32
 * @Version 1.0
 **/
public class SectionDaoImpl implements SectionDao {
    private BaseDao<Section> dao = new JDBCDao<>();
    private BaseDao<CompleteSection> completeSectionBaseDao = new JDBCDao<>();

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
                "`room_number` = ?\n" +
                "WHERE `course_id` = ? AND `section_id` = ? AND `year` = ? AND `semester` = ?\n";
        return dao.update(sql, section.getSection_capacity(), section.getBuilding(),section.getRoom_number(),
                section.getCourse_id(), section.getSection_id(), section.getYear(), section.getSemester());
    }

    @Override
    public List<CompleteSection> getCriteriaSectionList(CriteriaSection criteriaSection) {
        String sql = "SELECT course_id, section_id, year, semester,exam_date, exam_type, exam_building, exam_room_number, exam_time,\n" +
                "teachers, course_time, section_capacity, course_name, credits, credit_hours, school_abbr, building, room_number, current_student_num\n" +
                "FROM (\n" +
                "\t(select * from section where course_id like ? and section_id like ?) as section_t JOIN (\n" +
                "\t\tSELECT time_slot_id, group_concat(item separator ' ') AS course_time FROM (\n" +
                "\t\t\tSELECT time_slot_id, CONCAT_WS(',',day,CONCAT_WS('-',start_time,end_time)) AS item FROM time_slot\n" +
                "\t\t) AS temp GROUP BY time_slot_id\n" +
                "\t) AS slots on section_t.time_slot_id = slots.time_slot_id\n" +
                "\tNATURAL JOIN (select * from course where course_name like ?) as course_t\n" +
                "\tNATURAL JOIN (\n" +
                "\t\tSELECT course_id, section_id, year, semester, group_concat(teacher_name separator ',') AS teachers FROM \n" +
                "\t\tteacher natural join teaches GROUP BY course_id, section_id, year, semester\n" +
                "\t) AS teacher_t\n" +
                "\tNATURAL JOIN (\n" +
                "\t\tSELECT course_id, section_id, year, semester,exam_date, exam_type, exam_building, exam_room_number, \n" +
                "\t\tCONCAT_WS(',',day,CONCAT_WS('-',start_time,end_time)) AS exam_time \n" +
                "\t\tFROM exam join time_slot ON exam.exam_time_slot_id = time_slot.time_slot_id\n" +
                "\t) AS exam_slot_t\n" +
                "\tNATURAL JOIN (\n" +
                "\t\tSELECT course_id, section_id, year, semester, COUNT(student_id) AS current_student_num\n" +
                "\t\tFROM (\n" +
                "\t\t\tSELECT * FROM takes WHERE drop_flag = false OR drop_flag IS NULL  \n" +
                "        ) AS takes_t  NATURAL RIGHT JOIN section\n" +
                "\t\tGROUP BY course_id, section_id, year, semester\n" +
                "\t) AS student_num_t\n" +
                ")";
        return completeSectionBaseDao.getForList(CompleteSection.class, sql, criteriaSection.getCourseID(), criteriaSection.getSectionID(), criteriaSection.getName());
    }

    @Override
    public List<CompleteSection> getSectionList() {
        return getCriteriaSectionList(new CriteriaSection());
    }

    @Override
    public int getStudentNum(Section section) throws Exception {
        String sql = "SELECT course_id, section_id, year, semester, COUNT(student_id) AS current_student_num\n" +
                "FROM takes NATURAL RIGHT JOIN (\n" +
                "   SELECT * FROM section WHERE course_id=? AND section_id=? AND year=? AND semester=? \n" +
                ") AS sec_t GROUP BY course_id, section_id, year, semester";
        List<CompleteSection> list = completeSectionBaseDao.getForList(CompleteSection.class, sql,
                section.getCourse_id(),section.getSection_id(), section.getYear(), section.getSemester());
        /* 错误查询 */
        if (list.size() != 1){
            throw new Exception("section information error");
        }
        return list.get(0).getCurrent_student_num();
    }

    @Override
    public List<Section> getCourseConflictSectionList(CompleteSection section) {
        String sql = "SELECT distinct course_id, section_id, year, semester, building, room_number\n" +
                "FROM section JOIN time_slot ON section.time_slot_id = time_slot.time_slot_id\n" +
                "WHERE (building = ? AND room_number = ? AND day = ? AND ? <= end_time AND ? >= start_time)\n";
        List<TimeSlot> slots = Utils.getTimeSlotListByString(section.getCourse_time());
        List<Section> sections = new ArrayList<>();
        TimeSlot exam = Utils.getTimeSlotByString(section.getExam_time());
        for (TimeSlot ts: slots){
            sections.addAll(dao.getForList(Section.class, sql, section.getBuilding(), section.getRoom_number(),
                    ts.getDay(), ts.getStart_time(), ts.getEnd_time()));
        }
        return sections;
    }

    @Override
    public List<Section> getExamConflictSectionList(CompleteSection section) {
        String sql = "SELECT distinct course_id, section_id, year, semester, building, room_number\n" +
                "FROM section \n" +
                "NATURAL JOIN (\n" +
                "\tSELECT course_id, section_id, year, semester,exam_building,exam_room_number,day AS exam_day, start_time AS exam_start, end_time AS exam_end \n" +
                "    FROM exam JOIN time_slot ON exam.exam_time_slot_id = time_slot.time_slot_id\n" +
                ") AS exam_t\n" +
                "WHERE exam_building = ? AND exam_room_number = ? AND exam_day = ? AND ? <= exam_end AND ? >= exam_start";
        List<Section> sections = new ArrayList<>();
        TimeSlot exam = Utils.getTimeSlotByString(section.getExam_time());
        sections.addAll(dao.getForList(Section.class, sql,
                section.getExam_building(), section.getExam_room_number(),
                exam.getDay(),exam.getStart_time(),exam.getEnd_time()));
        return sections;
    }

    @Override
    public Section getSection(int courseID, int sectionID, int year, String semester) {
        String sql = "select * from section where course_id = ? and section_id = ? and year = ? and semester = ?";
        return dao.get(Section.class, sql, courseID, sectionID, year, semester);
    }

    public List<Section> getConflictSectionList(CompleteSection section) {
        String sql = "SELECT distinct course_id, section_id, year, semester, building, room_number\n" +
                "FROM section JOIN time_slot ON section.time_slot_id = time_slot.time_slot_id\n" +
                "NATURAL JOIN (\n" +
                "   SELECT course_id, section_id, year, semester,exam_building,exam_room_number,day AS exam_day, start_time AS exam_start, end_time AS exam_end \n" +
                "    FROM exam JOIN time_slot ON exam.exam_time_slot_id = time_slot.time_slot_id\n" +
                ") AS exam_t\n" +
                "WHERE (building = ? AND room_number = ? AND day = ? AND ? <= end_time AND ? >= start_time)\n" +
                "OR (exam_building = ? AND exam_room_number = ? AND exam_day = ? AND ? <= exam_end AND ? >= exam_start)";
        List<TimeSlot> slots = Utils.getTimeSlotListByString(section.getCourse_time());
        List<Section> sections = new ArrayList<>();
        TimeSlot exam = Utils.getTimeSlotByString(section.getExam_time());
        for (TimeSlot ts: slots){
            sections.addAll(dao.getForList(Section.class, sql, section.getBuilding(), section.getRoom_number(),
                    ts.getDay(), ts.getStart_time(), ts.getEnd_time(),
                    section.getExam_building(), section.getExam_room_number(),
                    exam.getDay(),exam.getStart_time(),exam.getEnd_time()));
        }
        return null;
    }
}
