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

    public CriteriaSection(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "CriteriaSection{" +
                "name='" + name + '\'' +
                '}';
    }
}
