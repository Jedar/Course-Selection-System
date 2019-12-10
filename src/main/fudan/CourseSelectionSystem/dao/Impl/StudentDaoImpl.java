package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.StudentDao;
import main.fudan.CourseSelectionSystem.entity.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName StudentDaoImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 20:12
 * @Version 1.0
 **/
public class StudentDaoImpl implements StudentDao {
    private BaseDao<Student> studentDao = new JDBCDao<>();
    private BaseDao<SectionWithGrade> sectionWithGradeDao = new JDBCDao<>();

    @Override
    public boolean addStudent(Student student) throws Exception{
        String sql = "insert into student (student_id, student_name, school_abbr) values (?,?,?)";
        return studentDao.update(sql, student.getStudent_id(), student.getStudent_name(), student.getSchool_abbr());
    }

    @Override
    public boolean addStudentWithProfile(Student student, Profile profile) throws SQLException {
        String sql = "insert into student (student_id, student_name, school_abbr) values (?,?,?)";
        String profileSql = "INSERT INTO `course_selection_system`.`profile`\n" +
                "(`profile_id`,\n" +
                "`password`,\n" +
                "`permission`)\n" +
                "VALUES\n" +
                "(?,MD5(?),?);\n";
        List<String> sqlList = new LinkedList<>();
        List<List<Object>> argList = new LinkedList<>();

        sqlList.add(profileSql);
        argList.add(Arrays.asList(profile.getProfile_id(),profile.getPassword(),profile.getPermission()));
//        System.out.println(profile);

        sqlList.add(sql);
        argList.add(Arrays.asList(student.getStudent_id(),student.getStudent_name(),student.getSchool_abbr()));

        return studentDao.transactionUpdate(sqlList,argList);
    }

    @Override
    public boolean deleteStudent(String studentID) {
        return false;
    }

    @Override
    public boolean updateStudent(String studentID) {
        return false;
    }

    @Override
    public Student getStudentByID(String studentID) {
        return null;
    }

    @Override
    public List<Student> getStudents() {
        String sql = "SELECT `student`.`student_id`,\n" +
                "    `student`.`student_name`,\n" +
                "    `student`.`school_abbr`\n" +
                "FROM `course_selection_system`.`student`;\n";
        return studentDao.getForList(Student.class, sql);
    }

    @Override
    public Student getStudentsBySection(Section section) {
        return null;
    }

    @Override
    public List<SectionWithGrade> getSectionWithGradeList(String studentID) {
        String sql = "select course_id, section_id, year, semester, course_name, credits, level " +
                     "from takes natural join course " +
                     "where student_id = ?";
        return sectionWithGradeDao.getForList(SectionWithGrade.class, sql, studentID);
    }

    @Override
    public double getGPA(String studentID) {
        String sql = "select sum(grade * credits) / sum(credits) " +
                "from takes natural join level_to_grade natural join course " +
                "where student_id = ?";
        return studentDao.getForValue(sql, studentID);
    }

    @Override
    public List<CompleteSection> getSelectedSectionList(String studentID) { //Todo
        String sql = "";
        return null;
    }


}
