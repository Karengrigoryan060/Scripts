package photorequests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import photorequests.model.Photo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Script extends Thread {

    static List<Long> result = new ArrayList<>();
    private final Long value;

    public Script(Long value) {
        this.value = value;
    }

    @Override
    public void run() {
        HttpResponse<String> stringHttpResponse = RequestService.requestPhoto(value);
        check(stringHttpResponse, value);
        logResults();
    }

    private static void logResults() {
        if (!result.isEmpty())
//            System.out.println("Problematic ids");
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }
        result = new ArrayList<>();
    }

    private static void check(HttpResponse<String> stringHttpResponse, long id) {
//        String errorMessage = "Something went wrong with : " + id;
        if (stringHttpResponse.getStatus() != 200) {
//            System.out.println(errorMessage + "  status code :" + stringHttpResponse.getStatus());
            result.add(id);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Photo>() {
        }.getType();
        Photo photo = null;
        try {
            photo = gson.fromJson(stringHttpResponse.getBody(), type);
        } catch (Exception e) {
            System.out.println("error 1 id : " + id);
        }

        if (photo != null && !photo.getStatus().equals("success")) {
//            System.out.println(errorMessage + "  message is :" + photo.getStatus());
            result.add(id);
        }
    }
}