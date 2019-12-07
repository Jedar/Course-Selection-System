package main.fudan.CourseSelectionSystem.dao.Impl;

import main.fudan.CourseSelectionSystem.dao.BaseDao;
import main.fudan.CourseSelectionSystem.dao.ProfileDao;
import main.fudan.CourseSelectionSystem.entity.Profile;

import java.sql.SQLException;
import java.util.List;

public class ProfileDaoImpl implements ProfileDao {
    private BaseDao<Profile> dao = new JDBCDao<>();

    @Override
    public boolean addProfile(Profile profile) throws SQLException {
        String profileSql = "INSERT INTO `course_selection_system`.`profile`\n" +
                "(`profile_id`,\n" +
                "`password`,\n" +
                "`permission`)\n" +
                "VALUES\n" +
                "(?,?,?);\n";
        return dao.update(profileSql, profile.getProfile_id(),profile.getPassword(),profile.getPermission());
    }

    @Override
    public Profile getProfile(String ID) {
        String sql = "SELECT `profile`.`profile_id`,\n" +
                "    `profile`.`password`,\n" +
                "    `profile`.`permission`\n" +
                "FROM `course_selection_system`.`profile`" +
                "WHERE profile_id = ?";
        return dao.get(Profile.class, sql, ID);
    }

    @Override
    public boolean checkExist(String ID, String passwd) {
        String sql = "SELECT `profile`.`profile_id`,\n" +
                "    `profile`.`password`,\n" +
                "    `profile`.`permission`\n" +
                "FROM `course_selection_system`.`profile`" +
                "WHERE profile_id = ? AND password = ?";
        List<Profile> profiles = dao.getForList(Profile.class, sql, ID, passwd);
        return profiles.size() == 1;
    }
}
