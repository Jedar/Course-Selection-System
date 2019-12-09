package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.Classroom;

import java.sql.SQLException;

public interface ClassroomDao {
    public boolean addClassroom(Classroom classroom) throws SQLException;
    public boolean deleteClassroom(String building, String room_number) throws SQLException;
    public boolean updateClassroom(Classroom classroom) throws SQLException;
    public Classroom getClassroom(String building, String room_number);
}
