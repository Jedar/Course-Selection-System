package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.Request;

import java.util.List;

public interface RequestDao {
    public boolean addRequest(Request request);
    public boolean deleteRequest(int studentID, int courseID, int sectionID, int year, String semester);
    public boolean updateRequest(Request request);
    public List<Request> getRequestListBySection(int courseID, int sectionID, int year, String semester);
    public List<Request> getRequestListByStudent(int studentID);
}
