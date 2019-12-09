package main.fudan.CourseSelectionSystem.service.Impl;

import main.fudan.CourseSelectionSystem.dao.DaoFactory;
import main.fudan.CourseSelectionSystem.dao.DaoRepository;
import main.fudan.CourseSelectionSystem.dao.ProfileDao;
import main.fudan.CourseSelectionSystem.service.ProfileService;

public class ProfileServiceImpl implements ProfileService {
    private ProfileDao profileDao = DaoFactory.getInstance().getProfileDao();

    @Override
    public boolean login(String id, String password) {
        return profileDao.checkExist(id,password);
    }

    @Override
    public String getPermission(String id) {
        return profileDao.getProfile(id).getPermission();
    }


}
