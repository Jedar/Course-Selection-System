package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    /* 加入新的学生数据 */
    public boolean addStudent(Student student) throws Exception;
    /* 加入学生数据的同时初始化学生信息 */
    public boolean addStudentWithProfile(Student student, Profile profile) throws SQLException;
    /* 删除学生信息 */
    public boolean deleteStudent(String studentID);
    /* 更新学生信息 */
    public boolean updateStudent(String studentID);
    /* 根据ID获取学生信息 */
    public Student getStudentByID(String studentID);
    /* 获取所有学生列表 */
    public List<Student> getStudents();
    /* 获取上某门课的所有学生列表 */
    public Student getStudentsBySection(Section section);
    /* 获取某个学生的基本信息包括成绩 */
    public List<SectionWithGrade> getSectionWithGradeList(String studentID);
    /* 获取学生的成绩 */
    public Double getGPA(String studentID);
    /* 获取总学分 */
    public Integer getTotalCredit(String studentID);
    /* 获取学生选的所有课程 */
    public List<CompleteSection> getSelectedSectionList(String studentID);
}
