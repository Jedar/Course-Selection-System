package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.TimeSlotDao;
import main.fudan.CourseSelectionSystem.entity.TimeSlot;

import java.util.List;

public class TimeSlotDaoImpl implements TimeSlotDao {
    private BaseDao<Object> integerBaseDao = new JDBCDao<>();

    @Override
    public int getMaxTimeSlotID() {
        String sql = "select max(time_slot_id) as num from time_slot";
        return (Integer) integerBaseDao.getForValue(sql);
    }

    @Override
    public boolean addTimeSlot(TimeSlot ts) {
        return false;
    }

    @Override
    public List<TimeSlot> getTimeSlotList(int id) {
        return null;
    }
}
