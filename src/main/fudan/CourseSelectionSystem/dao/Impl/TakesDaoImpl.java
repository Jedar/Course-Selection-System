package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.TakesDao;
import main.fudan.CourseSelectionSystem.entity.Takes;

import java.util.List;

/**
 * @ClassName TakesDaoImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 20:12
 * @Version 1.0
 **/
public class TakesDaoImpl implements TakesDao {

    @Override
    public boolean updateTakes(Takes takes) {
        return false;
    }

    @Override
    public boolean addTakes(Takes takes) {
        return false;
    }

    @Override
    public boolean dropSection(int studentID, int courseID, int sectionID, int year, String semester) {
        return false;
    }

    @Override
    public List<Takes> getTakesListByStudent(int StudentID) {
        return null;
    }
}
