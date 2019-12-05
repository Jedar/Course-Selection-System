package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.SchoolDao;
import main.fudan.CourseSelectionSystem.entity.School;

/**
 * @ClassName SchoolDaoImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/4 14:54
 * @Version 1.0
 **/
public class SchoolDaoImpl implements SchoolDao {
    private BaseDao<School> dao = new JDBCDao<>();

    public SchoolDaoImpl() {
        super();
    }

    @Override
    public boolean addSchool(School school) {
        String sql = "insert into school (abbr, name) values (?,?)";
        return dao.update(School.class, sql, school.getAbbr(), school.getName());
    }

    @Override
    public boolean deleteSchool(String abbr) {
        return false;
    }
}
