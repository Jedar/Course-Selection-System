package main.fudan.CourseSelectionSystem.service.Impl;

import main.fudan.CourseSelectionSystem.consts.Constant;
import main.fudan.CourseSelectionSystem.dao.DaoRepository;
import main.fudan.CourseSelectionSystem.dao.TeacherDao;
import main.fudan.CourseSelectionSystem.entity.Profile;
import main.fudan.CourseSelectionSystem.entity.Student;
import main.fudan.CourseSelectionSystem.entity.Teacher;
import main.fudan.CourseSelectionSystem.service.TeacherService;
import main.fudan.CourseSelectionSystem.util.ExcelReader;

import java.sql.SQLException;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao = DaoRepository.getTeacherDao();

    @Override
    public boolean insertTeacher(Teacher teacher) throws SQLException {
        Profile profile = new Profile();
        profile.setProfile_id(teacher.getTeacher_id());
        profile.setPassword(Constant.DEFAULT_PASSWORD);
        profile.setPermission(Constant.PERM_TEACHER);
        return teacherDao.addTeacherWithProfile(teacher,profile);
    }

    @Override
    public boolean insertTeachersByExcel(String path) throws Exception {
        boolean allCorrect = true;
        StringBuilder errMsg = new StringBuilder();
        ExcelReader reader;
        try {
            reader = new ExcelReader(path,true);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        while (reader.hasNextLine()){
            /* |id|name|title|abbr| */
            Teacher teacher = new Teacher();
            List<String> list = reader.readNextLine();
            try {
                teacher.setTeacher_id(list.get(0));
                teacher.setTeacher_name(list.get(1));
                teacher.setTitle(list.get(2));
                teacher.setSchool_abbr(list.get(3));
                allCorrect =  insertTeacher(teacher) && allCorrect;
            }
            catch (Exception e){
                System.err.println(e.getMessage());
                errMsg.append(list.toString()).append("\n");
                allCorrect = false;
            }
        }
        if (!allCorrect){
            throw new Exception(errMsg.toString());
        }
        return allCorrect;
    }

    @Override
    public List<Teacher> getTeacherList() {
        return teacherDao.getTeacherList();
    }
}
