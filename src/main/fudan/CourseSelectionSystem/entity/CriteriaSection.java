package main.fudan.CourseSelectionSystem.entity;

/**
 * @ClassName CriteriaSection
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 20:01
 * @Version 1.0
 **/
public class CriteriaSection {
    private String name;
    private int CourseID = -1;
    private int SectionID = -1;

    public CriteriaSection() {

    }

    public CriteriaSection(String name, int courseID, int sectionID) {
        this.name = name;
        CourseID = courseID;
        SectionID = sectionID;
    }

    public String getName() {
        if(name == null)
            return "%%";
        else
            return "%" + name + "%";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseID() {
        if(CourseID == -1)
            return "%%";
        else
            return "%" + CourseID + "%";
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

    public String getSectionID() {
        if(SectionID == -1)
            return "%%";
        else
            return "%" + SectionID + "%";
    }

    public void setSectionID(int sectionID) {
        SectionID = sectionID;
    }

    @Override
    public String toString() {
        return "CriteriaSection{" +
                "name='" + name + '\'' +
                '}';
    }
}
