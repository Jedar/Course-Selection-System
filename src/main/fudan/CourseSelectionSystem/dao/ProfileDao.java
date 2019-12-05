package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.Profile;

public interface ProfileDao {
    public boolean addProfile(Profile profile);

    public Profile getProfile(String ID);

    public boolean checkExist(String ID, String passwd);
}
