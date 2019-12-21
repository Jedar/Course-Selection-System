package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface SectionDao {
    /* 插入课程 */
    public boolean addSection(Section section, Exam exam, List<TimeSlot> timeSlots, TimeSlot timeSlot, List<Teaches> teachesList) throws SQLException;
    /* 删除课程 */
    public boolean deleteSection(int courseID, int sectionID, int year, String semester) throws SQLException;
    /* 修改课程信息 */
    public boolean updateSection(Section section) throws SQLException;
    /* 获取课程基本信息 */
    public Section getSection(int courseID, int sectionID, int year, String semester);
    /* 课程模糊搜索 */
    public List<CompleteSection> getCriteriaSectionList(CriteriaSection criteriaSection);
    /* 所有课程列表 */
    public List<CompleteSection> getSectionList();
    /* 选课人数 */
    public int getStudentNum(Section section) throws Exception;
    /* 检查课程时间，地点冲突 */
    public List<Section> getCourseConflictSectionList(CompleteSection section);
    /* 检查考试冲突 */
    public List<Section> getExamConflictSectionList(CompleteSection section);
}
