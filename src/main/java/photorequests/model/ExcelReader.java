package photorequests.model;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static photorequests.Runner.EXCEL_FILE_PATH;

public class ExcelReader {

    List<Long> ids = new ArrayList<>();

    private XSSFWorkbook readFromFile() {
        InputStream file = null;
        XSSFWorkbook sheets = null;
        try {
            file = new FileInputStream(EXCEL_FILE_PATH);
            sheets = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
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

    public List<Long> getExcelValue() {
        XSSFWorkbook xssfWork = readFromFile();
        int sheetCount = xssfWork.getNumberOfSheets();

        for (int i = 0; i < sheetCount; i++) {
            XSSFSheet sheet = xssfWork.getSheetAt(i);
            readSheet(sheet);
        }
        return ids;
    }

    private void readSheet(XSSFSheet sheet) {
        Iterator rowItr = sheet.rowIterator();
        while (rowItr.hasNext()) {
            XSSFRow row = (XSSFRow) rowItr.next();
            try {
                if ((long) row.getCell(0).getNumericCellValue() == 0) {
                    continue;
                }
                ids.add((long) row.getCell(0).getNumericCellValue());
            } catch (IllegalStateException ignore) {
                //ignore
            }

        }
    }

}
