package analytic_events;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public class Requests {

    private App app;

    private Requests(App app) {
        this.app = app;
    }

    public static Requests getInstance(App app) {
        return new Requests(app);
    }

    public HttpResponse<String> getEvents() {
        String url = "https://picsart.tools/portal/api/v1/apps/" + app.getAppNumber() + "/events/";
        System.out.println("Getting events ...");
        return get(url, getCommonHeaders());
    }


    public HttpResponse<String> getParams(String eventName) {
        String url = "https://picsart.tools/portal/api/v1/apps/" + app.getAppNumber() + "/events/" + eventName;
        System.out.println("Getting params of " + eventName + " event");
        return get(url, getCommonHeaders());
    }

    //2022-01-13
    public HttpResponse<String> getFireData(String eventName, String dateFrom, String dateTo) {
        String url = "https://picsart.tools/portal/api/v1/events/occurrence/?application=com.picsart.studio&event="
                + eventName + "&from=" + dateFrom + "&until=" + dateTo;
        System.out.println("Getting fired data of " + eventName + " event");
        return get(url, getCommonHeaders());
    }

    @SneakyThrows
    public HttpResponse<String> get(String url, Map<String, String> headers) {
        System.out.println("Requesting " + url);
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> stringHttpResponse = Unirest.get(url)
                .headers(headers)
                .asString();

        System.out.println("Response status code is " + stringHttpResponse.getStatus());
        return stringHttpResponse;
    }

    private static Map<String, String> getCommonHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("sec-ch-ua", "\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"98\", \"Google Chrome\";v=\"98\"");
        headers.put("Accept", "application/json, text/plain, */*");
        headers.put("Referer", "https://picsart.tools/picsart/events?e_status=%22LIVE%22");
        headers.put("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJNUUtKTXNjZ050N0xMcUtfZXpBOVRWeDVXRDZNMTROOG54ZXFIREJBczhrIn0.eyJleHAiOjE2NDUwMTc5NjQsImlhdCI6MTY0NDk5NjM2NCwiYXV0aF90aW1lIjoxNjQ0OTk2MzYzLCJqdGkiOiI3YjcwYWQ1ZS1jNmFiLTQwNzMtYTYxMS0zNDI3ZDY2M2RhMzgiLCJpc3MiOiJodHRwczovL2tleWNsb2FrLnBpY3NhcnQudG9vbHMvYXV0aC9yZWFsbXMvbWFzdGVyIiwic3ViIjoiZGFmY2IzMWQtZDA5Ny00MTRkLWE0MmYtZTJhMjIyZjJmYzkzIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiYWJzLWF1dGgtcHJvZCIsInNlc3Npb25fc3RhdGUiOiI0ZGQ0M2Q5YS0xNmRhLTQwNzAtODk1Mi00YzEyOWNmOTZlM2QiLCJhY3IiOiIxIiwic2NvcGUiOiJvcGVuaWQgZW1haWwgcHJvZmlsZSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJuYW1lIjoiIEthcmVuIEdyaWdvcnlhbiIsInByZWZlcnJlZF91c2VybmFtZSI6ImthcmVuLmdyaWdvcnlhbkBwaWNzYXJ0LmNvbSIsImdpdmVuX25hbWUiOiIgS2FyZW4iLCJmYW1pbHlfbmFtZSI6IkdyaWdvcnlhbiIsImVtYWlsIjoia2FyZW4uZ3JpZ29yeWFuQHBpY3NhcnQuY29tIn0.fp1dKejfH6Qpi0Gl2v_k6Q-5xVcfZ004EgfvVP0DKlK0JjjUYhMyEzQEY6C-va9YzPocVHjejKb_aHRjaLr5u_Z1P2u07tBvMcFTZpybJ4TPwHRpPDoCnGmJFDbkfcl28vtWGdROs5OWwgjGZEtMDwaF3tpSV1J7__kFqAtitxFAE01pKzpLCfgnLIk4RO5CvpYGuX7UPCvLHfu0rBMVes4YJttnHj5k7_FeR02GXNxgjNFu9oJ4eabHbPJnbK0JF6NhpbZZtRIYZlU6kwecWnTlRqRioYxZHg8bN6-e5EOKRtCdWxWqZxxR9xRaMAsrsjEn7rj7SvGCJ4xYmOio0w");
        headers.put("sec-ch-ua-mobile", "?0");
        headers.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.80 Safari/537.36");
        headers.put("sec-ch-ua-platform", "\"macOS\"");
        headers.put("Cookie", "JSESSIONID=98EE4617EBD42DC068BAF52E5CB7C14E");
        return headers;
    }
}
