package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.dao.Impl.*;
import main.fudan.CourseSelectionSystem.entity.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoRepository {
    public static CourseDao getCourseDao(){
        return new CourseDaoImpl();
    }

    public static RequestDao getRequestDao(){
        return new RequestDaoImpl();
    }

    public static SectionDao getSectionDao(){
        return new SectionDaoImpl();
    }

    public static StudentDao getStudentDao(){
        return new StudentDaoImpl();
    }

    public static TakesDao getTakeDao(){
        return new TakesDaoImpl();
    }

    public static TeacherDao getTeacherDao(){
        return new TeacherDaoImpl();
    }

    public static TimeSlotDao getTimeSlotDao() {
        return new TimeSlotDao() {

            @Override
            public int getMaxTimeSlotID() {
                return 1;
            }

            @Override
            public boolean addTimeSlot(TimeSlot ts) {
                System.out.println(ts);
                return true;
            }

            @Override
            public List<TimeSlot> getTimeSlotList(int id) {
                return new ArrayList<>();
            }
        };
    }

    public static ExamDao getExamDao() {
        return new ExamDao() {
            @Override
            public boolean addExam(Exam exam) {
                return false;
            }
        };
    }

    public static TeachesDao getTeachesDao() {
        return new TeachesDaoImpl();
    }

    public static ProfileDao getProfileDao(){
        return new ProfileDaoImpl();
    }

    public static ManagerDao getManagerDao(){
        return new ManagerDao() {
            @Override
            public boolean addManager(Manager manager, Profile profile) {
                System.out.println(manager);
                System.out.println(profile);
                return true;
            }

            @Override
            public Manager getManager(String id) {
                return null;
            }
        };
    }
}
