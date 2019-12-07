package main.fudan.CourseSelectionSystem.util;

import main.fudan.CourseSelectionSystem.entity.TimeSlot;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<TimeSlot> getTimeSlotListByString(String string){
        List<TimeSlot> list = new ArrayList<>();
        String[] slots = string.split(" ");
        for (String str : slots){
            list.add(getTimeSlotByString(str));
        }
        return list;
    }

    public static TimeSlot getTimeSlotByString(String string){
        String[] items = string.split(",");
        TimeSlot ts = new TimeSlot();
        /* 注意返回的id值未确定 */
        ts.setTime_slot_id(-1);
        ts.setDay(items[0]);
        String[] times = items[1].split("-");
        ts.setStart_time(Integer.parseInt(times[0]));
        ts.setEnd_time(Integer.parseInt(times[1]));
        return ts;
    }
}
