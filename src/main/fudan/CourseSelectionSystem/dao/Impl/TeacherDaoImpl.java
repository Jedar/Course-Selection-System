package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.TeacherDao;
import main.fudan.CourseSelectionSystem.entity.*;
import main.fudan.CourseSelectionSystem.entity.Profile;
import main.fudan.CourseSelectionSystem.entity.Teacher;
import main.fudan.CourseSelectionSystem.util.Utils;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName TeacherDaoImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 20:23
 * @Version 1.0
 **/
public class TeacherDaoImpl implements TeacherDao {
    private BaseDao<Teacher> dao = new JDBCDao<>();
    private BaseDao<Section> sectionBaseDao = new JDBCDao<>();

    @Override
    public boolean addTeacher(Teacher teacher) throws SQLException {
        String sql = "insert into teacher (teacher_id, teacher_name, title, school_abbr) values (?,?,?,?)";
        return dao.update(sql, teacher.getTeacher_id(), teacher.getTeacher_name(), teacher.getTitle(), teacher.getSchool_abbr());
    }

    @Override
    public boolean addTeacherWithProfile(Teacher teacher, Profile profile) throws SQLException {
        String teacherSql = "INSERT INTO `course_selection_system`.`teacher`\n" +
                "(`teacher_id`,\n" +
                "`teacher_name`,\n" +
                "`title`,\n" +
                "`school_abbr`)\n" +
                "VALUES\n" +
                "(?,?,?,?);";
        String profileSql = "INSERT INTO `course_selection_system`.`profile`\n" +
                "(`profile_id`,\n" +
                "`password`,\n" +
                "`permission`)\n" +
                "VALUES\n" +
                "(?,?,?);\n";
        List<String> sqlList = new LinkedList<>();
        List<List<Object>> argList = new LinkedList<>();

        sqlList.add(profileSql);
        argList.add(Arrays.asList(profile.getProfile_id(),profile.getPassword(),profile.getPermission()));
        System.out.println(profile);

        sqlList.add(teacherSql);
        argList.add(Arrays.asList(teacher.getTeacher_id(),teacher.getTeacher_name(),teacher.getTitle(),teacher.getSchool_abbr()));

        return dao.transactionUpdate(sqlList,argList);
    }

    @Override
    public boolean deleteTeacher(int teacherID) throws SQLException {
        String sql = "delete from teacher where teacher_id = ?";
        return dao.update(sql,teacherID);
    }

    @Override
    public boolean updateTeacher(Teacher teacher) throws SQLException {
        String sql = "UPDATE `course_selection_system`.`teacher`\n" +
                "SET\n" +
                "`teacher_name` = ?,\n" +
                "`title` = ?,\n" +
                "`school_abbr` = ?\n" +
                "WHERE `teacher_id` = ?;\n";
        return dao.update(sql,teacher.getTeacher_name(),teacher.getTitle(),teacher.getSchool_abbr(),teacher.getTeacher_id());
    }

    @Override
    public List<Teacher> getTeacherList() {
        String sql = "SELECT `teacher`.`teacher_id`,\n" +
                "    `teacher`.`teacher_name`,\n" +
                "    `teacher`.`title`,\n" +
                "    `teacher`.`school_abbr`\n" +
                "FROM `course_selection_system`.`teacher`;\n";
        return dao.getForList(Teacher.class, sql);
    }

    @Override
    public List<Section> getTimeConflictSections(CompleteSection section, String teacherID) {
        List<TimeSlot> timeSlotList = Utils.getTimeSlotListByString(section.getCourse_time());
        List<Section> sections = new ArrayList<>();
        String sql = "SELECT secs.course_id,secs.section_id,secs.year,secs.section_capacity,secs.building,secs.room_number,secs.semester,secs.time_slot_id \n" +
                "                FROM (\n" +
                "                   SELECT * FROM (SELECT * FROM teaches as t natural join section as s WHERE t.teacher_id = ?) as temp natural join time_slot as ts \n" +
                "                   WHERE temp.time_slot_id = ts.time_slot_id\n" +
                "                   ) as secs \n" +
                "WHERE secs.day = ? AND ? >= secs.start_time AND ? <= secs.end_time;";
        for (TimeSlot timeSlot : timeSlotList){
            List<Section> res = sectionBaseDao.getForList(Section.class,sql, teacherID, timeSlot.getDay(), timeSlot.getEnd_time(), timeSlot.getStart_time());
            sections.addAll(res);
        }
        return sections;

    }

    @Override
    public List<Student> getStudentOf(Teaches teaches) {
        return null;
    }

    @Override
    public List<Request> getRequestList(String teacherID, int year, String semester) {
        return null;
    }


}
