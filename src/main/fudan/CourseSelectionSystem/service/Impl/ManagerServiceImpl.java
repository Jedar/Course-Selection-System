package main.fudan.CourseSelectionSystem.service.Impl;

import main.fudan.CourseSelectionSystem.consts.Constant;
import main.fudan.CourseSelectionSystem.dao.DaoRepository;
import main.fudan.CourseSelectionSystem.dao.ManagerDao;
import main.fudan.CourseSelectionSystem.entity.Manager;
import main.fudan.CourseSelectionSystem.entity.Profile;
import main.fudan.CourseSelectionSystem.entity.Teacher;
import main.fudan.CourseSelectionSystem.service.ManagerService;
import main.fudan.CourseSelectionSystem.util.ExcelReader;

import java.util.List;

public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao = DaoRepository.getManagerDao();

    @Override
    public boolean insertManager(Manager manager) {
        Profile profile = new Profile();
        profile.setProfile_id(manager.getManager_id());
        profile.setPassword(Constant.DEFAULT_PASSWORD);
        profile.setPermission(Constant.PERM_MANAGER);
        return managerDao.addManager(manager,profile);
    }

    @Override
    public boolean insertManagerByExcel(String path) throws Exception {
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
            Manager manager = new Manager();
            List<String> list = reader.readNextLine();
            try {
                manager.setManager_id(list.get(0));
                manager.setContact(list.get(1));
                allCorrect =  insertManager(manager) && allCorrect;
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
}
