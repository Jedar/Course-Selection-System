package main.fudan.CourseSelectionSystem.service;

import main.fudan.CourseSelectionSystem.entity.Course;

public interface CourseService {
    /* 插入单个Course数据 */
    public boolean insertCourse(Course course);

    /* 根据Excel文件插入Course数据 */
    public boolean insertCoursesByExcel(String path);
}
