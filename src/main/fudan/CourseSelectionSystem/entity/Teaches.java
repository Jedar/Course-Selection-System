package main.fudan.CourseSelectionSystem.entity;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @ClassName Teaches
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 20:54
 * @Version 1.0
 **/
public class Teaches {
    private int course_id;
    private int section_id;
    private int year;
    private String semester;
    private String teacher_id;
    private String course_name;
    private List<Student> studentList;

    public Teaches() {

    }

    public Teaches(int course_id, int section_id, int year, String semester, String teacher_id) {
        this.course_id = course_id;
        this.section_id = section_id;
        this.year = year;
        this.semester = semester;
        this.teacher_id = teacher_id;
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

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Teaches{" +
                "course_id=" + course_id +
                ", section_id=" + section_id +
                ", year=" + year +
                ", semester='" + semester + '\'' +
                ", teacher_id='" + teacher_id + '\'' +
                ", course_name='" + course_name + '\'' +
                '}';
    }
}
