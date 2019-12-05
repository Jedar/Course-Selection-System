package main.fudan.CourseSelectionSystem.service.Impl;

import main.fudan.CourseSelectionSystem.dao.CourseDao;
import main.fudan.CourseSelectionSystem.dao.DaoRepository;
import main.fudan.CourseSelectionSystem.entity.Course;
import main.fudan.CourseSelectionSystem.service.CourseService;
import main.fudan.CourseSelectionSystem.util.ExcelReader;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao = DaoRepository.getCourseDao();

    @Override
    public boolean insertCourse(Course course) {
        /* 底层报错 */
        return courseDao.addCourse(course);
    }

    @Override
    public boolean insertCoursesByExcel(String path) throws Exception {
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
                allCorrect =  insertCourse(course) & allCorrect;
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
