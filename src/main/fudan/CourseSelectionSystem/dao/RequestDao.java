package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.Request;

import java.sql.SQLException;
import java.util.List;

public interface RequestDao {
    public boolean addRequest(Request request) throws SQLException;
    public boolean deleteRequest(String studentID, int courseID, int sectionID, int year, String semester) throws SQLException;
    public boolean updateRequest(Request request) throws SQLException;
    public List<Request> getRequestListBySection(int courseID, int sectionID, int year, String semester);
    public List<Request> getRequestListByStudent(String studentID);
}
