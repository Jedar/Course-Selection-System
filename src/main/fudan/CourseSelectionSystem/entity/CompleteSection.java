package main.fudan.CourseSelectionSystem.entity;

/**
 * @ClassName CompleteSection
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 21:01
 * @Version 1.0
 **/
public class CompleteSection {
    private int course_id;
    private int section_id;
    private int year;
    private String semester;
    private String current_student_num;
    private int section_capacity;
    private String course_name;
    private int credits;
    private int credit_hours;
    private String school_abbr;
    private String building;
    private String room_number;
    private String course_time;
    private String exam_date;
    private String exam_type;
    private String exam_time;
    private String teachers;

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getSection_id() {
        return section_id;
    }

    public void setSection_id(int section_id) {
        this.section_id = section_id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCurrent_student_num() {
        return current_student_num;
    }

    public void setCurrent_student_num(String current_student_num) {
        this.current_student_num = current_student_num;
    }

    public int getSection_capacity() {
        return section_capacity;
    }

    public void setSection_capacity(int section_capacity) {
        this.section_capacity = section_capacity;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCredit_hours() {
        return credit_hours;
    }

    public void setCredit_hours(int credit_hours) {
        this.credit_hours = credit_hours;
    }

    public String getSchool_abbr() {
        return school_abbr;
    }

    public void setSchool_abbr(String school_abbr) {
        this.school_abbr = school_abbr;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getCourse_time() {
        return course_time;
    }

    public void setCourse_time(String course_time) {
        this.course_time = course_time;
    }

    public String getExam_date() {
        return exam_date;
    }

    public void setExam_date(String exam_date) {
        this.exam_date = exam_date;
    }

    public String getExam_type() {
        return exam_type;
    }

    public void setExam_type(String exam_type) {
        this.exam_type = exam_type;
    }

    public String getExam_time() {
        return exam_time;
    }

    public void setExam_time(String exam_time) {
        this.exam_time = exam_time;
    }

    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "CompleteSection{" +
                "course_id=" + course_id +
                ", section_id=" + section_id +
                ", year=" + year +
                ", semester='" + semester + '\'' +
                ", section_capacity=" + section_capacity +
                ", course_name='" + course_name + '\'' +
                ", credits=" + credits +
                ", credit_hours=" + credit_hours +
                ", school_abbr='" + school_abbr + '\'' +
                ", building='" + building + '\'' +
                ", room_number='" + room_number + '\'' +
                '}';
    }
}
