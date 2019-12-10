package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.*;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    public boolean addStudent(Student student) throws Exception;
    public boolean addStudentWithProfile(Student student, Profile profile) throws SQLException;
    public boolean deleteStudent(String studentID);
    public boolean updateStudent(String studentID);
    public Student getStudentByID(String studentID);
    public List<Student> getStudents();
    public Student getStudentsBySection(Section section);
    public List<SectionWithGrade> getSectionWithGradeList(String studentID);
    public double getGPA(String studentID);
    public List<CompleteSection> getSelectedSectionList(String studentID);
}
