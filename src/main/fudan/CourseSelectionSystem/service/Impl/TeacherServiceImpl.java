package main.fudan.CourseSelectionSystem.service.Impl;

import main.fudan.CourseSelectionSystem.dao.DaoRepository;
import main.fudan.CourseSelectionSystem.dao.TeacherDao;
import main.fudan.CourseSelectionSystem.entity.Teacher;
import main.fudan.CourseSelectionSystem.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao = DaoRepository.getTeacherDao();

    @Override
    public boolean insertTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher);
    }

    @Override
    public boolean insertTeachersByExcel(String path) {

        return false;
    }
}
