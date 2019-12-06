package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.LevelToGrade;

import java.sql.SQLException;

public interface LevelToGradeDao {
    public boolean addLevelToGrade(LevelToGrade levelToGrade) throws SQLException;
    public boolean updateLevelToGrade(LevelToGrade levelToGrade) throws SQLException;
}
