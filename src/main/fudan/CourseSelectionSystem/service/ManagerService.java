package main.fudan.CourseSelectionSystem.service;

import main.fudan.CourseSelectionSystem.entity.Manager;

public interface ManagerService {
    public boolean insertManager(Manager manager);

    public boolean insertManagerByExcel(String path) throws Exception;
}
