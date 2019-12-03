package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.Takes;

import java.util.List;

public interface TakesDao {
    public boolean updateTakes(Takes takes);
    public boolean addTakes(Takes takes);
    public boolean dropSection(int studentID, int courseID, int sectionID, int year, String semester);
    public List<Takes> getTakesListByStudent(int StudentID);
}
