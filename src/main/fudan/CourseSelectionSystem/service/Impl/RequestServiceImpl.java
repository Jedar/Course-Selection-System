package main.fudan.CourseSelectionSystem.service.Impl;

import main.fudan.CourseSelectionSystem.dao.*;
import main.fudan.CourseSelectionSystem.entity.*;
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
    public List<Request> getRequestOfStudent(String studentID) {
        return requestDao.getRequestListByStudent(studentID);
    }

    @Override
    public boolean addRequest(Request request) {
        /* 检查是否已选或者退过该课程 */
        TakesDao takesDao = DaoFactory.getInstance().getTakesDao();
        Takes takes = takesDao.getTakes(request.getStudent_id(), request.getCourse_id(), request.getSection_id(), request.getYear(), request.getSemester());
        if(takes != null) {
            return false;
        }

        /* 检查选课人数是否已达课程上限 */
        SectionDao sectionDao = DaoFactory.getInstance().getSectionDao();
        Section section = sectionDao.getSection(request.getCourse_id(), request.getSection_id(), request.getYear(), request.getSemester());
        if(section == null) {
            return false;
        }else {
            try {
                int stuNum = sectionDao.getStudentNum(section);
                if(stuNum < section.getSection_capacity()) {
                    return false;
                }
            }catch (Exception e) {
                return false;
            }
        }

        /* 检查选课人数是否已达教室容量 */
        ClassroomDao classroomDao = DaoFactory.getInstance().getClassroomDao();
        Classroom classroom = classroomDao.getClassroom(section.getBuilding(), section.getRoom_number());
        if(classroom == null) {
            return false;
        }else {
            try {
                int stuNum = sectionDao.getStudentNum(section);
                if(stuNum >= classroom.getClassroom_capacity()) {
                    return false;
                }
            }catch (Exception e) {
                return false;
            }
        }

        /* 检查是否和已选课程存在时间冲突 */
        List<Section> timeConflict = takesDao.getTimeConflictSectionList(request.getStudent_id(), request.getCourse_id(), request.getSection_id(), request.getYear(), request.getSemester());
        List<Section> examConflict = takesDao.getExamConflictSectionList(request.getStudent_id(), request.getCourse_id(), request.getSection_id(), request.getYear(), request.getSemester());
        System.out.println(timeConflict.size());
        System.out.println(examConflict.size());
        if(timeConflict.size() != 0 || examConflict.size()!= 0)
            return false;

        /* 提交申请 */
        try {
            System.out.println("add request");
            return requestDao.addRequest(request);
        } catch (SQLException e) {
            // 插入数据出错
//            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean readRequest(Request request) {
        try {
            return requestDao.updateRequest(request);
        }catch (SQLException e) {
            // 读取数据出错
//            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Request> getRequestOf(String id) {
        return requestDao.getRequestOf(id);
    }
}
