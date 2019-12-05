package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.ClassroomDao;
import main.fudan.CourseSelectionSystem.entity.Classroom;

import java.sql.SQLException;

/**
 * @ClassName ClassroomDaoImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/4 15:15
 * @Version 1.0
 **/
public class ClassroomDaoImpl implements ClassroomDao {
    private BaseDao<Classroom> dao = new JDBCDao<>();
    @Override
    public boolean addClassroom(Classroom classroom) throws SQLException {
        String sql = "insert into classroom (building, room_number, classroom_capacity) values (?,?,?)";
        return dao.update(sql, classroom.getBuilding(), classroom.getRoom_number(), classroom.getClassroom_capacity());
    }

    @Override
    public boolean deleteClassroom(String building, String room_number) {
        return false;
    }

    @Override
    public Classroom getClassroom(String building, String room_number) {
        return null;
    }
}
