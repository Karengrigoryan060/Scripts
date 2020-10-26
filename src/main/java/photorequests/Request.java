package photorequests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import lombok.SneakyThrows;

import static photorequests.Runner.TOKEN;

public class Request {

    @SneakyThrows
    public HttpResponse<String> get(String url) {
//        System.out.println("Request : " + url);
        return Unirest.get(url)
                .header("x-api-key", TOKEN)
                .asString();
    }

}
