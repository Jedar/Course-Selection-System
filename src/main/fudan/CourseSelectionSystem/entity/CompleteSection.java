package main.fudan.CourseSelectionSystem.entity;

/**
 * @ClassName CompleteSection
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 21:01
 * @Version 1.0
 **/
public class CompleteSection {
    private int course_id;
    private int section_id;
    private int year;
    private String semester;
    private int section_capacity;
    private String course_name;
    private int credits;
    private int credit_hours;
    private String school_abbr;
    private String building;
    private String room_number;

    @Override
    public String toString() {
        return "CompleteSection{" +
                "course_id=" + course_id +
                ", section_id=" + section_id +
                ", year=" + year +
                ", semester='" + semester + '\'' +
                ", section_capacity=" + section_capacity +
                ", course_name='" + course_name + '\'' +
                ", credits=" + credits +
                ", credit_hours=" + credit_hours +
                ", school_abbr='" + school_abbr + '\'' +
                ", building='" + building + '\'' +
                ", room_number='" + room_number + '\'' +
                '}';
    }
}
