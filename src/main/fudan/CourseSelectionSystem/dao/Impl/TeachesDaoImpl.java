package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.TeachesDao;
import main.fudan.CourseSelectionSystem.entity.Teaches;

import java.util.List;

public class TeachesDaoImpl implements TeachesDao {
    BaseDao<Teaches> teachesBaseDao = new JDBCDao<>();
    @Override
    public boolean addTeaches(Teaches teaches) {
        return false;
    }

    @Override
    public List<Teaches> getTeaches() {
        return null;
    }

    @Override
    public List<Teaches> getTeachesListOf(String teacher_id) {
        String sql = "select course_id, section_id,year,semester,teacher_id,course_name \n" +
                "from teaches Natural Join course \n" +
                "where teacher_id = ?;";
        return teachesBaseDao.getForList(Teaches.class,sql,teacher_id);
    }
}
