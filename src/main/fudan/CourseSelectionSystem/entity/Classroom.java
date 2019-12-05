package main.fudan.CourseSelectionSystem.entity;

/**
 * @ClassName Classroom
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/4 15:02
 * @Version 1.0
 **/
public class Classroom {
    String building;
    String room_number;
    int classroom_capacity;

    public Classroom() {

    }

    public Classroom(String building, String room_number, int classroom_capacity) {
        this.building = building;
        this.room_number = room_number;
        this.classroom_capacity = classroom_capacity;
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

    public int getClassroom_capacity() {
        return classroom_capacity;
    }

    public void setClassroom_capacity(int classroom_capacity) {
        this.classroom_capacity = classroom_capacity;
    }
}
