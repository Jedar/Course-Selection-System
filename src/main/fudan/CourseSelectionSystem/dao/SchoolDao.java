package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.School;

import java.sql.SQLException;
import java.util.List;

public interface SchoolDao {
    public boolean addSchool(School school) throws SQLException;
    public boolean updateSchool(School school) throws SQLException;
    public List<School> getSchoolList();
    public boolean deleteSchool(String abbr);
}
