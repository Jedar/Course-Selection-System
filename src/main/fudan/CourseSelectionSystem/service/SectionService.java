package main.fudan.CourseSelectionSystem.service;

import main.fudan.CourseSelectionSystem.entity.CompleteSection;
import main.fudan.CourseSelectionSystem.entity.CriteriaSection;
import main.fudan.CourseSelectionSystem.entity.Section;


import main.fudan.CourseSelectionSystem.entity.Section;

import java.sql.SQLException;
import java.util.List;

public interface SectionService {
    /* 插入当个Section */
    public boolean insertSection(Section section);

    /* 根据excel表格插入数据 */
    public boolean insertSectionsByExcel(String path) throws Exception;

    /* 搜索课程 */
    public List<CompleteSection> searchSections(CriteriaSection criteriaSection);

    /* 查看课表 */
    public List<CompleteSection> getCourseListOfStudent(String studentID);

    public boolean deleteSection(Section section) throws SQLException;

    public List<CompleteSection> getCourseList();

}
