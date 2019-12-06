package main.fudan.CourseSelectionSystem.service.Impl;

import main.fudan.CourseSelectionSystem.dao.DaoRepository;
import main.fudan.CourseSelectionSystem.dao.ExamDao;
import main.fudan.CourseSelectionSystem.dao.Impl.TeachesDao;
import main.fudan.CourseSelectionSystem.dao.SectionDao;
import main.fudan.CourseSelectionSystem.dao.TimeSlotDao;
import main.fudan.CourseSelectionSystem.entity.*;
import main.fudan.CourseSelectionSystem.service.SectionService;
import main.fudan.CourseSelectionSystem.util.ExcelReader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SectionServiceImpl implements SectionService {
    private SectionDao sectionDao = DaoRepository.getSectionDao();
    private TimeSlotDao timeSlotDao = DaoRepository.getTimeSlotDao();
    private ExamDao examDao = DaoRepository.getExamDao();
    private TeachesDao teachesDao = DaoRepository.getTeachesDao();

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
                List<TimeSlot> slotList = turnStringIntoTimeSlotList(list.get(7),time_slot_id);
                TimeSlot exam_slot = turnStringIntoTimeSlot(list.get(8),time_slot_id+1);
                Exam exam = new Exam();
                exam.setCourse_id(Integer.parseInt(list.get(0)));
                exam.setExam_time_slot_id(exam_slot.getTime_slot_id());
                exam.setSection_id(Integer.parseInt(list.get(1)));
                exam.setSemester(list.get(2));
                exam.setYear(Integer.parseInt(list.get(3)));
                exam.setExam_date(list.get(9));
                exam.setExam_type(list.get(10));
                List<Teaches> teachesList = turnStringIntoTeachesList(list.get(11),section);
                /* 在插入数据前应当做数据重复检测 */

                /* 检测无问题则开始插入数据 */
                for (TimeSlot ts : slotList){
                    timeSlotDao.addTimeSlot(ts);
                }
                timeSlotDao.addTimeSlot(exam_slot);
                examDao.addExam(exam);
                for (Teaches t : teachesList){
                    teachesDao.addTeaches(t);
                }
                allCorrect = insertSection(section) && allCorrect;
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
