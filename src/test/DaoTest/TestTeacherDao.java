package test.DaoTest;

import main.fudan.CourseSelectionSystem.consts.Constant;
import main.fudan.CourseSelectionSystem.dao.Impl.TeacherDaoImpl;
import main.fudan.CourseSelectionSystem.dao.TeacherDao;
import main.fudan.CourseSelectionSystem.entity.*;

import java.util.List;

public class TestTeacherDao {
    private static TeacherDao teacherDao = new TeacherDaoImpl();

    public static void main(String[] args) {
//        test_insert();

//        test_slot_time_conflict();

//        test_get_stu_list();

        test_get_req_list();
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

    private static void test_slot_time_conflict(){
        String teacher_id = "T10000001";
        CompleteSection complete_section = new CompleteSection();
        complete_section.setCourse_time("星期一,1-3");
        try {
            List<Section> res = teacherDao.getTimeConflictSections(complete_section,teacher_id);
            System.out.println(res);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void test_get_stu_list(){
        Teaches teaches = new Teaches();
        teaches.setTeacher_id("T10000001");
        teaches.setCourse_id(102536);
        teaches.setSemester("春季");
        teaches.setSection_id(6);
        teaches.setYear(2019);
        try {
            List<Student> res = teacherDao.getStudentOf(teaches);
            System.out.println(res);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void test_get_req_list(){
        try {
            List<Request> res = teacherDao.getRequestList("T10000001",2019,"春季");
            System.out.println(res);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
