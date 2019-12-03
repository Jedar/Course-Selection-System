package main.fudan.CourseSelectionSystem.dao;

import java.util.List;

public interface CourseDao {
    public boolean addCourse(CourseDao course);
    public boolean deleteCourse(int courseID);
    public boolean updateCourse(int courseID);
    public List<CourseDao> getCourseList();
}
