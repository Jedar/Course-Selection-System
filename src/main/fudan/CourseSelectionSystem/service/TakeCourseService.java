package main.fudan.CourseSelectionSystem.service;

import main.fudan.CourseSelectionSystem.dao.DaoFactory;
import main.fudan.CourseSelectionSystem.dao.TakesDao;

public interface TakeCourseService {
    /* 选课 */
    public boolean selectCourse(String studentID, int courseID, int sectionID, int year, String semester);

    /* 退课 */
    public boolean dropCourse(String studentID, int courseID, int sectionID, int year, String semester);
}
