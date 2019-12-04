package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.SectionDao;
import main.fudan.CourseSelectionSystem.entity.CriteriaSection;
import main.fudan.CourseSelectionSystem.entity.Section;

import java.util.List;

/**
 * @ClassName SectionDaoImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 19:32
 * @Version 1.0
 **/
public class SectionDaoImpl implements SectionDao {

    @Override
    public boolean addSection(Section section) {
        return false;
    }

    @Override
    public boolean deleteSection(int courseID, int sectionID, int year, String semester) {
        return false;
    }

    @Override
    public boolean updateSection(Section section) {
        return false;
    }

    @Override
    public List<Section> getCriteriaSectionList(CriteriaSection criteriaSection) {
        return null;
    }

    @Override
    public List<Section> getSectionList() {
        return null;
    }

    @Override
    public int getStudentNum(Section section) {
        return 0;
    }
}
