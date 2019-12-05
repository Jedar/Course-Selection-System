package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.*;

import java.util.List;

public interface StudentDao {
    public boolean addStudent(Student student) throws Exception;
    public boolean deleteStudent(int studentID);
    public boolean updateStudent(int studentID);
    public Student getStudentByID(int studentID);
    public Student getStudentsBySection(Section section);
    public List<SectionWithGrade> getSectionWithGradeList(int studentID);
    public float getGPA(int studentID);
    public List<CompleteSection> getSelectedSectionList(int studentID);

    /*查看我的申请列表*/
    public List<Request> getRequestList(int studentID);
}
