package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.StudentDao;
import main.fudan.CourseSelectionSystem.entity.*;

import java.util.List;

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
    public boolean addStudent(Student student) throws Exception{
        String sql = "insert into student (student_id, student_name, school_abbr) values (?,?,?)";
        return dao.update(sql, student.getStudent_id(), student.getStudent_name(), student.getSchool_abbr());
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

    @Override
    public List<SectionWithGrade> getSectionWithGradeList(int studentID) {
        return null;
    }

    @Override
    public float getGPA(int studentID) {
        return 0;
    }

    @Override
    public List<CompleteSection> getSelectedSectionList(int studentID) {
        return null;
    }

    @Override
    public List<Request> getRequestList(int studentID) {
        return null;
    }
}
