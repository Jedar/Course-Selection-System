package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.Manager;
import main.fudan.CourseSelectionSystem.entity.Profile;

public interface ManagerDao {
    public boolean addManager(Manager manager, Profile profile);

    public Manager getManager(String id);
}
