package analytic_events;

import analytic_events.models.events.Event;
import analytic_events.models.events.EventData;
import analytic_events.models.events.Property;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JsonToJava {

    public static JsonToJava getInstance() {
        return new JsonToJava();
    }

    public void jsonToJavaMobile() {
        String fileName = "mobileData";
        Service mobileService = Service.getInstanceMobile();
        generatePropertyFile(mobileService, fileName);
        jsonToJava(fileName);
    }

    public void jsonToJavaWeb() {
        String fileName = "webData";
        Service mobileService = Service.getInstanceWeb();
//        generatePropertyFile(mobileService, fileName);
        jsonToJava(fileName);
    }

    private void jsonToJava(String fileName) {
        List<Property> properties = readFromJsonFile(fileName);
//        HashSet<Property> properties1 = new HashSet<>(properties);

        Set<String> collect = properties.stream().map(a -> "@SerializedName(\"" + getName(a.getName()) + "\")" + " private " + getType(a.getType()) + getName(a.getName()) + ";").collect(Collectors.toSet());

        collect.forEach(System.out::println);
    }

    private String getName(String name) {
        char[] chars = name.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '_') {
                chars[i + 1] = (char) (chars[i + 1] - 32);
            }
        }
        return String.copyValueOf(chars).replace("_", "");
    }

    private String getType(String type) {
        switch (type) {
            case "ARRAY_STRING":
                return "String [] ";
            case "FLOAT":
                return "Double ";
            case "STRING":
                return "String ";
            case "ARRAY_OBJECT":
                return "Object [] ";
            case "OBJECT":
                return "Object ";
            case "BOOLEAN":
                return "Boolean ";
            case "NUMERIC":
                return "Integer ";
            default:
                return "";
        }

    }

    private void generatePropertyFile(Service service, String fileName) {
        List<Property> allParams = new ArrayList<>();
        List<Event> events = service.getEvents();

        events.forEach(event -> {
            if (service.isEventFiredDuringLastMonth(event.getName())) {
                EventData params1 = service.getParams(event.getName());
                params1.getProperties().forEach(allParams::add);
            }
        });

        writeInJsonFile(allParams, fileName);
        allParams.forEach(System.out::println);
    }

    @SneakyThrows
    private void writeInJsonFile(List<Property> properties, String fileName) {

        Gson gson = new Gson();
        String propertyJson = gson.toJson(properties);

        File file = new File(fileName + ".json");
        file.createNewFile();

        try (FileWriter fileWriter = new FileWriter(file)) {
            System.out.println("Writing JSON object to file");
            System.out.println("-----------------------");
            System.out.print(propertyJson);

            fileWriter.write(propertyJson);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @SneakyThrows
    private List<Property> readFromJsonFile(String fileName) {
        Type type = new TypeToken<List<Property>>() {
        }.getType();
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(fileName + ".json"), type);
    }
}