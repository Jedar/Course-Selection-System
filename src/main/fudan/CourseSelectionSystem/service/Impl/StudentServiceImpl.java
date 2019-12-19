package main.fudan.CourseSelectionSystem.service.Impl;

import main.fudan.CourseSelectionSystem.consts.Constant;
import main.fudan.CourseSelectionSystem.dao.DaoRepository;
import main.fudan.CourseSelectionSystem.dao.StudentDao;
import main.fudan.CourseSelectionSystem.entity.Profile;
import main.fudan.CourseSelectionSystem.entity.SectionWithGrade;
import main.fudan.CourseSelectionSystem.entity.Student;
import main.fudan.CourseSelectionSystem.service.StudentService;
import main.fudan.CourseSelectionSystem.util.ExcelReader;

import java.util.List;
import java.util.Objects;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = DaoRepository.getStudentDao();

    @Override
    public boolean insertStudent(Student student) throws Exception {
        Profile profile = new Profile();
        profile.setProfile_id(student.getStudent_id());
        profile.setPassword(Constant.DEFAULT_PASSWORD);
        profile.setPermission(Constant.PERM_STUDENT);
        return studentDao.addStudentWithProfile(student,profile);
    }

    @Override
    public List<SectionWithGrade> getGradeList() {
        return null;
    }

    @Override
    public Number getGPA(String studentID) {
        Double GPA = studentDao.getGPA(studentID);
        if(GPA == null){
            return 0.0;
        }
        else{
            return GPA;
        }
    }

    @Override
    public Number getTotalCredit(String studentID) {
        Integer totalCredit = studentDao.getTotalCredit(studentID);
        if(totalCredit == null){
            return 0;
        }
        else{
            return totalCredit;
        }
    }

    @Override
    public boolean insertStudentsByExcel(String path) throws Exception {
        boolean allCorrect = true;
        StringBuilder errMsg = new StringBuilder();
        ExcelReader reader;
        try {
            reader = new ExcelReader(path,true);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        while (reader.hasNextLine()){
            /* |id|name|abbr| */
            Student student = new Student();
            List<String> list = reader.readNextLine();
            try {
                student.setStudent_id(list.get(0));
                student.setStudent_name(list.get(1));
                student.setSchool_abbr(list.get(2));
                allCorrect = insertStudent(student) && allCorrect;
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
    public List<Student> getStudentList() {
        return studentDao.getStudents();
    }
}
