package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.Teacher;

import java.util.List;

public interface TeacherDao {
    public boolean addTeacher(Teacher teacher);
    public boolean deleteTeacher(int teacherID);
    public boolean updateTeacher(int teacherID);
    public List<Teacher> getTeacherList();
}
