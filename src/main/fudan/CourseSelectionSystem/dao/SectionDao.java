package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.*;

import java.util.List;

public interface SectionDao {
    public boolean addSection(Section section, Exam exam, List<TimeSlot> timeSlots, TimeSlot timeSlot, List<Teaches> teachesList) throws Exception;
    public boolean deleteSection(int courseID, int sectionID, int year, String semester);
    public boolean updateSection(Section section);
    public List<CompleteSection> getCriteriaSectionList(CriteriaSection criteriaSection);
    public List<CompleteSection> getSectionList();

    //选课人数
    public int getStudentNum(Section section);

    /*检查课程时间，地点冲突*/
    public List<Section> getConflictSectionList(CompleteSection section);
}
