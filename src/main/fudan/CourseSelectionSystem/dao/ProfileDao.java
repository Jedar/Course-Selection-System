package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.Profile;

import java.sql.SQLException;

public interface ProfileDao {
    public boolean addProfile(Profile profile) throws SQLException;

    public Profile getProfile(String ID);

    public boolean checkExist(String ID, String passwd);
}
