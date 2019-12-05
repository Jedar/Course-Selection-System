package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.Course;

import java.util.List;

public interface CourseDao {
    public boolean addCourse(Course course);
    public boolean deleteCourse(int courseID);
    public boolean updateCourse(int courseID);
    public List<CourseDao> getCourseList();
}
