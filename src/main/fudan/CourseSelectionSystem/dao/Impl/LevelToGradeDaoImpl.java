package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.LevelToGradeDao;
import main.fudan.CourseSelectionSystem.entity.LevelToGrade;

import java.sql.SQLException;

/**
 * @ClassName LevelToGradeDaoImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/5 21:31
 * @Version 1.0
 **/
public class LevelToGradeDaoImpl implements LevelToGradeDao {
    BaseDao<LevelToGrade> dao = new JDBCDao<>();
    @Override
    public boolean addLevelToGrade(LevelToGrade levelToGrade) throws SQLException {
        String sql = "insert into level_to_grade (level, grade) values (?,?)";
        return dao.update(sql, levelToGrade.getLevel(), levelToGrade.getGrade());
    }

    @Override
    public boolean updateLevelToGrade(LevelToGrade levelToGrade) throws SQLException {
        String sql = "update level_to_grade set grade = ? where level = ?";
        return dao.update(sql, levelToGrade.getGrade(), levelToGrade.getLevel());  
    }
}
