package main.fudan.CourseSelectionSystem.entity;

import java.sql.Date;

/**
 * @ClassName SectionWithGrade
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/5 22:45
 * @Version 1.0
 **/
public class SectionWithGrade {
    private int course_id;
    private int section_id;
    private int year;
    private String semester;
    private String course_name;
    private int credits;
    private String level;

    public SectionWithGrade() {

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
