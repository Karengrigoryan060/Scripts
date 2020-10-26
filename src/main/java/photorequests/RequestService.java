package photorequests;

import com.mashape.unirest.http.HttpResponse;

import static photorequests.Runner.REQUEST_URL;

public class RequestService {

    private RequestService() {
    }

    public static HttpResponse<String> requestPhoto(long... ids) {
        String url = getUrl(ids);
        return new Request().get(url);
    }

    private static String getUrl(long... ids) {
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < ids.length; i++) {
            id.append(ids[i]);
            if (i != ids.length - 1)
                id.append(",");
        }

        return REQUEST_URL.replace("{ids}", id.toString());

    }

}
