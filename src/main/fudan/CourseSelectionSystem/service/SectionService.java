package main.fudan.CourseSelectionSystem.service;

import main.fudan.CourseSelectionSystem.entity.*;


import main.fudan.CourseSelectionSystem.entity.Section;

import java.sql.SQLException;
import java.util.List;

public interface SectionService {
    /* 插入Section数据 */
    public boolean insertSection(Section section);
    /* 根据excel表格插入数据 */
    public boolean insertSectionsByExcel(String path) throws Exception;
    /* 搜索课程 */
    public List<CompleteSection> searchSections(CriteriaSection criteriaSection);
    /* 查看课表 */
    public List<CompleteSection> getCourseListOfStudent(String studentID);
    /* 查看学生课程成绩 */
    public List<SectionWithGrade> getSectionWithGradeList(String studentID);
    /* 删除课程功能 */
    public boolean deleteSection(Section section) throws SQLException;
    /* 获取所有课程列表 */
    public List<CompleteSection> getCourseList();

}
