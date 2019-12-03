package main.fudan.CourseSelectionSystem.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyRepository {
    private Properties jdbc;

    private PropertyRepository(){
        InputStream jdbcIs = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        jdbc = new Properties();
        try {
            jdbc.load(jdbcIs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getJdbcProperties(){
        return jdbc;
    }

    private static PropertyRepository ins;

    static {
        ins = new PropertyRepository();
    }

    public static PropertyRepository getInstance(){
        return ins;
    }
}
