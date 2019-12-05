package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.dao.Impl.*;
import main.fudan.CourseSelectionSystem.entity.*;

import java.util.ArrayList;
import java.util.List;

public class DaoRepository {
    public static CourseDao getCourseDao(){
        return new CourseDao() {
            @Override
            public boolean addCourse(Course course) {
                System.out.println(course.toString());
                return true;
            }

            @Override
            public boolean deleteCourse(int courseID) {
                return true;
            }

            @Override
            public boolean updateCourse(int courseID) {
                return true;
            }

            @Override
            public List<Course> getCourseList() {
                return new ArrayList<>();
            }
        };
    }

    public static RequestDao getRequestDao(){
        return new RequestDao(){

            @Override
            public boolean addRequest(Request request) {
                return true;
            }

            @Override
            public boolean deleteRequest(int studentID, int courseID, int sectionID, int year, String semester) {
                return true;
            }

            @Override
            public boolean updateRequest(Request request) {
                return true;
            }

            @Override
            public List<Request> getRequestListBySection(int courseID, int sectionID, int year, String semester) {
                return null;
            }

            @Override
            public List<Request> getRequestListByStudent(int studentID) {
                return null;
            }
        };
    }

    public static SectionDao getSectionDao(){
        return new SectionDao(){

            @Override
            public boolean addSection(Section section) {
                return true;
            }

            @Override
            public boolean deleteSection(int courseID, int sectionID, int year, String semester) {
                return true;
            }

            @Override
            public boolean updateSection(Section section) {
                return true;
            }

            @Override
            public List<Section> getCriteriaSectionList(CriteriaSection criteriaSection) {
                return null;
            }

            @Override
            public List<Section> getSectionList() {
                return null;
            }

            @Override
            public int getStudentNum(Section section) {
                return 0;
            }
        };
    }

    public static StudentDao getStudentDao(){
        return new StudentDao(){

            @Override
            public boolean addStudent(Student student) {
                System.out.println(student);
                return true;
            }

            @Override
            public boolean deleteStudent(int studentID) {
                return true;
            }

            @Override
            public boolean updateStudent(int studentID) {
                return true;
            }

            @Override
            public Student getStudentByID(int studentID) {
                return null;
            }

            @Override
            public Student getStudentsBySection(Section section) {
                return null;
            }
        };
    }

    public static TakesDao getTakeDao(){
        return new TakesDao(){

            @Override
            public boolean updateTakes(Takes takes) {
                return true;
            }

            @Override
            public boolean addTakes(Takes takes) {
                return true;
            }

            @Override
            public boolean dropSection(int studentID, int courseID, int sectionID, int year, String semester) {
                return true;
            }

            @Override
            public List<Takes> getTakesListByStudent(int StudentID) {
                return null;
            }
        };
    }

    public static TeacherDao getTeacherDao(){
        return new TeacherDao(){

            @Override
            public boolean addTeacher(Teacher teacher) {
                return true;
            }

            @Override
            public boolean addTeacherWithProfile(Teacher teacher, Profile profile) {
                System.out.println(teacher);
                System.out.println(profile);
                return true;
            }

            @Override
            public boolean deleteTeacher(int teacherID) {
                return true;
            }

            @Override
            public boolean updateTeacher(int teacherID) {
                return true;
            }

            @Override
            public List<Teacher> getTeacherList() {
                return null;
            }
        };
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
        return new TeachesDao() {
            @Override
            public boolean addTeaches(Teaches teaches) {
                System.out.println(teaches);
                return true;
            }

            @Override
            public List<Teaches> getTeaches() {
                return new ArrayList<>();
            }
        };
    }

    public static ProfileDao getProfileDao(){
        return new ProfileDao() {
            @Override
            public boolean addProfile(Profile profile) {
                return true;
            }

            @Override
            public Profile getProfile(String ID) {
                return null;
            }

            @Override
            public boolean checkExist(String ID, String passwd) {
                return false;
            }
        };
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
