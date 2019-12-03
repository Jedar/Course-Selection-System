package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.CriteriaSection;
import main.fudan.CourseSelectionSystem.entity.Section;

import java.util.List;

public interface SectionDao {
    public boolean addSection(Section section);
    public boolean deleteSection(int courseID, int sectionID, int year, String semester);
    public boolean updateSection(Section section);
    public List<Section> getCriteriaSectionList(CriteriaSection criteriaSection);
    public List<Section> getSectionList();

    //选课人数
    public int getStudentNum(Section section);
}
