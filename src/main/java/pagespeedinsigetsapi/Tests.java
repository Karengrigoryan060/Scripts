package pagespeedinsigetsapi;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pagespeedinsigetsapi.models.MongoResult;
import pagespeedinsigetsapi.models.Result;
import pagespeedinsigetsapi.models.TestData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static pagespeedinsigetsapi.Service.DEVICE;
import static pagespeedinsigetsapi.Service.REQUEST_BASE_URL;

public class Tests {

    static List<MongoResult> mongoResults = new ArrayList<>();

    @DataProvider
    public Object[] testData() {
        List<TestData> testData = Service.getInstance().readFromFile();
        Object[] result = new Object[testData.size()];
        for (int i = 0; i < testData.size(); i++) {
            result[i] = testData.get(i).getUrl();
        }
        return result;
    }

    @Test(dataProvider = "testData")
    public void test(String url) {
        Result request = Service.getInstance().getResult(url);
        MongoResult mongoResult = new MongoResult(18, LocalDate.now().toString(), REQUEST_BASE_URL, url, DEVICE,
                (int) (request.getLighthouseResult().getCategories().getPerformance().getScore() * 100));
        mongoResults.add(mongoResult);
        System.out.println(mongoResult);
    }

    @AfterSuite
    public void saveData() {
        Service.getInstance().saveResultToMongo(mongoResults);

    }
}
