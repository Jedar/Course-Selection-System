package main.fudan.CourseSelectionSystem.dao;

import main.fudan.CourseSelectionSystem.entity.Teaches;

import java.util.List;

public interface TeachesDao {
    public boolean addTeaches(Teaches teaches);

    public List<Teaches> getTeaches();
}
