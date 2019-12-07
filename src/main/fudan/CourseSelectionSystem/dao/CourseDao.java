package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDao {
    public boolean addCourse(Course course) throws SQLException;
    public boolean deleteCourse(int courseID);
    public boolean updateCourse(Course course);
    public List<Course> getCourseList();
}
