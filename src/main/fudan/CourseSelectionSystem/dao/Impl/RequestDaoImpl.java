package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.RequestDao;
import main.fudan.CourseSelectionSystem.entity.Request;

import java.util.List;

/**
 * @ClassName RequestDaoImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 19:32
 * @Version 1.0
 **/
public class RequestDaoImpl{

    @Override
    public boolean addRequest(Request request) {
        return false;
    }

    @Override
    public boolean deleteRequest(int studentID, int courseID, int sectionID, int year, String semester) {
        return false;
    }

    @Override
    public boolean updateRequest(Request request) {
        return false;
    }

    @Override
    public List<Request> getRequestListBySection(int courseID, int sectionID, int year, String semester) {
        return null;
    }

    @Override
    public List<Request> getRequestListByStudent(int studentID) {
        return null;
    }
}
