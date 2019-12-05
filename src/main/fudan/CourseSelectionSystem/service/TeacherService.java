package main.fudan.CourseSelectionSystem.service;

import main.fudan.CourseSelectionSystem.entity.Teacher;

public interface TeacherService {
    /* 导入教师数据,出错时抛出错误 */
    public boolean insertTeacher(Teacher teacher);


    /* 通过excel文件导入教师数据,先catch error，插入所有数据后再throw总的问题， error自定义 */
    public boolean insertTeachersByExcel(String path);
}
