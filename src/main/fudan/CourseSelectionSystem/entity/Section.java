package main.fudan.CourseSelectionSystem.entity;

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
}