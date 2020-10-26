package pagespeedinsigetsapi;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import lombok.SneakyThrows;
import org.json.JSONArray;
import pagespeedinsigetsapi.models.MongoResult;
import pagespeedinsigetsapi.models.Result;
import pagespeedinsigetsapi.models.TestData;

import java.io.File;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Service {

    public static final String GOOGLE_API_URL = "https://www.googleapis.com/pagespeedonline/v5/runPagespeed";
    public static final String REQUEST_BASE_URL = "https://picsart.com";
    public static final String API_KEY = "AIzaSyDNI-312NnqKt55JB10twHLY7vpMjbhUXI";
    public static final String DEVICE = "mobile";
    public static final String SERVER_URL = "http://18.158.59.66:8090/lighthouse";

    private Service() {
    }

    public static Service getInstance() {
        return new Service();
    }

    public Result getResult(String url) {
        String core = "%s?url=%s%s&key=%s&strategy=%s";
        String fullUrl = String.format(core, GOOGLE_API_URL, REQUEST_BASE_URL, url, API_KEY, DEVICE);
        HttpResponse<String> stringHttpResponse = Request.getInstance().get(fullUrl);
        if (stringHttpResponse.getStatus() == 200) {
            String body = stringHttpResponse.getBody();
            Gson gson = new Gson();
            return gson.fromJson(body, Result.class);
        }
        return null;
    }

    @SneakyThrows
    public List<TestData> readFromFile() {
        StringBuilder data = new StringBuilder();
        File myObj = new File(Service.class.getResource("/mobiledata.json").getPath());
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            data.append(myReader.nextLine());
        }
        myReader.close();

        Type type = new TypeToken<List<TestData>>() {
        }.getType();
        Gson gson = new Gson();
        return gson.fromJson(data.toString(), type);
    }

    public void saveResultToMongo(List<MongoResult> mongoResults) {
        JSONArray jsArray = new JSONArray(mongoResults);
        String result = jsArray.toString();
        Request.getInstance().post(SERVER_URL, result);
    }
}
