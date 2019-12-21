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
    public boolean selectCourse(String studentID, int courseID, int sectionID, int year, String semester);
    /* 退课 */
    public boolean dropCourse(String studentID, int courseID, int sectionID, int year, String semester);
    /* 更新课程的成绩 */
    public boolean updateGrade(Takes takes) throws SQLException;
    /* 通过excel表格更新课程成绩 */
    public boolean updateGradeByExcel(String path, int courseID, int sectionID, int year, String semester) throws Exception;
    /* 获取选课信息 */
    public Takes getTakeData(String studentID, int courseID, int sectionID, int year, String semester);
}
