package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.dao.Impl.CompleteSectionDaoImpl;
import main.fudan.CourseSelectionSystem.entity.CompleteSection;

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

    private DaoFactory() {
        completeSectionDao = new CompleteSectionDaoImpl();
    }

    public static DaoFactory getInstance() {
        return daoFactory;
    }

    public CompleteSectionDao getCompleteSectionDao() {
        return completeSectionDao;
    }
}
