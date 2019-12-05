package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.Exam;
import main.fudan.CourseSelectionSystem.entity.TimeSlot;

public interface ExamDao {
    public boolean addExam(Exam exam);
}
