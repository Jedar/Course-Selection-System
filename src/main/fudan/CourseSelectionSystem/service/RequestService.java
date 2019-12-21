package main.fudan.CourseSelectionSystem.service;

import main.fudan.CourseSelectionSystem.entity.Request;

import java.util.List;

public interface RequestService {
    /* 提交选课事务 */
    public boolean addRequest(Request request);
    /* 处理选课事务 */
    public boolean readRequest(Request request);
    /* 获取某个老师的选课事务列表 */
    public List<Request> getRequestOf(String teacher_id);
    /* 获取学生的选课事务申请列表 */
    public List<Request> getRequestOfStudent(String studentID);
}
