package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.Profile;
import main.fudan.CourseSelectionSystem.entity.Teacher;

import java.util.List;

public interface TeacherDao {
    public boolean addTeacher(Teacher teacher);
    /* 插入教师的数据并且初始化老师用户基本信息 */
    public boolean addTeacherWithProfile(Teacher teacher, Profile profile);
    public boolean deleteTeacher(int teacherID);
    public boolean updateTeacher(int teacherID);
    public List<Teacher> getTeacherList();
}
