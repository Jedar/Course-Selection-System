package main.fudan.CourseSelectionSystem.service;

import main.fudan.CourseSelectionSystem.entity.Section;

public interface SectionService {
    /* 插入当个Section */
    public boolean insertSection(Section section);

    /* 根据excel表格插入数据 */
    public boolean insertSectionsByExcel(String path) throws Exception;
}
