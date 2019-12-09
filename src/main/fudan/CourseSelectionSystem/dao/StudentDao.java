package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.*;

import java.util.List;

public interface StudentDao {
    public boolean addStudent(Student student) throws Exception;
    public boolean deleteStudent(String studentID);
    public boolean updateStudent(String studentID);
    public Student getStudentByID(String studentID);
    public Student getStudentsBySection(Section section);
    public List<SectionWithGrade> getSectionWithGradeList(String studentID);
    public double getGPA(String studentID);
    public List<CompleteSection> getSelectedSectionList(String studentID);
}
