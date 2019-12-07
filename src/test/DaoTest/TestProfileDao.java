package test.DaoTest;

import main.fudan.CourseSelectionSystem.consts.Constant;
import main.fudan.CourseSelectionSystem.dao.Impl.ProfileDaoImpl;
import main.fudan.CourseSelectionSystem.dao.ProfileDao;
import main.fudan.CourseSelectionSystem.entity.Profile;

import java.sql.SQLException;

public class TestProfileDao {
    private static ProfileDao profileDao = new ProfileDaoImpl();

    private static Profile profile = new Profile();

    public static void main(String[] args) {
        init();
        test_get();
        test_check_exit();
        test_add();
        test_get();
        test_check_exit();
    }

    private static void init(){
        profile.setProfile_id("T90000001");
        profile.setPermission(Constant.PERM_TEACHER);
        profile.setPassword("123");
    }

    private static void test_add(){
        try {
            profileDao.addProfile(profile);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void test_get(){
        System.out.println(profileDao.getProfile(profile.getProfile_id()));
    }

    private static void test_check_exit(){
        if (!profileDao.checkExist("12465","1234")){
            System.out.println("Success");
        }
        else{
            System.out.println("Failed");
        }
        if (!profileDao.checkExist(profile.getProfile_id(),"1234")){
            System.out.println("Success");
        }
        else{
            System.out.println("Failed");
        }
        if (profileDao.checkExist(profile.getProfile_id(),profile.getPassword())){
            System.out.println("Success");
        }
        else{
            System.out.println("Failed");
        }
    }
}
