package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.School;

public interface SchoolDao {
    public boolean addSchool(School school);
    public boolean deleteSchool(String abbr);
}
