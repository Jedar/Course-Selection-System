package main.fudan.CourseSelectionSystem.entity;

import java.sql.Date;

public class Exam {
    private int exam_time_slot_id;
    private String exam_date;
    private String exam_type;
    private int course_id;
    private int section_id;
    private int year;
    private String semester;
    private String exam_building;
    private String exam_room_number;

    public Exam() {

    }

    public Exam(int exam_time_slot_id, String exam_date, String exam_type, int course_id, int section_id, int year, String semester, String exam_building, String exam_room_number) {
        this.exam_time_slot_id = exam_time_slot_id;
        this.exam_date = exam_date;
        this.exam_type = exam_type;
        this.course_id = course_id;
        this.section_id = section_id;
        this.year = year;
        this.semester = semester;
        this.exam_building = exam_building;
        this.exam_room_number = exam_room_number;
    }

    public int getExam_time_slot_id() {
        return exam_time_slot_id;
    }

    public void setExam_time_slot_id(int exam_time_slot_id) {
        this.exam_time_slot_id = exam_time_slot_id;
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

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getExam_building() {
        return exam_building;
    }

    public void setExam_building(String exam_building) {
        this.exam_building = exam_building;
    }

    public String getExam_room_number() {
        return exam_room_number;
    }

    public void setExam_room_number(String exam_room_number) {
        this.exam_room_number = exam_room_number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "exam_time_slot_id=" + exam_time_slot_id +
                ", exam_date='" + exam_date + '\'' +
                ", exam_type='" + exam_type + '\'' +
                ", course_id=" + course_id +
                ", section_id=" + section_id +
                ", year=" + year +
                ", semester='" + semester + '\'' +
                ", exam_building='" + exam_building + '\'' +
                ", exam_room_number='" + exam_room_number + '\'' +
                '}';
    }
}
