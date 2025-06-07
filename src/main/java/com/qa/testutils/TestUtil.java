package com.qa.testutils;

import com.qa.base.TestBase;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;

    public static String TESTDATA_SHEET_PATH = "C:\\Users\\prudh.000\\IdeaProjects\\PRANITHA_DEMO\\src\\main\\java\\com\\qa\\testdata\\testdata.xlsx";

    public static Sheet sheet;
    public static Workbook book;
    public static Object[][] getTestData(String sheetName){
        FileInputStream ip = null;
        try{
            ip= new FileInputStream(TESTDATA_SHEET_PATH);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(ip);

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i=0;i<sheet.getLastRowNum();i++){
            for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }
}
