package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.Classroom;

public interface ClassroomDao {
    public boolean addClassroom(Classroom classroom);
    public boolean deleteClassroom(String building, String room_number);
}
