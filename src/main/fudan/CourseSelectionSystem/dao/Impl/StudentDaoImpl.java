package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.StudentDao;
import main.fudan.CourseSelectionSystem.entity.Section;
import main.fudan.CourseSelectionSystem.entity.Student;

/**
 * @ClassName StudentDaoImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 20:12
 * @Version 1.0
 **/
public class StudentDaoImpl implements StudentDao {
    private BaseDao<Student> dao = new JDBCDao<>();

    @Override
    public boolean addStudent(Student student) {
        String sql = "insert into student (student_id, student_name, school_abbr) values (?,?,?)";
        return dao.update(Student.class, sql, student.getStudent_id(), student.getStudent_name(), student.getSchool_abbr());
    }

    @Override
    public boolean deleteStudent(int studentID) {
        return false;
    }

    @Override
    public boolean updateStudent(int studentID) {
        return false;
    }

    @Override
    public Student getStudentByID(int studentID) {
        return null;
    }

    @Override
    public Student getStudentsBySection(Section section) {
        return null;
    }
}
