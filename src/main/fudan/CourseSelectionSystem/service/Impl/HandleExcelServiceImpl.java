package main.fudan.CourseSelectionSystem.service.Impl;

import main.fudan.CourseSelectionSystem.dao.*;
import main.fudan.CourseSelectionSystem.dao.Impl.ClassroomDaoImpl;
import main.fudan.CourseSelectionSystem.dao.Impl.SchoolDaoImpl;
import main.fudan.CourseSelectionSystem.entity.Classroom;
import main.fudan.CourseSelectionSystem.entity.Course;
import main.fudan.CourseSelectionSystem.entity.School;
import main.fudan.CourseSelectionSystem.service.HandleExcelService;
import main.fudan.CourseSelectionSystem.util.ExcelReader;

import java.util.List;

public class HandleExcelServiceImpl implements HandleExcelService {
    private CourseDao courseDao = DaoRepository.getCourseDao();
    private SchoolDao schoolDao = new SchoolDaoImpl();
    private ClassroomDao classroomDao = new ClassroomDaoImpl();

    @Override
    public boolean handleSchoolExcel(String path) throws Exception {
        boolean allCorrect = true;
        boolean ret = true;
        ExcelReader reader;
        StringBuilder errMsg = new StringBuilder();
        reader = new ExcelReader(path,true);
        while (reader.hasNextLine()){
            School school = new School();
            List<String> list = reader.readNextLine();
            try {
                school.setAbbr(list.get(0));
                school.setName(list.get(1));
                allCorrect =  schoolDao.addSchool(school) & allCorrect;
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

    @Override
    public boolean handleCourseExcel(String path) throws Exception {
        boolean allCorrect = true;
        boolean ret = true;
        ExcelReader reader;
        StringBuilder errMsg = new StringBuilder();
        try {
            reader = new ExcelReader(path,true);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        while (reader.hasNextLine()){
            Course course = new Course();
            List<String> list = reader.readNextLine();
            try {
                course.setCourse_id(Integer.parseInt(list.get(0)));
                course.setCourse_name(list.get(1));
                course.setCredits(Integer.parseInt(list.get(2)));
                course.setCredit_hours(Integer.parseInt(list.get(3)));
                course.setSchool_abbr(list.get(4));
                allCorrect =  courseDao.addCourse(course) & allCorrect;
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

    @Override
    public boolean handleClassRoom(String path) throws Exception {
        boolean allCorrect = true;
        boolean ret = true;
        ExcelReader reader;
        StringBuilder errMsg = new StringBuilder();
        reader = new ExcelReader(path,true);
        while (reader.hasNextLine()){
            Classroom room = new Classroom();
            List<String> list = reader.readNextLine();
            try {
                room.setBuilding(list.get(0));
                room.setRoom_number(list.get(1));
                room.setClassroom_capacity(Integer.parseInt(list.get(2)));
                allCorrect =  classroomDao.addClassroom(room) & allCorrect;
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
