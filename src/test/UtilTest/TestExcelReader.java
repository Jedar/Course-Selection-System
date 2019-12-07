package test.UtilTest;

import main.fudan.CourseSelectionSystem.util.ExcelReader;

public class TestExcelReader {
    public static void main(String[] args) {
        try {
            ExcelReader reader = new ExcelReader("resources/data/manager.xlsx",true);
            while (reader.hasNextLine()){
                System.out.println(reader.readNextLine());
            }
            System.out.println(reader.readAllLines());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
