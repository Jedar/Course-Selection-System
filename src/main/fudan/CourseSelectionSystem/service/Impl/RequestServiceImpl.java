package main.fudan.CourseSelectionSystem.service.Impl;

import main.fudan.CourseSelectionSystem.dao.DaoFactory;
import main.fudan.CourseSelectionSystem.dao.RequestDao;
import main.fudan.CourseSelectionSystem.entity.Request;
import main.fudan.CourseSelectionSystem.service.RequestService;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName RequestServiceImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/10 15:57
 * @Version 1.0
 **/
public class RequestServiceImpl implements RequestService {
    private RequestDao requestDao = DaoFactory.getInstance().getRequestDao();
    @Override
    public boolean addRequest(Request request) {
        try {
            return requestDao.addRequest(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean readRequest(Request request) {
        try {
            return requestDao.updateRequest(request);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Request> getRequestOf(String id) {
        return requestDao.getRequestOf(id);
    }
}
