package main.fudan.CourseSelectionSystem.entity;

import java.util.Date;

public class Exam {
    private int exam_time_slot_id;
    private String exam_date;
    private String exam_type;
    private int course_id;
    private int section_id;
    private int year;
    private String semester;

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

    @Override
    public String toString() {
        return "Exam{" +
                "exam_time_slot_id=" + exam_time_slot_id +
                ", exam_date=" + exam_date +
                ", exam_type='" + exam_type + '\'' +
                ", course_id=" + course_id +
                ", section_id=" + section_id +
                ", year=" + year +
                ", semester='" + semester + '\'' +
                '}';
    }
}