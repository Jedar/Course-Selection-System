package main.fudan.CourseSelectionSystem.service;

import main.fudan.CourseSelectionSystem.entity.Student;

import java.util.List;

public interface StudentService {
    /* 导入学生数据,出错时抛出错误 */
    public boolean insertStudent(Student student) throws Exception;


    /* 通过excel文件导入学生数据 */
    public boolean insertStudentsByExcel(String path) throws Exception;

    /* 得到所有学生列表 */
    public List<Student> getStudentList();
}
