package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.dao.Impl.CompleteSectionDaoImpl;
import main.fudan.CourseSelectionSystem.dao.Impl.ProfileDaoImpl;
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

    private DaoFactory() {
        completeSectionDao = new CompleteSectionDaoImpl();
        profileDao = new ProfileDaoImpl();
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
}
