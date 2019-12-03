package main.fudan.CourseSelectionSystem.entity;

/**
 * @ClassName CourseDao
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 19:21
 * @Version 1.0
 **/
public class Course {
    private int course_id;
    private String course_name;
    private int credits;
    private int credit_hours;
    private String school_abbr;

    public Course() {

    }

    public Course(int course_id, String course_name, int credits, int credit_hours, String school_abbr) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.credits = credits;
        this.credit_hours = credit_hours;
        this.school_abbr = school_abbr;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
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
}
