package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.Section;
import main.fudan.CourseSelectionSystem.entity.Takes;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface TakesDao {
    /* 得到选课信息 */
    public Takes getTakes(String studentID, int courseID, int sectionID, int year, String semester);
    /* 更新选课信息（例如更新成绩） */
    public boolean updateTakes(Takes takes) throws SQLException;
    /* 加入选课条目 */
    public boolean addTakes(Takes takes) throws SQLException;
    /* 退课 */
    public boolean dropSection(String studentID, int courseID, int sectionID, int year, String semester) throws SQLException;
    /*得到上课时间冲突列表*/
    public List<Section> getTimeConflictSectionList(String studentID, int courseID, int sectionID, int year, String semester);
    /*得到考试时间冲突列表*/
    public List<Section> getExamConflictSectionList(String studentID, int courseID, int sectionID, int year, String semester);
}
