package main.fudan.CourseSelectionSystem.service;

import main.fudan.CourseSelectionSystem.dao.DaoFactory;
import main.fudan.CourseSelectionSystem.dao.TakesDao;
import main.fudan.CourseSelectionSystem.entity.Takes;

import java.sql.Date;
import java.sql.SQLException;
import main.fudan.CourseSelectionSystem.entity.Takes;
import main.fudan.CourseSelectionSystem.entity.Teaches;

public interface TakeCourseService {
    /* 选课 */
    public boolean selectCourse(String studentID, int courseID, int sectionID, Date year, String semester);

    /* 退课 */
    public boolean dropCourse(String studentID, int courseID, int sectionID, Date year, String semester);

    public boolean updateGrade(Takes takes) throws SQLException;

    public boolean updateGradeByExcel(String path, int courseID, int sectionID, Date year, String semester) throws Exception;

    public Takes getTakeData(String studentID, int courseID, int sectionID, Date year, String semester);
}
