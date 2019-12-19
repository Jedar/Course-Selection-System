package main.fudan.CourseSelectionSystem.service.Impl;

import main.fudan.CourseSelectionSystem.dao.*;
import main.fudan.CourseSelectionSystem.entity.*;
import main.fudan.CourseSelectionSystem.service.SectionService;
import main.fudan.CourseSelectionSystem.util.ExcelReader;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SectionServiceImpl implements SectionService {
    private SectionDao sectionDao = DaoRepository.getSectionDao();
    private TimeSlotDao timeSlotDao = DaoRepository.getTimeSlotDao();
    private ExamDao examDao = DaoRepository.getExamDao();
    private TeachesDao teachesDao = DaoRepository.getTeachesDao();
    private StudentDao studentDao = DaoFactory.getInstance().getStudentDao();

    @Override
    public boolean insertSection(Section section) {
//        return sectionDao.addSection(section);
        return false;
    }

    @Override
    public boolean insertSectionsByExcel(String path) throws Exception {
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
            Section section = new Section();
            List<String> list = reader.readNextLine();
            try {
                section.setCourse_id(Integer.parseInt(list.get(0)));
                section.setSection_id(Integer.parseInt(list.get(1)));
                section.setSemester(list.get(2));
                section.setYear(Integer.parseInt(list.get(3)));
                section.setSection_capacity(Integer.parseInt(list.get(4)));
                section.setBuilding(list.get(5));
                section.setRoom_number(list.get(6));
                int time_slot_id = timeSlotDao.getMaxTimeSlotID() + 1;
                section.setTime_slot_id(time_slot_id);
                List<TimeSlot> slotList = turnStringIntoTimeSlotList(list.get(7),time_slot_id);
                TimeSlot exam_slot = turnStringIntoTimeSlot(list.get(8),time_slot_id+1);
                Exam exam = new Exam();
                exam.setCourse_id(Integer.parseInt(list.get(0)));
                exam.setExam_time_slot_id(exam_slot.getTime_slot_id());
                exam.setSection_id(Integer.parseInt(list.get(1)));
                exam.setSemester(list.get(2));
                exam.setYear(Integer.parseInt(list.get(3)));
                /* TODO： 2019需要在表中加入 */
                exam.setExam_date("2019-"+list.get(10));
                exam.setExam_type(list.get(9));
                exam.setExam_building(list.get(11));
                exam.setExam_room_number(list.get(12));
                List<Teaches> teachesList = turnStringIntoTeachesList(list.get(13),section);
                /* 在插入数据前应当做数据重复检测 */

                /* 检测无问题则开始插入数据 */
                allCorrect = sectionDao.addSection(section,exam,slotList,exam_slot,teachesList) && allCorrect;
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
    public List<CompleteSection> searchSections(CriteriaSection criteriaSection) {
        return sectionDao.getCriteriaSectionList(criteriaSection);
    }

    @Override
    public List<CompleteSection> getCourseListOfStudent(String studentID) {
        return studentDao.getSelectedSectionList(studentID);
    }

    @Override
    public List<SectionWithGrade> getSectionWithGradeList(String studentID) {
        return studentDao.getSectionWithGradeList(studentID);
    }

    public boolean deleteSection(Section section) throws SQLException {
        return sectionDao.deleteSection(section.getCourse_id(),section.getSection_id(),section.getYear(),section.getSemester());
    }

    @Override
    public List<CompleteSection> getCourseList() {
        return sectionDao.getSectionList();
    }

    private List<TimeSlot> turnStringIntoTimeSlotList(String slots, int id){
        String[] slot_time = slots.split(" ");
        List<TimeSlot> list = new ArrayList<>();
        for (String str: slot_time){
            list.add(turnStringIntoTimeSlot(str,id));
        }
        return list;
    }

    private TimeSlot turnStringIntoTimeSlot(String slot, int id){
        String[] items = slot.split(",");
        TimeSlot ts = new TimeSlot();
        ts.setDay(items[0]);
        ts.setTime_slot_id(id);
        String[] times = items[1].split("-");
        ts.setStart_time(Integer.parseInt(times[0]));
        ts.setEnd_time(Integer.parseInt(times[1]));
        return ts;
    }

    private List<Teaches> turnStringIntoTeachesList(String teachers, Section section){
        String[] teacher_ids = teachers.split(",");
        List<Teaches> list = new ArrayList<>();
        for (String str : teacher_ids){
            list.add(turnStringIntoTeaches(str,section));
        }
        return list;
    }

    private Teaches turnStringIntoTeaches(String teachers, Section section){
        Teaches teaches = new Teaches();
        teaches.setCourse_id(section.getCourse_id());
        teaches.setSection_id(section.getSection_id());
        teaches.setSemester(section.getSemester());
        teaches.setYear(section.getYear());
        teaches.setTeacher_id(teachers);
        return teaches;
    }
}
