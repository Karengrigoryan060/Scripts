package pagespeedinsigetsapi;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import lombok.SneakyThrows;

public class Request {

    private Request() {
    }

    public static Request getInstance() {
        return new Request();
    }

    @SneakyThrows
    public HttpResponse<String> get(String url) {
        return Unirest.get(url)
                .asString();
    }

    @SneakyThrows
    public void post(String url, String body) {
        HttpResponse<String> response = Unirest.post(url)
                .header("Content-Type", "application/json")
                .body(body)
                .asString();
    }
}
