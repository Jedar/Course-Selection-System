package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.TimeSlot;

import java.util.List;

public interface TimeSlotDao {
    /* 得到当前id的最大值 */
    public int getMaxTimeSlotID();

    /* 插入time slot记录 */
    public boolean addTimeSlot(TimeSlot ts);

    /* 得到TimeSlot的列表 */
    public List<TimeSlot> getTimeSlotList(int id);
}
