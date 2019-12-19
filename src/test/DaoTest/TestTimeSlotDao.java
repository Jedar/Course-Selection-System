package test.DaoTest;

import main.fudan.CourseSelectionSystem.dao.Impl.TimeSlotDaoImpl;
import main.fudan.CourseSelectionSystem.dao.TimeSlotDao;

public class TestTimeSlotDao {
    private static TimeSlotDao dao = new TimeSlotDaoImpl();

    public static void main(String[] args) {
        System.out.println(dao.getMaxTimeSlotID());
    }
}
