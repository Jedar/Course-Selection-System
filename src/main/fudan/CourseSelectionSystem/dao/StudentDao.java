package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.Section;
import main.fudan.CourseSelectionSystem.entity.Student;

public interface StudentDao {
    public boolean addStudent(Student student);
    public boolean deleteStudent(int studentID);
    public boolean updateStudent(int studentID);
    public Student getStudentByID(int studentID);
    public Student getStudentsBySection(Section section);
}
