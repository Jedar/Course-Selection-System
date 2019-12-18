package main.fudan.CourseSelectionSystem.service;

import main.fudan.CourseSelectionSystem.entity.Student;
import main.fudan.CourseSelectionSystem.entity.Teacher;
import main.fudan.CourseSelectionSystem.entity.Teaches;

import java.sql.SQLException;
import java.util.List;

public interface TeacherService {
    /* 导入教师数据,出错时抛出错误 */
    public boolean insertTeacher(Teacher teacher) throws SQLException;


    /* 通过excel文件导入教师数据,先catch error，插入所有数据后再throw总的问题， error自定义 */
    public boolean insertTeachersByExcel(String path) throws Exception;

    /* 得到所有老师列表 */
    public List<Teacher> getTeacherList();

    /* 得到老师上课的列表 */
    public List<Teaches> getTeachesListOf(String id);

    /* 得到上课花名册 */
    public List<Student> getStudentsList(Teaches teaches);
}
