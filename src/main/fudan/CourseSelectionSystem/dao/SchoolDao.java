package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.School;

import java.sql.SQLException;

public interface SchoolDao {
    public boolean addSchool(School school) throws SQLException;
    public boolean deleteSchool(String abbr);
}
