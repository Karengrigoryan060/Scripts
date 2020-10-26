package urlreader;

import lombok.extern.log4j.Log4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static urlreader.Runner.EXCEL_FILE_PATH;

@Log4j
public class ExcelReader {

    private static ExcelReader excelReader;
    private static List<String> values;

    private ExcelReader() {
        values = new ArrayList<>();
    }

    public static ExcelReader getInstance() {
        if (excelReader == null) {
            excelReader = new ExcelReader();
        }
        return excelReader;
    }

    public void getExcelValue() {
        XSSFWorkbook xssfWork = readFromFile();
        int sheetCount = xssfWork.getNumberOfSheets();

        for (int i = 0; i < sheetCount; i++) {
            XSSFSheet sheet = xssfWork.getSheetAt(i);
            readSheet(sheet);
        }
        getURLs();
    }

    private void getURLs() {
        for (int i = 0; i < values.size(); i++) {
            System.out.println("{\n" +
                    "    \"url\": \"" + values.get(i) + "\"},");
        }
        System.out.println(values.size());
    }

    /**
     * Reading from file
     *
     * @return
     */
    private XSSFWorkbook readFromFile() {
        InputStream file = null;
        XSSFWorkbook sheets = null;
        try {
            file = new FileInputStream(EXCEL_FILE_PATH);
            sheets = new XSSFWorkbook(file);
        } catch (IOException e) {
            log.error(e.getMessage(), e.getCause());
        } finally {
            try {
                assert file != null;
                file.close();
            } catch (IOException e) {
                //ignore
            }
        }
        return sheets;
    }

    /**
     * Reading value from given sheet
     *
     * @param sheet
     */
    private void readSheet(XSSFSheet sheet) {
        Iterator rowItr = sheet.rowIterator();
        while (rowItr.hasNext()) {
            XSSFRow row = (XSSFRow) rowItr.next();
            for (int i = 0; i < 10; i++) {
                XSSFCell cell = row.getCell(i);
                try {
                    if (cell.getStringCellValue().contains("https://picsart.com"))
                        values.add(cell.getStringCellValue().replace("https://picsart.com", ""));
                } catch (Exception ignore) {
                }
            }
        }
    }
}
