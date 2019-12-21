package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.*;
import main.fudan.CourseSelectionSystem.entity.Profile;
import main.fudan.CourseSelectionSystem.entity.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDao {
    /* 加入一条教师数据 */
    public boolean addTeacher(Teacher teacher) throws SQLException;
    /* 插入教师的数据并且初始化老师用户基本信息 */
    public boolean addTeacherWithProfile(Teacher teacher, Profile profile) throws SQLException;
    /* 删除一条教师信息 */
    public boolean deleteTeacher(int teacherID) throws SQLException;
    /* 更新教师信息 */
    public boolean updateTeacher(Teacher teacher) throws SQLException;
    /* 获取所有的教师列表 */
    public List<Teacher> getTeacherList();
    /*得到上课时间冲突的课程*/
    public List<Section> getTimeConflictSections(CompleteSection section, String teacherID);
    /*查看选课名单*/
    public List<Student> getStudentOf(Teaches teaches);
    /*查看选课事务申请列表*/
    public List<Request> getRequestList(String teacherID, int year, String semester);
}
