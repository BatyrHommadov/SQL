package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {


    public static List<Map<String, String>> read(String path, String sheetName) throws IOException {

        // Brings all the data from ROM in the raw form, into the java program or RAM
        FileInputStream fileInputStream = new FileInputStream(path);
        // Converts raw data to something that humans can understand
        // plus it has many methods to manipulate the data just like we
        // do in an Excel file
        XSSFWorkbook excelFile = new XSSFWorkbook(fileInputStream);
        // gets all the data from a specified Sheet
        Sheet sheet = excelFile.getSheet(sheetName);
        // Gives us the no of rows that contain the data
        int noOfRows = sheet.getPhysicalNumberOfRows();
        // A data structure that will contain all excel data in the form of an ArrayList of maps
        List<Map<String, String>> excelData = new ArrayList<>();
        // extracting row zero as it contains the keys(all of them)
        Row row0 = sheet.getRow(0);
        // A loop to go through all the rows start from row 1 because
        // row 0 contains the keys
        for (int i = 1; i < noOfRows; i++) {
            /*
            A map that will store keys always from row 0
            and values from all the rows one by one
             */
            LinkedHashMap<String, String> rowDataMap = new LinkedHashMap<>();
            // extracts the row every new iteration
            Row row = sheet.getRow(i);
            // extracts how many cells contain the data from that row
            int noOfCells = row.getPhysicalNumberOfCells();
            for (int j = 0; j < noOfCells; j++) {
                // extracting the keys from the row 0 one by one
                String key = row0.getCell(j).toString();
                // extracting all the values from the rows one by one
                String value = row.getCell(j).toString();
                //storing key value pairs inside the map
                rowDataMap.put(key, value);
            }
            // once the map is complete we put that map inside the arrayList
            excelData.add(rowDataMap);
        }
        return excelData;
    }
}
