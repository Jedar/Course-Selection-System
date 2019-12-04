package main.fudan.CourseSelectionSystem.service;

import main.fudan.CourseSelectionSystem.entity.Student;

public interface StudentService {
    /* 导入学生数据,出错时抛出错误 */
    public boolean insertStudent(Student student);


    /* 通过excel文件导入学生数据 */
    public boolean insertStudentsByExcel(String path);
}
