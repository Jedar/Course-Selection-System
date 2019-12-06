package test;

import main.fudan.CourseSelectionSystem.consts.Constant;
import main.fudan.CourseSelectionSystem.dao.Impl.TeacherDaoImpl;
import main.fudan.CourseSelectionSystem.dao.TeacherDao;
import main.fudan.CourseSelectionSystem.entity.Profile;
import main.fudan.CourseSelectionSystem.entity.Teacher;

import java.util.List;

public class TestTeacherDao {
    private static TeacherDao teacherDao = new TeacherDaoImpl();

    public static void main(String[] args) {
        test_insert();
    }

    private static void test_insert(){
        Teacher teacher = new Teacher();
        teacher.setTeacher_id("T90000001");
        teacher.setTeacher_name("测试用户");
        teacher.setTitle("暂无");
        teacher.setSchool_abbr("SOFT");
        Profile profile = new Profile();
        profile.setProfile_id("T90000001");
        profile.setPassword("123456");
        profile.setPermission(Constant.PERM_TEACHER);
        try {
            teacherDao.addTeacherWithProfile(teacher,profile);
            teacher.setTeacher_name("名称已修改");
            teacherDao.updateTeacher(teacher);
            List<Teacher> teacherList = teacherDao.getTeacherList();
            System.out.println(teacherList);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
