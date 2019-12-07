package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.CourseDao;
import main.fudan.CourseSelectionSystem.entity.Course;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName CourseDaoImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 20:30
 * @Version 1.0
 **/
public class CourseDaoImpl implements CourseDao {
    private BaseDao<Course> dao = new JDBCDao<>();

    public CourseDaoImpl() {
        super();
    }

    @Override
    public boolean addCourse(Course course) throws SQLException{
        String sql = "insert into course (course_id, course_name, credits, credit_hours, school_abbr) values (?,?,?,?,?)";
        return dao.update(sql, course.getCourse_id(), course.getCourse_name(), course.getCredits(), course.getCredit_hours(), course.getSchool_abbr());
    }

    @Override
    public boolean deleteCourse(int courseID) throws SQLException {
        String sql = "DELETE FROM `course_selection_system`.`course`\n" +
                "WHERE course_id = ?";
        return dao.update(sql, courseID);
    }

    @Override
    public boolean updateCourse(Course course) throws SQLException {
        String sql = "UPDATE `course_selection_system`.`course`\n" +
                "SET\n" +
                "`course_name` = ?,\n" +
                "`credits` = ?,\n" +
                "`credit_hours` = ?,\n" +
                "`school_abbr` = ?\n" +
                "WHERE `course_id` = ?;\n";
        return dao.update(sql, course.getCourse_name(), course.getCredits(), course.getCredit_hours(), course.getSchool_abbr(), course.getCourse_id());
    }

    public List<Course> getCourseList() {
        String sql = "SELECT `course`.`course_id`,\n" +
                "    `course`.`course_name`,\n" +
                "    `course`.`credits`,\n" +
                "    `course`.`credit_hours`,\n" +
                "    `course`.`school_abbr`\n" +
                "FROM `course_selection_system`.`course`";
        return dao.getForList(Course.class, sql);
    }
}
