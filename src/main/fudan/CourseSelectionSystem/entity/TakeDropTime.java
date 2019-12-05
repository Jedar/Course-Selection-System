package main.fudan.CourseSelectionSystem.entity;

import java.sql.Timestamp;

/**
 * @ClassName TakeDropTime
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/5 19:03
 * @Version 1.0
 **/
public class TakeDropTime {
    private int year;
    private String semester;
    private Timestamp take_start_time;
    private Timestamp take_end_time;
    private Timestamp drop_start_time;
    private Timestamp drop_end_time;

    public TakeDropTime() {

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

    public Timestamp getTake_start_time() {
        return take_start_time;
    }

    public void setTake_start_time(Timestamp take_start_time) {
        this.take_start_time = take_start_time;
    }

    public Timestamp getTake_end_time() {
        return take_end_time;
    }

    public void setTake_end_time(Timestamp take_end_time) {
        this.take_end_time = take_end_time;
    }

    public Timestamp getDrop_start_time() {
        return drop_start_time;
    }

    public void setDrop_start_time(Timestamp drop_start_time) {
        this.drop_start_time = drop_start_time;
    }

    public Timestamp getDrop_end_time() {
        return drop_end_time;
    }

    public void setDrop_end_time(Timestamp drop_end_time) {
        this.drop_end_time = drop_end_time;
    }
}
