package analytic_events;

import analytic_events.models.events.Event;
import analytic_events.models.events.EventData;
import analytic_events.models.events.FiredData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    private App app;

    private Service(App app) {
        this.app = app;
    }

    public static Service getInstanceMobile() {
        return new Service(App.PICSART);
    }

    public static Service getInstanceWeb() {
        return new Service(App.PICSART_WEBSITE);
    }

    public List<Event> getEvents() {
        HttpResponse<String> eventsResponse = Requests.getInstance(app).getEvents();
        Gson gson = new Gson();
        Type type = new TypeToken<List<Event>>() {
        }.getType();
        List<Event> events = gson.fromJson(eventsResponse.getBody(), type);
        return events.stream().filter(s -> s.getStatus().equals("LIVE")).collect(Collectors.toList());
    }

    public EventData getParams(String eventName) {
        HttpResponse<String> eventsResponse = Requests.getInstance(app).getParams(eventName);
        Gson gson = new Gson();
        return gson.fromJson(eventsResponse.getBody(), EventData.class);
    }

    public List<FiredData> getFiredDataForLastMonth(String eventName) {
        HttpResponse<String> eventsResponse = Requests.getInstance(app).getFireData(eventName, getDateFrom(), getDateTo());
        Gson gson = new Gson();
        Type type = new TypeToken<List<FiredData>>() {
        }.getType();
        return gson.fromJson(eventsResponse.getBody(), type);
    }

    public boolean isEventFiredDuringLastMonth(String eventName) {
//        long firedCount = getFiredDataForLastMonth(eventName).stream()
//                .filter(eventFiredCount -> eventFiredCount.getKey() != null)
//                .mapToLong(eventFiredCount -> ((long) eventFiredCount.getValue())).sum();

        int res = 0;
        List<FiredData> firedDataForLastMonth = getFiredDataForLastMonth(eventName);
        for (int i = 0; i < firedDataForLastMonth.size(); i++) {
            if (firedDataForLastMonth.get(i).getValue() != null) {
                res += firedDataForLastMonth.get(i).getValue();
            }
        }

        return res != 0;
    }

    private String getDateFrom() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.minusDays(30);
        return format.format(localDateTime);
    }

    private String getDateTo() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        return format.format(now);
    }
}