package main.fudan.CourseSelectionSystem.service;

public interface ProfileService {
    public boolean login(String id, String password);

    public String getPermission(String id);
}
