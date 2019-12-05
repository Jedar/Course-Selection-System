package main.fudan.CourseSelectionSystem.entity;

/**
 * @ClassName School
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 20:55
 * @Version 1.0
 **/
public class School {
    private String abbr;
    private String name;

    public School() {

    }

    public School(String abbr, String name) {
        this.abbr = abbr;
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "School{" +
                "abbr='" + abbr + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
