package urlreader;

public class Runner {

    public static final String EXCEL_FILE_PATH = "/Users/karengrigoryan/Desktop/Website Structure.xlsx";

    public static void main(String[] args) {
        ExcelReader.getInstance().getExcelValue();
    }

}
