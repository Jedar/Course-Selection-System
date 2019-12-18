package main.fudan.CourseSelectionSystem.entity;

import java.sql.Date;

/**
 * @ClassName Request
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 19:22
 * @Version 1.0
 **/
public class Request {
    private String student_id;
    private int course_id;
    private int section_id;
    private Date year;
    private String semester;
    private String request_content;
    private String pass_or_not;
    private String reply_content;

    public Request() {

    }

    public Request(String student_id, int course_id, int section_id, Date year, String semester, String request_content, String pass_or_not, String reply_content) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.section_id = section_id;
        this.year = year;
        this.semester = semester;
        this.request_content = request_content;
        this.pass_or_not = pass_or_not;
        this.reply_content = reply_content;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
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

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getRequest_content() {
        return request_content;
    }

    public void setRequest_content(String request_content) {
        this.request_content = request_content;
    }

    public String getPass_or_not() {
        return pass_or_not;
    }

    public void setPass_or_not(String pass_or_not) {
        this.pass_or_not = pass_or_not;
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    @Override
    public String toString() {
        return "Request{" +
                "student_id='" + student_id + '\'' +
                ", course_id=" + course_id +
                ", section_id=" + section_id +
                ", year=" + year +
                ", semester='" + semester + '\'' +
                ", request_content='" + request_content + '\'' +
                ", pass_or_not='" + pass_or_not + '\'' +
                ", reply_content='" + reply_content + '\'' +
                '}';
    }
}
