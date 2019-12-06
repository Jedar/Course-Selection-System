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
    public boolean deleteClassroom(String building, String room_number) throws SQLException {
        String sql = "DELETE FROM `course_selection_system`.`classroom`" +
                "WHERE building=? AND room_number=?";
        return dao.update(sql, building, room_number);
    }

    @Override
    public Classroom getClassroom(String building, String room_number) {
        return null;
    }
}
