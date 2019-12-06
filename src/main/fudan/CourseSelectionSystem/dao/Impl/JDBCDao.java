package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.util.PropertyRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.*;

public class JDBCDao<T> implements BaseDao<T> {
    private BasicDataSource dataSource = null;

    public JDBCDao(){
        /* 获取配置文件内容 */
        Properties properties = PropertyRepository.getInstance().getJdbcProperties();
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        /* 初始化数据库 */
        dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driver);

        int initSize = Integer.parseInt(properties.getProperty("ds_init_size"));
        int minIdle = Integer.parseInt(properties.getProperty("ds_min_idle"));;
        int maxWait = Integer.parseInt(properties.getProperty("ds_max_wait"));
        int maxIdle = Integer.parseInt(properties.getProperty("ds_max_idle"));

        /* 设置连接池连接属性 */
        dataSource.setInitialSize(initSize);
        dataSource.setMaxWaitMillis(maxWait);
        dataSource.setMinIdle(minIdle);
    }

    @Override
    public <E> E getForValue(String sql, Object... args) {
        return null;
    }

    @Override
    public List<T> getForList(Class<T> clazz, String sql, Object... args) {
        List<T> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            /* 获取连接 */
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            conn = dataSource.getConnection();

            /* 放入参数 */
            int idx = 1;
            for(Object object:args){
                ps.setObject(idx++,object);
            }

            /* 执行语句 */
            resultSet = ps.executeQuery();

            /* 将结果放置于对象中 */
            Map<String,Object> map = new HashMap<>();
            T entity;
            while (resultSet.next()){
                ResultSetMetaData metaData = resultSet.getMetaData();
                int column = metaData.getColumnCount();
                for(int i = 0; i < column; i++){
                    String key = metaData.getColumnName(i+1);
                    Object value = resultSet.getObject(key);
                    map.put(key,value);
                }
                /* 利用反射得到实例 */
                entity = clazz.getDeclaredConstructor().newInstance();
                for(Map.Entry<String,Object> entry:map.entrySet()){
                    String name = entry.getKey();
                    Object value = entry.getValue();
                    BeanUtils.setProperty(entity,name,value);
                }

                list.add(entity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /* 释放连接 */
            release(resultSet,ps,conn);
        }
        return list;
    }

    @Override
    public T get(Class<T> clazz, String sql, Object... args) {
        T entity = null;

        List<T> list = getForList(clazz,sql,args);

        if(!list.isEmpty()){
            return list.get(0);
        }

        /* 返回值可能为空 */
        return entity;
    }

    @Override
    public boolean update(String sql, Object... args) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        int exeNum = 0;
        try {
            /* 获取连接 */
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);

            /* 放置参数 */
            int idx = 1;
            for(Object object:args){
                ps.setObject(idx++,object);
            }

            /* 执行语句 */
            exeNum = ps.executeUpdate();
        }finally {
            /* 释放连接 */
            release(null,ps,conn);
        }

        return (exeNum > 0);
    }

    @Override
    public boolean transactionUpdate(List<String> sqls, List<List<Object>> args) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        int exeNum = 0;
        try {
            /* 获取连接 */
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            for(int i = 0; i < sqls.size(); i++) {
                ps = conn.prepareStatement(sqls.get(i));

                /* 放置参数 */
                int idx = 1;
                for(Object object : args.get(i)) {
                    ps.setObject(idx++, object);
                }

                /*执行语句*/
                exeNum += ps.executeUpdate();
            }

            /*提交执行*/
            conn.commit();
        }finally {
            release(null,ps,conn);
        }
        return exeNum > 0;
    }

    @Override
    public boolean batch(Class<T> clazz, String sql, Object... args) {
        return false;
    }

    private void release(ResultSet rs, Statement statement, Connection conn){
        if(rs != null){
            try {
                rs.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try{
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
