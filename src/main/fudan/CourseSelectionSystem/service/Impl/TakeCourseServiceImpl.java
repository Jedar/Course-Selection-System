package main.fudan.CourseSelectionSystem.service.Impl;

import main.fudan.CourseSelectionSystem.dao.DaoFactory;
import main.fudan.CourseSelectionSystem.dao.SectionDao;
import main.fudan.CourseSelectionSystem.dao.TakesDao;
import main.fudan.CourseSelectionSystem.entity.Section;
import main.fudan.CourseSelectionSystem.entity.Takes;
import main.fudan.CourseSelectionSystem.service.TakeCourseService;

import java.sql.SQLException;
import java.util.List;

public class TakeCourseServiceImpl implements TakeCourseService {
    private TakesDao takesDao = DaoFactory.getInstance().getTakesDao();
    private SectionDao sectionDao = DaoFactory.getInstance().getSectionDao();

    @Override
    public boolean selectCourse(String studentID, int courseID, int sectionID, int year, String semester) {
        /* 检查上课人数限制 */
        Section section = sectionDao.getSection(courseID, sectionID, year, semester);
        int takesNum;
        try {
            takesNum = sectionDao.getStudentNum(section);
        }catch (Exception e) {
            return false;
        }
        if(takesNum >= section.getSection_capacity()){
            return false;
        }

        /* 处理若之前已退该课程情况 */
        Takes takes = takesDao.getTakes(studentID, courseID, sectionID, year, semester);
        if(takes != null){
            takes.setDrop_flag(false);
            try {
                return takesDao.updateTakes(takes);
            }catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        /* 检查上课、考试时间冲突 */
        List<Section> timeConflictList = takesDao.getTimeConflictSectionList(studentID, courseID, sectionID, year, semester);  /*上课时间冲突*/
        List<Section> examConflictList = takesDao.getExamConflictSectionList(studentID, courseID, sectionID, year, semester);  /*考试时间冲突*/
        if(timeConflictList.size() == 0 && examConflictList.size() == 0) {
            try {
                return takesDao.addTakes(new Takes(studentID, courseID, sectionID, year, semester, "U", false));
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean dropCourse(String studentID, int courseID, int sectionID, int year, String semester) {
        try {
            return takesDao.dropSection(studentID, courseID, sectionID, year, semester);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
