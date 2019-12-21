package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.Teaches;

import java.util.List;

public interface TeachesDao {
    /* 加入一条新的授课数据 */
    public boolean addTeaches(Teaches teaches);
    /* 获取所有授课列表 */
    public List<Teaches> getTeaches();
    /* 获取某个老师的所有授课信息 */
    public List<Teaches> getTeachesListOf(String teacher_id);
}
