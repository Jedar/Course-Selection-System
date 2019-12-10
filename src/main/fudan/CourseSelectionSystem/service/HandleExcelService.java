package main.fudan.CourseSelectionSystem.service;

public interface HandleExcelService {
    public boolean handleSchoolExcel(String path) throws Exception;

    public boolean handleCourseExcel(String path) throws Exception;

    public boolean handleClassRoom(String path) throws Exception;
}
