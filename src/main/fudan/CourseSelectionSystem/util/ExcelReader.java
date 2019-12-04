package main.fudan.CourseSelectionSystem.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ExcelReader
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/12/3 21:16
 * @Version 1.0
 **/
public class ExcelReader {
    /* path of the excel file */
    private String path;
    /* excel object */
    private Workbook wb;
    /* escape first line or not */
    private boolean escapeFlag;
    /* line index */
    private int lineIndex;
    /* sheet name */
    private Sheet sheet;
    /* initialize sheet with sheet name */
    public ExcelReader(String path, String sheetName, boolean flag) throws Exception {
        escapeFlag = flag;
        lineIndex = (flag)?1:0;
        this.path = path;
        File file = new File(path);
        FileInputStream fis;
        if (!file.exists()){
            throw new Exception("Excel file not exist");
        }
        if (path.endsWith("xls")){
            fis = new FileInputStream(file);
            wb = new HSSFWorkbook(fis);
        }
        else if(path.endsWith("xlsx")){
            wb = new XSSFWorkbook(file);
        }
        else {
            throw new Exception("Excel file type error");
        }
        wb.getSheetAt(0);
        sheet = wb.getSheet(sheetName);
    }

    /* initialize sheet by first sheet */
    public ExcelReader(String path, boolean flag) throws Exception {
        escapeFlag = flag;
        lineIndex = (flag)?1:0;
        this.path = path;
        File file = new File(path);
        FileInputStream fis;
        if (!file.exists()){
            throw new Exception("Excel file not exist");
        }
        if (path.endsWith("xls")){
            fis = new FileInputStream(file);
            wb = new HSSFWorkbook(fis);
        }
        else if(path.endsWith("xlsx")){
            wb = new XSSFWorkbook(file);
        }
        else {
            throw new Exception("Excel file type error");
        }
        sheet = wb.getSheetAt(0);
    }

    public List<String> readNextLine(){
        return readLineByNumber(lineIndex++);
    }

    public boolean hasNextLine(){
        return isLineInRange(lineIndex);
    }

    public List<List<String>> readAllLines(){
        List<List<String>> res = new ArrayList<>();
        int line = (escapeFlag)?1:0;
        while (isLineInRange(line)){
            res.add(readLineByNumber(line));
            line++;
        }
        return res;
    }

    private List<String> readLineByNumber(int num){
        List<String> list = new ArrayList<>();
        if (!isLineInRange(num)){
            return list;
        }
        Row row = sheet.getRow(num);
        int left = row.getFirstCellNum();
        int right = row.getLastCellNum();
        for (int i = left; i < right; i++){
            list.add(row.getCell(i).getStringCellValue());
        }
        return list;
    }

    private boolean isLineInRange(int num){
        return num <= sheet.getLastRowNum();
    }
}
