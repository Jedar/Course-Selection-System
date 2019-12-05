package main.fudan.CourseSelectionSystem.entity;

public class Manager {
    private String manager_id;
    private String contact;

    public String getManager_id() {
        return manager_id;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "manager_id='" + manager_id + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
