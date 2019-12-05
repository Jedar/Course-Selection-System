package main.fudan.CourseSelectionSystem.entity;

/**
 * @ClassName StuGradeInfo
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/4 22:45
 * @Version 1.0
 **/
public class StuGradeInfo {
    private String student_id;
    private int credits;
    private double gpa;

    public StuGradeInfo() {

    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
