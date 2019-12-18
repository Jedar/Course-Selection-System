package main.fudan.CourseSelectionSystem.entity;

import java.sql.Date;
import java.time.Year;

/**
 * @ClassName Section
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 19:21
 * @Version 1.0
 **/
public class Section {
    private int course_id;
    private int section_id;
    private int year;
    private String semester;
    private int section_capacity;
    private String building;
    private String room_number;
    private int time_slot_id;

    public Section() {

    }

    public Section(int course_id, int section_id, int year, String semester, int section_capacity, String building, String room_number, int time_slot_id) {
        this.course_id = course_id;
        this.section_id = section_id;
        this.year = year;
        this.semester = semester;
        this.section_capacity = section_capacity;
        this.building = building;
        this.room_number = room_number;
        this.time_slot_id = time_slot_id;
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

    public int getSection_capacity() {
        return section_capacity;
    }

    public void setSection_capacity(int section_capacity) {
        this.section_capacity = section_capacity;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public int getTime_slot_id() {
        return time_slot_id;
    }

    public void setTime_slot_id(int time_slot_id) {
        this.time_slot_id = time_slot_id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Section{" +
                "course_id=" + course_id +
                ", section_id=" + section_id +
                ", year=" + year +
                ", semester='" + semester + '\'' +
                ", section_capacity=" + section_capacity +
                ", building='" + building + '\'' +
                ", room_number='" + room_number + '\'' +
                ", time_slot_id=" + time_slot_id +
                '}';
    }
}
