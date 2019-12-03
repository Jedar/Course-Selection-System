package main.fudan.CourseSelectionSystem.entity;

/**
 * @ClassName Teacher
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 19:20
 * @Version 1.0
 **/
public class Teacher {
    private String teacher_id;
    private String teacher_name;
    private String title;
    private String school_abbr;

    public Teacher() {

    }

    public Teacher(String teacher_id, String teacher_name, String title, String school_abbr) {
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.title = title;
        this.school_abbr = school_abbr;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSchool_abbr() {
        return school_abbr;
    }

    public void setSchool_abbr(String school_abbr) {
        this.school_abbr = school_abbr;
    }
}
