package main.fudan.CourseSelectionSystem.entity;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 18:51
 * @Version 1.0
 **/
public class Student {
    private String student_id;
    private String student_name;
    private String school_abbr;

    public Student() {

    }

    public Student(String student_id, String student_name, String school_abbr) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.school_abbr = school_abbr;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getSchool_abbr() {
        return school_abbr;
    }

    public void setSchool_abbr(String school_abbr) {
        this.school_abbr = school_abbr;
    }
}
