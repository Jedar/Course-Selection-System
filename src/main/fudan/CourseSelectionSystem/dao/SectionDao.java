package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface SectionDao {
    public boolean addSection(Section section, Exam exam, List<TimeSlot> timeSlots, TimeSlot timeSlot, List<Teaches> teachesList) throws SQLException;
    public boolean deleteSection(int courseID, int sectionID, int year, String semester) throws SQLException;
    public boolean updateSection(Section section) throws SQLException;
    public Section getSection(int courseID, int sectionID, int year, String semester);
    public List<CompleteSection> getCriteriaSectionList(CriteriaSection criteriaSection);
    public List<CompleteSection> getSectionList();

    //选课人数
    public int getStudentNum(Section section) throws Exception;

    /* 检查课程时间，地点冲突 */
    public List<Section> getCourseConflictSectionList(CompleteSection section);

    /* 检查考试冲突 */
    public List<Section> getExamConflictSectionList(CompleteSection section);
}
