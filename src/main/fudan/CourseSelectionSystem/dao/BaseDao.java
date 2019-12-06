package main.fudan.CourseSelectionSystem.dao;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T>{

    <E> E getForValue(String sql, Object ... args);

    List<T> getForList(Class<T> clazz, String sql, Object... args);

    T get(Class<T> clazz, String sql, Object... args);

    boolean update(String sql, Object... args) throws SQLException;

    boolean transactionUpdate(List<String> sqls, List<List<Object>> args) throws SQLException;

    boolean batch(Class<T> clazz, String sql, Object... args);
}