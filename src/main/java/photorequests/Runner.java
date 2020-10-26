package photorequests;

import photorequests.model.ExcelReader;

import java.util.List;

public class Runner {

    public static final String REQUEST_URL = "https://api.picsart.com/photos/shutterstock/url?ids={ids}&action=post";
    public static final String TOKEN = "e361d76f-c4dd-470a-a0e6-a1660da3610a";
    public static String EXCEL_FILE_PATH = "/Users/karengrigoryan/Downloads/ShutterstockSep.xlsx";


    public static void main(String[] args) throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        List<Long> excelValue = new ExcelReader().getExcelValue();

        int a = 0;

        for (int i = 1; i < excelValue.size() / 10; i++) {
            Thread thread = null;
            for (int j = 1; j < 10; j++) {
                try {
                    thread = new Script(excelValue.get(a));
                    thread.start();
                    a++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            assert thread != null;
            thread.join();
        }
        System.out.println("Duration of run is : " + (System.currentTimeMillis() - currentTimeMillis));
    }
}


