package main.fudan.CourseSelectionSystem.service.Impl;

import main.fudan.CourseSelectionSystem.dao.DaoRepository;
import main.fudan.CourseSelectionSystem.dao.TakesDao;
import main.fudan.CourseSelectionSystem.entity.Classroom;
import main.fudan.CourseSelectionSystem.entity.Takes;
import main.fudan.CourseSelectionSystem.entity.Teaches;
import main.fudan.CourseSelectionSystem.service.TakeCourseService;
import main.fudan.CourseSelectionSystem.util.ExcelReader;

import java.sql.SQLException;
import java.util.List;

public class TakeCourseServiceImpl implements TakeCourseService {
    private TakesDao takesDao = DaoRepository.getTakeDao();

    @Override
    public boolean updateGrade(Takes takes) throws SQLException {
        return takesDao.updateTakes(takes);
    }

    @Override
    public boolean updateGradeByExcel(String path, int courseID, int sectionID, int year, String semester) throws Exception {
        /* |studentID|grade| */
        boolean allCorrect = true;
        boolean ret = true;
        ExcelReader reader;
        StringBuilder errMsg = new StringBuilder();
        reader = new ExcelReader(path,true);
        while (reader.hasNextLine()){
            Classroom room = new Classroom();
            List<String> list = reader.readNextLine();
            try {
                String studentID = list.get(0);
                String grade = list.get(1);
                Takes takes = takesDao.getTakes(studentID,courseID,sectionID,year,semester);
                if (takes == null){
                    throw new Exception("Student take course data Error");
                }
                takes.setLevel(grade);
                allCorrect =  takesDao.updateTakes(takes) & allCorrect;
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
    public Takes getTakeData(String studentID, int courseID, int sectionID, int year, String semester) {
        return takesDao.getTakes(studentID,courseID,sectionID,year,semester);
    }
}
