package main.fudan.CourseSelectionSystem.dao.Impl;
import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.TakesDao;
import main.fudan.CourseSelectionSystem.entity.Section;
import main.fudan.CourseSelectionSystem.entity.Takes;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName TakesDaoImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 20:12
 * @Version 1.0
 **/
public class TakesDaoImpl implements TakesDao {
    BaseDao<Takes> dao = new JDBCDao<>();

    @Override
    public Takes getTakes(int studentID, int courseID, int sectionID, int year, String semester) {
        return null;
    }

    @Override
    public boolean updateTakes(Takes takes) {
        return false;
    }

    @Override
    public boolean addTakes(Takes takes) throws SQLException {
        String sql = "insert into takes (student_id, course_id, section_id, year, semester) values (?,?,?,?,?)";
        return dao.update(sql, takes.getStudent_id(), takes.getCourse_id(), takes.getSection_id(), takes.getYear(), takes.getSemester());
    }

    @Override
    public boolean dropSection(int studentID, int courseID, int sectionID, int year, String semester) {
        return false;
    }

    @Override
    public List<Section> getTimeConflictSectionList(int studentID, int courseID, int sectionID, int year, String semester) {
        return null;
    }

    @Override
    public List<Section> getExamConflictSectionList(int studentID, int courseID, int sectionID, int year, String semester) {
        return null;
    }
}
