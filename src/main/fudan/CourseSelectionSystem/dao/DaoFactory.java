package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.dao.Impl.*;
import main.fudan.CourseSelectionSystem.entity.CompleteSection;
import main.fudan.CourseSelectionSystem.entity.Profile;

/**
 * @ClassName DaoFactory
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/5 21:38
 * @Version 1.0
 **/
public class DaoFactory {
    private static DaoFactory daoFactory = new DaoFactory();
    private CompleteSectionDao completeSectionDao;
    private ProfileDao profileDao;
    private TakesDao takesDao;
    private RequestDao requestDao;
    private StudentDao studentDao;
    private SectionDao sectionDao;
    private ClassroomDao classroomDao;

    private DaoFactory() {
        completeSectionDao = new CompleteSectionDaoImpl();
        profileDao = new ProfileDaoImpl();
        takesDao = new TakesDaoImpl();
        requestDao = new RequestDaoImpl();
        studentDao = new StudentDaoImpl();
        sectionDao = new SectionDaoImpl();
        classroomDao = new ClassroomDaoImpl();
    }

    public static DaoFactory getInstance() {
        return daoFactory;
    }

    public CompleteSectionDao getCompleteSectionDao() {
        return completeSectionDao;
    }

    public ProfileDao getProfileDao(){
        return profileDao;
    }

    public TakesDao getTakesDao() {
        return takesDao;
    }

    public RequestDao getRequestDao() {
        return requestDao;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public SectionDao getSectionDao() {
        return sectionDao;
    }

    public ClassroomDao getClassroomDao() {
        return classroomDao;
    }
}
