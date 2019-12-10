package main.fudan.CourseSelectionSystem.service;

import main.fudan.CourseSelectionSystem.entity.Takes;
import main.fudan.CourseSelectionSystem.entity.Teaches;

import java.sql.SQLException;

public interface TakeCourseService {

    public boolean updateGrade(Takes takes) throws SQLException;

    public boolean updateGradeByExcel(String path, int courseID, int sectionID, int year, String semester) throws Exception;

    public Takes getTakeData(String studentID, int courseID, int sectionID, int year, String semester);
}
