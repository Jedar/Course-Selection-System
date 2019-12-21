package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.Request;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface RequestDao {
    /* 加入新的选课事务申请条目 */
    public boolean addRequest(Request request) throws SQLException;
    /* 删除一条选课事务申请条目 */
    public boolean deleteRequest(String studentID, int courseID, int sectionID, int year, String semester) throws SQLException;
    /* 更新选课事务的状态（例如，同意申请） */
    public boolean updateRequest(Request request) throws SQLException;
    /* 获取某门课的选课事务 */
    public List<Request> getRequestListBySection(int courseID, int sectionID, int year, String semester);
    /* 获取某个学生的选课申请信息 */
    public List<Request> getRequestListByStudent(String studentID);
    /* 获取与某个老师有关的所有选课事务 */
    public List<Request> getRequestOf(String teacherID);
}
