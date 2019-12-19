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
    public boolean deleteClassroom(String building, String room_number) throws SQLException{
        String sql = "delete from classroom where building = ? and room_number = ?";
        return dao.update(sql, building, room_number);
    }

    @Override
    public Classroom getClassroom(String building, String room_number) {
        String sql = "select * from classroom " +
                "where building = ? and room_number = ?";
        return dao.get(Classroom.class, sql, building, room_number);
    }

    @Override
    public boolean updateClassroom(Classroom classroom) throws SQLException {
        String sql = "update classroom " +
                "set classroom_capacity = ? " +
                "where building = ? and room_number = ?";
        return dao.update(sql, classroom.getClassroom_capacity(), classroom.getBuilding(), classroom.getRoom_number());
    }
}
