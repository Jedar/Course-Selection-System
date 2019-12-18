package main.fudan.CourseSelectionSystem.service;

import main.fudan.CourseSelectionSystem.entity.Request;

import java.util.List;

public interface RequestService {
    /* request a section */
    public boolean addRequest(Request request);

    /* read a request */
    public boolean readRequest(Request request);

    /* 获取某个老师的选课事务列表 */
    public List<Request> getRequestOf(String teacher_id);
}
