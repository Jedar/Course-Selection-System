package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.TeacherDao;
import main.fudan.CourseSelectionSystem.entity.*;
import main.fudan.CourseSelectionSystem.entity.Profile;
import main.fudan.CourseSelectionSystem.entity.Teacher;

import java.sql.SQLException;
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

    @Override
    public boolean addTeacher(Teacher teacher) throws SQLException {
        String sql = "insert into teacher (teacher_id, teacher_name, title, school_abbr) values (?,?,?,?)";
        return dao.update(sql, teacher.getTeacher_id(), teacher.getTeacher_name(), teacher.getTitle(), teacher.getSchool_abbr());
    }

    @Override
    public boolean addTeacherWithProfile(Teacher teacher, Profile profile) {
        return false;
    }

    @Override
    public boolean deleteTeacher(int teacherID) {
//        String sql = "delete from teacher where teacher_id = ?";
        return false;
    }

    @Override
    public boolean updateTeacher(int teacherID) throws SQLException {
        return false;
    }

    @Override
    public List<Teacher> getTeacherList() {
        return null;
    }

    @Override
    public List<Section> getTimeConflictSections(CompleteSection section, String teacherID) {
        return null;
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
