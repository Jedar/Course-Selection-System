package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.TeacherDao;
import main.fudan.CourseSelectionSystem.entity.Teacher;

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
    public boolean addTeacher(Teacher teacher) {
        String sql = "insert into teacher (teacher_id, teacher_name, title, school_abbr) values (?,?,?,?)";
        return dao.update(Teacher.class, sql, teacher.getTeacher_id(), teacher.getTeacher_name(), teacher.getTitle(), teacher.getSchool_abbr());
    }

    @Override
    public boolean deleteTeacher(int teacherID) {
//        String sql = "delete from teacher where teacher_id = ?";
        return false;
    }

    @Override
    public boolean updateTeacher(int teacherID) {
        return false;
    }

    @Override
    public List<Teacher> getTeacherList() {
        return null;
    }
}
