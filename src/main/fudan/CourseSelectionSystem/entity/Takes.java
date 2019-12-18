package main.fudan.CourseSelectionSystem.entity;

import java.sql.Date;

/**
 * @ClassName Takes
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 19:48
 * @Version 1.0
 **/
public class Takes {
    private String student_id;
    private int course_id;
    private int section_id;
    private int year;
    private String semester;
    private String level;
    private boolean drop_flag;

    public Takes() {

    }


    public Takes( String student_id, int course_id, int section_id, int year, String semester, String level, boolean drop_flag) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.section_id = section_id;
        this.year = year;
        this.semester = semester;
        this.level = level;
        this.drop_flag = drop_flag;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id( String student_id) {
        this.student_id = student_id;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isDrop_flag() {
        return drop_flag;
    }

    public void setDrop_flag(boolean drop_flag) {
        this.drop_flag = drop_flag;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Takes{" +
                "student_id=" + student_id +
                ", course_id=" + course_id +
                ", section_id=" + section_id +
                ", year=" + year +
                ", semester='" + semester + '\'' +
                ", level='" + level + '\'' +
                ", drop_flag=" + drop_flag +
                '}';
    }
}
