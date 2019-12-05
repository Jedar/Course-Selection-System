package main.fudan.CourseSelectionSystem.dao;

import java.util.List;

public interface BaseDao<T>{

    <E> E getForValue(String sql, Object ... args);

    List<T> getForList(Class<T> clazz, String sql, Object... args);

    T get(Class<T> clazz, String sql, Object... args);

    boolean update(Class<T> clazz, String sql, Object... args);

    boolean batch(Class<T> clazz, String sql, Object... args);
}