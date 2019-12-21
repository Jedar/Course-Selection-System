package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.RequestDao;
import main.fudan.CourseSelectionSystem.entity.Request;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName RequestDaoImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 19:32
 * @Version 1.0
 **/
public class RequestDaoImpl implements RequestDao{
    private BaseDao<Request> dao = new JDBCDao<>();

    @Override
    public boolean addRequest(Request request) throws SQLException {
        /* 插入的对象只需要课程主键，学生id， 请求内容，其他可以不用设置 */
        String sql ="INSERT INTO `course_selection_system`.`sec_request`\n" +
                "(`student_id`,\n" +
                "`course_id`,\n" +
                "`section_id`,\n" +
                "`year`,\n" +
                "`semester`,\n" +
                "`request_content`)\n" +
                "VALUES (?,?,?,?,?,?)";
        return dao.update(sql, request.getStudent_id(), request.getCourse_id(), request.getSection_id(), request.getYear(),
                request.getSemester(), request.getRequest_content());
    }

    @Override
    public boolean deleteRequest(String studentID, int courseID, int sectionID, int year, String semester) throws SQLException {
        String sql = "DELETE FROM `course_selection_system`.`sec_request`\n" +
                "WHERE student_id = ? AND course_id = ? AND section_id = ? AND year = ? AND semester = ?";
        return dao.update(sql, studentID, courseID, sectionID, year, semester);
    }

    @Override
    public boolean updateRequest(Request request) throws SQLException {
        /* 确保所有值已经设置 */
        String sql = "UPDATE `course_selection_system`.`sec_request`\n" +
                "SET\n" +
                "`pass_or_not` = ?,\n" +
                "`reply_content` = ?\n" +
                "WHERE `student_id` = ? AND `course_id` = ? AND `section_id` = ? AND `year` = ? AND `semester` = ?";
        return dao.update(sql, request.getPass_or_not(), request.getReply_content(),
                request.getStudent_id(), request.getCourse_id(), request.getSection_id(), request.getYear(), request.getSemester());
    }

    @Override
    public List<Request> getRequestListBySection(int courseID, int sectionID, int year, String semester) {
        String sql = "SELECT `sec_request`.`student_id`,\n" +
                "    `sec_request`.`course_id`,\n" +
                "    `sec_request`.`section_id`,\n" +
                "    `sec_request`.`year`,\n" +
                "    `sec_request`.`semester`,\n" +
                "    `sec_request`.`request_content`,\n" +
                "    `sec_request`.`pass_or_not`,\n" +
                "    `sec_request`.`reply_content`\n" +
                "FROM `course_selection_system`.`sec_request`" +
                "WHERE `course_id` = ? AND `section_id` = ? AND `year` = ? AND `semester` = ?";
        return dao.getForList(Request.class, sql, courseID, sectionID, year, semester);
    }

    @Override
    public List<Request> getRequestListByStudent(String studentID) {
        String sql = "select * from sec_request where student_id = ?";
        return dao.getForList(Request.class, sql, studentID);
    }

    @Override
    public List<Request> getRequestOf(String teacherID) {
        String sql = "select course_id,section_id,year,semester,request_content,pass_or_not,reply_content,course_name,student_id,student_name \n" +
                "from sec_request natural join course natural join (select student_id, student_name from student) as student_t natural join teaches\n" +
                "where teacher_id=?";
        return dao.getForList(Request.class, sql, teacherID);
    }
}
