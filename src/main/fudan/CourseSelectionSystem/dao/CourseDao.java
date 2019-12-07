package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDao {
    public boolean addCourse(Course course) throws SQLException;
    public List<Course> getCourseList();
    public boolean deleteCourse(int courseID) throws SQLException;
    public boolean updateCourse(Course course) throws SQLException;
}
